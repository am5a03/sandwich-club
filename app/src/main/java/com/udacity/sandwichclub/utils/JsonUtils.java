package com.udacity.sandwichclub.utils;

import android.util.JsonReader;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import java.io.StringReader;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        final StringReader stringReader = new StringReader(json);
        final JsonReader jsonReader = new JsonReader(stringReader);

        final Sandwich sandwich = new Sandwich();

        try {
            jsonReader.nextString();
        } catch (Exception e) {
            Log.e(JsonUtils.class.getSimpleName(), "parseSandwichJson: ", e);
        }

        return null;
    }
}
