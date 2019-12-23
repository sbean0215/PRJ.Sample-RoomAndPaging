package test.push.noti.data.db;

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

}
