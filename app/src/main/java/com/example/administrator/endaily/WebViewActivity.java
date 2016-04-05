package com.example.administrator.endaily;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yyj.ui.ChangeTheme;

/**
 * Created by 草帽儿 on 2016/2/18.
 */
public class WebViewActivity extends BaseActivity{
    private WebView webView;
    private TextView titleTV;
    private ImageView backIv,reloadIv;
    private static ChangeTheme changeTheme;
    private ProgressDialog progressDialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        changeTheme = new ChangeTheme(this);
        changeTheme.initTheme();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_webview);
        Intent intent =getIntent();
        final String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        webView = (WebView) findViewById(R.id.webview);
        titleTV = (TextView) findViewById(R.id.webview_title);
        backIv = (ImageView) findViewById(R.id.webview_backIv);
        reloadIv = (ImageView) findViewById(R.id.webview_reload);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView != null && webView.canGoBack()) {
                    webView.goBack();
                    return;
                }
                finish();
            }
        });
        reloadIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView != null && url != null) {
                    webView.reload();
                }
            }
        });
        if (title!=null) {
            titleTV.setText(title);
        }
        webView.setWebViewClient(new MyWebViewClient());
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        WebSettings webSettings = webView.getSettings();
//        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//不使用缓存
        webSettings.setAllowFileAccess(true);// 若html是一个文件框的话,就可以浏览本地文件
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setSupportZoom(true); //支持缩放
        //WebView双击变大，再双击后变小，当手动放大后，双击可以恢复到原始大小
        webSettings.setUseWideViewPort(true);//
        webSettings.setDomStorageEnabled(true);//支持html5本地存储
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webSettings.getJavaScriptEnabled();
        webSettings.setJavaScriptEnabled(true);
        if (webView != null ) {
        if (url != null) {
                webView.loadUrl(url);
        } else {
            titleTV.setText("相关搜索");
            String connectedUrl = "http://wap.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&ch=&tn=baiduerr&bar=&wd=";
            String keyWords = getIntent().getStringExtra("Connected");
            if (keyWords!=null) {
                webView.loadUrl(connectedUrl+keyWords);
            }
        }
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            if (webView!=null&& webView.canGoBack()) {
                webView.goBack();
                return true;
            }
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        changeTheme.clearTheme();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        return true;
    }

    private class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url,Bitmap favicon) {//网页页面开始加载的时候
            if (progressDialog == null) {
                progressDialog=new ProgressDialog(WebViewActivity.this);
                progressDialog.setMessage("数据加载中，请稍后。。。");
                progressDialog.show();
                webView.setEnabled(false);// 当加载网页的时候将网页进行隐藏
            }
            super.onPageStarted(view, url,favicon);
        }
        @Override
        public void onPageFinished(WebView view, String url) {//网页加载结束的时候
            //super.onPageFinished(view, url);
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
                progressDialog = null;
                webView.setEnabled(true);
            }
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view ,String url){ //网页加载时的连接的网址
            view.loadUrl(url);
            return false;
        }
    }
}
