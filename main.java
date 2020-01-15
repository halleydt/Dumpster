import java.io.*;
import java.nio.*;
public class main {
    public static void main (String [] args) {
        Person guy = new Person("Jimmy John", "1999");
        guy.serialize(guy,"bigFile.txt");
        Person dude = new Person();
        dude.deserialize("bigFile.txt");
        System.out.println(guy);
        System.out.println(dude);
        System.out.println(guy.equals(dude));
        System.out.println("\n" + (dude.getName()));
    }
}
