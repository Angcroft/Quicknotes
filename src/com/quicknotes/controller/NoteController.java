package com.quicknotes.controller;

import com.quicknotes.model.Note;
import com.quicknotes.model.Note;
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
            writer.write(note.getContent() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
