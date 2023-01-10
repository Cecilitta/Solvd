package person;

import java.util.Objects;

public abstract class Person {
    private String contact;
    private String name;

    // ----Constructors------

    public Person(String contact, String name)  {
        super();
        this.contact = contact;
        this.name = name;
    }

    // ----Getters and Setters------
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // -------Method-------

    @Override
    public String toString() {
        return " Name: " + name + ", Contact: " + contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getContact().equals(person.getContact()) && getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContact(), getName());
    }
}
