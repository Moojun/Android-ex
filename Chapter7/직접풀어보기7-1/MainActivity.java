package com.seoultech.exercise7_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RelativeLayout baseLayout;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        baseLayout = (RelativeLayout) findViewById(R.id.baseLayout);
        editText = (EditText) findViewById(R.id.editText);

        imageView = (ImageView) findViewById(R.id.imageView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.item1:
                imageView.setImageResource(R.drawable.jeju1);
                return true;
            case R.id.item3:
                imageView.setImageResource(R.drawable.jeju3);
                return true;
            case R.id.item5:
                imageView.setImageResource(R.drawable.jeju5);
                return true;
            case R.id.itemRotate:
                float num = Float.parseFloat(editText.getText().toString());
                imageView.setRotation(num);
                return true;
        }
        return false;
    }



}