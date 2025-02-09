package io.coderproblem.journalwithdatabase.entity;


import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journal_entries")

public class journalentry {


    @Id
    ObjectId id;
    @NonNull
    String title;
    String content;
    LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}



