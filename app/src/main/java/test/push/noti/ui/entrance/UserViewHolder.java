package test.push.noti.ui.entrance;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import test.push.noti.BR;
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
