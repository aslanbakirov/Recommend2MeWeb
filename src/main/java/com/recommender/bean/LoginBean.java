package com.recommender.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "loginBean")
public class LoginBean {

	String username;
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(ActionEvent actionEvent) {
		if (("test".equalsIgnoreCase(getUsername())
				&& "test".equals(getPassword())) || ("aslan".equalsIgnoreCase(getUsername())
						&& "aslan".equals(getPassword())) || ("fat".equalsIgnoreCase(getUsername())
								&& "fat".equals(getPassword())) ) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml?username=" +getUsername());
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("username", new FacesMessage(
					"Invalid UserName and Password"));
		}
	}
	
}
