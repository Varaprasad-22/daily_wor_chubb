package SmartShip;

import java.util.*;

public class DeliveryAgent extends DeliveryEntity {
    private String city;
    private int maxLoad;
    private List<Package> assignedPackages;

    public DeliveryAgent(String id, String name, String city, int maxLoad) {
        super(id, name);
        this.city = city;
        this.maxLoad = maxLoad;
        this.assignedPackages = new ArrayList<>();
    }

    public String getCity() { return city; }
    public int getCurrentLoad() { return assignedPackages.size(); }

    public void assignPackage(Package p) throws OverloadException {
        if (assignedPackages.size() >= maxLoad)
            throw new OverloadException("Agent " + name + " overloaded!");
        assignedPackages.add(p);
    }

    @Override
    public void showDetails() {
        System.out.println("Agent: " + name + " (" + id + "), City: " + city + ", Assigned: " + assignedPackages.size());
    }
}