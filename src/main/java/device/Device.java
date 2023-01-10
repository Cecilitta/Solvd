package device;

import java.util.Objects;

public class Device {
    private String model;
    private int serialNumber;
    private TypeOfDevice type;


    //------------Constructor---------

    public Device(String model, int serialNumber, TypeOfDevice type) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.type = type;
    }


    //-----------getters and setters-----

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public TypeOfDevice getType() {
        return type;
    }

    public void setType(TypeOfDevice type) {
        this.type = type;
    }


//----------Methods------------------

    @Override
    public String toString() {
        return "Model: '" + model + '\'' + ", serialNumber: '" + serialNumber + '\'' + ", type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device device)) return false;
        return getModel().equals(device.getModel()) && Objects.equals(getSerialNumber(), device.getSerialNumber()) &&
                getType() == device.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getSerialNumber(), getType());
    }
}


