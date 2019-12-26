package test.push.noti.ui.msg;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.base.BaseActivity;
import test.push.noti.data.db.Message;
import test.push.noti.data.db.User;
import test.push.noti.databinding.ActivityMessagesBinding;
import test.push.noti.etc.Constants;
import test.push.noti.ui.msg.MessagesViewModel;
import test.push.noti.ui.msg.MessagesVpAdapter;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;

public class MessagesActivity extends BaseActivity {

    @Inject MessagesViewModel viewModel;
    @Inject MessagesVpAdapter messagesVpAdapter;
    ActivityMessagesBinding binding;

    private User user;

    @Override
    public int getLayoutId() {
        return R.layout.activity_messages;
    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(BR.activity, this);

        binding.viewpagerMessages.setAdapter(getVpAdapter());
        binding.tabLayoutMessageType.setupWithViewPager(binding.viewpagerMessages);

        user = (User)getIntent().getSerializableExtra(Constants.INTENT_EXTRAS.USER);

        setCustomTabs(binding.tabLayoutMessageType);
        viewModel.startToShowMessages(user);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getMessageList();
    }

    public void finishActivity() {
        finish();
    }

    public void startToDelete(Message message) {
        new AsyncTask<Message, Void, Void>() {
            @Override
            protected Void doInBackground(Message... messages) {
            viewModel.deleteMessage(messages[0]);
                return null;
            }
        }.execute(message);
    }


    public MessagesVpAdapter getVpAdapter() {
        return messagesVpAdapter;
    }

    private void setCustomTabs(TabLayout tabLayout) {
        for(int position = 0 ; position < tabLayout.getTabCount() ; position ++) {
            String messageType = (String)messagesVpAdapter.getPageTitle(position);

            tabLayout.getTabAt(position).setCustomView(R.layout.tab_item);
            final View tabsCustomView = tabLayout.getTabAt(position).getCustomView();   //TODO 리팩터링필요

            ((TextView)tabsCustomView.findViewById(R.id.tv_tab_title)).setText(messageType);

            //TODO 리팩토링 필요
            viewModel.getCountOf(messageType, user.no).observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(final Integer count) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView tvTabCount = tabsCustomView.findViewById(R.id.tv_tab_count);
                            if (count == null || count == 0) {
                                tvTabCount.setVisibility(View.GONE);
                            } else {
                                tvTabCount.setVisibility(View.VISIBLE);
                                tvTabCount.setText(String.valueOf(count));
                            }
                        }
                    });
                }
            });
        }
    }
}
