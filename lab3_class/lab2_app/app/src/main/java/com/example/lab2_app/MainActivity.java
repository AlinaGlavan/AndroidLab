package com.example.lab2_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView numberTextView = (TextView) findViewById(R.id.numberTextView);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        Button randButton = (Button) findViewById(R.id.randButton);
        randButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand= new Random();
                int randNo = rand.nextInt(seekBar.getProgress())+1;
                numberTextView.setText(Integer.toString(randNo));
            }
        });

    }
}
