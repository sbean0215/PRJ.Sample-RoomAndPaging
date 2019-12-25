package test.push.noti.ui.msg;

import androidx.databinding.DataBindingUtil;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.base.BaseActivity;
import test.push.noti.data.db.User;
import test.push.noti.databinding.ActivityMessagesBinding;
import test.push.noti.etc.Constants;
import test.push.noti.ui.msg.MessagesViewModel;
import test.push.noti.ui.msg.MessagesVpAdapter;

import javax.inject.Inject;

public class MessagesActivity extends BaseActivity {

    @Inject MessagesViewModel viewModel;
    @Inject MessagesVpAdapter messagesVpAdapter;
    ActivityMessagesBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_messages;
    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(BR.activity, this);

        binding.tabLayoutMessageType.setupWithViewPager(binding.viewpagerMessages);

        viewModel.startToShowMessages((User)getIntent().getSerializableExtra(Constants.INTENT_EXTRAS.USER));
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getMessageList();
    }

//    public void startToShowMessages(final User ofUser) {
//        viewModel.getMessageList(ofUser.no);
//    }

    public MessagesVpAdapter getVpAdapter() {
        return messagesVpAdapter;
    }
}
