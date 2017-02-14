package es.cice.webviewtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url ="file:///android_asset/ejemplo.html";
        WebView wb = (WebView) findViewById(R.id.web);
        wb.loadUrl(url);
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wb.addJavascriptInterface(new webAppInterface(this), "Android");


    }
    public class webAppInterface {
        Context context;
        public webAppInterface(Context context){
            this.context = context;

        }
        @JavascriptInterface
        public void showDialog(String message){
            AlertDialog.Builder b= new AlertDialog.Builder(this.context);
            b.setMessage(message).setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            b.create().show();

        }
    }
}
