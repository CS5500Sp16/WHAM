package com.neu.wham.prefs.util;

import java.util.HashMap;
import java.util.Map;


public final class NEUEventsPrefMapping {
	private static final Map<String, String> NEUEvents = new HashMap<String,String>();
	
	static{
		NEUEvents.put("Academic Events", "12896%14363%12877%12881%12891%12905%12897%3000%12898%12894");
		NEUEvents.put("Lecture", "12881");
		NEUEvents.put("Meeting", "12891");
		NEUEvents.put("Open Mic", "12905");
		NEUEvents.put("PhD defense", "3000");
		NEUEvents.put("Rally", "12898");
		NEUEvents.put("Class", "12877");
		NEUEvents.put("Lecture", "12881");
		NEUEvents.put("Family and Education", "14360");
		NEUEvents.put("Alumni", "14360");
		NEUEvents.put("Sports and Fitness", "12876");
		NEUEvents.put("Hobbies And Special Interest", "12890%12902");
		NEUEvents.put("Business And Professional", "12901%16080%12880");
		NEUEvents.put("Community And Culture", "12892%12893");
		NEUEvents.put("Charity And Causes", "12900");
		NEUEvents.put("Film, Media And Entertainment", "12878%12885");
		NEUEvents.put("Concert or Performance", "12879");
		NEUEvents.put("Conference", "12884");
		NEUEvents.put("Music", "12895%12888");
		NEUEvents.put("Performing And Visual Arts", "12903%12886%12887%46561%12889%12904");
		NEUEvents.put("Food And Drink", "12899");
		NEUEvents.put("Seminar or Talk", "12882");
		NEUEvents.put("Conference", "12884");
		NEUEvents.put("Class, Training, or Workshop", "12883");
        NEUEvents.put("Cultural", "12895");
        NEUEvents.put("Dance", "12903");
        NEUEvents.put("Film", "12885");
        NEUEvents.put("Other", "12906");
	}
	
	public static final String getNEUPref(final String mappedType){
		return NEUEvents.get(mappedType);
	}
}
