package com.example.unlimitedApp.tools.internetSpeed;

import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {
    WebView webView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_internet_speed_activity_main);

        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            setSupportActionBar(myToolbar);
        }
        webView = (WebView) findViewById(R.id.webView);
        // hide webview
        webView.setVisibility(WebView.GONE);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(v -> {
            webView.loadUrl("https://www.speedtest.net/");
            webView.setVisibility(WebView.VISIBLE);
            button.setVisibility(Button.GONE);
        });

    }
}