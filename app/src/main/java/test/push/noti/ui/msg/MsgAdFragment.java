package test.push.noti.ui.msg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.base.BaseFragment;
import test.push.noti.data.db.Message;
import test.push.noti.data.db.User;
import test.push.noti.databinding.FragmentAdBinding;
import test.push.noti.etc.Constants;
import test.push.noti.etc.RvItemDecoration;

import javax.inject.Inject;

public class MsgAdFragment extends BaseFragment {

    FragmentAdBinding binding;
    @Inject MessageRvAdapter messagesAdapter;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater, getFragLayoutId(), container, false);
        binding.setVariable(BR.fragment, this);
        binding.executePendingBindings();

        return binding.getRoot();
    }

    @Override
    public void initView() {
        binding.rvAdList.addItemDecoration(new RvItemDecoration(10, activity));

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
        return Constants.MESSAGE_TYPE.AD;
    }

    public MessageRvAdapter getRvAdapter() {
        return messagesAdapter;
    }
}
