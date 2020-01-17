package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        createFile();
        System.out.println("Количество букв 'r': " + countLetters());
        System.out.println("Количство слов в котороых не менее 3-х букв 'r': " + countWords());
    }

    private static void createFile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = new FileWriter("text.txt");
        StringBuilder lineSeparator = new StringBuilder(System.getProperty("line.separator"));
        StringBuilder line = new StringBuilder();
        String word = "";
        while (!word.equals("stop")) {
            word = scanner.nextLine();
            if (!word.equals("stop"))
                line.append(word).append(lineSeparator);
        }
        writer.write(line.toString());
        writer.flush();
        scanner.close();
        writer.close();
    }

    private static int countLetters() throws IOException {
        FileReader reader = new FileReader("text.txt");
        int count = 0, data;
        while (reader.ready()) {
            data = reader.read();
            if ((char) data == 'r') count++;
        }
        reader.close();
        return count;
    }

    private static int countWords() throws IOException {
        FileReader reader = new FileReader("text.txt");
        int count = 0, words = 0, data;
        while (reader.ready()) {
            data = reader.read();
            if ((char) data == 'r') count++;
            if (count >= 3 && (data == ' ' || data == '\n')) {
                words++;
                count = 0;
            } else if (data == ' ' || data == '\n') count = 0;
        }
        reader.close();
        return words;
    }
}