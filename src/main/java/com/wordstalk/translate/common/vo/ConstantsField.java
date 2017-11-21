package com.wordstalk.translate.common.vo;

import java.util.HashMap;
import java.util.Map;

public class ConstantsField {
	public static Map<Integer, String> levelMap = new HashMap<Integer, String>();
	static{
		levelMap.put(1, "新");
		levelMap.put(2, "低");
		levelMap.put(3, "中");
		levelMap.put(4, "高");
	}
	public static String SESSION_USER_NAME = "words_talk_name";
	public static final String SESSION_USER_ID = "words_talk_id";
	public static final String SESSION_USER_ROLE = "words_talk_role";
	
	public static Integer PROJECT_ALL = -1;
	public static Integer PROJECT_RUNNING = 0;
	public static Integer PROJECT_UNSETTLE = 1;
	public static Integer PROJECT_FINISH = 2;
    public static Integer PROJECT_UNSAVE = 3;

	public static final String SESSION_VALUE_PM = "PM";
	public static final String SESSION_VALUE_ADMIN = "admin";
}
