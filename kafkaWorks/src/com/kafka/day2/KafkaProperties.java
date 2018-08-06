package com.kafka.day2;

public interface KafkaProperties {
	String TOPIC1 = "sample-topic";
	String TOPIC2 = "sample-topic2";

	String KAFKA_SERVER_URL = "localhost";
	int KAFKA_SERVER_PORT = 9092;

	int KAFKA_PRDUCER_BUFFER_SIZE = 100 * 1024;
	int CONNECTION_TIME_OUT = 1000 * 10 * 10;
	String CLIENT_ID = "SimpleCosumnerDemoClient";
	String PRODUCER_CLIENT_ID = "SimpleCosumnerDemoProducerClient";
}
