/**
 * 
 */
package com.daac.pacq.dao.entity;

import java.util.List;

import com.daac.pacq.domain.entity.Contract;

/**
 * @author Serghey.Golub
 *
 */
public interface ContractDAO {
	
	public Contract				get(Integer id);
	public List<Contract> 		list();
	public List<Contract> 		list(Integer id);
	public List<Contract> 		filter(String filterString);
}
