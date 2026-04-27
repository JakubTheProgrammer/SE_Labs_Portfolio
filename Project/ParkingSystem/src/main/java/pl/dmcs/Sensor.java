package pl.dmcs;

public class Sensor {

    private String sensorId;
    private ParkingSpot linkedSpot;

    public Sensor(String sensorId, ParkingSpot linkedSpot) {
        this.sensorId = sensorId;
        this.linkedSpot = linkedSpot;
    }

    public void detectArrival() {
        linkedSpot.occupy();
    }

    public void detectDeparture() {
        linkedSpot.release();
    }
}
