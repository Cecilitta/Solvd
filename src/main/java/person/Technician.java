package person;

import service.ServiceType;

import java.util.Objects;

public final class Technician extends Person {

    private static int techCounter;
    private final int TECHNICIAN_ID;
    private ServiceType technicalSpecialty;
    private boolean specialist;

    //-------Constructor-------
    public Technician(String contact, String name, ServiceType technicalSpecialty, boolean specialist){
        super(contact, name);
        techCounter++;
        this.TECHNICIAN_ID = techCounter;
        this.technicalSpecialty = technicalSpecialty;
        this.specialist = specialist;
    }
    //------getters and setters--------

    public int getTECHNICIAN_ID() {
        return TECHNICIAN_ID;
    }

    public boolean isSpecialist() {
        return specialist;
    }

    public void setSpecialist(boolean specialist) {
        this.specialist = specialist;
    }

    public ServiceType getTechnicalSpecialty() {
        return technicalSpecialty;
    }

    public void setTechnicalSpecialty(ServiceType technicalSpecialty) {
        this.technicalSpecialty = technicalSpecialty;
    }

    //--------Methods-----------

    @Override
    public String toString() {
        return super.toString() +
                "Technician_ID: " + TECHNICIAN_ID +
                ", Technical Specialty: " + technicalSpecialty +
                ", is specialist: " + specialist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technician that)) return false;
        if (!super.equals(o)) return false;
        return getTECHNICIAN_ID() == that.getTECHNICIAN_ID() && isSpecialist() == that.isSpecialist()
                && getTechnicalSpecialty() == that.getTechnicalSpecialty();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTECHNICIAN_ID(), getTechnicalSpecialty(), isSpecialist());
    }
}
