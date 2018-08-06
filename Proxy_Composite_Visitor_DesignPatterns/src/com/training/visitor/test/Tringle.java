package com.training.visitor.test;

import java.util.ArrayList;
import java.util.List;

public class Tringle implements Shape {

	private static List<Shape> shapes;
	static{
		shapes=new ArrayList<>();
	}

	public Tringle(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	public void addShape(Shape shape) {
		shapes.add(shape);
	System.out.println("Tringle.addShape( )");
	}

	public void removeShape(Shape shape) {
		System.out.println("Tringle.removeShape()");
	}

	@Override
	public void acceptDraw(Visitor visitor) {
		visitor.draw(this);
		//System.out.println("Tringle.acceptDraw()");

	}

	@Override
	public void acceptPaint(Visitor visitor) {
		System.out.println("Tringle.acceptPaint()");

	}

}
