package test.push.noti.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.observers.DisposableCompletableObserver;
import test.push.noti.etc.CustomState;
import test.push.noti.data.AppRepository;
import test.push.noti.data.db.User;

import javax.inject.Inject;
import java.util.ArrayList;

public class AddNewUserViewModel extends ViewModel {

//    @Inject
    private AppRepository repository;

    private MutableLiveData<CustomState> mStatusOfInsert = new MutableLiveData<>();

    @Inject
    public AddNewUserViewModel(AppRepository repository) {
        this.repository = repository;
    }

    public void createNewUser(String userName) {

        mStatusOfInsert.postValue((userName == null || userName.equals(""))
                        ? CustomState.CANCEL : CustomState.ING);

        repository.insertNewUserToRoom(userName).subscribe(new DisposableCompletableObserver() {
            @Override
            public void onComplete() {
                mStatusOfInsert.postValue(CustomState.SUCCESS);
            }

            @Override
            public void onError(Throwable e) {
                mStatusOfInsert.postValue(CustomState.ERROR);
            }
        });

    }

    public ArrayList<User> getUserList() {
        return (ArrayList<User>)repository.getUserListFromRoom();
    }

    public MutableLiveData<CustomState> getmStatusOfInsert() {
        return mStatusOfInsert;
    }
}
