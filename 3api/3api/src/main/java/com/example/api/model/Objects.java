package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Objects")
public class Objects {


//    private int userId;
//    private int id;
//    private String name;
//    @JsonProperty("completed")
//   private Boolean status;
    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    @Id

    private int id;

    private String status;

    private List<Datas> data;

    private String message;
}
