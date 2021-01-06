package com.example.timer.playground;

import com.example.timer.info.TimeInfo;
import com.example.timer.jobs.HelloWorldJobs;
import com.example.timer.timeservice.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {

    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob() {

        final TimeInfo info = new TimeInfo();

        info.setTotalFireCount(5);
        info.setRepeatIntervalMs(2000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

        scheduler.schedule(HelloWorldJobs.class, info);
    }

    public List<TimeInfo> getAllRunningTimer() {

        return scheduler.getAllRunningTimers();
    }


    public TimeInfo getRunningTimer(String timerId) {
        return scheduler.getRunningTimer(timerId);
    }
}
