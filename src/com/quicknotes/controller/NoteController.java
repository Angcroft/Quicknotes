package com.quicknotes.controller;

import com.quicknotes.model.Note;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


//  Managing saving logic in text file
public class NoteController {
    public void saveNote(Note note) throws IOException{
        final String fileName = "notes.txt";
        final String content = note.getContent();
        final Path path = Paths.get(fileName);

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(content + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNote(Note note) throws IOException{
        final String fileName = "notes.txt";
        final Path path = Paths.get(fileName);

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        note.setContent(content.toString());
    }
}
