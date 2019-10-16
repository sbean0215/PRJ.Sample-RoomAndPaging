package test.push.noti.ui;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.base.BaseActivity;

public class EntranceActivity extends BaseActivity {

    ViewDataBinding binding;


    @Override
    public int getLayoutId() {
        return R.layout.activity_entrance;
    }

    @Override
    public void initView() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(BR.activity, this);

    }

    public void openAddNewUserActivity() {
        startActivity(new Intent(this, AddNewUserActivity.class));
    }
}
