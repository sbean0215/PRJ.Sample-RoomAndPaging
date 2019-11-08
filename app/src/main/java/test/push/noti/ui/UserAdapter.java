package test.push.noti.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import test.push.noti.R;
import test.push.noti.data.db.User;

public class UserAdapter extends PagedListAdapter<User, UserViewHolder> {


    protected UserAdapter() {
        super(DIFF_CALLBACK);
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = getItem(position);

        if(user == null) {
            holder.clear();
        } else {
            holder.bindTo(user);
        }
    }

    private static DiffUtil.ItemCallback<User> DIFF_CALLBACK = new DiffUtil.ItemCallback<User>() {
        @Override
        public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            // 이전 아이템과 새로운 아이템이 같은 것 인지 확인.
            return oldItem.no == newItem.no;
        }

        @Override
        public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
            // 같은 객체 인지
            return oldItem.equals(newItem);
        }


    };
}
