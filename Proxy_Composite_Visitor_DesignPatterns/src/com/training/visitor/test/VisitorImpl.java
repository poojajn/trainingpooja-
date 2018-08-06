package com.training.visitor.test;

public class VisitorImpl implements Visitor {

	@Override
	public void draw(Tringle tringle) {
	//tringle.draw();
		System.out.println(tringle.getName());
	}

	@Override
	public void paint(Tringle tringle) {
		System.out.println(tringle.getName());
	}

	@Override
	public void draw(Rectangle rectangle) {
		System.out.println(rectangle.getName());
	}

	@Override
	public void paint(Rectangle rectangle) {
		System.out.println(rectangle.getName());
	}

}
