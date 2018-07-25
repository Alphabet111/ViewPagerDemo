package application.android.com.viewpagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import application.android.com.viewpagerdemo.MainActivity;
import application.android.com.viewpagerdemo.R;
import application.android.com.viewpagerdemo.adapter.RvAdapter;
import application.android.com.viewpagerdemo.base.BaseScrollFragment;
import application.android.com.viewpagerdemo.util.DensityUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alphabet on 2018/5/30.
 */

public class CoordinatelayoutFragment extends BaseScrollFragment {

  private RecyclerView recyclerView;
  private LinearLayoutManager layoutManager;
  private CoordinatorLayout coordinatorLayout;
  private AppBarLayout appBarLayout;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_coordinatelayout, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recyclerView = view.findViewById(R.id.recyclerView);
    coordinatorLayout = view.findViewById(R.id.coordinatorLayout);
    appBarLayout = view.findViewById(R.id.appBarLayout);
    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 150; i++) {
      list.add("我是coordinateLayout");
    }
    RvAdapter adapter = new RvAdapter(list);
    recyclerView.setAdapter(adapter);
    appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
      @Override public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (isPageVisible()) {
          ((MainActivity) getActivity()).pageScrollTo(
              Math.min(Math.abs(verticalOffset), maxScrollDisY()));
        }
      }
    });
  }

  @Override public void pageScrollToTop() {
    layoutManager.scrollToPositionWithOffset(0, 0);
    appBarLayout.setExpanded(true);
    coordinatorLayout.scrollTo(0, 0);
  }

  @Override public void pageScrollTo(int disY) {
    if (disY <= maxScrollDisY()) {
      layoutManager.scrollToPositionWithOffset(0, -disY);
      coordinatorLayout.scrollTo(0, disY);
    }
  }

  @Override public int maxScrollDisY() {
    return DensityUtil.dip2px(160);
  }

  @Override public boolean isPageVisible() {
    return ((MainActivity) getActivity()).getCurrPageIndex() == 2;
  }
}
