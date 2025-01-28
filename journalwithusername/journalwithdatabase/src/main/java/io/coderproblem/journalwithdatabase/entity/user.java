package io.coderproblem.journalwithdatabase.entity;


import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@Data

public class user {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private  String username;
    @NonNull
    private  String password;
    @DBRef
    private List<journalentry> journalentries=new ArrayList<>();



}
