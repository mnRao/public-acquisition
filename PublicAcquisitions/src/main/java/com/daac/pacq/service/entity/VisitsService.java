package com.daac.pacq.service.entity;

import java.util.Date;

import com.daac.pacq.domain.entity.Visits;

public interface VisitsService {

	public Visits 		get(Date id);
	public void			add(Visits item);
	public void			update(Visits item);
}
