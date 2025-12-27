package parkinglot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParkingLotDemo {

public static void main(String args[]) throws IOException {
    String filePath="src/parkinglot/sample.txt";
    ParkingHandler handler=new ParkingHandler();
    try(BufferedReader reader=new BufferedReader(new FileReader(filePath))){
        String line;
        int lineNumber=1;
        while((line = reader.readLine()) != null) {
            System.out.println("Line" + lineNumber + ":" + line);
            String[] split=line.split(" ");
            if(split[0].equalsIgnoreCase("Park")){
                Vehical vehical=new Vehical(split[2],split[3]);
                handler.parkVehical(split[1],vehical);
            } else {
                handler.emptyParking(split[1]);
            }
        }
    } catch (IOException e) {
        System.err.println("Error reading the file: " + e.getMessage());
        e.printStackTrace();
    }

}
}
