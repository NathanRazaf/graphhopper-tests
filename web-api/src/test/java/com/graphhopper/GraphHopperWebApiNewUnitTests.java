package com.graphhopper;

import com.graphhopper.util.Helper;
import com.graphhopper.util.PointList;
import com.graphhopper.util.TurnCostsConfig;
import com.graphhopper.util.shapes.GHPoint;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * This class contains unit tests for various components of the GraphHopper Web API.
 */
public class GraphHopperWebApiNewUnitTests {

    /**
     * Tests the `parseList` method in the `Helper` class.
     * Verifies that it correctly parses lists from strings with different formats.
     */
    @Test
    public void testHelperParseList() {
        // Arrange
        String listString1 = "[one,two,three]";
        String listString2 = "one,two,three";
        String listString3 = "[]";
        List<String> expectedList1 = List.of("one", "two", "three");
        List<String> expectedList2 = List.of("ne", "two", "thre");
        List<String> expectedList3 = Collections.emptyList();

        // Act
        List<String> parsedList1 = Helper.parseList(listString1);
        List<String> parsedList2 = Helper.parseList(listString2);
        List<String> parsedList3 = Helper.parseList(listString3);

        // Assert
        assertEquals(expectedList1, parsedList1);
        assertEquals(expectedList2, parsedList2);
        assertEquals(expectedList3, parsedList3);
    }


    /**
     * Tests the date formatting functionality in the `Helper` class.
     * Verifies that the `createFormatter` methods create `DateFormat` objects with the expected
     * format and timezone, and that they correctly format dates.
     */
    @Test
    public void testHelperDateFormatting() {
        // Arrange
        DateFormat df = Helper.createFormatter();
        String formatString = "dd/MM/yyyy HH:mm:ss";
        DateFormat df2 = Helper.createFormatter(formatString);
        Date date = new Date(1234567890L * 1000);

        // Act
        String formattedDate = df.format(date);
        String formattedDate2 = df2.format(date);

        // Assert
        assertEquals("2009-02-13T23:31:30Z", formattedDate);
        assertEquals("13/02/2009 23:31:30", formattedDate2);
    }


    /**
     * Tests the copy constructor of the `TurnCostsConfig` class.
     * Verifies that it creates a new `TurnCostsConfig` object that is equivalent to the original.
     */
    @Test
    public void testTurnCostsConfigCopy() {
        // Arrange
        TurnCostsConfig config1 = new TurnCostsConfig(List.of("motorcar", "motor_vehicle"));
        TurnCostsConfig config2 = new TurnCostsConfig(config1);

        // Assert
        assertEquals(config1.toString(), config2.toString());
    }


    /**
     * Tests the static factory methods `car` and `bike` in the `TurnCostsConfig` class.
     * Verifies that they create `TurnCostsConfig` objects with the expected vehicle types.
     */
    @Test
    public void testTurnCostsConfigInstantiation() {
        // Arrange & Act
        TurnCostsConfig car = TurnCostsConfig.car();
        TurnCostsConfig bike = TurnCostsConfig.bike();

        // Assert
        assertEquals(List.of("motorcar", "motor_vehicle"), car.getVehicleTypes());
        assertEquals(List.of("bicycle"), bike.getVehicleTypes());
    }


    /**
     * Tests the behavior of the `TurnCostsConfig` constructor when provided with invalid vehicle types.
     * Verifies that it throws an `IllegalArgumentException` with the appropriate error message.
     */
    @Test
    public void testInvalidTurnCostsConfigVehicleTypes() {
        // Arrange
        List<String> emptyVehicleTypes = List.of();
        List<String> invalidVehicleTypes = List.of("motorcar", "bike");

        // Act & Assert
        IllegalArgumentException ex1 = assertThrows(IllegalArgumentException.class, () -> {
            new TurnCostsConfig(emptyVehicleTypes);
        });
        assertEquals("turn_costs cannot have empty vehicle_types", ex1.getMessage());

        IllegalArgumentException ex2 = assertThrows(IllegalArgumentException.class, () -> {
            new TurnCostsConfig(invalidVehicleTypes);
        });
        assertEquals("Currently we do not support the restriction: bike", ex2.getMessage());
    }


