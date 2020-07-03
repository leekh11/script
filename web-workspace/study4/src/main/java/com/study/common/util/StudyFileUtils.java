package com.study.common.util;

import java.text.DecimalFormat;

public class StudyFileUtils {
	
	public static String getFancySize(long size) {
		DecimalFormat form = new DecimalFormat("#,###.#");
		if(size < 1024) {
			return size + "byte";
		} else if(size < 1024*1024) {
			return form.format(size/1024.0) + "KB";
		} else if(size < 1024*1024*1024) {
			return form.format(size/(1024.0*1024.0)) + "MB";
		} else {
			return form.format(size/(1024.0*1024.0*1024.0)) + "GB";
		}
		
	}
}
