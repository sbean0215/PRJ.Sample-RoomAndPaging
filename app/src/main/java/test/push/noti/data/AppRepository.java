package test.push.noti.data;

import android.util.Log;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import test.push.noti.data.db.AppDataBase;
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

    public List<User> getUserListFromRoom () {
        return dataBase.getUserDao().loadAllUsers();
    }


}
