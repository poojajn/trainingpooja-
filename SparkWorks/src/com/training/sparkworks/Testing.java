package com.training.sparkworks;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Testing {
	public static void main(String[] args) {

		String appName = "sampleApp1";
		// as of now we have got 2 instances of spark or this can be got from remote
		// instance
		String sparkMaster = "local[2]";
		JavaSparkContext spContext = null;
		SparkConf conf = new SparkConf().setAppName(appName).setMaster(sparkMaster);
		// creating spark context from configuration
		spContext = new JavaSparkContext(conf);

		// read file into RDD
		JavaRDD<String> tweetsRDD = spContext.textFile("./data/movie.csv");
		// tweetsRDD.take(5).forEach(System.out::println);

		tweetsRDD.take(5).forEach(System.out::println);

		spContext.close();

	}
}
