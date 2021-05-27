package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.ActivityDetailsDTO;
import ro.tuc.ds2020.dtos.builders.ActivityBuilder;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.entities.Activity;
import ro.tuc.ds2020.repositories.ActivityRepository;

import java.util.UUID;


@Service
public class ActivityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityService.class);
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public UUID insert(ActivityDetailsDTO activityDetailsDTO){
        Activity activity = ActivityBuilder.toEntity(activityDetailsDTO);
        activity = activityRepository.save(activity);
        LOGGER.debug("Activity with id {}, name {}, start_date {}, end_date{}  was inserted in db", activity.getId(), activity.getName(), activity.getStart_date(), activity.getEnd_date());
        return activity.getId();
    }
}
