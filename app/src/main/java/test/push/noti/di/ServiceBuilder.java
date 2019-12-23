package test.push.noti.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import test.push.noti.etc.FcmService;

@Module
public abstract class ServiceBuilder {

    @ContributesAndroidInjector
    abstract FcmService provideFcmService();
}
