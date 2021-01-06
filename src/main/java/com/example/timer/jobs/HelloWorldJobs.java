package com.example.timer.jobs;

import com.example.timer.info.TimeInfo;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJobs implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJobs.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        TimeInfo info = (TimeInfo) jobDataMap.get(HelloWorldJobs.class.getSimpleName());
        LOG.info(info.getCallbackData());
    }
}
