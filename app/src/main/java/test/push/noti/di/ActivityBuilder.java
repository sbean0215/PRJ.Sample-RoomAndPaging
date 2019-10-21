package test.push.noti.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import test.push.noti.ui.AddNewUserActivity;
import test.push.noti.ui.AddNewUserActivityModule;
import test.push.noti.ui.EntranceActivity;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract EntranceActivity bindEntranceActivity();

    @ContributesAndroidInjector (modules = AddNewUserActivityModule.class)
    abstract AddNewUserActivity bindAddNewUserActivity();
}
