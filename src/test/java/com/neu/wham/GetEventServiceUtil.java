package com.neu.wham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.neu.wham.model.Event;

public class GetEventServiceUtil {
	
//	public static List<Event> buildEvents() throws ParseException{
//		
//		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//		
//		Event e1 = new Event();
//		e1.setEventName("Get Traction: The Virtual Growth Event [Tashkent]");
//		String e1Desc = "Register Now>> http://re.tc/wwondecl \nLEARN STRATEGIES, TACTICS "
//				+ "& TOOLS FOR GROWTH MARKETING IN 2016 \nIMPORTANT NOTE: This is a Virtual Event."
//				+ " You will receive your login information via email on February 29, 2016  \n  \n"
//				+ "Overview: \nThere’s no denying that growth is hot and here to stay. But despite "
//				+ "the buzz, many businesses still don’t have the framework they need to build a successful "
//				+ "growth engine. Join a community of data-driven marketers, sales hackers and innovative"
//				+ " entrepreneurs who will learn the fundamentals of rapid growth for 2016.  "
//				+ "\nEvent Features: \n3 days of in-depth learning ( 15 interactive sessions) - covering growth "
//				+ "fundamentals, advanced tactics, business development and sales \nConnect with 3K+ founders, "
//				+ "growth marketing execs and innovation teams \nAll sessions will be recorded and available on-demand "
//				+ "\nTopics include:  \n\nLean branding hacks and strategy\nEarly-stage growthProduct "
//				+ "marketing & UX/UI\nLean management and hiring\nReferral marketing\nCommunity development\n"
//				+ "Digital Marketing Best Practices\nSearch engine optimization\nWeb analytics\nSocial media & "
//				+ "content marketing\nAffiliate marketing\nDigital advertising & Paid Search\nEmail marketing"
//				+ " automation\nGrowth Hacking\nConversion optimization & testing\nMarketplace & viral growth\nGamification\nWeb"
//				+ " Scraping\nSales Automation\nHacking partnerships\n\n  \nLEARN MORE \n  \n   \nWho should Attend:"
//				+ "  \nGrowth Hackers • Growth Marketers• Founders • CEOs • Marketing Directors •  Software Engineers"
//				+ " • \nProduct Managers • Small Business Owners • Marketing Consultants • Investors • Mentors • Entrepreneurs"
//				+ " • Sales Executives \nPARTNERS: \n\n\n\n\n  \n\n\n  \n  \n\n\n\n \n\n  \n\n\n\n\n  \n\n\n  \n\n\n\n\n  \n\n\n"
//				+ "  \n\n\n\n\n  \n\n\n  \n\n\n\n\n  \n\n\n   \n\n\n\n\nIf you would like to learn more about sponsorship packages,"
//				+ " please send us an email to sponsor@startupsocials.com \nFollow US \nWeb I Linkedin I Facebook I Meetup "
//				+ "  \n  \n  \n•"; 	
//		e1.setEventDesc(e1Desc);
//		e1.setEventLocation("Tashkent 100001 UZ");
//		e1.setPhoneNumber(null);
//		e1.setEmailId(null);   
//		TimeZone tz1 = TimeZone.getTimeZone("Asia/Samarkand");
//		formatter2.setTimeZone(tz1);
//		e1.setLatitude(Double.parseDouble("41.3125"));
//		e1.setLongitude(Double.parseDouble("69.39027399999998"));
//		e1.setCreationTime(formatter2.parse("2016-02-24T00:25:20Z"));
//		e1.setLastUpdateTime(formatter2.parse("2016-03-01T08:32:17Z"));
//		e1.setOrganiserName(null);
//		e1.setOrganiserDesc(null);
//		e1.setOfficialEvent(false);
//		e1.setFilePath(null);
//		
//		
//		Event e2 = new Event();
//		e2.setEventName("인터넷바카라추천【DON963 쩜컴】카지노사이트");
//		String e2Desc = "be8인터넷바카라추천【DON963 쩜컴】카지노사이트인터넷바카라추천＼"
//				+ "ら카지노사이트인터넷바카라추천＼ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼"
//				+ "ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼ら바카라사이트＼"
//				+ "ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
//				+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라"; 	
//		e2.setEventDesc(e2Desc);
//		e2.setEventLocation("32/1 Titov Street Dushanbe Districts of Republican Subordination 734012 TJ");
//		e2.setPhoneNumber(null);
//		e2.setEmailId(null);   
//		TimeZone tz2 = TimeZone.getTimeZone("Asia/Dushanbe");
//		formatter2.setTimeZone(tz2);
//		e2.setLatitude(Double.parseDouble("38.5486864"));
//		e2.setLongitude(Double.parseDouble("68.8155587"));
//		e2.setCreationTime(formatter2.parse("2016-03-21T13:26:36Z"));
//		e2.setLastUpdateTime(formatter2.parse("2016-03-21T13:26:38Z"));
//		e2.setOrganiserName(null);
//		e2.setOrganiserDesc(null);
//		e2.setOfficialEvent(false);
//		e2.setFilePath(null);
//		
//		
//		Event e3 = new Event();
//		e3.setEventName("Встреча с Вице-Ректором университета Туриба, Рига, Латвия, Господином Имантсом Бергсом");
//		String e3Desc = "Уважаемые абитуриенты, будущие студенты Туриба и все, кто еще не определился с университетом! \n"
//				+ "Приглашаем Вас посетить открытую встречу с Вице-Ректором университета #Туриба, #Рига, #Латвия, "
//				+ "Господином Имантсом Бергсом, которая состоится 3 апреля 2016г. в Ташкенте.  \nФормат встречи – неформальное общение."
//				+ " Сначала Господин Бергс сделает небольшую презентацию об университете и студенческой жизни в Латвии. "
//				+ "Затем Вы сможете задать ему любые вопросы касательно университета, предметов, необходимых документов,"
//				+ " стипендий для студентов из Узбекистана и т.п. \nБольше информации об университете на нашей страничке в Facebook"
//				+ " - https://web.facebook.com/educationstandard/ \nВстреча будет проходить 3 апреля с 15.00 до 18.00 в отеле Radisson Blu,"
//				+ " Конференц-зал №2 Turquoise. \nЧтобы записаться на встречу необходимо: \n1. Нажать на кнопку «Select a time» (верхний правый угол под названием)."
//				+ " Страница обновится. \n2. Нажать в том же правом верхнем углу под названием кнопку «Register», выбрать время встречи и нажать «Checkout». \n"
//				+ "3. Ввести требуемые данные и нажать «Complete Registration». \nПри успешной регистрации на указанную вами почту придет электронный билет. "
//				+ "Не забудьте распечатать его и взять с собой на встречу :) \nВсе вопросы по телефону (+99871) 2687544."; 	
//		e3.setEventDesc(e3Desc);
//		e3.setEventLocation("88, Amir Temur Street Тошкент Toshkent Viloyati UZ");
//		e3.setPhoneNumber(null);
//		e3.setEmailId(null);  
//		TimeZone tz3 = TimeZone.getTimeZone("Asia/Samarkand");
//		formatter2.setTimeZone(tz3);
//		e3.setLatitude(Double.parseDouble("41.3296372"));
//		e3.setLongitude(Double.parseDouble("69.2835533"));
//		e3.setCreationTime(formatter2.parse("2016-02-18T12:35:36Z"));
//		e3.setLastUpdateTime(formatter2.parse("2016-03-18T10:03:00Z"));
//		e3.setOrganiserName(null);
//		e3.setOrganiserDesc(null);
//		e3.setOfficialEvent(false);
//		e3.setFilePath(null);
//		
//		return Arrays.asList(e1,e2,e3);
//		
//	}

