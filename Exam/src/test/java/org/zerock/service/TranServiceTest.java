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
		String str= "�ȳ��ϼ���11111. �׸���ǻ�� ��ī���̿� ���Ű� ȯ���մϴ�. �� ������ ������ �缺 �Ʒ� �����Դϴ�.!!~~~~~~~~~11111~~";
		service.addData(str);
	}
	
}
