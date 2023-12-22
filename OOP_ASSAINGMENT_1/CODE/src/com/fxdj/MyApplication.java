package com.fxdj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyApplication {

    /**
     * The main entry point of the application.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Specify the file path containing the coordinates (replace with your actual path)
        String filePath = "/Users/Acer/Desktop/source.txt";

        try {
            // Read coordinates from the specified file
            List<Point> points = readCoordinatesFromFile(filePath);

            // Create a Shape object from the points
            Shape shape = new Shape(points.toArray(new Point[0]));

            // Calculate and print the shape's properties
            double perimeter = shape.perimeter();
            double longestSide = shape.longestSide();
            double averageSide = shape.averageSide();

            System.out.println("Perimeter: " + perimeter);
            System.out.println("Longest side: " + longestSide);
            System.out.println("Average side: " + averageSide);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }
    }

    /**
     * retrieves coordinates as a list of Point objects after reading them from the given file.
     *
     * @param filePath The directory path to the coordinates-containing file
     * @return A list of Point objects with the coordinates displayed
     * @throws FileNotFoundException In the event that the file cannot be located
     */
    private static List<Point> readCoordinatesFromFile(String filePath) throws FileNotFoundException {
        List<Point> points = new ArrayList<>();

        // Use a Scanner to read the file line by line
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] coordinates = line.split(",");

                try {
                    // Parse the coordinates as numbers and create a Point object
                    double x = Double.parseDouble(coordinates[0].trim());
                    double y = Double.parseDouble(coordinates[1].trim());
                    points.add(new Point(x, y));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid coordinate format in line: " + line);
                    // Skip the line if there's a parsing error
                }
            }
        }

        return points;
    }
}
