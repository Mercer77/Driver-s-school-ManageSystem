package entity;

import java.sql.Timestamp;

/**
 * Ordertest entity. @author MyEclipse Persistence Tools
 */

public class Ordertest implements java.io.Serializable {

	// Fields

	private Integer id;
	private Jxstudents jxstudents;
	private String name;
	private String test;
	private String phone;
	private String address;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Ordertest() {
	}

	/** full constructor */
	public Ordertest(Jxstudents jxstudents, String name, String test, String phone, String address, Timestamp time) {
		this.jxstudents = jxstudents;
		this.name = name;
		this.test = test;
		this.phone = phone;
		this.address = address;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Jxstudents getJxstudents() {
		return this.jxstudents;
	}

	public void setJxstudents(Jxstudents jxstudents) {
		this.jxstudents = jxstudents;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTest() {
		return this.test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}