package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
//	현재 시간과 날자를 조회하는 sql

	@Select("SELECT SYSDATE()")
	public String getTime();

	public String getTime2();
	
}
