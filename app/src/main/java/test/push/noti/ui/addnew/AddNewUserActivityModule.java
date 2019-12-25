package test.push.noti.ui.addnew;

import dagger.Module;
import dagger.Provides;
import test.push.noti.data.AppRepository;

@Module
public class AddNewUserActivityModule {

    @Provides
    AddNewUserViewModel provideViewModel(/*AddNewUserActivity activity*/ AppRepository repository) {
        // return ViewModelProviders.of(activity).get(AddNewUserViewModel.class);
        /* 임시 */return new AddNewUserViewModel(repository);
    }

}
