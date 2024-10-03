package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MonthlyPayment extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_payment);

    // Retrieve the data from intent, set default values as 0, in case of empty values or lost data for principal, interest and tenure.
        Intent intent = getIntent();
        double principal = intent.getDoubleExtra("principal", 0);
        double interestRate = intent.getDoubleExtra("interestRate", 0);
        int tenure = intent.getIntExtra("tenure", 0);

    // Calculate monthly payment with the values taken from getDouble and getIntExtra.
        double monthlyPayment = calculateMonthlyPayment(principal, interestRate, tenure);

    // Display the monthly payment
        TextView paymentTextView = findViewById(R.id.paymentTextView);
        paymentTextView.setText(String.format("%.2f", monthlyPayment));
    }

    //This is the method that will use the EMI calculation formula to calculate the monthly installments.
    private double calculateMonthlyPayment(double principal, double interestRate, int tenure) {
        double monthlyRate = interestRate / 12 / 100;
        int Installments = tenure * 12;

       return (principal * monthlyRate * Math.pow(1 + monthlyRate, Installments)) /
                (Math.pow(1 + monthlyRate, Installments) - 1);   //The EMI Calculation Formula
    }

    //This intent is used to start a new activity, in this case it would be to go back to the main activity.
    public void Recalculate(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
