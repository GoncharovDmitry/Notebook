package com.company;

class Notebook {
    private String title;
    private String text;
    private String date;

    Notebook(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    String getDate() {
        return date;
    }

    void setDate(String date) {
        this.date = date;
    }
}
