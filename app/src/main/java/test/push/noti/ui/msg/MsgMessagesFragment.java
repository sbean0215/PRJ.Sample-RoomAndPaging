package test.push.noti.ui.msg;

import android.os.Bundle;
import test.push.noti.R;
import test.push.noti.base.BaseFragment;

public class MsgMessagesFragment extends BaseFragment {


    public static MsgMessagesFragment newInstance() {
        Bundle args = new Bundle();
        MsgMessagesFragment fragment = new MsgMessagesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getFragLayoutId() {
        return R.layout.fragment_messages;
    }

    @Override
    public void initView() {

    }

    @Override
    public String getTitle() {
        return "Messages";
    }

}
