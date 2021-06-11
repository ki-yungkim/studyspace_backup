package chapter5_class;

public class Person {
	String name;
	char gender;
	boolean married;
	float height;
	float weight;
	
	public Person() {
		
	}
	public Person(String pname) {
		name = pname;
	}
	public Person(String pname, float pheight, float pweight) {
		name = pname;
		height = pheight;
		weight = pweight;
		
	}
	
}
