package org.zerock.domain;

import java.util.List;

public class replyPageVO {
	
	
	private List<ReplyVO> list;
	
	private Integer replyCnt;
	
	public replyPageVO(List<ReplyVO> list,Integer replyCnt) {
		this.list=list;
		this.replyCnt=replyCnt;
	}

	@Override
	public String toString() {
		return "replyPageVO [list=" + list + ", replyCnt=" + replyCnt + "]";
	}

	public List<ReplyVO> getList() {
		return list;
	}

	public void setList(List<ReplyVO> list) {
		this.list = list;
	}

	public Integer getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(Integer replyCnt) {
		this.replyCnt = replyCnt;
	}

	
}
