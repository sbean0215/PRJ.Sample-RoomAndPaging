package test.push.noti.ui.msg;

import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import test.push.noti.data.AppRepository;
import test.push.noti.data.db.Message;
import test.push.noti.data.db.User;
import test.push.noti.etc.Constants;

public class MessagesViewModel extends ViewModel {

    private AppRepository repository;

    public MutableLiveData<User> userLiveData;

    static final int PAGING_ITEM = 10;

    public MessagesViewModel(AppRepository repository) {
        this.repository = repository;
        userLiveData = new MutableLiveData<>();
    }

    public void startToShowMessages(User ofUser) {
        userLiveData.setValue(ofUser);
    }

    public LiveData<PagedList<Message>> getMessages(int OfUserId, @NonNull String MessageType) {
        return new LivePagedListBuilder<>(repository.getAdListForPaging(OfUserId, MessageType), PAGING_ITEM).build();
    }


    public void getMessageList() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Log.i("BEAN", repository.getMessageListFromRoom().size() + "/");
                for(Message message : repository.getMessageListFromRoom())
                    Log.i("BEAN", message.userNo + " / " +message.messageType + " / " +message.contents + " / ");
                return  null;
            }
        }.execute();
    }
}
