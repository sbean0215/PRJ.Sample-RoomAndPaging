package test.push.noti.etc;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import dagger.android.AndroidInjection;
import test.push.noti.data.AppRepository;
import test.push.noti.data.db.Message;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class FcmService extends FirebaseMessagingService {

    @Inject AppRepository repository;

    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d("BEAN", "repository is " + (repository == null ? "null" : "not null"));
        Log.d("BEAN", remoteMessage.getData().toString());

        if(remoteMessage.getData() == null) {
            Log.d("BEAN", "Remote Message's Data is null.");
            return;
        }

        Map data = remoteMessage.getData();
        Message message = new Message(Integer.parseInt((String)data.get("target_user_id")), (String)data.get("msg_type"), (String)data.get("contents"));

        repository.insertMessage(message);
    }

    @Override
    public void onNewToken(String s) {
        Log.d("BEAN", "Refreshed token: " + s);
    }
}
