package hello;

import model.News;

import java.io.*;
import java.nio.file.Path;

public class NewsReader {
    public void write(News[] news, Path path) throws IOException {
        File file = path.toFile();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(news);
        }
    }

    public String[] read(File news) throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(news))) {
            return (String[]) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Class Not Found");
        }
    }
}
