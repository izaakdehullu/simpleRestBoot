package nl.icisoft.blogpost.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.icisoft.blogpost.exception.ResourceNotFoundException;
import nl.icisoft.blogpost.model.Blog;
import nl.icisoft.blogpost.model.dto.BlogCreateDTO;
import nl.icisoft.blogpost.repository.BlogRepository;

@RestController
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(path = "/blog")
    public List<Blog> index() {
        return blogRepository.findAll();
    }

    @GetMapping(path = "/blog/{id}")
    public Blog get(@PathVariable String id) {
        int intId = Integer.parseInt(id);
        Optional<Blog> value = blogRepository.findById(intId);
        return value.orElseThrow(() -> new ResourceNotFoundException("id bestaat niet"));
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        String content = body.get("content");
        Blog blog = new Blog(title, content);
        return blogRepository.save(blog);
    }

    @PostMapping("/blogs")
    public Blog create(@RequestBody BlogCreateDTO body) {
        Blog blog = modelMapper.map(body, Blog.class);
        return blogRepository.save(blog);
    }

    @PutMapping("/blog/{id}")
    public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        return blogRepository.findById(blogId).map(blog -> {
            blog.setTitle(body.get("title"));
            blog.setContent(body.get("content"));
            return blogRepository.save(blog);
        }).orElseThrow(() -> new ResourceNotFoundException("id bestaat niet"));
    }

    @DeleteMapping("blog/{id}")
    public boolean delete(@PathVariable String id) {
        Integer blogId = Integer.parseInt(id);
        blogRepository.deleteById(blogId);
        return true;
    }
}