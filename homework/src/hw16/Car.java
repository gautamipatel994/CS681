package hw16;
import java.util.ArrayList;

public class Car {

	private String model, make;
	private int mileage, year;
	private int price;

	public Car(String make, String model, int mileage, int year, int price) {
		super();
		this.model = model;
		this.make = make;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static void addNewCars(ArrayList<Car> cars) {
		cars.add(new Car("Tata", "Nano", 200, 2015, 2000));
		cars.add(new Car("Tesla", "3", 30, 2019, 500));
		cars.add(new Car("BMW", "Q5", 300, 2012, 20000));
		cars.add(new Car("Mercedes", "Benz", 0, 2020, 300));
		cars.add(new Car("Ford", "Escatic", 10, 2018, 800));

	}

	static Integer getMinPrice(ArrayList<Car> listOfCars) {
		return listOfCars.stream().parallel().map((Car car) ->car.getPrice() )
        .reduce(1000000000, (res, price)->price>res ? res : price);
		
	}

	static Integer getMaxPrice(ArrayList<Car> listOfCars) {
		return listOfCars.stream().parallel().map((Car car) ->car.getPrice() )
                .reduce(0, (res,price)->res > price ? res : price);
	}
	
	static Integer getAvgPrice(ArrayList<Car> listOfCars) {
		return listOfCars.stream().parallel().map((Car car) ->car.getPrice() )
                .reduce(0, (res,price) -> res+price, (finalRes, intermediateResult) -> finalRes)/listOfCars.size();
	}
	
	public static void main(String args[]) {
		ArrayList<Car> cars = new ArrayList<>();
		addNewCars(cars);
		Integer minPrice = getMinPrice(cars);
		System.out.println("Minimum price: " + minPrice);
		Integer maxPrice = getMaxPrice(cars);
		System.out.println("\nMaximum price: " + maxPrice);
		Integer avgPrice = getAvgPrice(cars);
		System.out.println("\nAvg Price: " + avgPrice);
		
	}
}
