package hw10;

public class AircraftRunnable extends Aircraft implements Runnable{
	public AircraftRunnable(Position pos) {
		super(pos);
	}

	public void run() {
		Aircraft aircraft = new Aircraft(new Position(73.5, 71.4, 81.4));
		System.out.println("Aircraft's current position: " + aircraft.getPosition());
		aircraft.setPosition(aircraft.getPosition().changeLat(42.2));
		System.out.println("Aircraft's new position: "+ aircraft.getPosition());
	}

	public static void main(String[] args) {
		Position p1=new Position(73.5, 71.4, 81.4);
		Thread T1 = new Thread(new AircraftRunnable(p1));
		T1.start();
		try {
			T1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
