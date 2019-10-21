package test.push.noti.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        initView();
    }

    public abstract int getLayoutId();
    public abstract void initView();
}
