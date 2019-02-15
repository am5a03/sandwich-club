package com.udacity.sandwichclub.utils;

import android.util.JsonReader;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = "JsonUtils";

    public static Sandwich parseSandwichJson(String json) {
        final StringReader stringReader = new StringReader(json);
        final JsonReader jsonReader = new JsonReader(stringReader);

        final Sandwich sandwich = new Sandwich();

        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                final String nodeName = jsonReader.nextName();
                if (nodeName.equals("name")) {
                    jsonReader.beginObject();

                    jsonReader.nextName();
                    sandwich.setMainName(jsonReader.nextString());

                    jsonReader.nextName();
                    sandwich.setAlsoKnownAs(readAsStringArray(jsonReader));

                    jsonReader.endObject();
                } else if (nodeName.equals("placeOfOrigin")) {
                    sandwich.setPlaceOfOrigin(jsonReader.nextString());
                } else if (nodeName.equals("description")) {
                    sandwich.setDescription(jsonReader.nextString());
                } else if (nodeName.equals("image")) {
                    sandwich.setImage(jsonReader.nextString());
                } else if (nodeName.equals("ingredients")) {
                    sandwich.setIngredients(readAsStringArray(jsonReader));
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            Log.e(JsonUtils.class.getSimpleName(), "parseSandwichJson: ", e);
        }

        Log.d(TAG, "parseSandwichJson: " + sandwich);

        return sandwich;
    }

    private static List<String> readAsStringArray(JsonReader reader) throws Exception {
        final List<String> items = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()) {
            items.add(reader.nextString());
        }
        reader.endArray();
        return items;
    }
}
