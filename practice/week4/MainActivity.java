package com.example.week4_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btnWest, btnEast, btnSouth, btnNorth, btnPlus, btnMinus;
    RelativeLayout RL1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RL1 = (RelativeLayout) findViewById(R.id.RL1);

        textView = (TextView) findViewById(R.id.textView);
        btnWest = (Button) findViewById(R.id.btnWest);
        btnEast = (Button) findViewById(R.id.btnEast);
        btnSouth = (Button) findViewById(R.id.btnSouth);
        btnNorth = (Button) findViewById(R.id.btnNorth);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer num = Integer.parseInt(textView.getText().toString());
                num = num + 1;
                textView.setText(num.toString());
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer num = Integer.parseInt(textView.getText().toString());
                num = num - 1;
                textView.setText(num.toString());
            }
        });

        btnEast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getTranslationX() > (RL1.getWidth() / 2 - textView.getWidth() / 2) - 30){
                    return;
                }

                textView.setTranslationX(textView.getTranslationX() + 50);
            }
        });

        btnWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getTranslationX() < -(RL1.getWidth() / 2 - textView.getWidth() / 2) + 20){
                    return;
                }

                textView.setTranslationX(textView.getTranslationX() - 50);
            }
        });

        btnNorth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (-textView.getTranslationY() > (RL1.getHeight() / 2 - textView.getHeight() / 2) - 20){
                    return;
                }

                textView.setTranslationY(textView.getTranslationY() - 50);
            }
        });

        btnSouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getTranslationY() > (RL1.getHeight() / 2 - textView.getHeight() / 2) - 40){
                    return;
                }

                textView.setTranslationY(textView.getTranslationY() + 50);
            }
        });



    }
}