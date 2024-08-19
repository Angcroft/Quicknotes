package com.quicknotes.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.quicknotes.controller.NoteController;
import com.quicknotes.model.Note;
import java.io.IOException;

//  Contains a JTextArea for writing notes and a button for saving it
public class NotePanel extends JPanel {
    private JTextArea noteArea;
    private JButton saveButton;
    private JButton loadButton;
    private PopupFrame popupMenuManager;
    JLabel label;

    private NoteController noteController;

    public JLabel getLabel() {
        return label;
    }

    private JPanel createNorthPanel() {
        JPanel  panel = new JPanel(new BorderLayout());

        saveButton = new JButton("Save note");
        saveButton.addActionListener(e -> saveNote());
        panel.add(saveButton, BorderLayout.NORTH);

        loadButton = new JButton("Load note");
        loadButton.addActionListener(e -> loadNote());
        panel.add(loadButton, BorderLayout.SOUTH);

        return panel;
    }

    public NotePanel(NoteController noteController) {
        this.noteController = noteController;

        setLayout(new BorderLayout());

        add(createNorthPanel(), BorderLayout.NORTH);

        noteArea = new JTextArea();
        add(new JScrollPane(noteArea), BorderLayout.CENTER);

        label = new JLabel("Label");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(700, 100);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.blue);
        add(label, BorderLayout.SOUTH);

        popupMenuManager = new PopupFrame(this);

        //  Also another mouse listener as it doesn't work if i click over the notepanel
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenuManager.showPopup(NotePanel.this, e.getX(), e.getY());
                }
            }
        });
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

    private void loadNote() {
        Note note = new Note();
        try {
            noteController.loadNote(note);
            noteArea.setText(note.getContent());
            JOptionPane.showMessageDialog(this, "Note loaded successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Failed to load note: " + e.getMessage());
        }
    }
}
