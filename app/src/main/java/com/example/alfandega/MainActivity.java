package com.example.alfandega;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    TextView titulo;
    ImageView seta;

    Animation aparece;
    Animation some;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo = findViewById(R.id.textTitulo);
        seta = findViewById(R.id.imageSeta);

        titulo.setText("Toque em qualquer lugar da tela para continuar.");
        seta.setVisibility(View.INVISIBLE);

        aparece = new AlphaAnimation(0,1);
        some = new AlphaAnimation(1,0);

        aparece.setDuration(500);
        some.setDuration(500);

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                seta.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                seta.setVisibility(View.VISIBLE);
                seta.startAnimation(some);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                seta.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                seta.setVisibility(View.INVISIBLE);
                titulo.setText("Toque em qualquer lugar da tela para continuar.");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void clicouTela (View view){


        if (Math.random() < 0.5){
            titulo.setText("Siga para a Esquerda");
            seta.setScaleX(1f);
        } else {
            titulo.setText("Siga para a Direita");
            seta.setScaleX(-1);
        }

        seta.startAnimation(aparece);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                seta.startAnimation(some);
            }
        }, 4000);

    }

}
