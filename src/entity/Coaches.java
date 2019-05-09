package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Coaches entity. @author MyEclipse Persistence Tools
 */

public class Coaches implements java.io.Serializable {

	// Fields

	private String num;
	private String name;
	private String sex;
	private String age;
	private String address;
	private String phone;
	private String zp;
	private String introduction;
	private String worktime;
	private Set jxstudentses = new HashSet(0);
	private Set traincars = new HashSet(0);

	// Constructors

	/** default constructor */
	public Coaches() {
	}

	/** minimal constructor */
	public Coaches(String num, String name, String sex, String age, String address, String phone, String worktime) {
		this.num = num;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.worktime = worktime;
	}

	/** full constructor */
	public Coaches(String num, String name, String sex, String age, String address, String phone, String zp,
			String introduction, String worktime, Set jxstudentses, Set traincars) {
		this.num = num;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.zp = zp;
		this.introduction = introduction;
		this.worktime = worktime;
		this.jxstudentses = jxstudentses;
		this.traincars = traincars;
	}

	// Property accessors

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZp() {
		return this.zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getWorktime() {
		return this.worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public Set getJxstudentses() {
		return this.jxstudentses;
	}

	public void setJxstudentses(Set jxstudentses) {
		this.jxstudentses = jxstudentses;
	}

	public Set getTraincars() {
		return this.traincars;
	}

	public void setTraincars(Set traincars) {
		this.traincars = traincars;
	}

}