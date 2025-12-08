package com.littlesekii.challenges.productsminewow.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {

    private String name;
    private Path path;
    
    private String delimiter = ";";
    private List<String> fields;

    public CSVFile(String name, String path, List<String> fields) {
        this.name = name;
        this.path = Path.of(path).resolve(name + ".csv");
        this.fields = fields;

        try {
            Files.createFile(this.path);
        } catch (IOException e) {
            System.out.println("O arquivo " + this.path + " já existe.");
        }
    }

    public CSVFile(String name, String path, List<String> fields, String delimiter) {
        this(name, path, fields);
        this.delimiter = delimiter;
    }

    public void appendLine(List<String> lineData) {
        StringBuilder newLine = new StringBuilder();

        if (lineData.size() != fields.size())
            throw new IllegalArgumentException("Invalid field count [" + lineData.size() + "]");

        for (int i = 0; i < lineData.size(); i++) {
            newLine.append(lineData.get(i));

            if (i < lineData.size() - 1)
                newLine.append(delimiter);
        }
        newLine.append("\n");
        appendWrite(newLine.toString());
    }

    public void replaceLines(List<List<String>> linesData) {
        StringBuilder newLines = new StringBuilder(); 
    
        for (int i = 0; i < linesData.size(); i++) {

            if (linesData.get(i).size() != fields.size())
                throw new IllegalArgumentException("Invalid field count [" + linesData.get(i).size() + "] in iteration " + i);

            for (int j = 0; j < linesData.get(i).size(); j++) {
                newLines.append(linesData.get(i).get(j));

                if (j < linesData.get(i).size() - 1)
                    newLines.append(delimiter);
            }
            newLines.append("\n");
        }
        replaceWrite(newLines.toString());
    }

    public List<List<String>> getLines() {
        List<List<String>> lines = new ArrayList<>();

        String raw = read();

        if (raw.isEmpty())
            return lines;

        List<String> auxLineList = List.of(raw.split("\n"));

        for (String l : auxLineList) {
            lines.add(List.of(l.split(delimiter)));
        }

        return lines;
    }

    public void appendWrite(String data) {
        try {
            Files.writeString(path, data, 
                StandardOpenOption.CREATE, 
                StandardOpenOption.APPEND, 
                StandardOpenOption.WRITE
            );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void replaceWrite(String data) {
        try {
            Files.writeString(path, data, 
                StandardOpenOption.CREATE, 
                StandardOpenOption.TRUNCATE_EXISTING, 
                StandardOpenOption.WRITE
            );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String read() {
        StringBuilder csvData = new StringBuilder();
        try {
            csvData.append(Files.readString(path));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return csvData.toString();
    }

    public void clear() {
        replaceWrite("");
    }


}
