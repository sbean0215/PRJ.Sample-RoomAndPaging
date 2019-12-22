package test.push.noti.ui;

import dagger.Module;
import dagger.Provides;
import test.push.noti.data.AppRepository;

@Module
public class MessagesActivityModule {

    @Provides
    MessagesViewModel provideMessagesViewModel(AppRepository repository) {
        return new MessagesViewModel(repository);
    }
}
