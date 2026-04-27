package pl.dmcs;

public class Staff {
    private String employeeId;

    public Staff(String employeeId) {
        this.employeeId = employeeId;
    }

    public void overrideStatus(ParkingSpot spot, boolean makeAvailable) {
        if (makeAvailable) {
            spot.release();
        } else {
            spot.occupy();
        }
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}