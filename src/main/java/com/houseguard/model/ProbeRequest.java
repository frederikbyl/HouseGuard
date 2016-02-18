package com.houseguard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;


@Entity
@Table(name="PROBE_REQUEST")
public class ProbeRequest {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Integer id;
	
	@Column(name="MACADDRESS", nullable = false)
	private String macAddress;
	
	private DateTime loggedTime;
	
	private HouseGuardUser user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public DateTime getLoggedTime() {
		return loggedTime;
	}

	public void setLoggedTime(DateTime loggedTime) {
		this.loggedTime = loggedTime;
	}

	public HouseGuardUser getUser() {
		return user;
	}

	public void setUser(HouseGuardUser user) {
		this.user = user;
	}
	
	
}
