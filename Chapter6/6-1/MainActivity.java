package com.seoultech.exercise6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer1;
    RadioButton rdoCal, rdoTime;
    RadioGroup radioGroup;

    DatePicker datePicker1;
    TimePicker timePicker1;

    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약(수정)");

        chronometer1 = (Chronometer) findViewById(R.id.chronometer1);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        datePicker1 = (DatePicker) findViewById(R.id.datePicker1);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        radioGroup.setVisibility(View.INVISIBLE);
        datePicker1.setVisibility(View.INVISIBLE);
        timePicker1.setVisibility(View.INVISIBLE);

        chronometer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer1.setBase(SystemClock.elapsedRealtime());
                chronometer1.start();
                chronometer1.setTextColor(Color.RED);

                radioGroup.setVisibility(View.VISIBLE);
            }
        });

        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker1.setVisibility(View.VISIBLE);
                timePicker1.setVisibility(View.INVISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker1.setVisibility(View.INVISIBLE);
                timePicker1.setVisibility(View.VISIBLE);
            }
        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer1.stop();
                chronometer1.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(datePicker1.getYear()));
                tvMonth.setText(Integer.toString(1 + datePicker1.getMonth()));
                tvDay.setText(Integer.toString(datePicker1.getDayOfMonth()));

                tvHour.setText(Integer.toString(timePicker1.getHour()));
                tvMinute.setText(Integer.toString(timePicker1.getMinute()));

                radioGroup.setVisibility(View.INVISIBLE);
                datePicker1.setVisibility(View.INVISIBLE);
                timePicker1.setVisibility(View.INVISIBLE);

                return false;
            }
        });
    }
}