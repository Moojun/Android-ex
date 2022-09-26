package com.example.exercise5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
//        baseLayout.setBackgroundColor(Color.rgb(0, 255, 0));
        setContentView(baseLayout, params);

        EditText editText = new EditText(this);
        editText.setHint("텍스트를 입력하세요");
        baseLayout.addView(editText);

        Button button = new Button(this);
        button.setBackgroundColor(Color.YELLOW);
        button.setText("버튼입니다");
        baseLayout.addView(button);

        TextView textView = new TextView(this);

        // textSize 를 dp 단위로 설정하는 코드
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        baseLayout.addView(textView);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                textView.setText(str);
            }
        });

    }
}