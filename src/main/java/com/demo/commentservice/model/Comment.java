package com.demo.commentservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@Table(name = "comments")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String commentId;
    private String comment;
    private String userId;
    @ElementCollection
    @CollectionTable(name = "comment_medialinks")
    private List<String> mediaLinks;
    private Float rating;
    private Status status;
    private String createdBy;
    private String updateBy;
    private Date creationTime;
    private Date updationTime = Calendar.getInstance().getTime();
}
