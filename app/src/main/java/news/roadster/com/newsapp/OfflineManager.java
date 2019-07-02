package news.roadster.com.newsapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import news.roadster.com.newsapp.pojo.NewsData;

public class OfflineManager {

    public static  String OFFLINE_NEWS_DATA = "OFFLINE_NEWS_DATA";

    public static SharedPreferences get(final Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("news.roadster.com.newsapp." + BuildConfig.BUILD_TYPE ,
                Context.MODE_PRIVATE);
    }


    public static NewsData getPref(final Context context, String pref,
                                   NewsData def) {
        Gson gson = new Gson();
        if (context == null) {
            return null;
        }
        SharedPreferences prefs = OfflineManager.get(context);
        String val = prefs.getString(pref, gson.toJson(def));

        if (val == null || val.equals("") || val.equals("null"))
            return def;
        else
            return new Gson().fromJson(val, NewsData.class);
    }

    public static void putPref(final Context context, String pref,
                               NewsData val) {
        Gson gson = new Gson();
        if (context == null) {
            return;
        }
        SharedPreferences prefs = OfflineManager.get(context);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(pref, gson.toJson(val));
        editor.apply();
    }

}
