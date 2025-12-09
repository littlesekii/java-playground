package com.littlesekii.playground.examples.fileOperations.niofilesapi;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.github.marschall.memoryfilesystem.MemoryFileSystemBuilder;

public class ExampleMain {
    
    public static void main(String[] args) {

        // Path path = Path.of("c:/dev");
        // System.out.println(path);

        // System.out.println(Files.exists(path));

        // try {
        //     path = Files.createDirectories(path.resolve("dev1/dev2/dev3"));
        //     Files.createFile(path.resolve("file.txt"));
        // } catch (IOException e) {
        //     // System.out.println(e.getMessage());
        //     e.printStackTrace();
        // }
        // System.out.println(Files.exists(path));



        // while (true) {
        //     try {
        //         Path tempFile = Files.createTempFile("file", null);

        //         Files.writeString(tempFile, "I am a temporary file");
        //         System.out.println(tempFile);
        //     } catch (IOException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        // }

        
        try (FileSystem fs = MemoryFileSystemBuilder.newWindows().build()) {
            Path root = fs.getPath("root");
            Files.createDirectory(root);

            Path dataDir = root.resolve("data");
            Files.createDirectory(dataDir);

            Path dataDir2 = root.resolve("data2");
            Files.createDirectory(dataDir2);

            System.out.println(Files.exists(dataDir.resolve("example.txt")));

            Path file = dataDir.resolve("example.txt");
            Files.createFile(file);
            Path file2 = dataDir.resolve("example2.txt");
            Files.createFile(file2);

            Path file3 = dataDir2.resolve("example3.txt");
            Files.createFile(file3);

            System.out.println(Files.exists(file));

            System.out.println(root);
            System.out.println(dataDir);
            System.out.println(file);

            try (Stream<Path> paths = Files.walk(root)) {
                List<Path> pathList = paths.sorted(Comparator.reverseOrder()).toList();
                pathList.forEach(path -> System.out.println(path));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
