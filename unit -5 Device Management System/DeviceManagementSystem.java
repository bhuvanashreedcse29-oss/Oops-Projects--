import java.util.*;
class Processor {
    private int cores;
    private String brand;

    public Processor(int cores, String brand) {
        this.cores = cores;
        this.brand = brand;
    }

    public int getCores() { return cores; }
    public String getBrand() { return brand; }
}
class SmartDevice {
    protected String modelName;
    protected Processor processor;

    public SmartDevice(String modelName, Processor processor) {
        this.modelName = modelName;
        this.processor = processor;
    }
    public void showSpecs() {
        System.out.println("Model: " + modelName + 
                           " | Cores: " + processor.getCores() + 
                           " | Processor Brand: " + processor.getBrand());
    }
    public void batteryLife() {
        System.out.println("General battery life");
    }
    public void repairCost() {
        System.out.println("General repair cost");
    }
}
class Laptop extends SmartDevice {
    public Laptop(String modelName, Processor processor) {
        super(modelName, processor);
    }

    @Override
    public void batteryLife() {
        System.out.println(modelName + " Battery Life: 8 Hours");
    }

    @Override
    public void repairCost() {
        System.out.println(modelName + " Screen Repair Cost: $250");
    }
}
class Smartphone extends SmartDevice {
    public Smartphone(String modelName, Processor processor) {
        super(modelName, processor);
    }
    @Override
    public void batteryLife() {
        System.out.println(modelName + " Battery Life: 24 Hours");
    }

    @Override
    public void repairCost() {
        System.out.println(modelName + " Screen Repair Cost: $120");
    }
}
class SmartWatch extends SmartDevice {
    public SmartWatch(String modelName, Processor processor) {
        super(modelName, processor);
    }

    @Override
    public void batteryLife() {
        System.out.println(modelName + " Battery Life: 3 Days");
    }

    @Override
    public void repairCost() {
        System.out.println(modelName + " Screen Repair Cost: $60");
    }
}
public class DeviceManagementSystem {
    public static void main(String[] args) {
        List<SmartDevice> devices = new ArrayList<>();
        devices.add(new Laptop("MacBook Pro", new Processor(12, "Apple M2")));
        devices.add(new Smartphone("Samsung Galaxy S23", new Processor(8, "Snapdragon")));
        devices.add(new SmartWatch("Garmin Fenix", new Processor(2, "ARM Cortex")));

        System.out.println("\n--- SMART DEVICE SYSTEM OUTPUT ---");
        for (SmartDevice device : devices) {
            System.out.println("\n----------------------------------");
            device.showSpecs();
            device.batteryLife();
            device.repairCost();
        }
    }
}