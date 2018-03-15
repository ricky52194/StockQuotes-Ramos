package com.example.ricky52194.stockquotes_ramos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView symbolDisplay, nameDisplay, lastPriceDisplay, lastTimeDisplay, changeDisplay, rangeDisplay;
    private Button buttonGo,buttonReset;
    String symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.search);
        symbolDisplay = findViewById(R.id.symbolDisplay);
        nameDisplay = findViewById(R.id.nameDisplay);
        lastPriceDisplay = findViewById(R.id.lastPriceDisplay);
        lastTimeDisplay = findViewById(R.id.lastTimeDisplay);
        changeDisplay = findViewById(R.id.changeDisplay);
        rangeDisplay = findViewById(R.id.rangeDisplay);
        buttonGo = findViewById(R.id.button);
        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                symbol = editText.getText().toString();
                myAsyncTask task = new myAsyncTask(MainActivity.this, symbolDisplay, nameDisplay, lastPriceDisplay, lastTimeDisplay, changeDisplay, rangeDisplay);
                task.execute(symbol);
            }
        });
        buttonReset = findViewById(R.id.button2);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.getText().clear();
                symbolDisplay.setText(getString(R.string.Initial));
                nameDisplay.setText(getString(R.string.Initial));
                lastPriceDisplay.setText(getString(R.string.Initial));
                lastTimeDisplay.setText(getString(R.string.Initial));
                changeDisplay.setText(getString(R.string.Initial));
                rangeDisplay.setText(getString(R.string.Initial));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(getString(R.string.editTextKey), editText.getText().toString());
        outState.putString(getString(R.string.symbolKey), symbolDisplay.getText().toString());
        outState.putString(getString(R.string.nameKey), nameDisplay.getText().toString());
        outState.putString(getString(R.string.priceKey), lastPriceDisplay.getText().toString());
        outState.putString(getString(R.string.timeKey), lastTimeDisplay.getText().toString());
        outState.putString(getString(R.string.changeKey), changeDisplay.getText().toString());
        outState.putString(getString(R.string.rangeKey), rangeDisplay.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText(savedInstanceState.getString(getString(R.string.editTextKey)));
        symbolDisplay.setText(savedInstanceState.getString(getString(R.string.symbolKey)));
        nameDisplay.setText(savedInstanceState.getString(getString(R.string.nameKey)));
        lastPriceDisplay.setText(savedInstanceState.getString(getString(R.string.priceKey)));
        lastTimeDisplay.setText(savedInstanceState.getString(getString(R.string.timeKey)));
        changeDisplay.setText(savedInstanceState.getString(getString(R.string.changeKey)));
        rangeDisplay.setText(savedInstanceState.getString(getString(R.string.rangeKey)));

    }
}
