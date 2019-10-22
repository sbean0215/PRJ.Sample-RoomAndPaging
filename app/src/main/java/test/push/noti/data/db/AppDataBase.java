package test.push.noti.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Message.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
