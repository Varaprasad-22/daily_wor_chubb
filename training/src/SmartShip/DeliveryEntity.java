package SmartShip;

public abstract class DeliveryEntity {
    protected String id;
    protected String name;

    public DeliveryEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void showDetails();
}
