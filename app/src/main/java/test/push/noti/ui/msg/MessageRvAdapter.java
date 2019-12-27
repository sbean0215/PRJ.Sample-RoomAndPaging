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
            // 이전 아이템과 새로운 아이템이 같은 항목을 나타내는 것인지 확인.
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
            // 항목의 내용이 변경되었는지 감지하는데 사용됨
            // areItemsTheSame == true 일 경우, 내용이 같은지 확인할때 호출됨
            // UI 상 표현되는 데이터가 같은지 여부를 반환해야 한다.

            if(oldItem.readable == newItem.readable && oldItem.contents.equals(newItem.contents))
                return oldItem.equals(newItem);

            return false;
        }
    };
}
