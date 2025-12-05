package com.rpcode.personal.expense.util;
import java.io.*;
import java.util.*;
import com.rpcode.personal.expense.model.Expense;

public class FileHandler {
    private static final String FILE_PATH="expenses.csv";

    public static void save(List<Expense> expenseList){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_PATH))){
            for(Expense e:expenseList){
                bw.write(e.toString());
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("Error while saving files: "+e.getMessage());
        }
    }

    public static void load(List<Expense> expenseList){
        File file=new File(FILE_PATH);
        if(!file.exists()) return;

        try(BufferedReader br=new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while((line=br.readLine())!=null){
                String[] arr=line.split(",");
                String title=arr[0];
                double amount=Double.parseDouble(arr[1]);
                String date=arr[2];
                String category=arr[3];
                expenseList.add(new Expense(title,amount,date,category));
            }
        }catch(IOException e){
            System.out.println("Error while loading file: "+e.getMessage());
        }
    }
    public static void generateReport(double total, Map<String, Double> catTotal){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("report.txt"))){
            bw.write("Expense Report: ");
            bw.newLine();
            bw.newLine();
            bw.write("Total Monthly Spending: "+total);
            bw.newLine();
            bw.newLine();
            bw.write("Category wise breakdown: ");
            bw.newLine();
            bw.newLine();
            for(String category:catTotal.keySet()){
                bw.write(category+":"+catTotal.get(category));
                bw.newLine();
                bw.newLine();
            }
            System.out.println("Report generated successfully (report.txt)");
        }catch(IOException e){
            System.out.println("Error generating report: "+e.getMessage());
        }
    }
}
