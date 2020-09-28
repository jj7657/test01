package org.zerock.mapper;

import org.apache.ibatis.annotations.Insert;

public interface Tran2Mapper {

	@Insert("insert into tbl_transaction2  value (#{data})")
	public int insertCol1(String data);
	
}
