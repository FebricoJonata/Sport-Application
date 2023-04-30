package com.example.sportapp.database.modal;

public class Ticket {
    private  int id;
    private String name;
    private String category;
    private String date;
    private int quantity;

    public Ticket() {}

    public Ticket(String name, String category, String date, int quantity) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.quantity = quantity;
    }

    public Ticket(int id, String name, String category, String date, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.date = date;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
