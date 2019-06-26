package observer;

import java.util.*;

public class Trainer {
	private String name;
	private int id;

	List<TrainerListener> trainerListeners = new ArrayList<>();

	public void addListener(TrainerListener trainerListener) {
		trainerListeners.add(trainerListener);
	}

	public void teach() {
		TrainerEvent trainerEvent = new TrainerEvent();

		for (TrainerListener trainerListener : trainerListeners) {
			if (trainerListener instanceof Student) {
				trainerEvent.setTopic("JAVA");
				trainerListener.doWork(trainerEvent);
			}
			if (trainerListener instanceof Employee) {
				trainerEvent.setTopic("SDLC");
				trainerListener.doWork(trainerEvent);
			}
		}
	}

	public void doHisWork() {
		TrainerEvent trainerEvent = new TrainerEvent();

		for (TrainerListener trainerListener : trainerListeners) {
			if (trainerListener instanceof Student) {
				trainerEvent.setTimepass("football");
				trainerListener.doTimepass(trainerEvent);
			}
			if (trainerListener instanceof Employee) {
				trainerEvent.setTimepass("tea");
				trainerListener.doTimepass(trainerEvent);
			}
		}
	}

	public Trainer(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}
