package hello;

import jdk.internal.util.xml.impl.ReaderUTF8;
import model.News;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
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
            String str = (String) objectInputStream.readObject();
            List<String> news = new ArrayList<>();
            LineNumberReader lineNumberReader = new LineNumberReader(new ReaderUTF8(objectInputStream));
            while (lineNumberReader.readLine() != null){
                news.add(lineNumberReader.readLine());
            }

            return news;
        } catch (ClassNotFoundException e) {
            throw new IOException("Class Not Found");
        }
    }
}
