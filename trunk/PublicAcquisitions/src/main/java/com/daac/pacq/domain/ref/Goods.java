package com.daac.pacq.domain.ref;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "REF_GOODS")
public class Goods  extends AbstractRefEntity  {
	
    @Column(name = "CODE")
    private String code;
    
    @Column(name = "PARENT_ID")
    private Integer parentId;
    
    @Column(name = "REF_TYPE_ID")
    private Integer typeId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
    
   
}
