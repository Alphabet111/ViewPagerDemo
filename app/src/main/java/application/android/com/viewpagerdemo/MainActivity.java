package application.android.com.viewpagerdemo;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import application.android.com.viewpagerdemo.adapter.BodyPagerAdapter;
import application.android.com.viewpagerdemo.adapter.HeaderPagerAdapter;
import application.android.com.viewpagerdemo.base.BaseScrollFragment;
import application.android.com.viewpagerdemo.event.BaseLinkPageChangeListener;
import application.android.com.viewpagerdemo.fragment.CoordinatelayoutFragment;
import application.android.com.viewpagerdemo.fragment.RecyclerViewFragment;
import application.android.com.viewpagerdemo.fragment.ScrollViewFragment;
import application.android.com.viewpagerdemo.util.DensityUtil;

public class MainActivity extends AppCompatActivity {

  private SlidingTabLayout tabLayout;
  private ViewPager headerVp;
  private ViewPager bodyVp;
  private List<BaseScrollFragment> fragments;
  private ScrollViewFragment scrollViewFragment;
  private RecyclerViewFragment quickLoanFragment;
  private CoordinatelayoutFragment creditCardFragment;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //设置允许通过ActivityOptions.makeSceneTransitionAnimation发送或者接收Bundle
//    getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
//    //设置使用TransistionManager进行动画，不设置的话系统会使用一个默认的TransitionManager
//    getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
    setContentView(R.layout.activity_main);
    initView();
    initViewPager();
    initListener();
  }

  private void initView() {
    tabLayout = findViewById(R.id.tabLayout);
    headerVp = findViewById(R.id.header_vp);
    bodyVp = findViewById(R.id.body_vp);
    fragments = new ArrayList<>();
    scrollViewFragment = new ScrollViewFragment();
    quickLoanFragment = new RecyclerViewFragment();
    creditCardFragment = new CoordinatelayoutFragment();
    fragments.add(scrollViewFragment);
    fragments.add(quickLoanFragment);
    fragments.add(creditCardFragment);
  }

  private void initViewPager() {
    bodyVp.setAdapter(new BodyPagerAdapter(getSupportFragmentManager(), fragments));
    String[] titles = { "scrollView", "recycleView", "coordinatelayout" };
    tabLayout.setViewPager(bodyVp, titles);
    headerVp.setAdapter(new HeaderPagerAdapter());
    headerVp.setPageMargin(DensityUtil.dip2px(10));
    headerVp.setOffscreenPageLimit(2);
    bodyVp.setOffscreenPageLimit(2);
  }

  public void pageScrollToTop() {
    for (int i = 0; i < fragments.size(); i++) {
      fragments.get(i).pageScrollToTop();
    }
  }

  private void initListener() {

    bodyVp.addOnPageChangeListener(new BaseLinkPageChangeListener(bodyVp, headerVp) {
      @Override public void onPageSelected(int position) {
        super.onPageSelected(position);
        pageScrollToTop();
      }
    });
    headerVp.addOnPageChangeListener(new BaseLinkPageChangeListener(headerVp, bodyVp) {
      @Override public void onPageSelected(int position) {
        super.onPageSelected(position);
        tabLayout.onPageSelected(position);
      }

      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        tabLayout.onPageScrolled(position, positionOffset, positionOffsetPixels);
      }
    });
  }

  public void pageScrollTo(int distance) {
    headerVp.setTranslationY(-distance);
    for (int i = 0; i < fragments.size(); i++) {
      if (i != getCurrPageIndex()) {
        fragments.get(i).pageScrollTo(distance);
      }
    }
  }

  public int getCurrPageIndex() {
    return bodyVp.getCurrentItem();
  }
}
