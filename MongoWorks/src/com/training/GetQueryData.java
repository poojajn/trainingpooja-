package com.training;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class GetQueryData {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("exdb");
		DBCollection dbc = db.getCollection("emps");
		DBObject queryCondition = new BasicDBObject("empid", 103);

		DBObject sortCondition = new BasicDBObject("empname", -1);

		DBCursor cursor = dbc.find(queryCondition).sort(sortCondition).limit(2);
		while (cursor.hasNext()) {
			DBObject object = cursor.next();
			System.out.println(JSON.serialize(object));
		}
	}
}
