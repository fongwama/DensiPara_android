package cg.fongwama.densipara.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cg.fongwama.densipara.R;
/**
 * Created by Orion WAMBERT on 01/04/2018.
 */
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        Thread thread=new Thread(){
            public void run(){
                try {
                    sleep(2000);
                    Intent intent=new Intent(Splash.this,Home.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
