package test.push.noti.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import test.push.noti.ui.msg.MessagesFragmentsModule;
import test.push.noti.ui.msg.MsgAdFragment;
import test.push.noti.ui.msg.MsgMessagesFragment;
import test.push.noti.ui.msg.MsgNoticeFragment;

@Module
public abstract class MsgFragBuilder {

    @ContributesAndroidInjector(modules = MessagesFragmentsModule.class)
    abstract MsgAdFragment provideMsgAdFragment();

    @ContributesAndroidInjector(modules = MessagesFragmentsModule.class)
    abstract MsgNoticeFragment provideMsgNoticeFragment();

    @ContributesAndroidInjector(modules = MessagesFragmentsModule.class)
    abstract MsgMessagesFragment provideMsgMessagesFragment();
}
