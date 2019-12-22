package test.push.noti.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import io.reactivex.observers.DisposableCompletableObserver;
import test.push.noti.etc.CustomState;
import test.push.noti.data.AppRepository;
import test.push.noti.data.db.User;

import javax.inject.Inject;

public class EntranceActivityViewModel extends ViewModel {

    AppRepository appRepository;

//    public final Observable<PagedList<User>> userList;
    public LiveData<PagedList<User>> userList;
    static final int PAGING_ITEM = 10;

    private MutableLiveData<CustomState> mStatusOfDelete = new MutableLiveData<>();



    @Inject
    public EntranceActivityViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
        getUserList();
    }

    private void getUserList() {
//        userList = new RxPagedListBuilder<>(appRepository.getUserListForPagingRx(), PAGING_ITEM)
//                .buildObservable();
        userList = new LivePagedListBuilder<>(appRepository.getUserListForPaging(), PAGING_ITEM)
                .build();
    }

    public void deleteUser(User user) {
        if(user == null) {
            mStatusOfDelete.postValue(CustomState.CANCEL);
            return;
        }

        mStatusOfDelete.postValue(CustomState.ING);

        appRepository.deleteUserAtRoom(user).subscribe(new DisposableCompletableObserver() {
            @Override
            public void onComplete() {
                mStatusOfDelete.postValue(CustomState.SUCCESS);
            }

            @Override
            public void onError(Throwable e) {
                mStatusOfDelete.postValue(CustomState.ERROR);
            }
        });
    }

    public MutableLiveData<CustomState> getmStatusOfDelete() {
        return mStatusOfDelete;
    }
}
