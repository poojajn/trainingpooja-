package com.training.visitor.test;

import java.util.ArrayList;
import java.util.List;

public class ClientComposite {

	
	public static void main(String[] args) {
		
		Shape<Tringle> tringle1= new Tringle("tri-1");
		
		Shape tringle2= new Tringle("tri-2");
		Shape tringle3= new Tringle("tri-3");
		Shape tringle4= new Tringle("tri-4");
		Shape tringle5= new Tringle("tri-5");
		Shape rect1= new Rectangle("Rectangle-1");
		Shape rect2= new Rectangle("Rectangle-2");
		Shape rect3= new Rectangle("Rectangle-3");
		Shape rect4= new Rectangle("Rectangle-4");
		Shape rect5= new Rectangle("Rectangle-5");
		
		((Tringle)tringle1).addShape(tringle1);
		((Tringle)tringle1).addShape(tringle2);
		((Tringle)tringle1).addShape(rect2);
		((Tringle)tringle1).addShape(rect1);
	
		((Rectangle)rect1).addShape(tringle1);
		((Rectangle)rect1).addShape(tringle2);
		((Rectangle)rect1).addShape(rect2);
		((Rectangle)rect1).addShape(rect1);
		
		
		List<Shape> shapes= new ArrayList<>();
		shapes.add(tringle1);
		shapes.add(rect1);
		Composite composite= new Composite(shapes);
		
		
		for(Shape shape:composite.getShapes()) {
			shape.acceptDraw(new VisitorImpl());
		}
	
		

	}
}
