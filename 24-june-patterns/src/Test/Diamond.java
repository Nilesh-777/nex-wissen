package Test;

interface I0 {
	default void m1() {
		System.out.println("I0:: m1()");
	}
}

interface I1 extends I0{
	default void m1() {
		System.out.println("I1:: m1()");
	}
}

interface I2 extends I0{
	default void m1() {
		System.out.println("I2:: m1()");
	}
}

class Impl implements I1, I2 {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		I1.super.m1();
	}

	

}

public class Diamond {
	public static void main(String[] args) {
		Impl impl = new Impl();
		impl.m1();
	}

}
