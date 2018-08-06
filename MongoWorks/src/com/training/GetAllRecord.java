package com.training;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class GetAllRecord {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("exdb");
		DBCollection dbc = db.getCollection("food");
		DBCursor cursor = dbc.find();
		while (cursor.hasNext()) {
			DBObject object = cursor.next();

			System.out.println(object.get("item"));
			System.out.println(object.get("ratings"));

			System.out.println("............................................................");
		}

	}
}
