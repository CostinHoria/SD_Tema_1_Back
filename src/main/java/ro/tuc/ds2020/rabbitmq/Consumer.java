package ro.tuc.ds2020.rabbitmq;

import net.minidev.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import ro.tuc.ds2020.dtos.ActivityDetailsDTO;
import ro.tuc.ds2020.services.ActivityService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class Consumer {
    private final ActivityService activityService;

    @Autowired
    private SimpMessagingTemplate websocket;

    @Autowired
    public Consumer(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue}", containerFactory = "jsaFactory")
    public void GetActivity(JSONObject activity_received){
        System.out.printf("WE GOT :"+activity_received.toString());

        String activity_NAME_received_string = activity_received.getAsString("activity_name");
        String activity_START_DATE_received_string = activity_received.getAsString("start_date");
        String activity_END_DATE_received_string = activity_received.getAsString("end_date");
        String activity_ID_PATIENT_received_string = activity_received.getAsString("patient_id");

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime activity_START_DATE = LocalDateTime.parse(activity_START_DATE_received_string, format);
        LocalDateTime activity_END_TIME = LocalDateTime.parse(activity_END_DATE_received_string, format);

        if(activity_NAME_received_string.equals("Sleeping") && Duration.between(activity_START_DATE, activity_END_TIME).toMillis()/1000> 7*60*60){
            System.out.println("HOPA AI DORMIT MAI MULT DE 7 ORE");
            websocket.convertAndSend("/topic/warning",String.format("HOPA AI DORMIT MAI MULT DE 7 ORE"));
        }

        if(activity_NAME_received_string.equals("Leaving") && Duration.between(activity_START_DATE, activity_END_TIME).toMillis()/1000> 5*60*60){
            System.out.println("HOPA STAT PE AFARA MAI MULT DE 5 ORE");
            websocket.convertAndSend("/topic/warning",String.format("HOPA STAT PE AFARA MAI MULT DE 5 ORE"));
        }

        if((activity_NAME_received_string.equals("Showering") && Duration.between(activity_START_DATE, activity_END_TIME).toMillis()/1000> 30*60) || (activity_NAME_received_string.equals("Toileting") && Duration.between(activity_START_DATE, activity_END_TIME).toMillis()/1000> 30*60) || (activity_NAME_received_string.equals("Grooming") && Duration.between(activity_START_DATE, activity_END_TIME).toMillis()/1000> 30*60)){
            System.out.println("HOPA STAT IN BAIE MAI MULT DE 30 DE MINUTE");
            websocket.convertAndSend("/topic/warning",String.format("HOPA STAT IN BAIE MAI MULT DE 30 DE MINUTE"));
        }




        UUID activity_ID_PATIENT = UUID.fromString(activity_ID_PATIENT_received_string);

        ActivityDetailsDTO activityDetailsDTO = new ActivityDetailsDTO(activity_NAME_received_string,activity_START_DATE,activity_END_TIME,activity_ID_PATIENT);
        activityService.insert(activityDetailsDTO);
    }
}
