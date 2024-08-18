package com.quicknotes.gui;

import javax.swing.*;
import java.awt.*;
import com.quicknotes.controller.NoteController;
import com.quicknotes.model.Note;

public class NotePanel extends JPanel {
    private JTextArea noteArea;
    private JButton saveButton;

    private NoteController noteController;

    public NotePanel(NoteController noteController) {
        this.noteController = noteController;

        setLayout(new BorderLayout());

        noteArea = new JTextArea();
        add(new JScrollPane(noteArea), BorderLayout.CENTER);

        saveButton = new JButton("Save note");
        saveButton.addActionListener(e -> saveNote());
        add(saveButton, BorderLayout.SOUTH);
    }

    private void saveNote() {
        String content = noteArea.getText();
        Note note = new Note(content);
        noteController.saveNote(note);
        JOptionPane.showMessageDialog(this, "Note saved with success!");
    }
}
