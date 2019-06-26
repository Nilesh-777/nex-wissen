package observer;

public class App {

	public static void main(String[] args) {
		Trainer trainer = new Trainer("Piyush", 124);

		Student student = new Student();

		Employee employee = new Employee();

		trainer.addListener(student);
		trainer.addListener(employee);

		trainer.teach();
		
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		trainer.doHisWork();

	}

}
