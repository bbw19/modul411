import java.util.*;
import java.io.*;

class TSP
{
    static ArrayList<Path> findHamiltonianCycle(int[][] distance, boolean[] visitCity, int currPos, int cities, int count, int cost, Path path, ArrayList<Path> solution)
    {
        if (count == cities && distance[currPos][0] > 0)
        {
            Edge edge = new Edge(distance[currPos][0], currPos, 0);
            path.addEdge(edge);

            if (path.getSize() < cities) {
                Edge edge1 = solution.get(solution.size() - 1).getByIndex(0);
                path.addEdgeIndex(0, edge1);
            }

            solution.add(path);
        }

        for (int i = 0; i < cities; i++)
        {
            if (!visitCity[i] && distance[currPos][i] > 0)
            {
                Edge edge = new Edge(distance[currPos][i], currPos, i);
                path.addEdge(edge);
                // Mark as visited
                visitCity[i] = true;
                findHamiltonianCycle(distance, visitCity, i, cities, count + 1, cost + distance[currPos][i], path, solution);
                path = new Path();
                // Mark ith node as unvisited
                visitCity[i] = false;
            }
        }
        return solution;
    }

    // main() method start
    public static void main(String[] args)
    {
        CSVFileHandler handler = new CSVFileHandler();
        try {
            handler.setSize("src/main/resources/locations.csv");
            handler.setLocations("src/main/resources/locations.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int cities = handler.getSize();
        int distance[][] = handler.getLocations();

        // create an array of type boolean to check if a node has been visited or not
        boolean[] visitCity = new boolean[cities];

        // by default, we make the first city visited
        visitCity[0] = true;
        Path path = new Path();
        ArrayList<Path> solution = new ArrayList<Path>();

        // call findHamiltonianCycle() method that returns the minimum weight Hamiltonian Cycle
        solution = findHamiltonianCycle(distance, visitCity, 0, cities, 1, 0, path, solution);
        // print the minimum weighted Hamiltonian Cycle
        Collections.sort(solution);
        ArrayList<Path> top3 = new ArrayList<Path>();

        for (int i = 0; i < solution.size(); i++) {
            if (i < 3) {
                System.out.println(solution.get(i));
                top3.add(solution.get(i));
            }
        }
        try {
            handler.writeFile(top3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}