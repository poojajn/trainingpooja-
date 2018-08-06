package com.training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;

public class StoreImage {
	public static void main(String[] args) throws FileNotFoundException {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("exdb");

		GridFS gfs = new GridFS(db, "myimages");
		String path = "/Users/pooja.j/Desktop/images";
		File folder = new File(path);
		for (File file : folder.listFiles()) {
			InputStream ins = new FileInputStream(file);
			GridFSInputFile picture = gfs.createFile(ins, file.getName());
			picture.setMetaData(new BasicDBObject("description", "image" + file.getName() + "store in exilant"));
			picture.save();
		}
		mongoClient.close();
		System.out.println("picture saved in DB......");
	}
}
