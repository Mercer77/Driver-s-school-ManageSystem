package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */

public class Car implements java.io.Serializable {

	// Fields

	private String carnum;
	private String carname;
	private Set traincars = new HashSet(0);

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(String carnum) {
		this.carnum = carnum;
	}

	/** full constructor */
	public Car(String carnum, String carname, Set traincars) {
		this.carnum = carnum;
		this.carname = carname;
		this.traincars = traincars;
	}

	// Property accessors

	public String getCarnum() {
		return this.carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getCarname() {
		return this.carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public Set getTraincars() {
		return this.traincars;
	}

	public void setTraincars(Set traincars) {
		this.traincars = traincars;
	}

}