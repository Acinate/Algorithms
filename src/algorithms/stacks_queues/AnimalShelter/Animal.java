package algorithms.stacks_queues.AnimalShelter;

public class Animal {
    private int order;
    protected String name;
    public Animal(String n) { name = n; }
    public void setOrder(int o) { order = o; }
    public int getOrder() { return order; }

    /* Compare orders of animals to return the older item. */
    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Animal) {
            if (name == ((Animal) o).name) {
                return true;
            }
        }
        return false;
    }
}
