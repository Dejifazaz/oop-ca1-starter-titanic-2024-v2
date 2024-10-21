package org.example;

import java.util.Comparator;

public class SortByName implements Comparator<Passenger> {

    @Override
    public int compare(Passenger p1, Passenger p2) {
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}
