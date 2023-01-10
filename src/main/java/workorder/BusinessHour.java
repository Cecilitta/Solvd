package workorder;

public enum BusinessHour {
    MONDAY("from 8 to 18 h."), TUESDAY("from 8 to 18 h."), WEDNESDAY("from 8 to 18 h."),
    THURSDAY("from 8 to 18 h."), FRIDAY("from 8 to 18 h."), SATURDAY("from 9 to 12 h.");

    private String openHours;

    BusinessHour(String openHours) {
        this.openHours = openHours;
    }

    public static BusinessHour getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }
}
