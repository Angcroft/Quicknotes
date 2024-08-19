package com.quicknotes.gui;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.*;

public class PopupFrame extends JPopupMenu implements MouseListener, ActionListener {
    private JMenuItem copy, cut, paste, selectAll;
    private NotePanel notePanel;

    public PopupFrame(NotePanel notePanel) {
        this.notePanel = notePanel;

        //  Add popup menu items
        copy = new JMenuItem("Copy");
        cut = new JMenuItem("Cut");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select all");

        //  Add action listeners to the menu items
        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        //  Adds menu items to popupMenu
        add(copy);
        add(cut);
        add(paste);
        add(selectAll);
    }

    public void showPopup(Component component, int x, int y) {
        show(component, x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == copy) {
            notePanel.getLabel().setText("You clicked on copy");
        } else if (e.getSource() == cut) {
            notePanel.getLabel().setText("You clicked on cut");
        } else if (e.getSource() == paste) {
            notePanel.getLabel().setText("You clicked on paste");
        } else if (e.getSource() == selectAll) {
            notePanel.getLabel().setText("You clicked on selectAll");
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        if (SwingUtilities.isRightMouseButton(evt)) {
            showPopup(evt.getComponent(), evt.getX(), evt.getY());
        }
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
