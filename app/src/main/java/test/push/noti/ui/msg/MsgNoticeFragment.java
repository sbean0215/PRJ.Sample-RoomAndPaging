package test.push.noti.ui.msg;

import android.os.Bundle;
import android.util.Log;
import test.push.noti.R;
import test.push.noti.base.BaseFragment;

import javax.inject.Inject;

public class MsgNoticeFragment extends BaseFragment {

    @Inject
    MessagesViewModel viewModel;

    private final static String title = "Notice";

    public static MsgNoticeFragment newInstance() {
        Bundle args = new Bundle();
        MsgNoticeFragment fragment = new MsgNoticeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getFragLayoutId() {
        return R.layout.fragment_notice;
    }

    @Override
    public void initView() {

    }

    @Override
    public String getTitle() {
        return "Notice";
    }
}
