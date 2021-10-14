package com.rohit.cms.user;

import java.util.ArrayList;
import java.util.List;

import com.rohit.cms.models.CmsUser;
import com.rohit.cms.models.Validator;

public class UserValidator implements Validator {
	ArrayList<String> errors;
	CmsUser user;
	public UserValidator(CmsUser user) {
		this.errors = new ArrayList<String>();
		this.user = user;
	}
	@Override
	public boolean Validate() {
		if(user.username == "" || user.username == null) {
			errors.add("Username cannot be empty");
		}
		if(user.password == "" || user.password == null) {
			errors.add("Password cannot be empty");
		}
		if(user.username != null && user.username.length() < 5) {
			errors.add("Username cannot be less than 5 characters");
		}
		if(user.username != null && user.username.length() > 50) {
			errors.add("Username cannot be greater than 50 characters");
		}
		if(user.password != null && user.password.length() > 20) {
			errors.add("Password cannot be greater than 20 characters");
		}
		return errors.size() == 0;
	}

	@Override
	public List<String> getErrors() {
		return errors;
	}

}
