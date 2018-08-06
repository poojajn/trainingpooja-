package com.training.commons;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class DataSource {
	public static JavaRDD<Integer> getcollData() {
		JavaSparkContext spContext = SparkConnection.getContext();

		List<Integer> data = Arrays.asList(3, 4, 45, 563, 3, 3, 6, 88, 89);
		JavaRDD<Integer> collData = spContext.parallelize(data);
		collData.cache();
		return collData;
	}
}
