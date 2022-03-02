package com.vivek.Chakrawaat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
		
	public void drive() {
		System.out.println("Bhaag rhi hai.. car: ");
	}

}
