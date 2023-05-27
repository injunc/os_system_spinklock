package presentation;

public class Example {

	public static void main(String[] args) {
		Spinlock spinlock = new Spinlock();
		Bowl bowl = new Bowl();
		Human master = new Human(bowl, spinlock);
		Dog duckgu = new Dog(bowl, spinlock, "흑구");
		Dog baeckgu = new Dog(bowl, spinlock, "백구");

		master.start();
		duckgu.start();
		baeckgu.start();

		try {
			master.join();
			duckgu.join();
			baeckgu.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("식사 끝");
	}
}

