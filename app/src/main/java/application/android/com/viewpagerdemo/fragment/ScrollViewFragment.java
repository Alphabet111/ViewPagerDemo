package application.android.com.viewpagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import application.android.com.viewpagerdemo.MainActivity;
import application.android.com.viewpagerdemo.R;
import application.android.com.viewpagerdemo.base.BaseScrollFragment;
import application.android.com.viewpagerdemo.scrollview.ObservableScrollView;
import application.android.com.viewpagerdemo.scrollview.OnScrollChangedListener;
import application.android.com.viewpagerdemo.util.DensityUtil;

/**
 * Created by alphabet on 2018/5/30.
 */

public class ScrollViewFragment extends BaseScrollFragment {

  private ObservableScrollView scrollView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_scroll, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    scrollView = view.findViewById(R.id.scrollView);
    scrollView.setOnScrollChangedListener(new OnScrollChangedListener() {
      @Override public void onScrollChanged(int top, int oldTop) {
        if (isPageVisible()) {
          ((MainActivity) getActivity()).pageScrollTo(Math.min(top, maxScrollDisY()));
        }
      }
    });
  }

  @Override public void pageScrollToTop() {
    if (scrollView == null ) {
      return;
    }
    if (scrollView.getScrollY() == 0) {
      ((MainActivity) getActivity()).pageScrollTo(0);
    } else {
      scrollView.scrollTo(0, 0);
    }
  }

  @Override public void pageScrollTo(int disY) {
    if (disY <= maxScrollDisY()) {
      scrollView.scrollTo(0, disY);
    }
  }

  @Override public int maxScrollDisY() {
    return DensityUtil.dip2px(160);
  }

  @Override public boolean isPageVisible() {
    return ((MainActivity) getActivity()).getCurrPageIndex() == 0;
  }
}
