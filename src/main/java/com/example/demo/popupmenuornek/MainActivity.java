package com.example.demo.popupmenuornek;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private Dialog dialog;
    private CountDownTimer cdTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_popup);
        dialog.setTitle("Acil Durum!");
        dialog.setCanceledOnTouchOutside(false);//Dialogun kenarlarına basıldığında pencere kapanmıyorbu fonksiyon sayesinde
        cdTimer = new Zamanlayici(this,dialog,60000,1000);


    }

    public void dialogGoster(View view){
        dialog.show();
        cdTimer.start();
    }

    public void dialogKapat(View view){
        dialog.dismiss();
        cdTimer.cancel();
        cdTimer = null;
        cdTimer = new Zamanlayici(this,dialog,60000,1000);
        Toast.makeText(this,"İşlem İptal Edildi",Toast.LENGTH_LONG).show();
    }
}
