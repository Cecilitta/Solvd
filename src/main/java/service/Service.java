package service;

import java.util.Objects;

public class Service {
    private ServiceType type;
    private float price;
    private boolean serviceDone;

    //-------Constructor----------

    public Service(ServiceType type, float price) {
        this.type = type;
        this.price = price;
        this.serviceDone = false;
    }

    //------Getters and setters----

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isServiceDone() {
        return serviceDone;
    }

    public void setServiceDone(boolean serviceDone) {
        this.serviceDone = serviceDone;
    }
    //----Methods------------

    @Override
    public String toString() {
        return
                " Type: " + type +
                        ", price: " + price +
                        ", is done: " + serviceDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service service)) return false;
        return Float.compare(service.getPrice(), getPrice()) == 0 && isServiceDone() == service.isServiceDone() &&
                getType() == service.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getPrice(), isServiceDone());
    }
}

