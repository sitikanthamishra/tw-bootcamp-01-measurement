package org.measurement;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.measurement.Length.*;

public class LengthTest {

    @Test
    public void test100MeterIsEqualTo100Meter() {
        Length length = meter(100);;
        assertEquals(meter(100), length);
    }

    @Test
    public void test1MeterNotEqualTo2Meter() {
        Length length = meter(1);
        assertNotEquals(meter(2), length);
    }

    @Test
    public void test1000MeterEquals1Kilometer() {
        Length length = meter(1000);
        assertEquals(kilometer(1), length);
    }

    @Test
    public void test2000MeterEquals2Kilometer() {
        Length length = meter(2000);
        assertEquals(kilometer(2), length);
    }

    @Test
    public void test1KilometerEquals1000Meter() {
        Length length = kilometer(1);
        assertEquals(meter(1000), length);
    }

    @Test
    public void test3KmEquals3000Meter() {
        Length length = kilometer(3);
        assertEquals(meter(3000), length);
    }

    @Test
    public void testAnotherObjectNotEqualToLength() {
        Integer thousand = 1000;
        assertNotEquals(meter(1000), thousand);
    }

    @Test
    public void testLengthNotEqualsNull() {
        assertNotEquals(meter(1000), null);
    }

    @Test
    public void testLengthAsHashMapKey() {
        Map<Length, Integer> testMap = new HashMap<>();
        Length length = meter(100);
        testMap.put(length, 15);
        assertNotNull(testMap.get(meter(100)));
    }

    @Test
    public void testPutLengthWithMeterAsUnitAndGetLengthWithKilometerAsUnit() {
        Map<Length, Integer> map = new HashMap<>();
        Length length = meter(1000);
        map.put(length, 13);
        assertNotNull(map.get(kilometer(1)));
    }

    @Test
    public void test100CentimeterEquals1Meter() {
        Length length = centimeter(100);
        assertEquals(meter(1), length);
    }

    @Test
    public void test200CentimeterEquals2Meter() {
        Length length = centimeter(200);
        assertEquals(meter(2), length);
    }

    @Test
    public void test150CentimeterNotEquals125Meter() {
        Length length = centimeter(150);
        assertNotEquals(centimeter(125), length);
    }

    @Test
    public void test10MetersEquals1000Centimeters() {
        Length length = meter(10);
        assertEquals(centimeter(1000), length);
    }

    @Test
    public void test5KilometerEquals500000Centimeters() {
        Length length = kilometer(5);
        assertEquals(centimeter(500000), length);
    }

    @Test
    public void test200000CentimetersEquals2Kilometer() {
        Length length = centimeter(200000);
        assertEquals(kilometer(2), length);
    }

    @Test
    public void test1000MetersPlus1000MetersEquals2000Meters() {
        Length lhs = meter(1000);
        Length rhs = meter(1000);
        Length result = lhs.add(rhs);
        assertTrue(result.exactlyEquals(meter(2000)));
        assertFalse(result.exactlyEquals(meter(1000)));
    }

    @Test
    public void test1KilometerPlus300MeterEquals1p3Kilometer() {
        Length lhs = kilometer(1);
        Length rhs = meter(300);
        Length result = lhs.add(rhs);
        assertTrue(kilometer(1.3).exactlyEquals(result));
    }

    @Test
    public void test500MetersPlus1KilometerEquals1500Meters() {
        Length lhs = meter(500);
        Length rhs = kilometer(1);
        Length result = lhs.add(rhs);
        assertTrue(meter(1500).exactlyEquals(result));
    }
}
