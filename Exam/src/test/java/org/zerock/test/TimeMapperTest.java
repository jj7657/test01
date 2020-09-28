package org.zerock.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TimeMapperTest {
	

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TimeMapper tm;
	
	@Test
	public void testGetTime() {
		logger.info(tm.getClass().getName());
		logger.info(tm.getTime());
	}
	
	@Test
	public void testGetTime2() {
		logger.info(tm.getClass().getName());
		logger.info(tm.getTime2());
	}
	
	
	
	
}
