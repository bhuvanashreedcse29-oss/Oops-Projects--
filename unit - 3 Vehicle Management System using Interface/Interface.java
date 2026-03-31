import java.io.*;
import java.util.*;
interface Vehicle{
	void start();
	void stop();
	void fuelCapacity();
	void fuelType();
	void maxFuelCapacity();
	void speed();
}
class Car implements Vehicle{
	public void start(){
		System.out.println("Starting the car...");
	}
	public void stop(){
		System.out.println("The car has Stopped...");
	}
	public void fuelCapacity(){
		System.out.println("Fuel Capacity : 100 liters.");
	}
	public void fuelType(){
		System.out.println("Fuel Type : Diesel.");
	}
	public void maxFuelCapacity(){
		System.out.println("Max Fuel Capacity : 75 liters.");
	}
	public void speed(){
		System.out.println("Speed per Km : 80 Km.");
	}
}	
class Bike implements Vehicle{
	public void start(){
		System.out.println("Starting the bike...");
	}
	public void stop(){
		System.out.println("The bike has Stopped...");
	}
	public void fuelCapacity(){
		System.out.println("Fuel Capacity : 120 liters.");
	}
	public void fuelType(){
		System.out.println("Fuel Type : Petrol.");
	}
	public void maxFuelCapacity(){
		System.out.println("Max Fuel Capacity : 25 liters.");
	}
	public void speed(){
		System.out.println("Speed per Km : 15-20 Km.");
	}
}
class Bus implements Vehicle{
	public void start(){
		System.out.println("Starting the bus...");
	}
	public void stop(){
		System.out.println("The bus has Stopped...");
	}
	public void fuelCapacity(){
		System.out.println("Fuel Capacity : 600 liters.");
	}
	public void fuelType(){
		System.out.println("Fuel Type : BioDiesel.");
	}
	public void maxFuelCapacity(){
		System.out.println("Max Fuel Capacity : 450 liters.");
	}
	public void speed(){
		System.out.println("Speed per Km : 100 Km.");
	}
}
class Jeep implements Vehicle{
	public void start(){
		System.out.println("Starting the Jeep...");
	}
	public void stop(){
		System.out.println("The Jeep has Stopped...");
	}
	public void fuelCapacity(){
		System.out.println("Fuel Capacity : 81 liters.");
	}
	public void fuelType(){
		System.out.println("Fuel Type : Gasoline.");
	}
	public void maxFuelCapacity(){
		System.out.println("Max Fuel Capacity : 64 liters.");
	}
	public void speed(){
		System.out.println("Speed per Km : 280 Kmph.");
	}
}
public class Interface{
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose a Vecicle: ");
		System.out.println("1. Car");
		System.out.println("2. Bike");
		System.out.println("3. Bus");
		System.out.println("4. Jeep");
		int n = scan.nextInt();
		Vehicle t;
		if(n==1){
			t = new Car();
		}
		else if(n==2){
			t = new Bike();
		}
		else if(n==3){
			t = new Bus();
		}
		else{
			t = new Jeep();		
		}
		t.start();
		t.fuelCapacity();
		t.fuelType();
		t.maxFuelCapacity();
		t.speed();
   }
}