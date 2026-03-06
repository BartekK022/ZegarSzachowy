package com.example.projektzegarszachowy;

import android.os.CountDownTimer;
import android.widget.Button;

import java.nio.Buffer;

public class Gracz {
    private int ileSekund;
    private CountDownTimer countDownTimer;
    private Button button;
    private boolean czyAktywny;

    public Gracz(Button button, boolean czyAktywny) {
        this.button = button;
        this.czyAktywny = czyAktywny;
        ileSekund = 180; // nasz zegar na razie na 3 minuty
        if(czyAktywny) {
            uruchomZegar();
        } else {
            StopZegar();
        }
    }

    public void odwrocAktywnosc() {
        czyAktywny =! czyAktywny;
        if (czyAktywny) {
            uruchomZegar();
        } else {
            StopZegar();
        }
    }

    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(ileSekund*1000, 1000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long l) {
                ileSekund = (int) (l/1000);
                button.setText(""+ileSekund);

            }
        };
        countDownTimer.start();
    }
    private void StopZegar() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
    private String LadnyCzas(int ileSekund) {
        int sekundy = ileSekund%60;
        int minuty = (ileSekund/60)%60;
        int godzina = ileSekund/3600;
        return String.format("%02d:%02d:%02d", godzina, minuty, sekundy);
    }
}
