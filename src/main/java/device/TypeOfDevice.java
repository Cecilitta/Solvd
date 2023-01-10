package device;

public enum TypeOfDevice {
    DESKTOP("Windows"), NOTEBOOK("Mac OS"), TABLET("Mac OS"),
    MOBILE("Android");

    private String operatingSystem;

    //------Constructor-----
    TypeOfDevice(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    //------Methods
    public static TypeOfDevice getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    //----Getter and setter-----
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }


}
