package test.push.noti.ui;

import dagger.Module;
import dagger.Provides;
import test.push.noti.data.AppRepository;

@Module
public class EntranceActivityModule {

    @Provides
    EntranceActivityViewModel provideEntranceActivityViewModel(AppRepository repository) {
        /* 임시 */ return new EntranceActivityViewModel(repository);
    }

    @Provides
    UserAdapter provideUserAdapter() {
        return new UserAdapter();
    }
}
