package observer;

public class Student implements TrainerListener {


	@Override
	public void doWork(TrainerEvent e) {
		System.out.println("Student :: learning "+e.getTopic());

	}

	@Override
	public void doTimepass(TrainerEvent e) {
		System.out.println("student :: playing "+e.getTimepass());
	}

}
