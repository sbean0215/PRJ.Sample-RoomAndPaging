package test.push.noti.ui;

import android.os.Bundle;
import test.push.noti.R;
import test.push.noti.base.BaseFragment;

public class MsgNoticeFragment extends BaseFragment {

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
