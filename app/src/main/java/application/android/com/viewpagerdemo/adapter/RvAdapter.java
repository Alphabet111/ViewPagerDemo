package application.android.com.viewpagerdemo.adapter;

import application.android.com.viewpagerdemo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/**
 * Created by alphabet on 2018/6/14.
 */

public class RvAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
  public RvAdapter(List<String> data) {
    super(R.layout.item_rv, data);
  }

  @Override protected void convert(BaseViewHolder helper, String item) {
    helper.setText(R.id.tv_name,item);
  }
}
