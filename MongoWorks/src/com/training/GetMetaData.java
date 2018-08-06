package com.training;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class GetMetaData {
	public static void main(String[] args) {
		// localhost port:27017
		MongoClient mongoclient = new MongoClient("localhost", 27017);
		System.out.println("connection got to" + mongoclient);
		System.out.println("list of DBS from mongo:");
		for (String dbName : mongoclient.getDatabaseNames()) {
			System.out.println("\t" + dbName);
			DB db = mongoclient.getDB(dbName);
			for (String collectionName : db.getCollectionNames()) {
				System.out.println("\t\t" + collectionName);
			}
		}
	}
}
