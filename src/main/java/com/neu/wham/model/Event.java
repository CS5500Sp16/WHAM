package com.neu.wham.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Event {
	@NotEmpty(message="Event name is empty") 
	private String eventName;
	@NotEmpty(message="Event desc is empty") 
	private String eventDesc;
	@NotNull(message="Event location cannot be null") 
	private String eventLocation;
	private String phoneNumber;
	@NotNull(message="Organiser Mail is null") 
	private String emailId;
	@NotNull(message="Event start Date is null") 
	private Date startDate;
	@NotNull(message="Event end Date is null") 
	private Date endDate;
	@NotNull(message="Event start Time is null") 
	private Date startTime;
	@NotNull(message="Event end time is null") 
	private Date endTime;
	private double latitude;
	private double longitude;
	private String filePath;
	@NotNull(message="Event organiser name is null") 
	private String organiserName;
	@NotNull(message="Event organiser desc is null") 
	private String organiserDesc;
	private boolean isOfficialEvent;
	private Date creationTime;
	private Date lastUpdateTime;
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getOrganiserName() {
		return organiserName;
	}
	public void setOrganiserName(String organiserName) {
		this.organiserName = organiserName;
	}
	public String getOrganiserDesc() {
		return organiserDesc;
	}
	public void setOrganiserDesc(String organiserDesc) {
		this.organiserDesc = organiserDesc;
	}
	public boolean isOfficialEvent() {
		return isOfficialEvent;
	}
	public void setOfficialEvent(boolean isOfficialEvent) {
		this.isOfficialEvent = isOfficialEvent;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", eventDesc=" + eventDesc + ", eventLocation=" + eventLocation
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", startTime=" + startTime + ", endTime=" + endTime + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", filePath=" + filePath + ", organiserName=" + organiserName
				+ ", organiserDesc=" + organiserDesc + ", isOfficialEvent=" + isOfficialEvent + ", creationTime="
				+ creationTime + ", lastUpdateTime=" + lastUpdateTime + "]";
	}
}
