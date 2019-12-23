package test.push.noti.ui;

import android.os.Bundle;
import test.push.noti.R;
import test.push.noti.base.BaseFragment;

public class MsgAdFragment extends BaseFragment {

    public static MsgAdFragment newInstance() {
        Bundle args = new Bundle();
        MsgAdFragment fragment = new MsgAdFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getFragLayoutId() {
        return R.layout.fragment_ad;
    }

    @Override
    public void initView() {
    }

    @Override
    public String getTitle() {
        return "Ad";
    }
}
