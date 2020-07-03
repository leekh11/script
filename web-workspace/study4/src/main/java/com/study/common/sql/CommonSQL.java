package com.study.common.sql;

public class CommonSQL {
	public static final String PRE_PAGING_QRY 
		= "SELECT *  FROM (SELECT rownum as rn, a.* FROM (    ";
	public static final String POST_PAGING_QRY 
		= ") a WHERE rownum <= ?  ) b   WHERE rn between ? and ? ";
	
	
}
