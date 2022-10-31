package com.seoultech.week7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileFilter;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    MyPictureView myPictureView1;
    TextView textView;
    File [] imageFiles;
    String imageFilename;
    int curNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String [] {Manifest
                .permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        textView = (TextView) findViewById(R.id.textView);
        myPictureView1 = (MyPictureView) findViewById(R.id.myPictureView1);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/Pictures").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile();   // 이 부분에서 directory 가 포함되는 것을 방지한다
            }
        });
        imageFilename = imageFiles[0].toString();
        myPictureView1.imagePath = imageFilename;

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum <= 0) {
                    curNum = imageFiles.length - 1;
                }
                else {
                    curNum--;
                }
                imageFilename = imageFiles[curNum].toString();
                myPictureView1.imagePath = imageFilename;
                myPictureView1.invalidate();
                textView.setText(String.valueOf(curNum + 1) + " / " + imageFiles.length);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length - 1) {
                    curNum = 0;
                }
                else {
                    curNum++;
                }
                imageFilename = imageFiles[curNum].toString();
                myPictureView1.imagePath = imageFilename;
                myPictureView1.invalidate();
                textView.setText(String.valueOf(curNum + 1) + " / " + imageFiles.length);
            }
        });


    }
}