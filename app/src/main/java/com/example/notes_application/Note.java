package com.example.notes_application;

public class Note {
    String title;
    String cdate;
    String dbtn;

    public Note(String title, String cdate, int delete_icon) {
        this.title = title;
        this.cdate = cdate;
        this.dbtn = dbtn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getDbtn() {
        return dbtn;
    }

    public void setDbtn(String dbtn) {
        this.dbtn = dbtn;
    }
}
