package com.gamerunner.gamerunnerapp.examples.c1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {

	private DataService dataService;

	@Autowired // not necessary for Constructor based injection
	public BusinessCalculationService(DataService dataService) {
		super();
		System.out.println("Contructor injection – BusinessCalculationService");
		this.dataService = dataService;
	}

	@Autowired
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Using " + dataService);
		return sb.toString();
	}
}
