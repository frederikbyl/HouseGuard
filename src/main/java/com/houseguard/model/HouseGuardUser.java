package com.houseguard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;


@Entity
@Table(name="PROBE_REQUEST")
public class HouseGuardUser {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Integer id;
	
	@Column(name="MACADDRESS", nullable = false)
	private String macAddress;
	
	private DateTime loggedTime;
	
	private HouseGuardUser user;
}
