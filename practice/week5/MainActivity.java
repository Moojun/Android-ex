package com.seoultech.week5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnMove, btnBack;
    EditText editText;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 웹 브라우저");

        btnMove = (Button) findViewById(R.id.btnMove);
        btnBack = (Button) findViewById(R.id.btnBack);

        editText = (EditText)findViewById(R.id.editText);
        webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new CookWebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);

        // editText 에서 Enter Button 을 누르면 아래로 커서가 내려가지 않고 실행됨
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent event) {

                // 방법 1
                btnMove.callOnClick();

                // 방법 2
//                switch(i) {
//                    case KeyEvent.KEYCODE_ENTER:
//                        webView.loadUrl(editText.getText().toString());
//                        break;
//                }
                return false;

            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(editText.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                webView.goBack();
            }
        });
    }

    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,
                                                String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }


}