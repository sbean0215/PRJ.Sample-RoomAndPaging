package test.push.noti.data.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "messages",
        foreignKeys = @ForeignKey(entity = User.class, parentColumns = "no", childColumns = "user_no"))
public class Message {

    public Message(int userNo, String messageType, String contents) {
        this.userNo = userNo;
        this.messageType = messageType;
        this.contents = contents;
        this.readable = true;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;      // message id

    @ColumnInfo(name = "user_no")
    public int userNo;

    @ColumnInfo(name = "msg_type")
    public String messageType;

    @ColumnInfo
    public String contents;

    @ColumnInfo( defaultValue = "1" )   // 0 is false, 1 is true
    public boolean readable;

}
