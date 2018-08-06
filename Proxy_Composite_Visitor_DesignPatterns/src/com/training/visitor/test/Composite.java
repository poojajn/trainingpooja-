package com.training.visitor.test;

import java.util.List;

public class Composite {

	private List<Shape> shapes;

	public void addShape(Shape shape) {
		shapes.add(shape);
		System.out.println("Composite.addShape( )");
	}

	public void removeShape(Shape shape) {
		System.out.println("Composite.removeShape()");
	}

	public Composite(List<Shape> shape) {
		this.shapes = shape;
	}

	public Composite() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<Shape> getShapes(){
		return this.shapes;
		
	}

}
