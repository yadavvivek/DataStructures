package com.vivek.SpringAnno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class MediaTex implements MobileProcessor {

	public void process() {
	    System.out.println("2nd best processor!");
	}

}
