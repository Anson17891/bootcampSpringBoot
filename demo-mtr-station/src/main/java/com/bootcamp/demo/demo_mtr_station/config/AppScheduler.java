package com.bootcamp.demo.demo_mtr_station.config;
//!see xxxApplication.java

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {
  //usage eg:
// periodically :
//1. check data
//2. generate report
//3. send mail
//!4. just do smth automatically....

  //! Until the task complete, count 3s 
@Scheduled(fixedDelay= 3000)//!after method end, wait 3s and start next call
public void sayHello()throws Exception{
  System.out.println("before =" + System.currentTimeMillis());
  System.out.println("hello world");
  Thread.sleep(4000L); //pretend the task required 4 sec  //!the method endure 4s
  System.out.println("after =" + System.currentTimeMillis());
}  
// run spring-boot:run -> print "hello world" every 3000ms
//!!!! -> automatically do smthing every xxx sec


//! FixRate -> fixed time required to complete within a timeframe
//! Actual schedule need to catch up the required schedule
@Scheduled(fixedRate= 4000) //! require to complete the method in 4s  -> somehow the method run longer than fixRate -> "dept" -> complete until clean up the dept
public void sayGoodBye()throws Exception{
  System.out.println("before =" + System.currentTimeMillis());
  System.out.println("Good Bye");
   Thread.sleep(5000L); //!the method endure 5s
  System.out.println("after =" + System.currentTimeMillis());
}  
//! two threads (two methods are independent)



@Scheduled(cron = "0 6 20 * * MON-FRI", zone = "Asia/Hong_Kong")
 public void runTask(){
  System.out.println("Testing Cron Job");
 }



}
