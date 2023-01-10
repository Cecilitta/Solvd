package service;

public enum ServiceType {
    HARDWARE, SOFTWARE;

    public static ServiceType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
