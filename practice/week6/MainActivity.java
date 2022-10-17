package com.seoultech.week6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;
    Button button;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String [] pkmArray = new String[]{"이상해씨", "파이리", "꼬부기"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("당신의 선택은?");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setSingleChoiceItems(pkmArray, 5, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        str = pkmArray[i];
                    }
                });
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       textView.setText(str);
                       Toast toast = new Toast(MainActivity.this);
                       View toastView = (View) View.inflate(MainActivity.this, R.layout.toast1,
                               null);

                       TextView toastText = (TextView) toastView.findViewById(R.id.toastText1);
                       toastText.setText(str + " 를 선택했습니다");
                       toast.setView(toastView);
                       toast.setGravity(Gravity.CENTER | Gravity.TOP, 0, 200);
                       toast.show();
                    }
                });
                dlg.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.itemRed:
                linearLayout.setBackgroundColor(Color.RED);
                textView.setTextColor(Color.WHITE);
                return true;
            case R.id.itemGreen:
                linearLayout.setBackgroundColor(Color.GREEN);
                textView.setTextColor(Color.WHITE);
                return true;
            case R.id.itemBlue:
                linearLayout.setBackgroundColor(Color.BLUE);
                textView.setTextColor(Color.WHITE);
                return true;
        }
        return false;
    }


}