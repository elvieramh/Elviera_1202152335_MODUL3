package android.example.com.elviera_1202152335_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                //intent digunakan untuk memindah ke halaman selanjutnya
                Intent x = new Intent(SplashScreenActivity.this, LoginActivity.class);
                //memulai aktivitas
                startActivity(x);
                finish();
            }
        },1500); //Script ini berguna untuk mengatur lamanya splashscreen akan tampil selama 1,5 detik
    }
}
