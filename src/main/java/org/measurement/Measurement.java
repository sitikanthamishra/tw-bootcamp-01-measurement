package org.measurement;

public class Measurement {

    protected final double value;

    protected final Unit unit;

    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

}
