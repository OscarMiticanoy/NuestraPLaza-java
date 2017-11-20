package com.concretepage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean(name = "userBean", eager = true)
@RequestScoped
public class UserBean {
	private String email;
	public String save(){
		return "output";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}