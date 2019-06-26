package observer;

public interface TrainerListener {
	public void doWork(TrainerEvent e);

	public void doTimepass(TrainerEvent e);
}
