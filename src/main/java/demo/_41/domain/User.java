package demo._41.domain;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by nlabrot on 02/09/15.
 */
public class User {

    @JsonView(Summary.class)
    private String firstName;

    @JsonView(Summary.class)
    private String lastName;

    @JsonView(All.class)
    private String address;

    public User(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public static class Summary {
    }

    public static class All extends Summary {
    }
}
