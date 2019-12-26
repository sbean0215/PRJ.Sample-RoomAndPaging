package test.push.noti.ui.entrance;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import test.push.noti.data.db.User;
import test.push.noti.databinding.ItemUserBinding;


public class UserAdapter extends PagedListAdapter<User, UserViewHolder> {

    private User selectedUser;
    private Integer positionOfSelectedUser;

    protected UserAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = getItem(position);

        if(user == null) {
            holder.clear();
        } else {
            holder.bindTo(user, position, this);
        }
    }

    public void setSelected(User user, int atPosition) {
        if (selectedUser != null) {
            selectedUser.isSelected = false;
            notifyItemChanged(positionOfSelectedUser);
        }

        user.isSelected = true;
        notifyItemChanged(atPosition);

        selectedUser = user;
        positionOfSelectedUser = atPosition;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void removeSelect() {
        Log.i("BEAN" , "=================removeSelect");
        selectedUser = null;
        positionOfSelectedUser = -1;
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
