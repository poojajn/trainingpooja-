package com.training;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class GetOneRecord {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("exdb");
		DBCollection dbc = db.getCollection("food");
		DBObject myobj = dbc.findOne();
		System.out.println("emp id" + myobj.get("empid"));
		System.out.println("emp name" + myobj.get("empname"));
		System.out.println("emp mail" + myobj.get("email"));
	}
}
