package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* 4-2. 애완동물 사진 보기 앱 만들기
    1. '시작함'에 체크하면 좋아하는 애완동물 세 가지 중에서 하나를 선택하라는 내용이 나온다.
    2. 선택 후에 <선택 완료> 버튼을 클릭하면 해당 애완동물의 이미지가 나타난다.

     */

    TextView textView1, textView2;
    CheckBox checkAgree;
    RadioGroup radioGroup;
    RadioButton radioDog, radioCat, radioRabbit;
    Button button1;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        textView1 = (TextView) findViewById(R.id.textView1);
        checkAgree = (CheckBox) findViewById(R.id.checkAgree);

        textView2 = (TextView) findViewById(R.id.textView2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioDog = (RadioButton) findViewById(R.id.radioDog);
        radioCat = (RadioButton) findViewById(R.id.radioCat);
        radioRabbit = (RadioButton) findViewById(R.id.radioRabbit);

        button1 = (Button) findViewById(R.id.button1);
        imageView = (ImageView) findViewById(R.id.imageView);

        checkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkAgree.isChecked()) {
                    textView2.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                }
                else {
                    textView2.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch(radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioDog:
                        imageView.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radioCat:
                        imageView.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radioRabbit:
                        imageView.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),
                                "Select the animal!",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}