package hello;

import model.News;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class NewsReader {
    public static void write(List<News> news, Path path) throws IOException {
        File file = path.toFile();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(news);
        }
    }

    public static List<String> read(Path path) throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toFile()))) {
            return (List<String>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Class Not Found");
        }
    }
}
