package com.example.lebenti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lebenti.databinding.ActivityAddBinding;


public class AddActivity extends AppCompatActivity {
ActivityAddBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount=binding.amount.getText().toString();
                String telephone=binding.payementNumero.getText().toString();
                String desc=binding.descripton.getText().toString();
                boolean isIncome=binding.incomeRadio.isChecked();

                ExpenseTable expenseTable=new ExpenseTable();
                expenseTable.setAmount(Long.parseLong(amount));
                expenseTable.setDescription(desc);
                expenseTable.setTelephone(telephone);
                expenseTable.setIncome(isIncome);

                ExpenseDatabase expenseDatabase=ExpenseDatabase.getInstance(view.getContext());
                ExpenseDao expenseDao=expenseDatabase.getDao();

                expenseDao.insertExpense(expenseTable);
//                finish();
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}