package com.woact.dolplads.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dolplads on 15/10/2016.
 */
@NamedQueries({
        @NamedQuery(name = Post.NUMBER_OF_POSTS, query = "select count(post) from Post post")
})
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post extends Contribution {
    public static final String NUMBER_OF_POSTS = "post_total";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Post(User user, String text, Date creationDate) {
        super(user, text, creationDate);
    }

    @PostConstruct
    public void init() {
        this.comments = new ArrayList<>();
    }
}
