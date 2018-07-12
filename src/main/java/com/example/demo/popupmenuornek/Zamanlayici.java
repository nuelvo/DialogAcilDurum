package com.example.demo.popupmenuornek;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Zamanlayici extends CountDownTimer {


    private int baslangicGeriSayim;
    private int geriSayimMiktari;
    private Context context;
    private TextView txtKalanSure;
    private Dialog dialog;




    public Zamanlayici(Context context,Dialog dialog, int baslangicGeriSayim, int geriSayimMiktari){
        super(baslangicGeriSayim,geriSayimMiktari);
        this.baslangicGeriSayim = baslangicGeriSayim;
        this.geriSayimMiktari = geriSayimMiktari;
        this.context =context;
        this.dialog = dialog;

        txtKalanSure = (TextView) dialog.findViewById(R.id.txtKalanSure);
    }



    @Override
    public void onTick(long kalanSure) {
            txtKalanSure.setText("Kalan Süre : " + kalanSure/1000);//Milisaniyeyi saniyeye çevirdik
    }

    @Override
    public void onFinish() {
            txtKalanSure.setText("Kalan Süre : NA");//süre bitiminde yapılması gerekenler
            dialog.dismiss();
        Toast.makeText(context,"Mesaj Gönderildi",Toast.LENGTH_LONG).show();
    }
}
