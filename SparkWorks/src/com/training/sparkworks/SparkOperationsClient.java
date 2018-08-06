package com.training.sparkworks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import com.training.commons.DataSource;
import com.training.commons.SparkConnection;
import com.training.commons.Utilities;

public class SparkOperationsClient {
	public static void main(String[] args) {
		Logger.getLogger("org").setLevel(Level.ERROR);
		Logger.getLogger("akka").setLevel(Level.ERROR);

		JavaSparkContext sparkContext = SparkConnection.getContext();
		JavaRDD<Integer> collData = DataSource.getcollData();
		System.out.println("total no. of daat..." + collData.count());

		// 2.load the file and cache it
		JavaRDD<String> autoDataContent = sparkContext.textFile("./data/autoData.csv");
		// to know no. of records
		System.out.println("fsdfsdf" + autoDataContent.count());

		autoDataContent.take(4).forEach(System.out::println);

		System.out.println("loading data from file");
		Utilities.printStringRDD(autoDataContent, 12);
		// storing RDD's
		// autoDataContent.saveAsTextFile("data/auto-data-modified.csv");

		JavaRDD<String> tabData = autoDataContent.map(str -> str.replace(",", "/t"));
		Utilities.printStringRDD(tabData, 5);

		/////////////////////// filter
		/////////////////////// example///////////////////////////////////////////////
		String header = autoDataContent.first();
		JavaRDD<String> autoDataWithoutHerader = autoDataContent.filter(s -> !s.equals(header));
		Utilities.printStringRDD(autoDataWithoutHerader, 5);

		// get only toyota data
		JavaRDD<String> toyota = autoDataContent.filter(s -> !s.contains("toyota"));
		Utilities.printStringRDD(toyota, 5);

		JavaRDD<String> distinct = autoDataContent.distinct();
		Utilities.printStringRDD(distinct, 10);

		// to count number of worrds in the given RDD
		System.out.println("using flat map");
		JavaRDD<String> words = toyota.flatMap(new FlatMapFunction<String, String>() {

			@Override
			public Iterator<String> call(String t) throws Exception {
				return Arrays.asList(t.split(",")).iterator();

			}

		});
		System.out.println("toyotaRDD word count ::" + words.count());

		// after clensing the data
		System.out.println("*******************After clensing Data*******************");
		JavaRDD<String> clenseRDD = autoDataContent.map(new ClenseRDDCars());

		Utilities.printStringRDD(clenseRDD, 2);

		// set operations
		JavaRDD<String> words1 = sparkContext.parallelize(Arrays.asList("pooja", "how", "are", "u"));
		JavaRDD<String> word2 = sparkContext.parallelize(Arrays.asList("pooja", "how", "gdgdfg"));
		System.out.println("uninon operation-Set");
		Utilities.printStringRDD(words1.union(word2), 9);

		System.out.println("intersaption operations Set");
		Utilities.printStringRDD(words1.intersection(word2), 9);

		// find sum of number in the given RDD(3, 4, 45, 563, 3, 3, 6, 88, 89)
		Integer collDatacount = collData.reduce((x, y) -> x + y);
		System.out.println("sum of given Intergers  " + collDatacount);

		// Integer collDataavrage = collData;

		// System.out.println("sum of given Intergers " + collDatacount);
	}

}
