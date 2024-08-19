package com.quicknotes.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.quicknotes.controller.NoteController;

//  Main window of program
public class NotepadFrame extends JFrame implements MouseListener {
    private NotePanel notePanel;
    private NoteController noteController;
    private JPopupMenu popupMenu;

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

        popupMenu = new JPopupMenu();
        popupMenu.setBounds(200, 100, 150, 200);

        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem paste = new JMenuItem("Paste");
        JMenuItem selectAll = new JMenuItem("Select all");

        popupMenu.add(copy);
        popupMenu.add(cut);
        popupMenu.add(paste);
        popupMenu.add(selectAll);

        this.addMouseListener(this);
        this.add(popupMenu);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        popupMenu.show(this, evt.getX(), evt.getY());
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        //  
    }

    @Override
    public void mouseReleased(MouseEvent evt) {

    }

    @Override
    public void mouseEntered(MouseEvent evt) {

    }

    @Override
    public void mouseExited(MouseEvent evt) {
        
    }
}
