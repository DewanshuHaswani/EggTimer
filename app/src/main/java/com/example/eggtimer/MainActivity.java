package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
     SeekBar seekBar;
    int startTime;

    public void updateTextView(long ms)
    {
        int m = (int)ms/1000;
        textView.setText(Integer.toString(m));
    }

    public void disableSeekBar()
    {
        seekBar.setEnabled(false);
    }
    public void enableSeekBar()
    {
        seekBar.setEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        //timer
         startTime =10;
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        button.setOnClickListener(new View.OnClickListener()
        {


            @Override
            public void onClick(View v) {
                disableSeekBar();
                new CountDownTimer(startTime * 1000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        updateTextView(millisUntilFinished);

                    }
                    public void onFinish() {
                        enableSeekBar();
                    }
                }.start();
            }

        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                startTime=progress*5;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}