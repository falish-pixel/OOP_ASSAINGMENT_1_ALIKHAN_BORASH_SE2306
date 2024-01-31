package com.fxdj;

//Represents a shape defined by a set of points.
public class Shape {

    //The points defining the shape's vertices.
    private Point[] points;
    //The calculated perimeter of the shape.
    private double perim;

    /**
     * Creates a new Shape object with the given points.
     *
     * @param points The points defining the shape's vertices
     */
    public Shape(Point[] points) {
        this.points = points;
    }

     //Calculates and returns the perimeter of the shape.
     //@return The perimeter of the shape
    public double perimeter() {
        double perimeter = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            Point currentPoint = points[i];
            Point nextPoint = points[(i + 1) % len];
            // Add the distance between the current and next points to the perimeter
            perimeter += currentPoint.distanceTo(nextPoint);
        }
        // Store the calculated perimeter for later use
        this.perim = perimeter;
        return perimeter;
    }

    /**
     * Calculates and returns the average length of the shape's sides.
     *
     * @return The average length of the shape's sides
     */
    public double averageSide() {
        int numOfSides = points.length;
        // Divide the previously calculated perimeter by the number of sides
        return (perim / numOfSides);
    }

    /**
     * Finds and returns the length of the longest side of the shape.
     *
     * @return The length of the longest side of the shape
     */
    public double longestSide() {
        double longestSide = 0;
        for (int i = 0; i < points.length; i++) {
            Point currentPoint = points[i];
            Point nextPoint = points[(i + 1) % points.length];
            // Update the longestSide variable if the current distance is larger
            longestSide = Math.max(currentPoint.distanceTo(nextPoint), longestSide);
        }
        return longestSide;
    }
}
