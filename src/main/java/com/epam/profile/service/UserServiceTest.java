package com.epam.profile.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;


import org.junit.Test;

import com.epam.profile.model.JobLevels;


public class UserServiceTest {
	
	private static UserService mockedUserService;
	
	private static JobLevels jobLevels1;
	
	private static JobLevels jobLevels2;
	
	@BeforeClass
	public static void setUp(){
		mockedUserService = mock(UserService.class);
		jobLevels1=new JobLevels();
		jobLevels1.setJobLevelId(100);
		jobLevels1.setJobLevelName("Level1");
		
		jobLevels2=new JobLevels();
		jobLevels2.setJobLevelId(101);
		jobLevels2.setJobLevelName("Level2");
		
		when(mockedUserService.getJobLevels()).thenReturn(Arrays.asList(jobLevels1,jobLevels2));
	}
	@Test
	public void testgetJobLevels()throws Exception {
		List<JobLevels> allJobLevels = mockedUserService.getJobLevels();
		assertEquals(2,allJobLevels.size());
		JobLevels jobLevels=allJobLevels.get(0);
		assertEquals("100", jobLevels.getJobLevelId().toString());
	}
}
