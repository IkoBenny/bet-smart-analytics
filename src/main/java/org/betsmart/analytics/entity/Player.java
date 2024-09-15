package org.betsmart.analytics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {

	@Id
	@Column(name = "PLAYER_ID")
	private String id;
	
	@Column(name = "FIRST_NAME")
	private String fName;
	
	@Column(name = "LAST_NAME")
	private String lName;
	
	@Column(name = "START_YEAR")
	private String sYear;
	
	@Column(name = "END_YEAR")
	private String eYear;
	
	@Column(name = "POSITION")
	private String pos;
	
	@Column(name = "HEIGHT")
	private String height;
	
	@Column(name = "WEIGHT")
	private String weight;
	
	@Column(name = "BIRTHDATE")
	private String bDay;
	
	@Column(name = "COLLEGE")
	private String college;
	
	public Player (){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getsYear() {
		return sYear;
	}

	public void setsYear(String sYear) {
		this.sYear = sYear;
	}

	public String geteYear() {
		return eYear;
	}

	public void seteYear(String eYear) {
		this.eYear = eYear;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getbDay() {
		return bDay;
	}

	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}
	
}
