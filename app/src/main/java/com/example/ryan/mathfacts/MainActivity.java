package com.example.ryan.mathfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar numberSeekBar;
    ListView timesTablesListView;
    TextView multiplierTextView;
    int multiplier = 10;
    ArrayList<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberSeekBar = findViewById(R.id.numberSeekBar);
        timesTablesListView = findViewById(R.id.timesTablesListView);
        multiplierTextView= findViewById(R.id.multiplierTextView);

        multiplierTextView.setText(Integer.toString(multiplier) + "'s facts");

        updateAnswers();
        setupSeekBar();
    }

    public void setupSeekBar() {
        numberSeekBar.setMax(12);
        numberSeekBar.setProgress(10);

        numberSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i < 1) {
                    numberSeekBar.setProgress(1);
                    i = 1;
                }
                multiplier = i;
                multiplierTextView.setText(Integer.toString(multiplier) + "'s facts");
                updateAnswers();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    public void updateAnswers() {
        answers.clear();
        for (int xx = 1; xx < 13; xx++) {
            answers.add(Integer.toString(multiplier) + " × " + Integer.toString(xx) + " = " + Integer.toString(xx * multiplier));
        }

        ArrayAdapter<String> timesTableAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, answers);
        timesTablesListView.setAdapter(timesTableAdapter);
    }
}
