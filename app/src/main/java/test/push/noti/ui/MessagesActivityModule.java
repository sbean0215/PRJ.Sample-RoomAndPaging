package test.push.noti.ui;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import test.push.noti.data.AppRepository;

@Module
public class MessagesActivityModule {

    @Provides
    MessagesViewModel provideMessagesViewModel(AppRepository repository) {
        return new MessagesViewModel(repository);
    }

    @Provides
    MessagesVpAdapter provideMessagesVpAdapter(MessagesActivity activity) {
        return new MessagesVpAdapter(activity.getSupportFragmentManager());
    }
}
