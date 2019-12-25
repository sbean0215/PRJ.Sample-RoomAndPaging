package test.push.noti.ui.msg;

import dagger.Module;
import dagger.Provides;
import test.push.noti.data.AppRepository;
import test.push.noti.di.scope.PerActivity;

@Module
public class MessagesActivityModule {

    @PerActivity
    @Provides
    MessagesViewModel provideMessagesViewModel(AppRepository repository) {
        return new MessagesViewModel(repository);
    }

    @Provides
    MessagesVpAdapter provideMessagesVpAdapter(MessagesActivity activity) {
        return new MessagesVpAdapter(activity.getSupportFragmentManager());
    }
}
