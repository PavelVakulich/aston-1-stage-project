package com.aston.afspapp.entity;

import java.io.Serializable;
import java.util.Objects;

public class User extends BaseEntity implements Serializable, Comparable<User> {
    private String name;
    private String password;
    private String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(User user) {
        if (user == null) {
            return 1;
        }
        int result = this.name.compareTo(user.name);
        if (result != 0) {
            return result;
        }
        result = this.password.compareTo(user.password);
        if (result != 0) {
            return result;
        }
        return this.email.compareTo(user.email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + (getName() == null ? 0 : getName().hashCode());
        total = total * 31 + (getPassword() == null ? 0 : getPassword().hashCode());
        total = total * 31 + (getEmail() == null ? 0 : getEmail().hashCode());
        return total;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("User{name='").append(getName())
                .append("', password='").append(getPassword())
                .append("', email='").append(getEmail())
                .append("'}")
                .toString();
    }

    public static class Builder {
        private String name;
        private String password;
        private String email;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(name, password, email);
        }
    }
}
