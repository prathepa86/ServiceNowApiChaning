package methodchainingexample;

public class CredoSystemzMethodChaining {

	public static CredoSystemzMethodChaining chainingMethods() {
		System.out.println("This method is used to chain the other methods");
	 return new CredoSystemzMethodChaining();
	}
	
	public CredoSystemzMethodChaining enquiry() {
		System.out.println("Students enquiry about courses");
		return this;
	}
	
	public CredoSystemzMethodChaining registration() {
		System.out.println("students should register with credo systemz");
		return this;
	}
	
	public CredoSystemzMethodChaining watsappgroup() {
		System.out.println("Registered students will be added in watsapp group");
		return this;
	}
	
	public void completedCourse() {
		System.out.println("End of the course");
	}
	
}
