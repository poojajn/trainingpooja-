package com.training.visitor.test;

public interface Shape<T>  {
	
	
	public void acceptDraw(Visitor visitor);
	public void acceptPaint(Visitor visitor);
	

}
