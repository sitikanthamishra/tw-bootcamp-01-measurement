package org.measurement;

import java.util.Objects;

public class Length extends Measurement {

    public Length add(Length length) {
        double result = this.unit.toBaseUnit(this.value) + length.unit.toBaseUnit(length.value);
        return new Length(this.unit.fromBaseUnit(result), (LengthUnit) this.unit);
    }


    public static Length centimeter(double value) {
        return new Length(value, LengthUnit.CENTIMETER);
    }

    public static Length meter(double value) {
        return new Length(value, LengthUnit.METER);
    }

    public static Length kilometer(double value) {
        return new Length(value, LengthUnit.KILOMETER);
    }

    private enum LengthUnit implements Unit {
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

        public double toBaseUnit(double value) {
            return value * this.conversionFactor();
        }

        public double fromBaseUnit(double value) {
            return value / this.conversionFactor();
        }
    }

    public Length(double value, LengthUnit unit) {
        super(value, unit);
    }

    private double toBaseUnit() {
        return this.unit.toBaseUnit(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return this.toBaseUnit() == length.toBaseUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toBaseUnit());
    }
}
