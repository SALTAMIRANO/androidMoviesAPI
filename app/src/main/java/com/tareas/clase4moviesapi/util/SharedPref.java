package com.tareas.clase4moviesapi.util;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private final static String sharedName="myPreferences";

    public static void   setKey(Context context, String key, String value){
        SharedPreferences pref = context.getSharedPreferences(sharedName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public static String   getKey(Context context,String key){
        SharedPreferences pref = context.getSharedPreferences(sharedName,Context.MODE_PRIVATE);
        try
        {
            return pref.getString(key, "");
        }
        catch (Exception ex){
            return "";
        }
    }


    public static void   setKeyInt(Context context, String key, Integer value){
        SharedPreferences pref = context.getSharedPreferences(sharedName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public static Integer   getKeyInteger(Context context,String key){
        SharedPreferences pref = context.getSharedPreferences(sharedName,Context.MODE_PRIVATE);
        try
        {
            return pref.getInt(key,0);
        }
        catch (Exception ex){
            return 0;
        }
    }


}
