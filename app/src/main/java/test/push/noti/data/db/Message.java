package test.push.noti.data.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "messages",
        foreignKeys = @ForeignKey(entity = User.class, parentColumns = "no", childColumns = "user_no"))
public class Message {

    @PrimaryKey(autoGenerate = true)
    public int id;      // message id

    @ColumnInfo(name = "user_no")
    public int userNo;

    @ColumnInfo(name = "msg_type")
    public String messageType;

    @ColumnInfo
    public String contents;

}
