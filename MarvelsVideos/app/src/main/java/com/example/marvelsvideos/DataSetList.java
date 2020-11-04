package com.example.marvelsvideos;

public class DataSetList {
    String image;
    String link;
    String text;


    public DataSetList(String text, String marvel, String link){
        this.image = marvel;
        this.text = text;
        this.link = link;
    }

    public DataSetList(int marvel, String link) {
    }

    public String getImage () {
        return image;
    }

    public void setImage ( String image) {
        this.image = image;
    }

    public String getLink () {
        return link;
    }

    public void setLink (String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }

}


