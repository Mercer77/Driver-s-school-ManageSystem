package entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Jxstudents entity. @author MyEclipse Persistence Tools
 */

public class Jxstudents implements java.io.Serializable {

	// Fields

	private String num;
	private Coaches coaches;
	private String name;
	private String sex;
	private String idcard;
	private String phone;
	private String ksjd;
	private Timestamp signuptime;
	private String zp;
	private Set ordertests = new HashSet(0);

	// Constructors

	/** default constructor */
	public Jxstudents() {
	}

	/** minimal constructor */
	public Jxstudents(String num, String ksjd, Timestamp signuptime) {
		this.num = num;
		this.ksjd = ksjd;
		this.signuptime = signuptime;
	}

	/** full constructor */
	public Jxstudents(String num, Coaches coaches, String name, String sex, String idcard, String phone, String ksjd,
			Timestamp signuptime, String zp, Set ordertests) {
		this.num = num;
		this.coaches = coaches;
		this.name = name;
		this.sex = sex;
		this.idcard = idcard;
		this.phone = phone;
		this.ksjd = ksjd;
		this.signuptime = signuptime;
		this.zp = zp;
		this.ordertests = ordertests;
	}

	// Property accessors

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Coaches getCoaches() {
		return this.coaches;
	}

	public void setCoaches(Coaches coaches) {
		this.coaches = coaches;
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

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getKsjd() {
		return this.ksjd;
	}

	public void setKsjd(String ksjd) {
		this.ksjd = ksjd;
	}

	public Timestamp getSignuptime() {
		return this.signuptime;
	}

	public void setSignuptime(Timestamp signuptime) {
		this.signuptime = signuptime;
	}

	public String getZp() {
		return this.zp;
	}

	public void setZp(String zp) {
		this.zp = zp;
	}

	public Set getOrdertests() {
		return this.ordertests;
	}

	public void setOrdertests(Set ordertests) {
		this.ordertests = ordertests;
	}

}