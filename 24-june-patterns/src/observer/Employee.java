package observer;

public class Employee implements TrainerListener {

	
	@Override
	public void doWork(TrainerEvent e) {
		System.out.println("Employee :: learning "+e.getTopic());
	}

	@Override
	public void doTimepass(TrainerEvent e) {
		System.out.println("Employee :: Having "+e.getTimepass()+" break");
	}
}
