package org.zerock.Exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

@RestController
@RequestMapping("sample")
public class RestController01 {

	@RequestMapping("hello")
	public String sayHello() {
		return "Hello World";
	}
	
	@RequestMapping("sendVO")
	public SampleVO sendVO() {
		SampleVO vo = new SampleVO();
		vo.setMno(123);
		vo.setFirstName("길동");
		vo.setLastName("길");
		return vo; 		
	}
	
	@RequestMapping("sendList")
	public List<SampleVO> sendList() {
		List<SampleVO> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {			
		SampleVO vo = new SampleVO();
		vo.setMno(i);
		vo.setFirstName("길동");
		vo.setLastName("길");
		list.add(vo);
		}
		
		return list; 		
	}
	@RequestMapping("sendMap")
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer,SampleVO> map = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {			
			SampleVO vo = new SampleVO();
			vo.setMno(i);
			vo.setFirstName("길동");
			vo.setLastName("길");
			map.put(i,vo);
		}
		
		return map; 		
	}
	
	
	
	
	
	
	
	
	
	
	
}
