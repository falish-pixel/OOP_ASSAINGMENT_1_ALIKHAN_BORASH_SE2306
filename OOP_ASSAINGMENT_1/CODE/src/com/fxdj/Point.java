package com.fxdj;

import java.lang.Math;

/**
 * Represents a point in 2D space with x and y coordinates.
 */
public class Point {

    /**
     * The x-coordinate of the point.
     */
    private double x;

    /**
     * The y-coordinate of the point.
     */
    private double y;

    /**
     * Creates a new Point object with the given x and y coordinates.
     *
     * @param x The x-coordinate of the point
     * @param y The y-coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the point.
     *
     * @return The x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the point.
     *
     * @return The y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Calculates and returns the distance between this point and another point.
     *
     * @param destination The other point to calculate the distance to
     * @return The distance between the two points
     */
    public double distanceTo(Point destination) {
        // Get the coordinates of both points
        double x1 = this.x;
        double y1 = this.y;
        double x2 = destination.getX();
        double y2 = destination.getY();

        // Calculate the distance using the Pythagorean theorem
        double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return distance;
    }

    /**
     * Returns a string representation of the point in the format (x, y).
     *
     * @return The string representation of the point
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}