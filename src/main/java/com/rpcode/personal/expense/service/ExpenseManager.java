package com.rpcode.personal.expense.service;
import java.util.*;
import com.rpcode.personal.expense.model.Expense;
import com.rpcode.personal.expense.util.FileHandler;

public class ExpenseManager {
    private List<Expense> expenses=new ArrayList<>();
    public ExpenseManager(){
        FileHandler.load(expenses);
    }
    public List<Expense> searchByCategory(String category){
        List<Expense> result=new ArrayList<>();
        for(Expense e:expenses){
            if(e.getCategory().equalsIgnoreCase(category)){
                result.add(e);
            }
        }
        return result;
    }
    public List<Expense> searchByMonth(String month){
        List<Expense> result=new ArrayList<>();
        for(Expense e:expenses){
            String date=e.getDate();
            String[] parts=date.split("-");
            if(parts[1].equals(month.trim())){
                result.add(e);
            }
        }
        return result;
    }
    public void addExpense(Expense e){
        expenses.add(e);
        FileHandler.save(expenses);
    }
    public List<Expense> getAllExpenses(){
        return expenses;
    }
}
