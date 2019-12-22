package test.push.noti.ui;

import androidx.lifecycle.ViewModel;
import test.push.noti.data.AppRepository;

public class MessagesViewModel extends ViewModel {

    private AppRepository repository;

    public MessagesViewModel(AppRepository repository) {
        this.repository = repository;
    }
}
