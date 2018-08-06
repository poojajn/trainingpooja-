package com.training.sparkworks;

import java.util.Arrays;

import org.apache.spark.api.java.function.Function;

public class ClenseRDDCars implements Function<String, String> {

	@Override
	public String call(String v1) throws Exception {
		System.out.println("ghfgh"+v1);
		String[] attributeList = v1.split("\t");
		// change char to number
		attributeList[3] = (attributeList[3].equals("two")) ? "2" : "4";
		// to change car type to upper case
		attributeList[4] = attributeList[4].toUpperCase();
		return Arrays.toString(attributeList);
	}

}
