package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView extends AppCompatActivity {
    WebView mwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mwebView=findViewById(R.id.webnews);
        Intent intent= getIntent();
        String url =  intent.getStringExtra("url");
        mwebView.setWebViewClient( new WebViewClient());
        mwebView.loadUrl(url);

    }
}