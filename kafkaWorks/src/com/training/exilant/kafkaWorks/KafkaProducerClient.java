package com.training.exilant.kafkaWorks;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * http://kafka.apache.org/documentation
 * 
 * @author pooja.j
 *
 */
public class KafkaProducerClient {
	public static void main(String[] args) {
		// set all the properties
		// the details can be kept in flat file or properties vlass

		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "localhost:9092");
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());

		properties.setProperty("acks", "1");
		properties.setProperty("retries", "3");

		Producer<String, String> producer = new KafkaProducer<String, String>(properties);

		for (int i = 0; i < 100; i++) {
			ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("topicA", "1" + i,
					"Testing message from java" + i);
			System.out.println("message sent..." + i);
			producer.send(producerRecord);
		}
		/*
		 * ProducerRecord<String, String> producerRecord = new ProducerRecord<String,
		 * String>("topicA", "1", "Testing message from java");
		 * producer.send(producerRecord);
		 */
		producer.flush();
		producer.close();
		System.out.println("message sent...");

	}
}
