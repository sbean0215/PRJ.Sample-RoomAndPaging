package test.push.noti;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import io.reactivex.Completable;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import test.push.noti.data.db.AppDataBase;
import test.push.noti.data.db.User;
import test.push.noti.data.db.UserDao;

import java.io.IOException;
import java.util.ArrayList;

public class RoomTest {

    private UserDao userDao;
    private AppDataBase db;

//    @Mock
//    Context context;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void createDb() {

        Context context = Mockito.mock(PushNotiTestApp.class);

        db = Room.inMemoryDatabaseBuilder(context, AppDataBase.class).build();
        userDao = db.getUserDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void test() {

        User user = new User();
        user.no = 0;
        user.name = "Sung Bean";

        userDao.insertUser(user);

        ArrayList<User> allUsers = (ArrayList) userDao.loadAllUsers();

        MatcherAssert.assertThat(allUsers.size(), Matchers.is(1));
        MatcherAssert.assertThat(allUsers.get(0).name, Matchers.equalTo(user.name));

    }
}
