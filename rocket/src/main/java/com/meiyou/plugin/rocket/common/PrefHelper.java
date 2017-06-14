package com.meiyou.plugin.rocket.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Utility class to store settings
 */
public class PrefHelper {

  private PrefHelper() {
    // no instance
  }

  private static final String KEY_PREFS = "BeeConfigPrefs";

  public static void setBoolean(Context context, String key, boolean value) {
    getEditor(context).putBoolean(key, value).commit();
  }

  public static boolean getBoolean(Context context, String key) {
    return getPrefs(context).getBoolean(key, false);
  }

  public static void setInt(Context context, String key, int value) {
    getEditor(context).putInt(key, value).commit();
  }

  public static int getInt(Context context, String key) {
    return getPrefs(context).getInt(key, 0);
  }

  static SharedPreferences getPrefs(Context context) {
    return context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE);
  }

  private static SharedPreferences.Editor getEditor(Context context) {
    SharedPreferences prefs = context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE);
    return prefs.edit();
  }

}
