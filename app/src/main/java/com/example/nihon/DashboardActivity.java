package com.example.nihon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    int quantity = 10;
    Button submit;
    TextView vol;
    private int sendVol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));

        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        submit = findViewById(R.id.submitButton);
        vol = findViewById(R.id.baseVolume);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              sendData();
            }

            private void sendData() {
                sendVol =Integer.parseInt(vol.getText().toString().trim());
                Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                i.putExtra(ResultActivity.QTY,sendVol);
                startActivity(i);
            }
        });

    }
    // increment and decrement
    //when a + button is called
    public void addOrder(View view){
        if(quantity >= 100){
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }
    //when a - button is called
    public void reduceOrder(View view){
        if(quantity == 10){
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }
    //estimate
//    public void subMit(View view){
//        CharSequence vol1 = vol.getText();
//        Intent i = new Intent(DashboardActivity.this, ResultActivity.class);
//        i.putExtra("volume", vol1);
//        startActivity(i);
//    }
    //displays the quantity
    public void display(int number){
        TextView quantity = findViewById(R.id.baseVolume);
        quantity.setText(" " + number);
    }
}