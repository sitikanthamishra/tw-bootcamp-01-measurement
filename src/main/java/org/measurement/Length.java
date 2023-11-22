package org.measurement;

public class Length extends Measurement {

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

    @Override
    public Measurement add(Measurement length) {
        double result = super.addValue(length);
        return new Length(this.unit.fromBaseUnit(result), (LengthUnit) this.unit);
    }

}
