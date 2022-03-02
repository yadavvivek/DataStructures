package umesh.vivek.ravi.nilesh;

public class MethodReferencePractice {
	
	public static void main (String args []) {
		MethodReferencePractice ab = new MethodReferencePractice();
		MyInterface my = ab::aMethod;
		my.itfcMethod();
	}
	
	public void aMethod() {
		System.out.print("From another class.\n");
	}

}


interface MyInterface {
	void itfcMethod();
}
