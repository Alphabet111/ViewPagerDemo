package application.android.com.viewpagerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class RecyclerViewFragment extends BaseScrollFragment {

  private RecyclerView recyclerView;
  private LinearLayoutManager layoutManager;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_recyclerview, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recyclerView = view.findViewById(R.id.recyclerView);
    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      list.add("我是recyclerView");
    }
    RvAdapter adapter = new RvAdapter(list);
    adapter.addHeaderView(View.inflate(getActivity(), R.layout.rv_header, null));
    recyclerView.setAdapter(adapter);

    recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (isPageVisible()) {
          if (layoutManager.findFirstVisibleItemPosition() == 0) {
            ((MainActivity) getActivity()).pageScrollTo(recyclerView.computeVerticalScrollOffset());
          } else {
            ((MainActivity) getActivity()).pageScrollTo(maxScrollDisY());
          }
        }
      }
    });
  }

  @Override public void pageScrollToTop() {
    layoutManager.scrollToPositionWithOffset(0, 0);
  }

  @Override public void pageScrollTo(int disY) {
    if (disY <= maxScrollDisY()) {
      layoutManager.scrollToPositionWithOffset(0, -disY);
    }
  }

  @Override public int maxScrollDisY() {
    return DensityUtil.dip2px(160);
  }

  @Override public boolean isPageVisible() {
    return ((MainActivity) getActivity()).getCurrPageIndex() == 1;
  }
}
