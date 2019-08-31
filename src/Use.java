class Use {
	
	public static void main(String[] args) {
		Shape a = new Circle(1, 2);
		Circle b = new Circle(3, 4);
		System.out.println("a");
		a.say();
		System.out.println("b");
		b.say();
	}
	
}

abstract class Shape {

	Shape(int x, int y) {
		moveTo(x, y);
	}
	
	void moveTo(int x, int y) {
		System.out.println("Shape at ("+x+", "+y+")");
	}
	
	void say() {
		System.out.println("Shape");
	}
	
}

class Circle extends Shape {
	
	Circle(int x, int y) {
		super(x, y);
	}
	
	void say() {
		System.out.println("Circle");
	}
	
}