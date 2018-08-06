package com.kafka.day2;

public class Client {
	public static void main(String[] args) {
		System.out.println("sfadsf");
		Boolean isAsync = true;

		Producer producer = new Producer(KafkaProperties.TOPIC2, isAsync, "FisrtTest");
		producer.start();

		try {

			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		producer.setInterupt(true);
	}
}
