package test.push.noti;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import test.push.noti.di.DaggerAppComponent;

public class PushNotiTestApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
