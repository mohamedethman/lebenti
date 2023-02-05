package com.example.lebenti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lebenti.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

ActivityMainBinding binding;
ExpenseAdapter expenseAdapter;
ExpenseDatabase expenseDatabase;
ExpenseDao expenseDao;
long income=0,expense=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddActivity.class));

            }
        });

        expenseDatabase=ExpenseDatabase.getInstance(this);
        expenseDao=expenseDatabase.getDao();
        expenseAdapter=new ExpenseAdapter(this);
        binding.itemsRrecycler.setAdapter(expenseAdapter);
        binding.itemsRrecycler.setLayoutManager(new LinearLayoutManager(this));

        List<ExpenseTable> expenseTables=expenseDao.getAll();

        for (int i =0; i <expenseTables.size(); i++){
            if(expenseTables.get(i).isIncome()){
                income=income+expenseTables.get(i).getAmount();
            }
            else{
                expense=expense+expenseTables.get(i).getAmount();

            }
            expenseAdapter.add(expenseTables.get(i));
        }
        binding.totalExpense.setText(expense+"");
        binding.totalIncome.setText(income+"");
        long balance=income+expense;
        binding.totalAmount.setText(balance+"");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}