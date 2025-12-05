package com.rpcode.personal.expense.model;

public class Expense {
    private String title;
    private double amount;
    private String date;
    private String category;
    public Expense(String title, double amount, String date, String category){
        this.title=title;
        this.amount=amount;
        this.date=date;
        this.category=category;
    }
    public String getCategory(){
        return this.category;
    }   
    public String getDate(){
        return this.date;
    }
    @Override
    public String toString(){
        return title+","+amount+","+date+","+category;
    }
}
