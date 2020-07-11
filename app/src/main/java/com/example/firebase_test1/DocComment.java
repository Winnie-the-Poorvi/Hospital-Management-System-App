package com.example.firebase_test1;

class DocComment {
    String text;
    String date;
    String id;
//Time time;

    public DocComment(String text, String date, String id) {
        this.text = text;
        this.date = date;
        this.id = id;
        //this.time = time;
    }

    public DocComment()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /*public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }*/


}
