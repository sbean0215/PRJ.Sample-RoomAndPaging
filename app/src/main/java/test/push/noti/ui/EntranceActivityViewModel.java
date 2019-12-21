package test.push.noti.ui;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;
import io.reactivex.Observable;
import test.push.noti.data.AppRepository;
import test.push.noti.data.db.User;

import javax.inject.Inject;

public class EntranceActivityViewModel extends ViewModel {

    AppRepository appRepository;

//    public final Observable<PagedList<User>> userList;
    public LiveData<PagedList<User>> userList;
    static final int PAGING_ITEM = 10;

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
        appRepository.deleteUserAtRoom(user);
    }


}
