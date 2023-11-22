package org.measurement;

import java.util.Objects;

public class Length {

    private final double value;

    private final Unit unit;

    public Length add(Length length) {
        double result = this.unit.toCentimeters(this.value) + length.unit.toCentimeters(length.value);
        return new Length(this.unit.fromCentimeters(result), this.unit);
    }

    public boolean exactlyEquals(Length length) {
        return this.value == length.value && this.unit == length.unit;
    }

    public static Length centimeter(double value) {
        return new Length(value, Unit.CENTIMETER);
    }

    public static Length meter(double value) {
        return new Length(value, Unit.METER);
    }

    public static Length kilometer(double value) {
        return new Length(value, Unit.KILOMETER);
    }

    private enum Unit {
        METER,
        KILOMETER,
        CENTIMETER;

        private int conversionFactor() {
            return switch (this) {
                case KILOMETER -> 100000;
                case METER -> 100;
                case CENTIMETER -> 1;
            };
        }

        private double toCentimeters(double value) {
            return value * this.conversionFactor();
        }

        private double fromCentimeters(double value) {
            return value / this.conversionFactor();
        }
    }

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toCentimeters() {
        return this.unit.toCentimeters(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return this.toCentimeters() == length.toCentimeters();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toCentimeters());
    }
}
