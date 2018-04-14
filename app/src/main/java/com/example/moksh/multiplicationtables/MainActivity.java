package com.example.moksh.multiplicationtables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;                                                                              //Created ListView.

    public void generateTable (int timesTable){                                                     //Function to create an ArrayList and set Adapter.
        final ArrayList<String> tables = new ArrayList<>();
        for (int i = 10; i>=1; i--){                                                                //Loop to add numbers to ArrayList.
        tables.add(0, Integer.toString(timesTable*i));}

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tables);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar number = (SeekBar) findViewById(R.id.seekBar);
        number.setMax(20);
        listView = (ListView) findViewById(R.id.listview);




        number.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {                   //OnSeekBarChangeListener method.
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                generateTable(progress);                                                            //ArrayAdapter changes with change in progress of SeekBar
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
