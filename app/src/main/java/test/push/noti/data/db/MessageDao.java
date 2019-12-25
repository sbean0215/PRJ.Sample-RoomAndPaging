package test.push.noti.data.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;

import java.util.List;

@Dao
public interface MessageDao {

    @Insert
    public void insertMessage(Message message);

    @Query("SELECT * FROM messages")
    public List<Message> loadAllMessage();

    @Query("SELECT * FROM messages WHERE user_no = :userId AND msg_type = :messageType")
    public DataSource.Factory<Integer, Message> loadMessageOf(int userId, String messageType);

}
