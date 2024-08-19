package com.quicknotes.gui;

import javax.swing.*;
import java.awt.*;
import com.quicknotes.controller.NoteController;
import com.quicknotes.model.Note;

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
        noteController.saveNote(note);
        JOptionPane.showMessageDialog(this, "Note saved with success!");
    }
}
