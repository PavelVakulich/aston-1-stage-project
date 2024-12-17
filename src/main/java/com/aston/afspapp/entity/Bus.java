package com.aston.afspapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Bus extends BaseEntity implements Serializable, Comparable<Bus> {
    private Integer number;
    private String model;
    private BigDecimal mileage;

    public Bus(Integer number, String model, BigDecimal mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    @Override
    public int compareTo(Bus bus) {
        if (bus == null) {
            return 1;
        }
        int result = this.number.compareTo(bus.number);
        if (result != 0) {
            return result;
        }
        result = this.model.compareTo(bus.model);
        if (result != 0) {
            return result;
        }
        return this.mileage.compareTo(bus.mileage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(this.getNumber(), bus.getNumber())
                && Objects.equals(this.getModel(), bus.getModel())
                && Objects.equals(this.getMileage(), bus.getMileage());
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + getNumber();
        total = total * 31 + (getModel() == null ? 0 : getModel().hashCode());
        total = total * 31 + getMileage().intValueExact();
        return total;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Bus{number=").append(getNumber())
                .append(", model='").append(getModel())
                .append("', mileage=").append(getMileage())
                .append('}')
                .toString();
    }

    public static class Builder {
        private int number;
        private String model;
        private BigDecimal mileage;

        public Builder setNumber(int number) {
            this.number = number;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setMileage(BigDecimal mileage) {
            this.mileage = mileage;
            return this;
        }

        public Bus build() {
            return new Bus(number, model, mileage);
        }
    }
}
