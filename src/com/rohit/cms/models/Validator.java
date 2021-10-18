package com.rohit.cms.models;

import java.util.List;

public interface Validator<T> {
	List<String> getErrors();
	boolean Validate(T obj);
}
