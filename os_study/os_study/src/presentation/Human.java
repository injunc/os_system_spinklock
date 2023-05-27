package presentation;

import java.util.Formatter;

public class Human extends Thread{
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

	private Bowl bowl ;
	private Spinlock spinlock;
	public Human(Bowl bowl,Spinlock spinlock) {
		super("주인");
		this.spinlock = spinlock;
		this.bowl =bowl;
	}
	
	public void run() {
		for(int i=0;i<8;i++) {
			try {
//			spinlock.lock();
				Thread.sleep(300);
				feed();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
//				spinlock.unlock();
			}
		}
	}
	
	public void feed() {
		Formatter formatter = new Formatter();
		int num = (bowl.getDogFood())+1;
		bowl.setDogFood(num);
		formatter.format(" : %6s (남은 사료 량: %3d )","먹어", bowl.getDogFood());
		System.out.println(ANSI_RED+"["+getName()+"]"+ANSI_RESET+formatter.toString());
		formatter.close();
	}
	
}
