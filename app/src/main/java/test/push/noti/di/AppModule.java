package test.push.noti.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import test.push.noti.PushNotiTestApp;

import javax.inject.Singleton;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext(PushNotiTestApp application){
        return application;
    }
}
