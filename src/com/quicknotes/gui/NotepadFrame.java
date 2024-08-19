package com.quicknotes.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.quicknotes.controller.NoteController;

public class NotepadFrame extends JFrame {
    private NotePanel notePanel;
    private NoteController noteController;
    private PopupFrame popupMenuManager;

    public NotepadFrame() {
        this.setTitle("QuickNotes");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        noteController = new NoteController();
        notePanel = new NotePanel(noteController);

        setLayout(new BorderLayout());
        add(notePanel, BorderLayout.CENTER);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenuManager.showPopup(NotepadFrame.this, e.getX(), e.getY());
                }
            }
        });

        this.setVisible(true);
    }
}