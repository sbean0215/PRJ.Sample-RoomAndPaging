package test.push.noti.ui.msg;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;

@Module
public class MessagesFragmentsModule {

    @Provides
    MessageRvAdapter provideMessageRvAdapter(MessagesActivity activity){
        return new MessageRvAdapter(activity);
    }
}
