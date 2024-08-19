package com.quicknotes.gui;

import javax.swing.*;
import java.awt.*;
import com.quicknotes.controller.NoteController;
import com.quicknotes.model.Note;
import java.io.IOException;

//  Contains a JTextArea for writing notes and a button for saving it
public class NotePanel extends JPanel {
    private JTextArea noteArea;
    private JButton saveButton;

    private NoteController noteController;

    public NotePanel(NoteController noteController) {
        this.noteController = noteController;

        setLayout(new BorderLayout());

        saveButton = new JButton("Save note");
        saveButton.addActionListener(e -> saveNote());
        add(saveButton, BorderLayout.NORTH);

        noteArea = new JTextArea();
        add(new JScrollPane(noteArea), BorderLayout.CENTER);
    }

    private void saveNote() {
        String content = noteArea.getText();
        Note note = new Note(content);
        try {
            noteController.saveNote(note);
            JOptionPane.showMessageDialog(this, "Note saved with success!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to save note: " + e.getMessage());
        }
    }
}
