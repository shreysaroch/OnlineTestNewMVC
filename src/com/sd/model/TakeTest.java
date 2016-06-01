package com.sd.model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sd.Impl.UserTestDaoImpl;
import com.sd.pojo.TestPojo;
import com.sd.pojo.UserPojo;

public class TakeTest {

	public ArrayList<TestPojo> getValidTest(UserPojo user){
		
		int groupId = user.getGroupId();
		
		ArrayList<TestPojo> tests = new ArrayList<TestPojo>();
		
		ApplicationContext factory=new ClassPathXmlApplicationContext("SpringBeanConfiguration.xml");
		UserTestDaoImpl usertest = (UserTestDaoImpl) factory.getBean("userTestDao");
		tests = (ArrayList<TestPojo>) usertest.getUserTests(groupId);

		Date sysTime = new Date();
		DateFormat df = new SimpleDateFormat("HH:MM:SS");
		String currentTime = df.format(sysTime);
		ArrayList<TestPojo> validTests = new ArrayList<TestPojo>();
		for(TestPojo t:tests){
			System.out.println("Test :"+t);
			System.out.println(currentTime);
			Date startTime = t.getStartTime();
			Date endTime = t.getEndTime();
			String start = df.format(startTime);
			String end = df.format(endTime);
			try {
			    Date time1 = new SimpleDateFormat("HH:mm:ss").parse(start);
			    Calendar calendar1 = Calendar.getInstance();
			    calendar1.setTime(time1);
			    calendar1.add(Calendar.DATE, 1);

			    Date time2 = new SimpleDateFormat("HH:mm:ss").parse(end);
			    Calendar calendar2 = Calendar.getInstance();
			    calendar2.setTime(time2);
			    calendar2.add(Calendar.DATE, 1);

			    Date d = new SimpleDateFormat("HH:mm:ss").parse(currentTime);
			    Calendar calendar3 = Calendar.getInstance();
			    calendar3.setTime(d);
			    calendar3.add(Calendar.DATE, 1);

			    Date x = calendar3.getTime();
			    System.out.println("Compare"+x.after(calendar1.getTime()) + x.before(calendar2.getTime()));
			    
			    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
			        System.out.println(true);
			        System.out.println("ADDED");
					validTests.add(t);
			    }
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			
			
		}
		return validTests;
	}
}
