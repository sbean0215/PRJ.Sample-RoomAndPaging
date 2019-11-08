package test.push.noti.ui;

import dagger.Module;
import test.push.noti.data.AppRepository;

@Module
public class EntranceActivityModule {
    EntranceActivityViewModel provideEntranceActivityViewModel(AppRepository repository) {
        /* 임시 */ return new EntranceActivityViewModel(repository);
    }
}
