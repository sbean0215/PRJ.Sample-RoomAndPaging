package test.push.noti.ui.msg;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import test.push.noti.BR;
import test.push.noti.data.db.Message;

public class MessageRvViewHolder extends RecyclerView.ViewHolder {

    protected ViewDataBinding binding;
    protected MessageRvAdapter adapter;
    protected Activity activity;

    public MessageRvViewHolder(@NonNull ViewDataBinding binding, MessageRvAdapter adapter, Activity activity) {
        super(binding.getRoot());
        this.binding = binding;
        this.adapter = adapter;
        this.activity = activity;
    }


    public void bindTo(Message message, int atPosition) {
        binding.setVariable(BR.message, message);
        binding.setVariable(BR.position, atPosition);
        binding.setVariable(BR.adapter, adapter);
        binding.setVariable(BR.activity, activity);
        binding.executePendingBindings();
    }

    public void clear() {
        binding.setVariable(BR.message, null);
        binding.executePendingBindings();
    }

}
