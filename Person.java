import java.io.*;
import java.util.*;

public class Person {
    private String name;
    private String birthYear;

    public Person() {
        this("John Doe", "19XX");
    }

    public Person(String name, String year) {
        this.name = name;
        this.birthYear = year;
    }

    public void setName(String nameX) {
        name = nameX;
    }

    public void setBirthYear(String yearX) {
        birthYear = yearX;
    }

    public String toString() {
        return "Name: " + name + "\nBirth Year: " + birthYear;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public static void serialize(Person person, String fileAddress) {
        String CSVString = "";
        try {
            PrintWriter outFile = new PrintWriter(new FileOutputStream(fileAddress));
            outFile.println(person.getName() + "," + person.getBirthYear());
            outFile.flush();
            outFile.close();
        }
        catch (Exception e) {
            System.out.println("We got a problem. \n" + e);
        }
    }

    public static Person deserialize(String fileAddress) {
        Person person = null;
        try {
            Scanner fileInput = new Scanner(new FileInputStream(fileAddress));
            String inputLine = fileInput.nextLine();
            System.out.println(inputLine);
            String [] line = inputLine.split(",");
            String nameX = inputLine.substring(0, inputLine.indexOf(','));
            String ageX = inputLine.substring(inputLine.indexOf(',') + 1);
            person.setName(nameX);
            person.setBirthYear(ageX);
            person = new Person(line[0], line[1]);
        }
        catch (Exception e) {
            System.out.println("We got a problem. \n" + e);
        }
        return person;
    }

    public boolean equals(Object obj) {
        boolean rVal = false;
        if (obj instanceof Person) {
            rVal = getBirthYear().compareToIgnoreCase(((Person) obj).getBirthYear()) == 0;
            rVal = rVal && getName().compareToIgnoreCase(((Person) obj).getName()) == 0;
        }
        return rVal;
    }
}
