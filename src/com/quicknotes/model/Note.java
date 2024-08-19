package com.quicknotes.model;

//  This represents the content of the note from NotePanel
public class Note {
    private String content;

    public Note() {
        this.content = "";
    }

    public Note(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
