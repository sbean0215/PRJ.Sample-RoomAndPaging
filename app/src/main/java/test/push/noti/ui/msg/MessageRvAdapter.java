package test.push.noti.ui.msg;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import test.push.noti.data.db.Message;
import test.push.noti.databinding.ItemMessageBinding;

import javax.inject.Inject;

public class MessageRvAdapter extends PagedListAdapter<Message, MessageRvViewHolder> {

    private Activity activity;

    @Inject
    protected MessageRvAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public MessageRvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = ItemMessageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MessageRvViewHolder(binding, this, activity);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageRvViewHolder holder, int position) {
        Message message = getItem(position);

        if(message == null) holder.clear();
        else holder.bindTo(message, position);
    }


    private static DiffUtil.ItemCallback<Message> DIFF_CALLBACK = new DiffUtil.ItemCallback<Message>() {
        @Override
        public boolean areItemsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
            // 이전 아이템과 새로운 아이템이 같은 것 인지 확인.
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
            // 같은 객체 인지
            return oldItem.equals(newItem);
        }
    };
}
