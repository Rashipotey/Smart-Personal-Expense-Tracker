package com.rpcode.personal.expense.service;
import java.util.*;
import com.rpcode.personal.expense.model.Expense;
import com.rpcode.personal.expense.util.FileHandler;

public class ExpenseManager {
    private List<Expense> expenses=new ArrayList<>();
    public ExpenseManager(){
        FileHandler.load(expenses);
    }
    public void addExpense(Expense e){
        expenses.add(e);
        FileHandler.save(expenses);
    }
    public List<Expense> getAllExpenses(){
        return expenses;
    }
}
