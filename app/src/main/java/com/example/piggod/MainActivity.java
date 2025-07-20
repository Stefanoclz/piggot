package com.example.piggod;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000; // Tempo in millisecondi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Passiamo alla schermata di gioco
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                setContentView(R.layout.activity_main);
                startActivity(intent);
                finish(); // Chiudiamo l'attività corrente
            }
        }, SPLASH_TIME_OUT);*/
        // Imposta il layout per la schermata principale (splash screen)
        setContentView(R.layout.activity_main);

        // Ritarda il passaggio alla schermata di gioco
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Passa alla schermata di gioco dopo 10 secondi
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                finish(); // Chiude l'attività corrente
            }
        }, SPLASH_TIME_OUT);
    };
}
