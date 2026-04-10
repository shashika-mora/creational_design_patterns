class BitRegister {
    public BitRegister(String val) { System.out.println("Generated BitRegister: " + val); }
}

class AnalogValue {
    public AnalogValue(String val) { System.out.println("Generated AnalogValue: " + val); }
}

class ShiftRegister {
    public BitRegister getOutput() {
        System.out.println("Shift register output computed.");
        return new BitRegister("[DATA_OUT]");
    }
}

class SARADC {
    private ShiftRegister shiftReg;

    public ShiftRegister buildComponents(AnalogValue input) {
        this.shiftReg = new ShiftRegister();
        return this.shiftReg;
    }
}

interface ADCBuilder {
    void build(AnalogValue input);
    BitRegister getResult();
}

class SARADCBuilder implements ADCBuilder {
    private SARADC adcDevice;
    private ShiftRegister outReg;

    public void build(AnalogValue input) {
        adcDevice = new SARADC();
        outReg = adcDevice.buildComponents(input);
    }

    public BitRegister getResult() {
        return outReg.getOutput();
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        AnalogValue sensorInput = new AnalogValue("[Raw Sensor Signal]");
        ADCBuilder builder = new SARADCBuilder();
        
        builder.build(sensorInput);
        BitRegister finalOutput = builder.getResult();
    }
}