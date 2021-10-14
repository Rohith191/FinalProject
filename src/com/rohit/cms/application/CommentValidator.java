package com.rohit.cms.application;

import java.util.ArrayList;
import java.util.List;

import com.rohit.cms.models.Comment;
import com.rohit.cms.models.Validator;

public class CommentValidator implements Validator {
	Comment comment;
	ArrayList<String> errors;
	public CommentValidator(Comment comment) {
		this.comment = comment;
		this.errors = new ArrayList<String>();
	}
	@Override
	public List<String> getErrors() {
		return errors;
	}

	@Override
	public boolean Validate() {
		if(comment.body == null || comment.body == "") {
			errors.add("Comment body cannot be empty!");
		}
		if(comment.body != null || comment.body.length() > 100) {
			errors.add("Comment body cannot be greater than 100 characters!");
		}
		return errors.size() == 0;
	}

}
