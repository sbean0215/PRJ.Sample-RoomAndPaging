package test.push.noti.ui.msg;

import dagger.Module;
import dagger.Provides;

@Module
public class MessagesFragmentsModule {

    @Provides
    MessageRvAdapter provideMessageRvAdapter(){
        return new MessageRvAdapter();
    }
}
