package application.android.com.viewpagerdemo.adapter;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import application.android.com.viewpagerdemo.R;

/**
 * Created by alphabet on 2018/5/30.
 */

public class HeaderPagerAdapter extends PagerAdapter {

  private int color;

  @Override public int getCount() {
    return 3;
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view == object;
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    View view =
        LayoutInflater.from(container.getContext()).inflate(R.layout.item_header, container, false);
    TextView tvTitle = view.findViewById(R.id.tv_title);
    switch (position) {
      case 0:
        color = Color.parseColor("#ff0000");
        tvTitle.setText("SCROLLVIEW");
        break;
      case 1:
        color = Color.parseColor("#00ff00");
        tvTitle.setText("RECYCLERVIEW");
        break;
      case 2:
        color = Color.parseColor("#0000ff");
        tvTitle.setText("COORDINATELAYOUT");
        break;
    }
    view.findViewById(R.id.root_view).setBackgroundColor(color);
    container.addView(view);
    return view;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView(((View) object));
  }
}
