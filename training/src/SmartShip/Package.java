package SmartShip;

public class Package {
    private String id;
    private String destinationCity;
    private int priority; // Higher = more urgent

    public Package(String id, String destinationCity, int priority) throws InvalidPackageException {
        if (priority < 1 || priority > 5)
            throw new InvalidPackageException("Priority must be between 1 and 5.");
        this.id = id;
        this.destinationCity = destinationCity;
        this.priority = priority;
    }

    public String getId() { return id; }
    public String getDestinationCity() { return destinationCity; }
    public int getPriority() { return priority; }

    public void showDetails() {
        System.out.println("Package ID: " + id + ", City: " + destinationCity + ", Priority: " + priority);
    }
}