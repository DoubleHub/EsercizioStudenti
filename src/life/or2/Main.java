package life.or2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static String[] getDataFromFile(String filePath) throws IOException {
        String[] data = {"", "", ""};
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String s = reader.readLine();
        for (int i = 0; s != null && i < 3; i++) {
            data[i] = s;
            s = reader.readLine();
        }

        return data;
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        try {
            try (Stream<Path> paths = Files.walk(Paths.get("STUDENTI"))) {
                paths
                    .filter(Files::isRegularFile)
                    .forEach((Path file) -> {
                        try {
                            students.add(new Student(getDataFromFile(file.toString())));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        students.sort(Comparator.comparing(Student::getIdentifier));
        System.out.println(students);
    }

}
