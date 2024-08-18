package com.quicknotes.controller;

import com.quicknotes.model.Note;
import java.io.*;

public class NoteController {
    public void saveNote(Note note) {
        try (FileWriter writer = new FileWriter("note.txt", true)) {
            writer.write(note.getContent() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
