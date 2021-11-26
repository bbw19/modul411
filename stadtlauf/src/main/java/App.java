import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Runner myRunner(ArrayList<Runner> list, String itemToBeSearched){
        for(Runner singleItem: list){
            if(singleItem.getNumber().equalsIgnoreCase(itemToBeSearched)){
                return singleItem;
            }
        }
        return list.get(0);
    }

    public static void junioren(ArrayList<Runner> list) {
        for(Runner rn: list) {
            if (rn.getType().equals("1")) {
                System.out.println(rn.getName());
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<Runner> list = new ArrayList<Runner>();

        BufferedReader br;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("src/main/resources/Listen/startliste.txt"));//file name with path
            while ((sCurrentLine = br.readLine()) != null) {
                String[] strArr = sCurrentLine.split("\t");
                Runner runner = new Runner();
                runner.setNumber(strArr[0]);
                runner.setType(strArr[1]);
                runner.setName(strArr[2]);
                list.add(runner);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("src/main/resources/Listen/messresultate.txt"));//file name with path
            while ((sCurrentLine = br.readLine()) != null) {
                String[] strArr = sCurrentLine.split(" ");

                String time = null;
                String number = null;

                for (String str : strArr) {
                    if (str != " ") {
                        if (str.length() > 4) {
                            time = str;
                        } else {
                            number = str;
                        }
                    }
                }

                Runner runner = myRunner(list, number);

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
                LocalTime time1 = LocalTime.parse(time, dateTimeFormatter);
                runner.setTime(time1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.sort((o1, o2) ->
                o1.getTime().compareTo(
                o2.getTime()
        ));

        System.out.println("What do you want?");

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            switch (in.nextLine()) {
                case "junioren":
                    junioren(list);
                    break;
                case "senioren":

                    break;
                case "elite":

                    break;
                case "namen":

                    break;
                default:
                    break;
            }
            break;
        }
        junioren(list);
    }
}
