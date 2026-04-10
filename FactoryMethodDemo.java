abstract class ABSSensor {
    public void setup() { printLog("Setting up general ABS sensor"); }
    protected void printLog(String msg) { System.out.println(msg); }
}

class CarSensor extends ABSSensor {
    @Override
    public void setup() { printLog("Setting up Car ABS Sensor component"); }
}

class TruckSensor extends ABSSensor {
    @Override
    public void setup() { printLog("Setting up Truck ABS Sensor component"); }
}

abstract class ABSController {
    protected abstract ABSSensor createSensor();

    public void initializeSystem() {
        System.out.println("Initializing ABS Controller...");
        ABSSensor sensor = createSensor();
        sensor.setup();
    }
}

class CarABSController extends ABSController {
    @Override
    protected ABSSensor createSensor() {
        return new CarSensor();
    }
}

class TruckABSController extends ABSController {
    @Override
    protected ABSSensor createSensor() {
        return new TruckSensor();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        ABSController carSystem = new CarABSController();
        carSystem.initializeSystem();

        ABSController truckSystem = new TruckABSController();
        truckSystem.initializeSystem();
    }
}