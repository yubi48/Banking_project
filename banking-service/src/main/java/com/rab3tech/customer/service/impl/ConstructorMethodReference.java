package com.rab3tech.customer.service.impl;

import java.util.function.Supplier;

class Dog{
	String name="tommy";
	String color="white";
	@Override
	public String toString() {
		return "Dog [name=" + name + ", color=" + color + "]";
	}
}

public class ConstructorMethodReference {
	
	public static void main(String[] args) {
		
		Supplier<Dog> supplier1=new Supplier<Dog>() {
			@Override
			public Dog get() {
				return new Dog();
			}
		};
		

		Supplier<Dog> supplier2=()->new Dog();    //calling default constrcur
		
		//
		Supplier<Dog> supplier3=Dog::new; //constructor reference
		
		
		
		System.out.println(supplier1.get());
		
	}

}
