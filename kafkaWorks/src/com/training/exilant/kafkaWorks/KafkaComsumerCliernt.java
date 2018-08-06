package com.training.exilant.kafkaWorks;

import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaComsumerCliernt {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("bootstrap.servers", "localhost:9092");
		prop.setProperty("key.deserializer", StringDeserializer.class.getName());
		prop.setProperty("value.deserializer", StringDeserializer.class.getName());
		prop.setProperty("group.id", "FirstGroup");

		prop.setProperty("session.timeout.ms", "30000");
		prop.setProperty("auto.offset.reset", "earliest");

		KafkaConsumer<String, String> kafkaConsum = new KafkaConsumer<>(prop);
		kafkaConsum.subscribe(Arrays.asList("topicA"));

		while (true) {
			ConsumerRecords<String, String> consumerRecords = kafkaConsum.poll(1000);

			System.out.println("count msg" + consumerRecords.count());

			for (ConsumerRecord<String, String> temp : consumerRecords) {
				System.out.println("key:" + temp.key() + ", value" + temp.value() + " ,partition" + temp.partition()
						+ ", Topic" + temp.topic() + ",time" + new Date(temp.timestamp()));

			}
			try {
				Thread.sleep(100);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
