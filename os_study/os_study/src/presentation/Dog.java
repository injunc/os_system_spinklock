package presentation;

import java.util.Formatter;

public class Dog extends Thread {

	private Bowl bowl;
	Spinlock spinlock;
	int appetite = (int) (Math.random() * 5) + 3;

	public Dog(Bowl bowl, Spinlock spinlock, String name) {
		super(name);
		this.bowl = bowl;
		this.spinlock =spinlock;
	}

	public void run() {
		for (int i = 0; i < appetite; i++) {
			try {
//				spinlock.lock();
				Thread.sleep(600);
				act();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
//				spinlock.unlock();
			}
		}
	}

	public void act() {	
		Formatter formatter = new Formatter();
		int food = bowl.getDogFood();
		if (food > 0) {
			eat(formatter);
		} else {
			bark(formatter);
		}
		formatter.close();
	}
	
	public void eat(Formatter formatter) {
		int num = (bowl.getDogFood()) - 1;
		bowl.setDogFood(num);
		formatter.format("[%s] : %6s (남은 사료 량: %3d )", getName(), "냠 냠", bowl.getDogFood());
		System.out.println(formatter.toString());
	}
	
	public void bark(Formatter formatter) {
		formatter.format("[%s] : %6s (남은 사료 량: %3d )", getName(), "멍 멍", bowl.getDogFood());
		System.out.println(formatter.toString());
	}

}
