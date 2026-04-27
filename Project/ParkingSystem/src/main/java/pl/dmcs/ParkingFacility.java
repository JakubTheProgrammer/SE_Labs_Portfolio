package pl.dmcs;

import java.util.ArrayList;
import java.util.List;

public class ParkingFacility {
    private List<ParkingSpot> spots = new ArrayList<>();
    private int capacity;

    public ParkingFacility(int capacity) {
        this.capacity = capacity;
    }

    public void addSpot(ParkingSpot spot) {
        if (spots.size() < capacity) {
            spots.add(spot);
        }
    }

    public int getAvailableCount() {
        int count = 0;
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                count++;
            }
        }
        return count + (capacity - spots.size());
    }
}