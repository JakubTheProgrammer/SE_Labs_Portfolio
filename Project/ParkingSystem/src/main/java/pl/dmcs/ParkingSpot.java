package pl.dmcs;

public class ParkingSpot {
    private String id;
    private boolean available = true;
    private boolean reserved = false;

    public ParkingSpot(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void occupy() {
        this.available = false;
    }

    public void release() {
        this.available = true;
        this.reserved = false;
    }

    public void reserve() {
        this.reserved = true;
        this.available = false;
    }
}