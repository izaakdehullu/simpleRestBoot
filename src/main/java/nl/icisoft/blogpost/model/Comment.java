package nl.icisoft.blogpost.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import nl.icisoft.blogpost.model.dto.CommentDTO;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@RequiredArgsConstructor // bugje zou niet moeten
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @NonNull
    @Column(name = "userid")
    private String user;

    @NonNull
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    private Blog blog;

    public Comment() {
        // Empty
    }

    public Comment(CommentDTO commentDTO) {
        this.user = commentDTO.getUser();
        this.content = commentDTO.getContent();
    }
}