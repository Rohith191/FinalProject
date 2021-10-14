package com.rohit.cms.models;

import java.util.List;

public interface Validator {
	List<String> getErrors();
	boolean Validate();
}
