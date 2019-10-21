package test.push.noti.di;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import test.push.noti.PushNotiTestApp;

import javax.inject.Singleton;

@Singleton
@Component (modules = {AndroidSupportInjectionModule.class
        , AppModule.class
        , ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<PushNotiTestApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<PushNotiTestApp> {}
}
