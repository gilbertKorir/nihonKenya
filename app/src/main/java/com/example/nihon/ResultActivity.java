package com.example.nihon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
public static final String QTY = "QTY";

private static final DecimalFormat df = new DecimalFormat("0.00");
private double finalVol;
TextView q1,q2,q3,q4,q5,q6,q7,q8,m1,m2,m3,m4,m5,m6,m7,m8,allTotal;
private int qnty;
public int amt;
public double d1,d2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //etting data from Dashborard Activity
        Intent intent = getIntent();
        qnty = intent.getIntExtra(QTY,0);

        //quantities listing
        q1 = findViewById(R.id.qt1);
        q2 = findViewById(R.id.qt2);
        q3 = findViewById(R.id.qt3);
        q4 = findViewById(R.id.qt4);
        q5 = findViewById(R.id.qt5);
        q6 = findViewById(R.id.qt6);
        q7 = findViewById(R.id.qt7);
        q8 = findViewById(R.id.qt8);

        //calculating quantities
        q1.setText(df.format(qnty * 0.08));
        q2.setText(df.format(qnty * 0.02));
        q3.setText(df.format(qnty * 0.04));
        q4.setText(df.format(qnty * 0.05));
        q5.setText(df.format(qnty * 0.02));
        q6.setText(df.format(qnty * 0.03));
        q7.setText(df.format(qnty * 0.01));
        q8.setText(df.format(qnty * 0.003));

        //Amount listing
        m1 = findViewById(R.id.am1);
        m2 = findViewById(R.id.am2);
        m3 = findViewById(R.id.am3);
        m4 = findViewById(R.id.am4);
        m5 = findViewById(R.id.am5);
        m6 = findViewById(R.id.am6);
        m7 = findViewById(R.id.am7);
        m8 = findViewById(R.id.am8);

        //calculating amounts
        m1.setText(df.format(qnty*24.00));
        m2.setText(df.format(qnty*5.00));
        m3.setText(df.format(qnty*34.00));
        m4.setText(df.format(qnty*7.50));
        m5.setText(df.format(qnty*6.00));
        m6.setText(df.format(qnty*7.50));
        m7.setText(df.format(qnty*2.00));
        m8.setText(df.format(qnty*7.50));

        //calculating the cumulative amount
        d1 = qnty*24.00 + qnty*5.00 + qnty*34.00 +qnty*7.50 + qnty*6.00 + qnty*7.50 +qnty*2.00 +qnty*7.50;
        double all = Double.valueOf(d1);

        //total
        allTotal = findViewById(R.id.totalAmount);
        allTotal.setText("Your total amount will be: " + df.format(all));

        //title
        getSupportActionBar().setTitle("Output");
        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
    public void qt1(double number){
        TextView quantity = findViewById(R.id.qt1);
        quantity.setText((int) number);
    }

    

}