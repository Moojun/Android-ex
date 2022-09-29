package com.example.exercise5_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/* GridLayout 을 활용한 계산기

     */

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Button [] numButtons = new Button[10];
    Integer [] numBtnIDs = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3,
            R.id.btnNum4, R.id.btnNum5, R.id.btnNum6, R.id.btnNum7,
            R.id.btnNum8, R.id.btnNum9 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("GridLayout 계산기");

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        // 숫자 Button 10개를 대입
        for (int i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        textResult = (TextView) findViewById(R.id.textResult);

        // 숫자 Button 10개에 대해 Event 처리
        for (int i = 0; i < numButtons.length; i++) {
            final int index;    // 주의: 꼭 필요함. i 변수를 익명 클래스 안에서 직접 실행하면 실행 오류가 발생함
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (editText1.isFocused()) {
                        num1 = editText1.getText().toString()
                                + numButtons[index].getText().toString();
                        editText1.setText(num1);
                    }
                    else if (editText2.isFocused()) {
                        num2 = editText2.getText().toString()
                                + numButtons[index].getText().toString();
                        editText2.setText(num2);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = editText1.getText().toString();
                num2 = editText2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
            }
        });



    }
}