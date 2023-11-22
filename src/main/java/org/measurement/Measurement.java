package org.measurement;

public class Measurement {

    protected final double value;

    protected final Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean exactlyEquals(Measurement measurement) {
        return this.value == measurement.value && this.unit == measurement.unit;
    }

}
