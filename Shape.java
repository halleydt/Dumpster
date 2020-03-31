package BoxOfShapes;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Scanner;

public class Shape implements Serializable {

    int size;
    String color;

    public Shape(String color, int size) {
        this.size = size;
        this.color = color;
    }

    public Shape() {
        new Shape("white" , 0);
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj){
        boolean temp = false;
        if (obj instanceof Shape) {
            Shape newObj = (Shape) obj;
            temp = (this.getColor().equalsIgnoreCase(newObj.getColor()) && this.getSize() == newObj.getSize());
        }
        return temp;
    }

    public static void serializeToXML(Shape obj, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
                System.out.println("Exception: " + e.toString());
            }
        });
        encoder.writeObject(obj);
        encoder.close();
        fos.close();
    }

    public static Shape deserializeFromXML(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        XMLDecoder decoder = new XMLDecoder(fis);
        Shape decodedObj = (Shape) decoder.readObject();
        decoder.close();;
        fis.close();
        return decodedObj;
    }
    public static void serializeBinary(Shape obj, String fileAddress){
        try {
            FileOutputStream fileOut = new FileOutputStream(fileAddress);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(obj);
            objOut.flush();
            objOut.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static Shape deserializeBinary(String fileAddress){
        Shape obj = null;
        try {
            FileInputStream fileInput = new FileInputStream(fileAddress);
            ObjectInputStream objIn = new ObjectInputStream(fileInput);
            obj = (Shape) objIn.readObject();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }
    public static void serialize(Shape person, String fileAddress) {
        String CSVString = "";
        try {
            PrintWriter outFile = new PrintWriter(new FileOutputStream(fileAddress));
            outFile.println(person.getColor() + "," + person.getSize());
            outFile.flush();
            outFile.close();
        }
        catch (Exception e) {
            System.out.println("We got a problem. \n" + e);
        }
    }

    public static Shape deserialize(String fileAddress) {
        Shape temp = null;
        try {
            Scanner fileInput = new Scanner(new FileInputStream(fileAddress));
            String inputLine = fileInput.nextLine();
            String [] line = inputLine.split(",");
            temp = new Shape(line[0], Integer.parseInt(line[1]));
        }
        catch (Exception e) {
            System.out.println("We got a problem. \n" + e);
        }
        return temp;
    }
}