package test.push.noti;

import android.app.Service;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import test.push.noti.di.DaggerAppComponent;

import javax.inject.Inject;

public class PushNotiTestApp extends DaggerApplication {

    @Inject
    DispatchingAndroidInjector<Service> dispatchingServiceInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("BEAN", "getInstanceId failed", task.getException());
                            return;
                        }

                        String token = task.getResult().getToken(); // Get new Instance ID token
                        Log.d("BEAN", "token ==>  "+ token);
                    }
                });
    }

    @Override
    public DispatchingAndroidInjector<Service> serviceInjector() {
        return dispatchingServiceInjector;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
