package test.push.noti.ui;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.base.BaseActivity;
import test.push.noti.data.db.User;
import test.push.noti.databinding.ActivityEntranceBinding;

import javax.inject.Inject;

public class EntranceActivity extends BaseActivity {

    @Inject EntranceActivityViewModel viewModel;
    ActivityEntranceBinding binding;

    @Inject public UserAdapter userAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_entrance;
    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(BR.activity, this);

        viewModel.userList.observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(PagedList<User> users) {
                userAdapter.submitList(users);
            }
        });
    }

    public void openAddNewUserActivity() {
        startActivity(new Intent(this, AddNewUserActivity.class));
    }

    public UserAdapter getRvAdapter() {
        return userAdapter;
    }
}
