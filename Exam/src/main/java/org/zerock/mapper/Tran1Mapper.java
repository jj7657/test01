package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Tran1Mapper {
	
	@Insert("insert into tbl_transaction1 value (#{data})")
	public int insertCol1(String data);
	
	
}
