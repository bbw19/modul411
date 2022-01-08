public class Edge {
    private int cost;
    private int from;
    private int to;

    public Edge(int cost, int from, int to) {
        this.cost = cost;
        this.from = from;
        this.to = to;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "cost=" + cost +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
