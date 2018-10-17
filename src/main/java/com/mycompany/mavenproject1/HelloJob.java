package com.mycompany.mavenproject1;

import java.util.Date;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    private static final Logger log = Logger.getLogger(HelloJob.class.getName());
    
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        log.info("Restarter execute method " + new Date());
    
    }
    
    
   
    
}
