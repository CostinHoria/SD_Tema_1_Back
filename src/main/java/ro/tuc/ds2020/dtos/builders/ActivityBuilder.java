package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.ActivityDTO;
import ro.tuc.ds2020.dtos.ActivityDetailsDTO;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
import ro.tuc.ds2020.entities.Activity;
import ro.tuc.ds2020.entities.Caregiver;

public class ActivityBuilder {

    public ActivityBuilder() {
    }

    public static ActivityDTO toActivityDTO(Activity activity){
        return new ActivityDTO(activity.getId(),activity.getName(),activity.getStart_date(),activity.getEnd_date(),activity.getId_client());
    }

    public static ActivityDetailsDTO toActivityDetailsDTO(Activity activity){
        return new ActivityDetailsDTO(activity.getId(), activity.getName(), activity.getStart_date(), activity.getEnd_date(), activity.getId_client());
    }

    public static Activity toEntity(ActivityDetailsDTO activityDetailsDTO){
        return new Activity(activityDetailsDTO.getId(), activityDetailsDTO.getName(), activityDetailsDTO.getStart_date(), activityDetailsDTO.getEnd_date(),activityDetailsDTO.getId_client());
    }

    public static void updateEntity(ActivityDetailsDTO activityDetailsDTO, Activity activity){
        if(activityDetailsDTO!= null && activity!=null){
            activity.setId(activityDetailsDTO.getId());
            activity.setName(activityDetailsDTO.getName());
            activity.setStart_date(activityDetailsDTO.getStart_date());
            activity.setEnd_date(activityDetailsDTO.getEnd_date());
            activity.setId_client(activityDetailsDTO.getId_client());
        }
    }
}
