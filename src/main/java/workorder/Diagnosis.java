package workorder;

import exception.NoDetailException;

import java.util.Objects;

public class Diagnosis {
    private final float DIAGNOSIS_PRICE = 50f;
    private String detail;


    //-------Constructor------

    public Diagnosis(String detail) throws NoDetailException {
        this.detail = detail;

    }

    //-------getter and setter------

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public float getDIAGNOSIS_PRICE() {
        return DIAGNOSIS_PRICE;
    }

    //-------Methods------


    @Override
    public String toString() {
        return "Detail: '" + detail + '\'' + ", Diagnosis price: " + DIAGNOSIS_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diagnosis that)) return false;
        return Float.compare(that.getDIAGNOSIS_PRICE(), getDIAGNOSIS_PRICE()) == 0 && getDetail().equals(that.getDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDetail(), getDIAGNOSIS_PRICE());
    }
}
