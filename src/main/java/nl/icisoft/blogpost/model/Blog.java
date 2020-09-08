package nl.icisoft.blogpost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "blogs")
@Data
@AllArgsConstructor
@RequiredArgsConstructor // bugje zou niet moeten
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private int id;

    @NonNull
    private String title;

    @NonNull
    private String content;

    public Blog() {
        // Empty
    }

}