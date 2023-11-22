package org.measurement;

import java.util.Objects;

public abstract class Measurement {

    protected final double value;

    protected final Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean exactlyEquals(Measurement measurement) {
        return this.value == measurement.value && this.unit == measurement.unit;
    }

    protected double toBaseUnit() {
        return this.unit.toBaseUnit(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Measurement length = (Measurement) o;
        return this.toBaseUnit() == length.toBaseUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toBaseUnit());
    }

    protected double addValue(Measurement measurement) {
        return this.unit.toBaseUnit(this.value) + measurement.unit.toBaseUnit(measurement.value);
    }

    protected abstract Measurement add(Measurement measurement);
}
