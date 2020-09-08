package nl.icisoft.blogpost.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.icisoft.blogpost.exception.ResourceNotFoundException;
import nl.icisoft.blogpost.model.Comment;
import nl.icisoft.blogpost.model.dto.CommentDTO;
import nl.icisoft.blogpost.repository.BlogRepository;
import nl.icisoft.blogpost.repository.CommentRepository;

@RestController
public class CommentController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping(path = "/blog/{blogid}/comment")
    public Comment createComment(@PathVariable(value = "blogid") Integer blogid,
            @Valid @RequestBody CommentDTO commentDTO) {

        return blogRepository.findById(blogid).map(blg -> {
            Comment comment = new Comment(commentDTO);
            comment.setBlog(blg);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException(""));

    }

}