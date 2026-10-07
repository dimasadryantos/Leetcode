package com.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {

    public static void main(String[] args) {
        List<List<String>> paths = List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo"));

        String startCities = createStartCities(paths);
        System.out.println("Destination city: " + startCities);

    }

    private static String createStartCities(List<List<String>> paths) {
        Set<String> startCities = new HashSet<>();

        for (List<String> path : paths) {
            String startingCity = path.get(0);
            startCities.add(startingCity);
        }

        for (List<String> path : paths) {
            String arrival = path.get(1);
            if (!startCities.contains(arrival)) {
                return arrival;
            }
        }
        return "";
    }
}
