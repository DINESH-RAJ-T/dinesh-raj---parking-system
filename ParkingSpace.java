public class ParkingSpace {
    private int id;
    private String location;
    private boolean isOccupied;

    public ParkingSpace(int id, String location) {
        this.id = id;
        this.location = location;
        this.isOccupied = false;
    }

    public int getId() { return id; }
    public String getLocation() { return location; }
    public boolean isOccupied() { return isOccupied; }
    public void setOccupied(boolean occupied) { isOccupied = occupied; }
}