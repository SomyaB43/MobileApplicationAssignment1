package com.example.assignment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    /*This method is executed once the calculate monthly payment button is clicked on.
    * It basically takes all of the user inputted values and creates an intent to transfer the user
    * and the data to the next activity*/
    public void CalculateMonthlyPayment(View v) {
        //Retrieves each value from it the EditText View with it's respective ID.
        EditText principal = findViewById(R.id.PrincipalAmount);
        EditText interestRate = findViewById(R.id.InterestRate);
        EditText tenure = findViewById(R.id.Tenure);

        //Takes each value that was retrieved and parses it to a string value.
        double Principal = Double.parseDouble(principal.getText().toString());
        double InterestRate = Double.parseDouble(interestRate.getText().toString());
        int Tenure = Integer.parseInt(tenure.getText().toString());

        /*Creates an intent to redirect to the MonthlyPayment class once the button is pressed
        Extras with the intent is used to indicate that the principal, interest rate and amortization period will
        also be taken to the next activity as data points for processing*/
        Intent i = new Intent(this, MonthlyPayment.class);
        i.putExtra("principal", Principal);
        i.putExtra("interestRate", InterestRate);
        i.putExtra("tenure", Tenure);
        startActivity(i);
    }

}



