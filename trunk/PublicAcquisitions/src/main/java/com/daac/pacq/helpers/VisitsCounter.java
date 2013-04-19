package com.daac.pacq.helpers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class VisitsCounter  {
	private int isOldSession = 0;

	public int getIsOldSession() {
		
		if(isOldSession == 0) {
			isOldSession = 1;
			return 0;
		}
		
		return isOldSession;
	}

	
}
