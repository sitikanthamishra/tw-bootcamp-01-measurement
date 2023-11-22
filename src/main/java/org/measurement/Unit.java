package org.measurement;

public interface Unit {
    double toBaseUnit(double value);
    double fromBaseUnit(double value);
}
