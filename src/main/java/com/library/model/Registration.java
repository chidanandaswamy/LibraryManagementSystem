package com.library.model;

import java.util.Objects;

public class Registration {

	private String name;
	private String mobileNo;
	private String uname;
	private String pass;
	private String role;

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getMobileNo() {
		return mobileNo;
	}

	void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	String getUname() {
		return uname;
	}

	void setUname(String uname) {
		this.uname = uname;
	}

	String getPass() {
		return pass;
	}

	void setPass(String pass) {
		this.pass = pass;
	}

	String getRole() {
		return role;
	}

	void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mobileNo, name, pass, role, uname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registration other = (Registration) obj;
		return Objects.equals(mobileNo, other.mobileNo) && Objects.equals(name, other.name)
				&& Objects.equals(pass, other.pass) && Objects.equals(role, other.role)
				&& Objects.equals(uname, other.uname);
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", mobileNo=" + mobileNo + ", uname=" + uname + ", pass=" + pass
				+ ", role=" + role + "]";
	}

}