	public static JSONArray getCannedEventbriteResponse() throws JSONException {
		JSONArray cannedEvents = new JSONArray();
		
		
		// first object
		JSONObject event1 = new JSONObject();
		
		// create address object
		JSONObject address1 = new JSONObject();
		address1.put("country", "KG");
		address1.put("city", "Bishkek");
		address1.put("address_1", "Gorky Street");
		address1.put("address_2", "null");
		address1.put("latitude", "42.856827");
		address1.put("longitude", "74.61858410000002");
		address1.put("region", "Chuy Province");
		address1.put("postal_code", "null");
		
		// create venue object
		JSONObject venue1 = new JSONObject();
		venue1.put("address", address1);
		
		// create name object
		JSONObject name1 = new JSONObject();
		name1.put("text", "Boston Calling - May 27, 28, 29, 2016");
		name1.put("html", "Boston Calling - May 27, 28, 29, 2016");
		
		// create description object
		JSONObject description1 = new JSONObject();
		String desText1 = "event1 description mock";
		description1.put("text", desText1);
		description1.put("html", desText1);
		
		// create start object
		JSONObject start1 = new JSONObject();
		start1.put("timezone", "Asia/Bishkek");
		start1.put("local", "2016-04-05T18:30:00");
		start1.put("utc", "2016-04-05T12:30:00Z");
		
		// create end object
		JSONObject end1 = new JSONObject();
		end1.put("timezone", "Asia/Bishkek");
		end1.put("local", "2016-04-05T20:30:00");
		end1.put("utc", "2016-04-05T14:30:00Z");
		
		event1.put("name", name1);
		event1.put("description", description1);
		event1.put("start", start1);
		event1.put("end", end1);
		event1.put("created", "2016-04-02T14:48:24Z");
		event1.put("changed", "2016-04-02T14:48:26Z");
		event1.put("venue", venue1);
		
		
		
		// second object
		JSONObject event2 = new JSONObject();
				
		// create address object
		JSONObject address2 = new JSONObject();
		address2.put("country", "UZ");
		address2.put("city", "Tashkent");
		address2.put("address_1", "A. Navoi street 21");
		address2.put("address_2", "Shaykhontokhur district");
		address2.put("latitude", "41.2994958");
		address2.put("longitude", "69.24007340000003");
		address2.put("region", "null");
		address2.put("postal_code", "null");
				
		// create venue object
		JSONObject venue2 = new JSONObject();
		venue2.put("address", address2);
				
		// create name object
		JSONObject name2 = new JSONObject();
		name2.put("text", "IELTS lessons taught by one of the top IELTS teachers in Uzbekistan");
		name2.put("html", "IELTS lessons taught by one of the top IELTS teachers in Uzbekistan");
				
		// create description object
		JSONObject description2 = new JSONObject();
		String desText2 = "event2 description mock";
		description2.put("text", desText2);
		description2.put("html", desText2);
				
		// create start object
		JSONObject start2 = new JSONObject();
		start2.put("timezone", "Asia/Tashkent");
		start2.put("local", "2016-04-04T15:30:00");
		start2.put("utc", "2016-04-04T10:30:00Z");
				
		// create end object
		JSONObject end2 = new JSONObject();
		end2.put("timezone", "Asia/Tashkent");
		end2.put("local", "2016-06-03T17:30:00");
		end2.put("utc", "2016-06-03T12:30:00Z");
				
		event2.put("name", name2);
		event2.put("description", description2);
		event2.put("start", start2);
		event2.put("end", end2);
		event2.put("created", "2016-03-23T13:15:47Z");
		event2.put("changed", "2016-04-04T11:33:11Z");
		event2.put("venue", venue2);
		
		
		
		// second object
		JSONObject event3 = new JSONObject();
						
		// create address object
		JSONObject address3 = new JSONObject();
		address3.put("country", "UZ");
		address3.put("city", "Tashkent");
		address3.put("address_1", "null");
		address3.put("address_2", "null");
		address3.put("latitude", "41.3125");
		address3.put("longitude", "69.39027399999998");
		address3.put("region", "null");
		address3.put("postal_code", "100001");
						
		// create venue object
		JSONObject venue3 = new JSONObject();
		venue3.put("address", address3);
						
	    // create name object
		JSONObject name3 = new JSONObject();
		name3.put("text", "Get Traction: The Virtual Growth Event [Tashkent]");
		name3.put("html", "Get Traction: The Virtual Growth Event [Tashkent]");
						
		// create description object
		JSONObject description3 = new JSONObject();
		String desText3 = "event3 description mock";
		description3.put("text", desText3);
		description3.put("html", desText3);
						
		// create start object
		JSONObject start3 = new JSONObject();
		start3.put("timezone", "Asia/Samarkand");
		start3.put("local", "2016-03-01T10:00:00");
		start3.put("utc", "2016-03-01T05:00:00Z");
						
		// create end object
		JSONObject end3 = new JSONObject();
		end3.put("timezone", "Asia/Samarkand");
		end3.put("local", "2016-08-04T14:00:00");
		end3.put("utc", "2016-08-04T09:00:00Z");
						
		event3.put("name", name3);
		event3.put("description", description3);
		event3.put("start", start3);
		event3.put("end", end3);
		event3.put("created", "2016-03-23T13:15:47Z");
		event3.put("changed", "2016-04-04T11:33:11Z");
		event3.put("venue", venue3);
		
		
		
		
		cannedEvents.put(event1);
		cannedEvents.put(event2);
		cannedEvents.put(event3);
				
		
		System.out.println("return cannedEvents: " + cannedEvents);
		return cannedEvents;
	}
	
}
