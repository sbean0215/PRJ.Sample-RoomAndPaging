package test.push.noti.ui.entrance;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import test.push.noti.BR;
import test.push.noti.etc.Constants;
import test.push.noti.etc.CustomState;
import test.push.noti.R;
import test.push.noti.etc.RvItemDecoration;
import test.push.noti.base.BaseActivity;
import test.push.noti.data.db.User;
import test.push.noti.databinding.ActivityEntranceBinding;
import test.push.noti.ui.msg.MessagesActivity;
import test.push.noti.ui.addnew.AddNewUserActivity;

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

        binding.rvUserList.addItemDecoration(new RvItemDecoration(10, this));

        viewModel.userList.observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(PagedList<User> users) {
                userAdapter.submitList(users);
            }
        });

        viewModel.getmStatusOfDelete().observe(this, new Observer<CustomState>() {
            @Override
            public void onChanged(CustomState customState) {
                switch (customState) {
                    case ING: Toast.makeText(getBaseContext(), "delete ING", Toast.LENGTH_LONG).show(); break;
                    case SUCCESS: Toast.makeText(getBaseContext(), "delete SUCCESS", Toast.LENGTH_LONG).show(); break;
                    case ERROR: Toast.makeText(getBaseContext(), "delete error", Toast.LENGTH_LONG).show(); break;
                    case CANCEL: Toast.makeText(getBaseContext(), "select user to deleting", Toast.LENGTH_LONG).show(); break;
                }
                userAdapter.removeSelect();
            }
        });
    }

    public void openAddNewUserActivity() {
        startActivity(new Intent(this, AddNewUserActivity.class));
    }

    public void openMessagesActivity() {
        //TODO function :: 1. selecting user / 2. pass Intent data
        if (userAdapter.getSelectedUser() == null) {
            Toast.makeText(this, "select user", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, MessagesActivity.class);
        intent.putExtra(Constants.INTENT_EXTRAS.USER_ID, userAdapter.getSelectedUser().no);
        intent.putExtra(Constants.INTENT_EXTRAS.USER, userAdapter.getSelectedUser());

        startActivity(intent);
    }

    public UserAdapter getRvAdapter() {
        return userAdapter;
    }

    public void startToDeleteUser(){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                viewModel.deleteUser(userAdapter.getSelectedUser());
                return null;
            }
        }.execute();
    }
}
