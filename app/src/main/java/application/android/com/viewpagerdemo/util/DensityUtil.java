package application.android.com.viewpagerdemo.util;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import android.content.Context;
import android.content.res.Resources;

public class DensityUtil {
  public DensityUtil() {
  }

  /** @deprecated */
  @Deprecated
  public static int px2dip(Context context, float pxValue) {
    return px2dip(pxValue);
  }

  public static int px2dip(float pxValue) {
    float scale = Resources.getSystem().getDisplayMetrics().density;
    return (int)(pxValue / scale + 0.5F);
  }

  /** @deprecated */
  @Deprecated
  public static int dip2px(Context context, float dipValue) {
    return dip2px(dipValue);
  }

  public static int dip2px(float dipValue) {
    float scale = Resources.getSystem().getDisplayMetrics().density;
    return (int)(dipValue * scale + 0.5F);
  }

  /** @deprecated */
  @Deprecated
  public static int px2sp(Context context, float pxValue) {
    return px2sp(pxValue);
  }

  public static int px2sp(float pxValue) {
    float scale = Resources.getSystem().getDisplayMetrics().scaledDensity;
    return (int)(pxValue / scale + 0.5F);
  }

  /** @deprecated */
  @Deprecated
  public static int sp2px(Context context, float spValue) {
    return sp2px(spValue);
  }

  public static int sp2px(float spValue) {
    float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
    return (int)(spValue * fontScale + 0.5F);
  }

  public static int getScreenWidth() {
    return Resources.getSystem().getDisplayMetrics().widthPixels;
  }

  public static int getScreenHeight() {
    return Resources.getSystem().getDisplayMetrics().heightPixels;
  }
}
