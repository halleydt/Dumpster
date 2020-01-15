import java.io.*;
import java.util.*;
public class CSVSerialization {
//    public void CSVSerialize(Person obj, String fileAddress){
//        String CSVString = "";
//        try {
//            PrintWriter outFile = new PrintWriter(new FileOutputStream(fileAddress));
//            outFile.println(obj.getName() + "," + obj.getAge());
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    public Person CSVDeserialization(String fileAddress){
        try {
            Scanner fileInput = new Scanner(new FileInputStream(fileAddress));
            String inputLine = fileInput.nextLine();
            String name = inputLine.substring(inputLine.indexOf(0), inputLine.indexOf(','));
            String year = inputLine.substring(inputLine.indexOf(',') + 1);
            return new Person(name, year);

        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
