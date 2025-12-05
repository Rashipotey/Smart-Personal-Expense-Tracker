package com.rpcode.personal.expense.service;
import java.util.*;
import com.rpcode.personal.expense.model.Expense;

public class ExpenseManager {
    private List<Expense> expenses=new ArrayList<>();
    public void addExpense(Expense e){
        expenses.add(e);
    }
    public List<Expense> getAllExpenses(){
        return expenses;
    }
}
