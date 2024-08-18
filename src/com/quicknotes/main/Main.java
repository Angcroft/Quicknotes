package com.quicknotes.main;

import com.quicknotes.gui.NotepadFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotepadFrame().setVisible(true);
            }
        });
    }
}