package test.push.noti.ui;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.base.BaseActivity;

public class AddNewUserActivity extends BaseActivity {

    ViewDataBinding binding;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_new_user;
    }

    @Override
    public void initView() {

        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(BR.activity, this);

    }

    public void closeActivity() {
        finish();
    }
}
