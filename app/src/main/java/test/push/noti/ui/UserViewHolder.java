package test.push.noti.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import test.push.noti.BR;
import test.push.noti.R;
import test.push.noti.data.db.User;

public class UserViewHolder extends RecyclerView.ViewHolder {


    protected ViewDataBinding binding;


    public UserViewHolder(@NonNull ViewDataBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bindTo(User user, int atPosition, UserAdapter adapter) {
        binding.setVariable(BR.user, user);
        binding.setVariable(BR.adapter, adapter);
        binding.setVariable(BR.position, atPosition);
        binding.executePendingBindings();
    }

    public void clear() {
        binding.setVariable(BR.user, null);
        binding.executePendingBindings();
    }

}
