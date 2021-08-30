package com.rudimentum.basice_commerce.model;

public class Product {
    private int id;
    private String color, img, name, date, level, text;

    public Product(int id, String color, String img, String name, String date, String level, String text) {
        this.id = id;
        this.color = color;
        this.img = img;
        this.name = name;
        this.date = date;
        this.level = level;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }
}
