package test.push.noti.ui;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import test.push.noti.BR;
import test.push.noti.CustomState;
import test.push.noti.R;
import test.push.noti.base.BaseActivity;

import javax.inject.Inject;

public class AddNewUserActivity extends BaseActivity {

    @Inject AddNewUserViewModel viewModel;

    ViewDataBinding binding;


    @Override
    public int getLayoutId() {
        return R.layout.activity_add_new_user;
    }

    @Override
    public void initView() {

        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setVariable(BR.activity, this);

        viewModel.getmStatusOfInsert().observe(this, new Observer<CustomState>() {
            @Override
            public void onChanged(CustomState customState) {
                switch (customState) {
                    case ING:
                        Toast.makeText(getBaseContext(), "insert ING", Toast.LENGTH_LONG).show();
                        break;
                    case SUCCESS:
                        Toast.makeText(getBaseContext(), "insert SUCCESS", Toast.LENGTH_LONG).show();
                        closeActivity();
                        break;
                    case ERROR:
                        Toast.makeText(getBaseContext(), "insert error", Toast.LENGTH_LONG).show();
                        break;
                    case CANCEL:
                        Toast.makeText(getBaseContext(), "name is empty. input a user name.", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

    }

    public void closeActivity() {
        finish();
    }

    public void startAddingNewUser() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                viewModel.createNewUser(((EditText)findViewById(R.id.et_user_name)).getText().toString());
                return  null;
            }
        }.execute();
    }

}
