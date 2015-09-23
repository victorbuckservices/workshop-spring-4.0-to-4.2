package demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by nlabrot on 02/09/15.
 */
@Table(name = "USER")
@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "ADDRESS")
    private String address;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    private User(Builder builder) {
        setId(builder.id);
        setFirstName(builder.firstName);
        setLastName(builder.lastName);
        setAddress(builder.address);
    }

    public static Builder newUser() {
        return new Builder();
    }

    public static Builder newUser(User copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.firstName = copy.firstName;
        builder.lastName = copy.lastName;
        builder.address = copy.address;
        return builder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null && id.equals(user.id);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String address;

        private Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}
