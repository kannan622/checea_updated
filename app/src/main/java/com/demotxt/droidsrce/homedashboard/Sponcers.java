package com.demotxt.droidsrce.homedashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Sponcers extends AppCompatActivity {

    String link_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        Intent intent = this.getIntent();
        if (intent != null)// to avoid the NullPointerException

            link_ = intent.getStringExtra("link");

        WebView mywebview = (WebView) findViewById(R.id.webview);

        mywebview.clearCache(true);
        mywebview.clearHistory();
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mywebview.setWebViewClient(new WebViewClient());
        // mywebview.loadUrl("https://www.javatpoint.com/");

        /*String data = "<html><body><h1>Hello, Javatpoint!</h1></body></html>";
        mywebview.loadData(data, "text/html", "UTF-8"); */

        mywebview.loadUrl(link_);


        if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(mywebview, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }

        mywebview.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                ProgressBar progressbar = (ProgressBar) findViewById(R.id.progress_bar);
                progressbar.setVisibility(View.GONE);
            }
        });
    }
}