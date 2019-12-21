package test.push.noti.data.db;

import android.graphics.Bitmap;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

@Entity (tableName = "users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int no;  // local id

    @ColumnInfo
    @NonNull
    public String name;

    @ColumnInfo(name = "profile_img_path")
    @Nullable
    public String profileImgPath;

    @Ignore
    public Bitmap baseProfileImg;

    @Ignore
    public boolean isSelected;

}
