package com.quicknotes.gui;

import javax.swing.*;
import java.awt.*;
import com.quicknotes.controller.NoteController;

//  Main window of program
public class NotepadFrame extends JFrame {
    private NotePanel notePanel;
    private NoteController noteController;

    public NotepadFrame() {
        setTitle("QuickNotes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        noteController = new NoteController();
        notePanel = new NotePanel(noteController);

        setLayout(new BorderLayout());
        add(notePanel, BorderLayout.CENTER);
    }
}
