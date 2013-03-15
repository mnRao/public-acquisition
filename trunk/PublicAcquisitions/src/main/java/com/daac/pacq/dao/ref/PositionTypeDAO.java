package com.daac.pacq.dao.ref;

import java.util.List;

import com.daac.pacq.domain.ref.PositionType;

public interface PositionTypeDAO {

	public PositionType			get(Integer id);
	public List<PositionType> 	list();
	public List<PositionType> 	filter(String filterString);
}
