public class Game {
    double cost;
    String name;
    String category;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Game(double cost, String name, String category) {
        this.cost = cost;
        this.name = name;
        this.category = category;
    }
}
