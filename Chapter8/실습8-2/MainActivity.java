package com.seoultech.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    MyPictureView myPictureView1;
    int curNum = 1;
    File [] imageFiles;
    String imageFilename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String [] {Manifest
                .permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPictureView1 = (MyPictureView) findViewById(R.id.myPictureView1);

        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/Pictures").listFiles();

        imageFilename = imageFiles[0].toString();
        myPictureView1.imagePath = imageFilename;

        /* 출력 test 결과 .thumbnails 디렉토리도 같이 출력됨 */
        for (int i = 0; i < imageFiles.length; i++) {
            System.out.println(imageFiles[i].toString());
        }

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum <= 1) {
                    Toast.makeText(getApplicationContext(), "첫 번째 그림입니다.", Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    curNum--;
                    imageFilename = imageFiles[curNum].toString();
                    myPictureView1.imagePath = imageFilename;
                    myPictureView1.invalidate();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length - 1 - 1) {
                    Toast.makeText(getApplicationContext(), "마지막 그림입니다.", Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    curNum++;
                    imageFilename = imageFiles[curNum].toString();
                    myPictureView1.imagePath = imageFilename;
                    myPictureView1.invalidate();
                }
                System.out.println("curNum is " + curNum + ", and imageFiles.length - 1 is : "
                        + (imageFiles.length - 1));
            }
        });

    }
}