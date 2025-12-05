package com.rpcode.personal;
import com.rpcode.personal.expense.model.Expense;
import com.rpcode.personal.expense.service.ExpenseManager;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ExpenseManager manager=new ExpenseManager();

        while(true){
            System.out.println("Smart Personal Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View ALl Expenses");
            System.out.println("3. Search by Category");
            System.out.println("4. Search by Month");
            System.out.println("5. Exit");
            System.out.println("Enter choice:");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter title");
                    String title=sc.nextLine();
                    System.out.println("Enter amount");
                    double amount=sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter date (dd-mm-yyyy)");
                    String date=sc.nextLine();
                    System.out.println("Enter category");
                    String category=sc.nextLine();
                    Expense e=new Expense(title,amount,date,category);
                    manager.addExpense(e);
                    System.out.println("Expense added successfully!");
                    break;
                case 2:
                    System.out.println("Expense List:");
                    for(Expense exp:manager.getAllExpenses()){
                        System.out.println(exp);
                    }
                    break;
                case 3:
                    System.err.println("Enter Category");
                    String categ=sc.nextLine();
                    List<Expense> list1=manager.searchByCategory(categ);
                    System.out.println("\n--- Results ---");
                    list1.forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter Month");
                    String mon=sc.nextLine();
                    List<Expense> list2=manager.searchByMonth(mon);
                    System.out.println("\n--- Results ---");
                    list2.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Thank you for using Smart Personal Expense Tracker App.");
                    return;
                default:
                    System.out.println("Inavlid Choice. Try Again.");
            }
        }
    }
}
