package test.push.noti.ui.msg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.base.BaseFragment;
import test.push.noti.data.db.Message;
import test.push.noti.data.db.User;
import test.push.noti.databinding.FragmentAdBinding;
import test.push.noti.databinding.FragmentMessagesBinding;
import test.push.noti.databinding.FragmentNoticeBinding;
import test.push.noti.etc.Constants;
import test.push.noti.etc.RvItemDecoration;
import test.push.noti.ui.msg.MessageRvAdapter;
import test.push.noti.ui.msg.MessagesViewModel;

import javax.inject.Inject;

public class MsgMessagesFragment extends BaseFragment {

    @Inject MessagesViewModel viewModel;
    FragmentMessagesBinding binding;
    @Inject MessageRvAdapter messagesAdapter;

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


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater, getFragLayoutId(), container, false);
        binding.setVariable(BR.fragment, this);
        return binding.getRoot();
    }

    @Override
    public void initView() {
        binding.rvMessageList.addItemDecoration(new RvItemDecoration(10, activity));

        viewModel.userLiveData.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                viewModel.getMessages(user.no, getTitle()).observe(getViewLifecycleOwner(), new Observer<PagedList<Message>>() {
                    @Override
                    public void onChanged(PagedList<Message> messages) {
                        messagesAdapter.submitList(messages);
                        messagesAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }
    @Override
    public String getTitle() {
        return Constants.MESSAGE_TYPE.MESSAGE;
    }

    public MessageRvAdapter getRvAdapter() {
        return messagesAdapter;
    }
}
