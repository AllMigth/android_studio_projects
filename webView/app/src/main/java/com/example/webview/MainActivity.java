package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        String customHTML="<html><body><h1>Hola mundo</h1>" +
                "<h3>Adios</h3>" +
                "<p>Mi primer codigo html en android</p>" +
                "</body></html>";

        //webView.loadUrl("https://codigofacilito.com");
        //activar el uso de js
        webView.loadData(customHTML,"text/html; charset=utf-8",null);
        webView.setBackgroundColor(Color.GREEN);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setTextZoom(100);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            //2 parametros
            //webview y el progreso de carga de la pagina dentro del webview
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress==100){
                    progressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }
}
