package myproject;

import java.io.*;
import java.util.Scanner;

public class FileReaderOperations {

    public static void main(String[] args) {
        try {
            File file = new File("demo.txt");

            // Write data to the file
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Hello Java\nThis is a Scanner example");
            }

            // Read data from the file
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void fileprocess() throws IOException {
        try (FileWriter writer = new FileWriter("fileReader.txt")) {
            writer.write("Learning FileReader and FileWriter in Java");
        }

        try (FileReader reader = new FileReader("fileReader.txt")) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        }
    }
}
