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
    private PopupFrame popupMenuManager;
    JLabel label;

    private NoteController noteController;

    public NotePanel(NoteController noteController) {
        this.noteController = noteController;

        setLayout(new BorderLayout());

        saveButton = new JButton("Save note");
        saveButton.addActionListener(e -> saveNote());
        add(saveButton, BorderLayout.NORTH);

        noteArea = new JTextArea();
        add(new JScrollPane(noteArea), BorderLayout.CENTER);

        label = new JLabel("Label");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(700, 100);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.blue);
        add(label, BorderLayout.SOUTH);

        popupMenuManager = new PopupFrame();

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
}
