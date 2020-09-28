package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TranServiceTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TranService service;
	
	@Test
	public void testTran() {
		String str= "안녕하세요11111. 그린컴퓨터 아카데미에 오신걸 환영합니다. 이 과정은 빅데이터 양성 훈련 과정입니다.!!~~~~~~~~~11111~~";
		service.addData(str);
	}
	
}
