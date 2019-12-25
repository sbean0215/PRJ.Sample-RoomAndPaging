package test.push.noti.ui.msg;

import android.os.AsyncTask;
import android.util.Log;
import androidx.lifecycle.ViewModel;
import test.push.noti.data.AppRepository;
import test.push.noti.data.db.Message;

import java.util.ArrayList;

public class MessagesViewModel extends ViewModel {

    private AppRepository repository;

    public MessagesViewModel(AppRepository repository) {
        this.repository = repository;
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
