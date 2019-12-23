package test.push.noti.data.db;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class, Message.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract UserDao getUserDao();
    public abstract MessageDao getMessageDao();



    private static final String DATABASE_NAME = "noti-test-db";
    private static AppDataBase databaseInstance;

    public static AppDataBase getInstance(Context context) {

        if(databaseInstance == null)
            databaseInstance = Room.databaseBuilder(context, AppDataBase.class, DATABASE_NAME)
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            Log.i("BEAN", "create DB");
                            super.onCreate(db);
                        }

                        @Override
                        public void onOpen(@NonNull SupportSQLiteDatabase db) {
                            Log.i("BEAN", "open DB");
                            super.onOpen(db);
                        }
                    }).build();

        return databaseInstance;
    }
}
