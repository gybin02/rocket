package com.meiyou.plugin.rocket.common;

import android.content.Context;

import java.util.List;
import java.util.Map;

/**
 * It is used to provide necessary methods
 */
public interface ConfigListener {
@Deprecated
  @SuppressWarnings("unused") void onInfoContentCreated(Map<String, String> content);
@Deprecated
  @SuppressWarnings("unused") void onLogContentCreated(List<String> list);

  @SuppressWarnings("unused") void onClose();

  @SuppressWarnings("unused") Context getContext();

  @SuppressWarnings("unused") void setContext(Context context);
}
