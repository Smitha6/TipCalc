package com.example.alex.tipcalculator_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double tipTotalAmount = 0;    //how much the amount will be with tip
    double perPersonAmount = 0;    //how much each person will pay
    double tipAmount = 0.0;    //how much the tip is
    int numPeople = 0;    //how many people there are
    double totalAmount = 0.0;    //how much the total is (without tip)

    TextView totalTv;
    TextView tipTv;
    TextView personTv;

    EditText amountEt;
    EditText numberOfPeopleEt;
    EditText rCustomAmount;

    Button clearButton;
    Button calculateButton;

    RadioButton r10;
    RadioButton r20;
    RadioButton r30;
    RadioButton rCustom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        totalTv = findViewById(R.id.tipAmount);
        tipTv = findViewById(R.id.totalAmount);
        personTv = findViewById(R.id.totalPerPerson);
        amountEt = findViewById(R.id.AmountEt);
        rCustomAmount = findViewById(R.id.rCustomAmount);
        numberOfPeopleEt = findViewById(R.id.NumberOfPeopleEt);

        clearButton = findViewById(R.id.clear);
        calculateButton = findViewById(R.id.calc);

        r10 = findViewById(R.id.r10);
        r20 = findViewById(R.id.r20);
        r30 = findViewById(R.id.r30);
        rCustom = findViewById(R.id.rCustom);

        rCustomAmount.setEnabled(false);

        //clears the tip amount
        clearButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                clear();
            }
        });

        //calculates the final answer
        calculateButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //gets the bill amount
                totalAmount = Double.parseDouble(amountEt.getText().toString());
                numPeople = Integer.parseInt(numberOfPeopleEt.getText().toString());

                //calculates the answers
                calculate(tipAmount, numPeople, totalAmount);
            }
        });

        //radio buttons
        r10.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //rCustomAmount.setEnabled(false);
                tipAmount = .10;
            }
        });
        r20.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //rCustomAmount.setEnabled(false);
                tipAmount = .20;
            }
        });
        r30.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //rCustomAmount.setEnabled(false);
                tipAmount = .30;
            }
        });
        rCustom.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                rCustomAmount.setEnabled(true);
                tipAmount = Double.parseDouble(rCustomAmount.getText().toString()) / 100;
            }
        });
    }





    protected void calculate(double tip, int people, double totalAmount)
    {
        //calculates answers
        tipAmount = totalAmount * tip;
        tipTotalAmount = tipAmount + totalAmount;
        perPersonAmount = tipTotalAmount / people;

        //displays answers
        tipTv.setText(tipAmount + "");
        totalTv.setText(tipTotalAmount + "");
        personTv.setText(perPersonAmount + "");
    }
    protected void clear()
    {
        //clears data
        tipAmount = 0;
        tipTotalAmount = 0;
        perPersonAmount = 0;
        numPeople = 0;

        //displays answers
        tipTv.setText(tipAmount + "");
        totalTv.setText(tipTotalAmount + "");
        personTv.setText(perPersonAmount + "");
    }

}
