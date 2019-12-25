package test.push.noti.ui.msg;

import android.os.Bundle;
import android.util.Log;
import test.push.noti.R;
import test.push.noti.base.BaseFragment;

import javax.inject.Inject;

public class MsgMessagesFragment extends BaseFragment {

    @Inject MessagesViewModel viewModel;

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
