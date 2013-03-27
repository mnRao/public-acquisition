package com.daac.pacq.service.entity;

import java.util.List;

import com.daac.pacq.domain.entity.Question;

public interface QuestionService {

	public Question	get(Integer id);
	public List<Question> list(Integer id);
	public List<Question> filter(String filterString);
}
