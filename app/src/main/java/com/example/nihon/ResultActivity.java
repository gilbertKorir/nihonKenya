package com.example.nihon;

import androidx.appcompat.app.AppCompatActivity;

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
TextView q1,q2,q3,q4,q5,q6,q7,q8;
private int qnty;

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

        //calculating amounts
        q1.setText(String.valueOf(df.format(qnty * 0.08+"0")));
        q2.setText(String.valueOf(df.format(qnty * 0.02+"0")));
        q3.setText(String.valueOf(df.format(qnty * 0.04+"0")));
        q4.setText(String.valueOf(df.format(qnty * 0.05+"0")));
        q5.setText(String.valueOf(df.format(qnty * 0.02+"0")));
        q6.setText(String.valueOf(df.format(qnty * 0.03+"0")));
        q7.setText(String.valueOf(df.format(qnty * 0.01+"0")));
        q8.setText(String.valueOf(df.format(qnty * 0.003+"0")));

        //Amount listing




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