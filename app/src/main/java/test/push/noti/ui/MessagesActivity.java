package test.push.noti.ui;

import android.util.Log;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.base.BaseActivity;
import test.push.noti.databinding.ActivityMessagesBinding;

import javax.inject.Inject;

public class MessagesActivity extends BaseActivity {

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

    }

    public MessagesVpAdapter getVpAdapter() {
        return messagesVpAdapter;
    }
}
