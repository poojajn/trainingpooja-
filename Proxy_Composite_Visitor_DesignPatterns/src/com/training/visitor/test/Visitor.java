package com.training.visitor.test;

public interface Visitor {

	void draw(Tringle tringle);

	void paint(Tringle tringle);

	void draw(Rectangle rectangle);

	void paint(Rectangle rectangle);

}
