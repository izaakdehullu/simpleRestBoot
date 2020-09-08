package nl.icisoft.blogpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.icisoft.blogpost.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}