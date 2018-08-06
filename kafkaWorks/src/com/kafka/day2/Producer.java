package com.kafka.day2;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class Producer extends Thread {

	private KafkaProducer<Integer, String> producer;
	private String topic;
	private Boolean isAsync;
	private Boolean interpt;
	private String name;

	@SuppressWarnings("resource")
	public Producer(String topic, Boolean isAsync, String name) {
		super();
		this.topic = topic;
		this.isAsync = isAsync;
		this.name = name;
		interpt = false;
		Properties pr = new Properties();
		pr.setProperty("bootstrap.servers", KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);

		pr.setProperty("client.id", KafkaProperties.PRODUCER_CLIENT_ID);

		pr.setProperty("key.serializer", IntegerSerializer.class.getName());
		pr.setProperty("value.serializer", StringSerializer.class.getName());

		producer = new KafkaProducer<>(pr);
	}

	@Override
	public void run() {
		int messaNo = 1;
		while (!interpt) {

			String messgeString = "Message from Prducer" + this.name + "Count :" + messaNo;
			if (isAsync) {
				ProducerRecord<Integer, String> record = new ProducerRecord<Integer, String>(this.topic, messaNo,
						messgeString);

				long starttime = System.currentTimeMillis();

				producer.send(record, new ProducerMessageCallable(starttime, messaNo, messgeString));

				// producer.send(record);
			} else {
				ProducerRecord<Integer, String> record = new ProducerRecord<Integer, String>(this.topic, messaNo,
						messgeString);
				try {
					producer.send(record).get();
				} catch (InterruptedException | ExecutionException e1) {
					e1.printStackTrace();
				}

			}
		}

	}

	public void setInterupt(boolean interrupt) {
		this.interpt = interrupt;
	}
}