
package com.mycompany.mavenproject1;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import org.quartz.CronTrigger;
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class SimpleExample {
    private static final Logger log = Logger.getLogger(SimpleExample.class.getName());
    
    public static void main(String[] args) {
        log.info("START PROCESS");
        
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler sched = sf.getScheduler();
            log.info("Create sched");
            JobDetail job = newJob(HelloJob.class).withIdentity("job1","group1").build();
            CronTrigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .withSchedule(cronSchedule("0/20 * * * * ?"))
                    .build();
            sched.scheduleJob(job, trigger);
            
            log.info("Call 20 sec ");
            
            log.info("Start");
            sched.start();
            log.info("End");
//            Thread.sleep(300L * 1000L);
//            
//            sched.shutdown();
            
        } catch (Exception ex) {
            Logger.getLogger(SimpleExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
