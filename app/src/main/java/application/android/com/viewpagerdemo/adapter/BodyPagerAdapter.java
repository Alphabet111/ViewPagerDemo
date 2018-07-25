package application.android.com.viewpagerdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import application.android.com.viewpagerdemo.base.BaseScrollFragment;
import java.util.List;

/**
 * Created by alphabet on 2018/5/30.
 */

public class BodyPagerAdapter extends FragmentPagerAdapter{
  private List<BaseScrollFragment> fragments;

  public BodyPagerAdapter(FragmentManager fm, List<BaseScrollFragment> fragments) {
    super(fm);
    this.fragments = fragments;
  }

  @Override public Fragment getItem(int position) {
    return fragments.get(position);
  }

  @Override public int getCount() {
    return 3;
  }
}
