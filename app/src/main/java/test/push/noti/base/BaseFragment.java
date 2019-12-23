package test.push.noti.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {

    protected BaseActivity activity;

    public abstract int getFragLayoutId();
    public abstract void initView();
    public abstract String getTitle();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof BaseActivity)
            this.activity = (BaseActivity) context ;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return DataBindingUtil.inflate(inflater, getFragLayoutId(), container, false).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }
}
