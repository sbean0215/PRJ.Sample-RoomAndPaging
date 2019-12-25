package test.push.noti.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import test.push.noti.di.scope.PerActivity;
import test.push.noti.ui.addnew.AddNewUserActivity;
import test.push.noti.ui.addnew.AddNewUserActivityModule;
import test.push.noti.ui.entrance.EntranceActivity;
import test.push.noti.ui.entrance.EntranceActivityModule;
import test.push.noti.ui.msg.*;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector (modules = EntranceActivityModule.class)
    abstract EntranceActivity bindEntranceActivity();

    @ContributesAndroidInjector (modules = AddNewUserActivityModule.class)
    abstract AddNewUserActivity bindAddNewUserActivity();

    @PerActivity
    @ContributesAndroidInjector (modules = {
            MessagesActivityModule.class
            , MsgFragBuilder.class
    })
    abstract MessagesActivity bindMessagesActivity();

}
