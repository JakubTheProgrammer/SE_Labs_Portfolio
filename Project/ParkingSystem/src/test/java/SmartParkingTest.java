import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.dmcs.ParkingFacility;
import pl.dmcs.ParkingSpot;
import pl.dmcs.Sensor;
import pl.dmcs.Staff;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingTest {

    private ParkingSpot spot;
    private ParkingFacility facility;

    @BeforeEach
    public void setUp() {
        spot = new ParkingSpot("A1");
        facility = new ParkingFacility(10);
    }

    @Test
    public void testNewSpotIsAvailable() {
        assertTrue(spot.isAvailable());
    }

    @Test
    public void testSpotOccupied() {
        spot.occupy();
        assertFalse(spot.isAvailable());
    }

    @Test
    public void testSpotReleased() {
        spot.occupy();
        spot.release();
        assertTrue(spot.isAvailable());
    }

    @Test
    public void testFacilityCapacityDecreasesWhenOccupied() {
        facility.addSpot(spot);
        spot.occupy();
        assertEquals(9, facility.getAvailableCount());
    }

    @Test
    public void testSpotReservationMarksAsUnavailable() {
        spot.reserve();
        assertTrue(spot.isReserved());
        assertFalse(spot.isAvailable());
    }

    @Test
    public void testSensorDetectsVehicleAndOccupiesSpot() {
        Sensor sensor = new Sensor("S1", spot);
        sensor.detectArrival();
        assertFalse(spot.isAvailable());
    }

    @Test
    public void testStaffOverridesSpotStatus() {
        Staff admin = new Staff("EMP123");
        spot.occupy();

        admin.overrideStatus(spot, true);

        assertTrue(spot.isAvailable());
    }
}