    /**
     * Tests the creation of a `GHPoint` from a JTS `Point` object.
     * Verifies that the latitude and longitude values are correctly extracted and assigned.
     */
    @Test
    public void testGHPointInstantiationFromGeoPoint() {
        // Arrange
        GeometryFactory gf = new GeometryFactory();
        Coordinate coordinate = new Coordinate(10, 20);
        Point point = gf.createPoint(coordinate);

        // Act
        GHPoint ghPoint = GHPoint.create(point);

        // Assert
        assertEquals(20, ghPoint.getLat());
        assertEquals(10, ghPoint.getLon());
    }


    /**
     * Tests the creation of `GHPoint` objects using various factory methods.
     * Verifies that the latitude values are correctly parsed and assigned.
     */
    @Test
    public void testGHPointInstantiationFromOtherMethods() {
        // Act
        GHPoint point1 = GHPoint.fromString("10,20");
        GHPoint point2 = GHPoint.fromStringLonLat("10,20");
        GHPoint point3 = GHPoint.fromJson(new double[]{10, 20});

        // Assert
        assertEquals(10, point1.getLat());
        assertEquals(20, point2.getLat());
        assertEquals(20, point3.getLat());
    }


    /**
     * Tests various methods of the `PointList` class in 2D mode.
     * Verifies the dimension, size, adding of another `PointList`, reversing, and getting latitude.
     */
    @Test
    public void test2DPointListMethods() {
        // Arrange
        PointList pointList = new PointList(10, false);
        PointList pointList2 = new PointList(10, false);
        pointList2.add(0.1, 0.2);
        pointList2.add(0.3, 0.4);
        pointList2.add(0.5, 0.6);
        pointList2.add(0.7, 0.8);

        // Act
        pointList.add(pointList2);
        pointList.reverse();

        // Assert
        assertEquals(2, pointList.getDimension());
        assertEquals(4, pointList.size());
        assertEquals(0.1, pointList.getLat(3));
    }


    /**
     * Tests various methods of the `PointList` class in 3D mode.
     * Verifies the dimension, size, adding of another `PointList`, reversing, and getting elevation,
     * and also checks for an exception when adding a point without elevation data.
     */
    @Test
    public void test3DPointListMethods() {
        // Arrange
        PointList pointList = new PointList(10, true);
        PointList pointList2 = new PointList(10, true);

        // Act & Assert
        IllegalStateException ex = assertThrows(IllegalStateException.class, () -> {
            pointList2.add(0.1, 0.2);
        });
        assertEquals("Cannot add point without elevation data in 3D mode", ex.getMessage());

        // Act (continue)
        pointList2.add(0.1, 0.2, 0.3);
        pointList2.add(0.4, 0.5, 0.6);
        pointList2.add(0.7, 0.8, 0.9);
        pointList2.add(1.0, 1.1, 1.2);
        pointList.add(pointList2);
        pointList.reverse();

        // Assert
        assertEquals(3, pointList.getDimension());
        assertEquals(4, pointList.size());
        assertEquals(1.2, pointList.getEle(0));
    }

    /**
     * Tests the copy and clone methods of the `PointList` class
     * Verifies that the copied/cloned `PointList` objects are equal to the original
     * and that the `clone(true)` method creates a deep copy
     */
    @Test
    public void testPointListCopy() {
        // Arrange
        PointList pointList = new PointList(10, false);
        pointList.add(0.1, 0.2);
        pointList.add(0.3, 0.4);
        pointList.add(0.5, 0.6);

        // Act
        PointList pointList2 = pointList.copy(0, pointList.size());
        PointList pointList3 = pointList.clone(false);
        PointList pointList4 = pointList.clone(true);

        // Assert
        assertEquals(pointList.toString(), pointList2.toString());
        assertEquals(pointList, pointList2);
        assertEquals(pointList, pointList3);
        pointList.reverse();
        assertEquals(pointList, pointList4);
    }
}
