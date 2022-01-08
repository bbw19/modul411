import java.util.ArrayList;

public class Path implements Comparable {
    private int cost;
    private ArrayList<Edge> steps;

    public Path() {
        this.cost = 0;
        this.steps = new ArrayList<Edge>();
    }

    public void addEdge(Edge edge) {
        this.cost += edge.getCost();
        this.steps.add(edge);
    }

    public void addEdgeIndex(int index, Edge edge) {
        this.cost += edge.getCost();
        this.steps.add(index, edge);
    }

    public Edge getByIndex(int index) {
        return this.steps.get(index);
    }

    public int getSize() {
        return this.steps.size();
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<Edge> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Edge> steps) {
        this.steps = steps;
    }

    @Override
    public int compareTo(Object path) {
        int compareCost = ((Path)path).getCost();
        return this.cost - compareCost;
    }

    @Override
    public String toString() {
        return "Path{" +
                "cost=" + cost +
                ", steps=" + steps +
                '}';
    }
}
