package com.seoultech.exercise6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    /*
    ViewFlipper
    <사진보기 시작>과 <사진보기 정지>를 만들고, <사진보기 시작>을 클릭하면 1초 단위로 화면이 자동으로 넘어가게 한다.
     */

    Button btnStart, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewFlipper viewFlipper1;

        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        viewFlipper1 = (ViewFlipper) findViewById(R.id.viewFlipper1);
        viewFlipper1.setFlipInterval(1000); // 화면이 넘어가는 시간 1000ms=1s 로 설정

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper1.startFlipping();
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                viewFlipper1.stopFlipping();
            }
        });

    }
}