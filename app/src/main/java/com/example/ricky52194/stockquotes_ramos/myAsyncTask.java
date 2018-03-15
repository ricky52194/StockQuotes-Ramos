package com.example.ricky52194.stockquotes_ramos;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

/**
 * Created by ricky52194 on 3/13/18.
 */

public class myAsyncTask extends AsyncTask<String,Void,Stock> {

    private Context context;
    private TextView symbolDisplay, nameDisplay, lastPriceDisplay, lastTimeDisplay, changeDisplay, rangeDisplay;

    public myAsyncTask(Context context, TextView symbolDisplay, TextView nameDisplay, TextView lastPriceDisplay, TextView lastTimeDisplay, TextView changeDisplay, TextView rangeDisplay){
        this.context = context;
        this.symbolDisplay = symbolDisplay;
        this.nameDisplay = nameDisplay;
        this.lastPriceDisplay = lastPriceDisplay;
        this.lastTimeDisplay = lastTimeDisplay;
        this.changeDisplay = changeDisplay;
        this.rangeDisplay = rangeDisplay;
    }

    @Override
    protected Stock doInBackground(String... strings) {
        try {
            Stock stock = new Stock(strings[0]);
            stock.load();
            return stock;
        } catch (IOException e) {
            Log.e(context.getString(R.string.Stock), context.getString(R.string.stockErrorMsg));
            return null;
        }
    }

    @Override
    protected void onPostExecute(Stock stock) {
        if(stock != null) {
            symbolDisplay.setText(stock.getSymbol());
            nameDisplay.setText(stock.getName());
            lastPriceDisplay.setText(stock.getLastTradePrice());
            lastTimeDisplay.setText(stock.getLastTradeTime());
            changeDisplay.setText(stock.getChange());
            rangeDisplay.setText(stock.getRange());
        }else{
            Toast.makeText(context, context.getString(R.string.toastErrorMsg), Toast.LENGTH_LONG).show();
        }
    }
}
