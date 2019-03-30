package cn.sxt.application.pojo;

import java.io.Serializable;

/***
 * 用户实体类
 */
public class User implements Serializable{
	
	private Integer id;
	private String uname;
	private String address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		//System.out.println("=============getUname");
		return uname;
	}
	public void setUname(String uname) {
		//System.out.println("=============setUname");
		this.uname = uname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
