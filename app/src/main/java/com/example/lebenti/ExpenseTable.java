package com.example.lebenti;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense")
public class ExpenseTable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String telephone;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExpenseTable(String description) {
        this.description = description;
    }

    private String description;
    private  long amount;
    private boolean isIncome;

    public ExpenseTable() {
    }

    public ExpenseTable(int id, String telephone, long amount, boolean isIncome) {
        this.id = id;
        this.telephone = telephone;
        this.amount = amount;
        this.isIncome = isIncome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }
}
