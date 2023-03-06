public class Table {
    private int tableNumber;
    private int capacity;
    private boolean isAvailable;
    private long availabilityEndTime;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isAvailable = true;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve(long minutes) {
        this.isAvailable = false;
        this.availabilityEndTime = System.currentTimeMillis() + (minutes * 60 * 1000);
    }

    public void release() {
        this.isAvailable = true;
        this.availabilityEndTime = 0;
    }

    public long getAvailability() {
        if (isAvailable) {
            return 0;
        } else {
            return availabilityEndTime - System.currentTimeMillis();
        }
    }
}
