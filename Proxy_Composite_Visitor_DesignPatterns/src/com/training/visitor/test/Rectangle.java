package com.training.visitor.test;

import java.util.ArrayList;
import java.util.List;

public class Rectangle implements Shape {

	private static  List<Shape> shapes;
	static{
		shapes= new ArrayList<>();
	}
	public Rectangle(String name) {
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
		System.out.println("Rectangle.addShape( )");
	}

	public void removeShape(Shape shape) {
		System.out.println("Rectangle.removeShape()");
	}
	
	@Override
	public void acceptDraw(Visitor visitor) {
		visitor.draw(this);
		//System.out.println("Rectangle.acceptDraw()");
	}

	@Override
	public void acceptPaint(Visitor visitor) {
		visitor.paint(this);
		//System.out.println("Rectangle.acceptPaint()");
		
	}

}
