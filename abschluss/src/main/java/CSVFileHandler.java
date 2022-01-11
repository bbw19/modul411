import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

class CSVFileHandler {
    static int[][] locations;
    public int size;
    BufferedWriter writer;

    public void setSize(String path) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        int size = 0;

        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            size = data.length;
        }
        csvReader.close();
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setLocations(String path) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader(path));
        String row;
        int count = 0;
        locations = new int[size][size];

        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            for (int i = 0; i < data.length; i++) {
                locations[count][i] = Integer.parseInt(data[i]);
            }
            count++;
        }
        csvReader.close();
    }

    public static int[][] getLocations() {
        return locations;
    }

    public void writeFile(ArrayList<Path> list) throws IOException {
        writer = Files.newBufferedWriter(Paths.get("src/main/resources/solution.csv"));
        writer.write("Cost,Path");
        writer.newLine();

        for (int i = 0; i < list.size(); i++) {
            String cost;
            String path = "";
            cost = Integer.toString(list.get(i).getCost());

            ArrayList<Edge> steps = list.get(i).getSteps();
            for (int j = 0; j < steps.size(); j++) {
                if (j == 0) {
                    path += Integer.toString(steps.get(j).getFrom());
                }
                path += "->" + Integer.toString(steps.get(j).getTo());
            }
            writer.write(cost+","+path);
            writer.newLine();
        }
        writer.close();
    }
}