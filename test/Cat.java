package test;


interface Animal{
	public abstract void sound();
}
class Dog implements Animal{
	String name;
	Dog(String name) {
		this.name = name;
	}
	public void sound() {
		System.out.println("Fuck you");
	}
}
public class Cat implements Animal{
	public static void main(String[] args) {
		
		Animal cat = new Cat("Hieu");
		System.out.println(cat);
		cat = new Dog("Con cho");
		System.out.println(cat);
	}
	String name;
	Cat(String name) {
		this.name = name;
	}
	
	
	public void sound() {
		System.out.println("hello");
	}
	
}
