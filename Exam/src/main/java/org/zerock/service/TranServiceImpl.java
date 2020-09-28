package org.zerock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Tran1Mapper;
import org.zerock.mapper.Tran2Mapper;

@Service
public class TranServiceImpl implements TranService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Tran1Mapper tmapper1;
	@Autowired
	private Tran2Mapper tmapper2;
	
	
	@Transactional
	@Override
	public void addData(String value) {
		// TODO Auto-generated method stub
		
		logger.info("transaction 적용하기 전");
		tmapper1.insertCol1(value);
		tmapper2.insertCol1(value);
	}

}
