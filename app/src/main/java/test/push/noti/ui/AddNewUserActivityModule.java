package test.push.noti.ui;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;
import test.push.noti.data.AppRepository;
import test.push.noti.data.db.AppDataBase;

import javax.inject.Singleton;

@Module
public class AddNewUserActivityModule {

    @Provides
    AddNewUserViewModel provideViewModel(/*AddNewUserActivity activity*/ AppRepository repository) {
        // return ViewModelProviders.of(activity).get(AddNewUserViewModel.class);
        /* 임시 */return new AddNewUserViewModel(repository);
    }

}
