package com.rpcode.personal.expense.util;
import java.io.*;
import java.util.List;
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
}
