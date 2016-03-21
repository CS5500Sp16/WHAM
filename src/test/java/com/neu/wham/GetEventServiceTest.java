package com.neu.wham;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.neu.wham.controllers.DataSourceController;
import com.neu.wham.exceptions.LocationException;
import com.neu.wham.exceptions.LocationException.LocationExceptionType;
import com.neu.wham.model.Event;
import com.neu.wham.services.GetEventService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("test-context.xml")
public class GetEventServiceTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private DataSourceController dataSourceController;
	 
    @Mock
    private GetEventService getEventServiceMock; 
    private LocationException locationException;
    
    @Autowired
    private WebApplicationContext context;
   

    @Before
//    public void setup() {
//      this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//    }
    public void setup() {
    	MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(dataSourceController)
        		//.setHandlerExceptionResolvers(new ExceptionHandlerExceptionResolver())
        		.build();
      }
    
        
    @Test
    public void getEvents_validLatLonRadTest() throws Exception{
    	
    	SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	
    	Event e1 = new Event();
    	e1.setEventName("Get Traction: The Virtual Growth Event [Tashkent]");
    	String e1Desc = "Register Now>> http://re.tc/wwondecl \nLEARN STRATEGIES, TACTICS "
    			+ "& TOOLS FOR GROWTH MARKETING IN 2016 \nIMPORTANT NOTE: This is a Virtual Event."
    			+ " You will receive your login information via email on February 29, 2016  \n  \n"
    			+ "Overview: \nThere’s no denying that growth is hot and here to stay. But despite "
    			+ "the buzz, many businesses still don’t have the framework they need to build a successful "
    			+ "growth engine. Join a community of data-driven marketers, sales hackers and innovative"
    			+ " entrepreneurs who will learn the fundamentals of rapid growth for 2016.  "
    			+ "\nEvent Features: \n3 days of in-depth learning ( 15 interactive sessions) - covering growth "
    			+ "fundamentals, advanced tactics, business development and sales \nConnect with 3K+ founders, "
    			+ "growth marketing execs and innovation teams \nAll sessions will be recorded and available on-demand "
    			+ "\nTopics include:  \n\nLean branding hacks and strategy\nEarly-stage growthProduct "
    			+ "marketing & UX/UI\nLean management and hiring\nReferral marketing\nCommunity development\n"
    			+ "Digital Marketing Best Practices\nSearch engine optimization\nWeb analytics\nSocial media & "
    			+ "content marketing\nAffiliate marketing\nDigital advertising & Paid Search\nEmail marketing"
    			+ " automation\nGrowth Hacking\nConversion optimization & testing\nMarketplace & viral growth\nGamification\nWeb"
    			+ " Scraping\nSales Automation\nHacking partnerships\n\n  \nLEARN MORE \n  \n   \nWho should Attend:"
    			+ "  \nGrowth Hackers • Growth Marketers• Founders • CEOs • Marketing Directors •  Software Engineers"
    			+ " • \nProduct Managers • Small Business Owners • Marketing Consultants • Investors • Mentors • Entrepreneurs"
    			+ " • Sales Executives \nPARTNERS: \n\n\n\n\n  \n\n\n  \n  \n\n\n\n \n\n  \n\n\n\n\n  \n\n\n  \n\n\n\n\n  \n\n\n"
    			+ "  \n\n\n\n\n  \n\n\n  \n\n\n\n\n  \n\n\n   \n\n\n\n\nIf you would like to learn more about sponsorship packages,"
    			+ " please send us an email to sponsor@startupsocials.com \nFollow US \nWeb I Linkedin I Facebook I Meetup "
    			+ "  \n  \n  \n•"; 	
    	e1.setEventDesc(e1Desc);
    	e1.setEventLocation("Tashkent 100001 UZ");
    	e1.setPhoneNumber(null);
    	e1.setEmailId(null);    	
    	e1.setStartDate(formatter1.parse("2016-03-01"));
    	TimeZone tz1 = TimeZone.getTimeZone("Asia/Samarkand");
		formatter2.setTimeZone(tz1);
    	e1.setEndDate(formatter2.parse("2016-08-04T14:00:00"));
    	e1.setEndTime(formatter2.parse("2016-08-04T14:00:00"));
    	e1.setLatitude(Double.parseDouble("41.3125"));
    	e1.setLongitude(Double.parseDouble("69.39027399999998"));
    	e1.setCreationTime(formatter2.parse("2016-02-24T00:25:20Z"));
    	e1.setLastUpdateTime(formatter2.parse("2016-03-01T08:32:17Z"));
    	e1.setOrganiserName(null);
		e1.setOrganiserDesc(null);
		e1.setOfficialEvent(false);
		e1.setFilePath(null);
		
		
		Event e2 = new Event();
    	e2.setEventName("인터넷바카라추천【DON963 쩜컴】카지노사이트");
    	String e2Desc = "be8인터넷바카라추천【DON963 쩜컴】카지노사이트인터넷바카라추천＼"
    			+ "ら카지노사이트인터넷바카라추천＼ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼"
    			+ "ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼ら바카라사이트＼"
    			+ "ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라＼ら카지노사이트인터넷바카라추천＼"
    			+ "ら바카라사이트＼ら온라인카지노＼ら온라인바카라＼ら실시간카지노＼ら실시간바카라"; 	
    	e2.setEventDesc(e2Desc);
    	e2.setEventLocation("32/1 Titov Street Dushanbe Districts of Republican Subordination 734012 TJ");
    	e2.setPhoneNumber(null);
    	e2.setEmailId(null);    	
    	e2.setStartDate(formatter1.parse("2016-03-22"));
    	TimeZone tz2 = TimeZone.getTimeZone("Asia/Dushanbe");
		formatter2.setTimeZone(tz2);
    	e2.setEndDate(formatter2.parse("2016-03-22T22:00:00"));
    	e2.setEndTime(formatter2.parse("2016-03-22T22:00:00"));
    	e2.setLatitude(Double.parseDouble("38.5486864"));
    	e2.setLongitude(Double.parseDouble("68.8155587"));
    	e2.setCreationTime(formatter2.parse("2016-03-21T13:26:36Z"));
    	e2.setLastUpdateTime(formatter2.parse("2016-03-21T13:26:38Z"));
    	e2.setOrganiserName(null);
		e2.setOrganiserDesc(null);
		e2.setOfficialEvent(false);
		e2.setFilePath(null);
		
		
		Event e3 = new Event();
    	e3.setEventName("Встреча с Вице-Ректором университета Туриба, Рига, Латвия, Господином Имантсом Бергсом");
    	String e3Desc = "Уважаемые абитуриенты, будущие студенты Туриба и все, кто еще не определился с университетом! \n"
    			+ "Приглашаем Вас посетить открытую встречу с Вице-Ректором университета #Туриба, #Рига, #Латвия, "
    			+ "Господином Имантсом Бергсом, которая состоится 3 апреля 2016г. в Ташкенте.  \nФормат встречи – неформальное общение."
    			+ " Сначала Господин Бергс сделает небольшую презентацию об университете и студенческой жизни в Латвии. "
    			+ "Затем Вы сможете задать ему любые вопросы касательно университета, предметов, необходимых документов,"
    			+ " стипендий для студентов из Узбекистана и т.п. \nБольше информации об университете на нашей страничке в Facebook"
    			+ " - https://web.facebook.com/educationstandard/ \nВстреча будет проходить 3 апреля с 15.00 до 18.00 в отеле Radisson Blu,"
    			+ " Конференц-зал №2 Turquoise. \nЧтобы записаться на встречу необходимо: \n1. Нажать на кнопку «Select a time» (верхний правый угол под названием)."
    			+ " Страница обновится. \n2. Нажать в том же правом верхнем углу под названием кнопку «Register», выбрать время встречи и нажать «Checkout». \n"
    			+ "3. Ввести требуемые данные и нажать «Complete Registration». \nПри успешной регистрации на указанную вами почту придет электронный билет. "
    			+ "Не забудьте распечатать его и взять с собой на встречу :) \nВсе вопросы по телефону (+99871) 2687544."; 	
    	e3.setEventDesc(e3Desc);
    	e3.setEventLocation("88, Amir Temur Street Тошкент Toshkent Viloyati UZ");
    	e3.setPhoneNumber(null);
    	e3.setEmailId(null);    	
    	e3.setStartDate(formatter1.parse("2016-04-03"));
    	TimeZone tz3 = TimeZone.getTimeZone("Asia/Samarkand");
		formatter2.setTimeZone(tz3);
    	e3.setEndDate(formatter2.parse("2016-03-22T22:00:00"));
    	e3.setEndTime(formatter2.parse("2016-03-22T22:00:00"));
    	e3.setLatitude(Double.parseDouble("41.3296372"));
    	e3.setLongitude(Double.parseDouble("69.2835533"));
    	e3.setCreationTime(formatter2.parse("2016-02-18T12:35:36Z"));
    	e3.setLastUpdateTime(formatter2.parse("2016-03-18T10:03:00Z"));
    	e3.setOrganiserName(null);
		e3.setOrganiserDesc(null);
		e3.setOfficialEvent(false);
		e3.setFilePath(null);
    	
		String lat = "42.3389";
		String lon = "71.0903";
		String rad = "500";
		
		when(getEventServiceMock.getEvents(lat, lon, rad)).thenReturn(Arrays.asList(e1,e2,e3));
		
		String url = "/datasource/" + lat + "/" + lon + "/" + rad;
		mockMvc.perform(get(url))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].eventName", is("Get Traction: The Virtual Growth Event [Tashkent]")))
				.andExpect(jsonPath("$[1].eventName", is("인터넷바카라추천【DON963 쩜컴】카지노사이트")))
				.andExpect(jsonPath("$[2].eventName", is("Встреча с Вице-Ректором университета Туриба, Рига, Латвия, Господином Имантсом Бергсом")));
    }
    
    //?lat=91&long=0&r=10
    //Expected Return: { Coordinates are not valid. Please ensure lattitude is between -90 and 90 and longitude is between -180 and 180 } 
    @Test(expected = LocationException.class)
    public void getEvents_invalidLonTest() throws Exception{
    	String lat = "91";
    	String lon = "0";
    	String rad = "10";
    	String url = "/datasource/" + lat + "/" + lon + "/" + rad;
    	
    	LocationException exception = new LocationException(LocationExceptionType.LOCATION_OUT_OF_BOUNDS);
    	
    	when(dataSourceController.firstRequest(lat, lon, rad)).thenThrow(locationException);
    	
		mockMvc.perform(get(url))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0]", is(exception)));   
    
    
    }
    
}
