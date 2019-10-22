package test.push.noti.di;

import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import test.push.noti.PushNotiTestApp;
import test.push.noti.data.db.AppDataBase;

import javax.inject.Singleton;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(PushNotiTestApp application){
        return application;
    }

    @Singleton
    @Provides
    AppDataBase provideDataBase(Context app) {
        return Room.databaseBuilder(app, AppDataBase.class, "noti-test-db")
                .build();
    }
}
