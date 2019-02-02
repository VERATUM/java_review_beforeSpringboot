package com.testServlet.entity;
/**
 * User实体类
 * @author Administrator
 *
 */
public class User {
	private Integer id;
	private String name;
	private String password;
	private String mail;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public User(Integer id, String name, String password, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mail = mail;
	}
	public User() {}
}
