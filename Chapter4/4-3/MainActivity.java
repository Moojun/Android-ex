package com.example.ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* 계산기 앱, 기능 구현 리스트
    1. 버튼을 누르면 계산 결과가 하단 TextView 에 출력
    2. 나머지값을 구하는 버튼 추가
    3. EditText 에서 숫자만 입력받도록 수정
    4. EditText 가 정수뿐만 아니라 실숫값을 받도록 수정
    5. 값을 입력하지 않고 버튼을 클릭할 때 오류 메시지를 토스트 메시지로 나타낸다.
    6. 0으로 나누면 토스트 메시지를 나타내지 않고 계산하지 않는다.
     */

    EditText editText1, editText2;
    Button BtnAdd, BtnSub, BtnMul, BtnDiv, BtnRemainder;
    TextView textView1;
    String str1, str2;
    Double result;  // 실수값으로 계산을 위해

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        BtnAdd = (Button) findViewById(R.id.BtnAdd);
        BtnSub = (Button) findViewById(R.id.BtnSub);
        BtnMul = (Button) findViewById(R.id.BtnMul);
        BtnDiv = (Button) findViewById(R.id.BtnDiv);
        BtnRemainder = (Button) findViewById(R.id.BtnRemainder);
        textView1 = (TextView) findViewById(R.id.textView1);

        BtnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                str1 = editText1.getText().toString();
                str2 = editText2.getText().toString();

                if (str1.trim().equals("") || str2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter the value",
                            Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(str1) + Double.parseDouble(str2);
                    textView1.setText("계산 결과 : " + result.toString());
                }
            }
        });

        BtnSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                str1 = editText1.getText().toString();
                str2 = editText2.getText().toString();

                if (str1.trim().equals("") || str2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter the value",
                            Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(str1) - Double.parseDouble(str2);
                    textView1.setText("계산 결과 : " + result.toString());
                }
            }
        });

        BtnMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                str1 = editText1.getText().toString();
                str2 = editText2.getText().toString();

                if (str1.trim().equals("") || str2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter the value",
                            Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(str1) * Double.parseDouble(str2);
                    textView1.setText("계산 결과 : " + result.toString());
                }
            }
        });

        BtnDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                str1 = editText1.getText().toString();
                str2 = editText2.getText().toString();

                if (str1.trim().equals("") || str2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter the value",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (str2.trim().equals("0")) {
                        Toast.makeText(getApplicationContext(), "Cannot divide into a Zero",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        result = Double.parseDouble(str1) / Double.parseDouble(str2);
                        textView1.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });

        BtnRemainder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                str1 = editText1.getText().toString();
                str2 = editText2.getText().toString();

                if (str1.trim().equals("") || str2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter the value",
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (str2.trim().equals("0")) {
                        Toast.makeText(getApplicationContext(), "Cannot divide into a Zero",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        result = Double.parseDouble(str1) % Double.parseDouble(str2);
                        textView1.setText("계산 결과 : " + result.toString());
                    }
                }
            }
        });

    }
}