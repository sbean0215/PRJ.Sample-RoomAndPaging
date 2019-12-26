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

import java.util.HashMap;

public class MessagesViewModel extends ViewModel {

    private AppRepository repository;

    public MutableLiveData<User> userLiveData;
    public MutableLiveData<HashMap<String, Integer>> tabCountLiveData;

    static final int PAGING_ITEM = 10;

    public MessagesViewModel(AppRepository repository) {
        this.repository = repository;
        userLiveData = new MutableLiveData<>();
        tabCountLiveData = new MutableLiveData<>();
    }

    public void startToShowMessages(User ofUser) {
        userLiveData.setValue(ofUser);
    }

    public LiveData<PagedList<Message>> getMessages(int ofUserId, @NonNull String messageType) {
        return new LivePagedListBuilder<>(repository.getAdListForPaging(ofUserId, messageType), PAGING_ITEM).build();
    }

    public LiveData<Integer> getCountOf(String messageType, int userId){
        return repository.getCountOf(messageType, userId);
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

    public void deleteMessage(Message message) {
        repository.delete(message);
    }
}
