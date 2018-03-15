package com.example.ricky52194.stockquotes_ramos;

/**
 * Created by ricky52194 on 3/13/18.
 */

import android.util.Log;
import org.json.JSONObject;

public class JsonUtils {

    public static JSONObject parseStockQuoteJson(String json) {
        JSONObject quote = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            quote = jsonObject.getJSONObject("quote");
            Log.i("JSON", quote.toString());

        } catch (Exception ex) {
            Log.e("JSON", "Error parsing JSON");
        }
        return quote;
    }
}