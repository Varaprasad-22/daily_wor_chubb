package SmartShip;

import java.util.*;
public class DeliveryManager {
    private Map<String, DeliveryAgent> agents;
    private Queue<Package> packageQueue;
    private Set<String> packageIds;

    public DeliveryManager() {
        agents = new HashMap<>();
        packageQueue = new PriorityQueue<>(new Comparator<Package>() {
            public int compare(Package p1, Package p2) {
                return Integer.compare(p2.getPriority(), p1.getPriority()); 
            }
        });
        packageIds = new HashSet<>();
    }

    public void addAgent(DeliveryAgent agent) throws DuplicateEntryException {
        if (agents.containsKey(agent.id))
            throw new DuplicateEntryException("Duplicate agent ID: " + agent.id);
        agents.put(agent.id, agent);
    }

    public void addPackage(Package pkg) throws DuplicateEntryException {
        if (packageIds.contains(pkg.getId()))
            throw new DuplicateEntryException("Duplicate package ID: " + pkg.getId());
        packageQueue.offer(pkg);
        packageIds.add(pkg.getId());
    }

    public void assignPackages() throws AgentNotAvailableException, OverloadException {
        while (!packageQueue.isEmpty()) {
            Package pkg = packageQueue.poll();
            String destCity = pkg.getDestinationCity();
            List<DeliveryAgent> cityAgents = new ArrayList<>();
            for (DeliveryAgent agent : agents.values()) {
                if (agent.getCity().equalsIgnoreCase(destCity)) {
                    cityAgents.add(agent);
                }
            }

            if (cityAgents.isEmpty()) {
                throw new AgentNotAvailableException("No agents available in city: " + destCity);
            }
            for (int i = 0; i < cityAgents.size() - 1; i++) {
                for (int j = i + 1; j < cityAgents.size(); j++) {
                    if (cityAgents.get(i).getCurrentLoad() > cityAgents.get(j).getCurrentLoad()) {
                        DeliveryAgent temp = cityAgents.get(i);
                        cityAgents.set(i, cityAgents.get(j));
                        cityAgents.set(j, temp);
                    }
                }
            }

            DeliveryAgent bestAgent = cityAgents.get(0);
            bestAgent.assignPackage(pkg);
            System.out.println("assigned Package " + pkg.getId() + " to " + bestAgent.name);
        }
    }

    public void showAllAgents() {
        System.out.println("\ndetails");
        for (DeliveryAgent agent : agents.values()) {
            agent.showDetails();
        }
    }
}
