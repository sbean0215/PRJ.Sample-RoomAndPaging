package test.push.noti.data;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import test.push.noti.data.db.AppDataBase;
import test.push.noti.data.db.Message;
import test.push.noti.data.db.User;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class AppRepository {

    private AppDataBase dataBase;

    @Inject
    public AppRepository(AppDataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Completable insertNewUserToRoom(String userName) {

        User user = new User();
        user.name = userName;

        return dataBase.getUserDao().insertUser(user);
    }

    public Completable deleteUserAtRoom(User user) {
        return dataBase.getUserDao().deleteUser(user);
    }

    public List<User> getUserListFromRoom () {
        return dataBase.getUserDao().loadAllUsers();
    }

    public DataSource.Factory<Integer, User> getUserListForPaging() {
        return dataBase.getUserDao().loadAllUsersWithPL();
    }

    public void insertMessage(Message message) {
        dataBase.getMessageDao().insertMessage(message);
    }

    public List<Message> getMessageListFromRoom () {
        return dataBase.getMessageDao().loadAllMessage();
    }

    public DataSource.Factory<Integer, Message> getAdListForPaging(int ofUserId, String messageType) {
        return dataBase.getMessageDao().loadMessageOf(ofUserId, messageType);
    }

    public LiveData<Integer> getCountOfNew(String MessageType, int userId) {
        return dataBase.getMessageDao().countOfNew(MessageType, userId);
    }

    public void delete(Message message) {
        dataBase.getMessageDao().deleteMessage(message);
    }

    public void setRead(Message message) {
        message.readable = false;
        dataBase.getMessageDao().update(message);
    }

}
