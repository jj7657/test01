package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
//	���� �ð��� ���ڸ� ��ȸ�ϴ� sql

	@Select("SELECT SYSDATE()")
	public String getTime();

	public String getTime2();
	
}
