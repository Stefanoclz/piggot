package com.example.piggod;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity  extends AppCompatActivity {

    private TextView StoryTextView;
    private TextView questionTextView;
    private EditText userInputEditText;
    private Button restbutton;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Inizializza le view
        StoryTextView = findViewById(R.id.StoryTextView);
        questionTextView = findViewById(R.id.questionTextView);
        userInputEditText = findViewById(R.id.userInputEditText);
        restbutton = findViewById(R.id.restbutton);
        submitButton = findViewById(R.id.button);  // Assicurati di avere un pulsante nel layout XML

        restbutton.setVisibility(View.GONE);

        restbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primaScelta();
                userInputEditText.setText("");
                restbutton.setVisibility(View.GONE);
            }
        });

        // Chiama il metodo che imposta la prima parte della storia e la domanda
        primaScelta();

        // Imposta un listener per il pulsante di invio
        submitButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String response = userInputEditText.getText().toString().toUpperCase();

                int scelta = 0;

                if (response.contains("BLU")) {
                    scelta = 1;
                } else if (response.contains("GIALLO")) {
                    scelta = 2;
                } else {
                    questionTextView.setText("Risposta non valida, impegnati scimmia!!");
                    return;  // Esci dal listener senza eseguire ulteriori azioni
                }

                switch (scelta) {
                    case 1:
                        StoryTextView.setText("Scegli di bere il liquido blu, era antigelo mischiato ad acido tamponato e con del delizioso Powerade blu. Agonizzando ti accasci mentre le tue interiora si sciolgono.");
                        questionTextView.setText("GAME OVER!");
                        restbutton.setVisibility(View.VISIBLE);
                        break;

                    case 2:
                        StoryTextView.setText("Un fantastico sapore di limonata ti invade il palato, ma come riappoggi il bicchiere ti senti svenire. Ti svegli indefinito tempo dopo, sei vestito e libero, ti accorgi che nella mano destra stringi una pistola, di fronte a te il tuo migliore amico ed il tuo peggior nemico sono legati.");
                        questionTextView.setText("A chi spari?");
                        break;
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void primaScelta() {
        // Qui puoi impostare il testo della domanda o altre logiche del gioco
        String narratore = "La pioggia cadeva violenta fuori dalla finestra, aprii gli occhi e vidi due bicchieri davanti a me, uno con un liquido giallo e l'altro con uno blu. In fondo alla stanza una scritta col sangue diceva 'Bevi o non potrai mai più respirare.'";

        ObjectAnimator fadein = ObjectAnimator.ofFloat(questionTextView, "alpha", 0f, 1f);
        fadein.setDuration(2000);

       final Handler handler = new Handler();
       StoryTextView.setText("");
       questionTextView.setText("");
        final int[] i = {0};
       handler.post(new Runnable() {
           @Override
           public void run() {
               if (i[0] < narratore.toCharArray().length) {
                   StoryTextView.setText(StoryTextView.getText().toString() + narratore.toCharArray()[i[0]]);
                   i[0]++;
                   handler.postDelayed(this, 50); // Continua il ciclo dopo il ritardo
               }
               if (i[0] == narratore.toCharArray().length) {
                    questionTextView.setText("Quale bevi, 'Blu' o 'Giallo'?");
                    fadein.start();
               }
           }
       });
    }
}


