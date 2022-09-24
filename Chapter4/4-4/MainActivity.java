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
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /* 4-4. 예제 4-2 수정.
    1. '시작함'을 스위치로 변경
    2. <선택 완료> 버튼을 없애고, 라디오버튼을 선택할 때마다 즉시 해당 이미지가 나오도록 변경한다.
    3. 마지막에 <종료>와 <처음으로> 버튼을 추가한다. <종료>를 클릭하면 응용 프로그램이 완전히 종료되게 하고,
    <처음으로>를 클릭하면 다시 초기화되고 처음 화면이 나오게 한다.
    3-1. <처음으로> 버튼 클릭 후 다시 실행 시, RadioButton check 해제 및 ImageView 그림 완전 제거된 상태로 setting 필요
     */

    TextView textView1, textView2;
    Switch switchAgree;
    RadioGroup radioGroup;
    RadioButton radioArr[] = new RadioButton[3];
    ImageView imageView;
    Button endBtn, startBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        textView1 = (TextView) findViewById(R.id.textView1);
        switchAgree = (Switch) findViewById(R.id.switchAgree);

        textView2 = (TextView) findViewById(R.id.textView2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioArr[0] = (RadioButton) findViewById(R.id.radioPie);
        radioArr[1] = (RadioButton) findViewById(R.id.radioQ);
        radioArr[2] = (RadioButton) findViewById(R.id.radioR);

        imageView = (ImageView) findViewById(R.id.imageView);
        endBtn = (Button) findViewById(R.id.endBtn);
        startBtn = (Button) findViewById(R.id.startBtn);

        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                // 체크되면 모두 보이도록 설정
                if (switchAgree.isChecked()) {
                    textView2.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    endBtn.setVisibility(View.VISIBLE);
                    startBtn.setVisibility(View.VISIBLE);
                }
                else {
                    textView2.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);
                    endBtn.setVisibility(View.INVISIBLE);
                    startBtn.setVisibility(View.INVISIBLE);
                }
            }
        });

        // 라디오버튼을 클릭할 때, 이미지 뷰를 변경시킴 ==> 배열로 처리함.
        final int draw[] =  { R.drawable.pie, R.drawable.q10, R.drawable.r11};
        for (int i = 0; i < radioArr.length; i++) {
            final int index;    // 주의! 꼭 필요함.
            index = i;
            radioArr[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageView.setImageResource(draw[index]);
                }
            });
        }


        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setVisibility(View.INVISIBLE);
                radioGroup.setVisibility(View.INVISIBLE);
                imageView.setVisibility(View.INVISIBLE);
                endBtn.setVisibility(View.INVISIBLE);
                startBtn.setVisibility(View.INVISIBLE);

                imageView.setImageResource(0);  // imageView 를 비우기 위해
                radioGroup.clearCheck();
                switchAgree.setChecked(false);
            }
        });


    }
}