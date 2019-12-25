package test.push.noti.ui.msg;

import android.os.Bundle;
import android.util.Log;
import test.push.noti.R;
import test.push.noti.base.BaseFragment;

import javax.inject.Inject;

public class MsgAdFragment extends BaseFragment {

    @Inject MessagesViewModel viewModel;

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
