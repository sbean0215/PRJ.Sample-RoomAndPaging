package test.push.noti.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import test.push.noti.R;
import test.push.noti.data.db.User;

public class UserViewHolder extends RecyclerView.ViewHolder {
    User user;
    TextView tvUserName;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        tvUserName = itemView.findViewById(R.id.tv_user_name);
    }


    public void bindTo(User user) {
        this.user = user;
        tvUserName.setText(user.name);
    }

    public void clear() {
        user = null;
        tvUserName.setText("");
    }

}
