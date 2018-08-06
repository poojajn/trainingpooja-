package com.training;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class StoreEmpRecord {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB("exdb");
		DBCollection dbc = db.getCollection("emps");
		DBObject objetc = new BasicDBObject();
		objetc.put("empid", 302);
		objetc.put("empname", "shibani");
		objetc.put("email", "shibani@gmai.com");
		// dbc.save(objetc);
		// 2 nd way
		Map<String, Object> map = new HashMap<>();
		map.put("empid", 303);
		map.put("empid", "sahana");
		map.put("empid", "sahana@gmail.com");
		// dbc.save(new BasicDBObject(map));
		// 3rd way
		String jsonString = "{empid:305,empname:'harini',email:'harini@gmail.com',esal:3454}";
		// dbc.save((DBObject) JSON.parse(jsonString));
		System.out.println("object saved...");

		/// forth way
		Employee emp = new Employee();
		emp.setEmpid(307);
		emp.setName("anuj");
		emp.setEmail("dfdsfgds");
		emp.setSalary(4543);
		dbc.save((DBObject) emp);
		System.out.println("data saved....");

	}
}
