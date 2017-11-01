package my.edu.taruc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MONTHLY_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";
    private EditText editTextCarPrice, editTextDownPayment, editTextLoadPeriod,editTextInterestRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link ui to program
        editTextCarPrice = (EditText)findViewById(R.id.editTextCarPrice);
        editTextDownPayment = (EditText)findViewById(R.id.editTextDownPayment);
        editTextLoadPeriod = (EditText)findViewById(R.id.editTextLoadPeriod);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);


    }

    public void calculateLoan(View view){
        //Create an Explicit intent
        Intent intent = new Intent(this, ResultActivity.class);
        startActivity(intent);

        //TODO : calculate monthly payment and determine
        //loan application status; approve or reject
        double carPrice, downPayment, repayment, interestRate, monthlyPayment, totalInterest, totalLoan , salary = 3000;
        String status;

        carPrice = Double.parseDouble(editTextCarPrice.getText().toString());
        downPayment = Double.parseDouble(editTextDownPayment.getText().toString());
        repayment = Double.parseDouble(editTextLoadPeriod.getText().toString());
        interestRate = Double.parseDouble(editTextInterestRate.getText().toString());

        totalInterest = (carPrice - downPayment) * interestRate * (repayment*12);
        totalLoan = (carPrice - downPayment) + totalInterest;
        monthlyPayment = totalLoan / repayment;

        if(monthlyPayment >= (0.3 * salary)){
           status = "Rejected";
        }
        else
            status = "Accepted";


        //Passing data using putExtra method
        //putExtra(TAG, value)
        intent.putExtra(MONTHLY_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);


        startActivity(intent);
    }
}
