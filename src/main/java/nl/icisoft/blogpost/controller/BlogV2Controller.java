package nl.icisoft.blogpost.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nl.icisoft.blogpost.model.Blog;
import nl.icisoft.blogpost.model.dto.BlogCreateDTO;
import nl.icisoft.blogpost.model.dto.BlogUpdateDTO;
import nl.icisoft.blogpost.repository.BlogRepository;

@RestController
@RequestMapping("/v2/blog")
public class BlogV2Controller {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<Blog> index() {
        return blogRepository.findAll();
    }

    // @GetMapping(path = "/{id}")
    // public Blog get(@PathVariable String id) {
    //     int intId = Integer.parseInt(id);
    //     Optional<Blog> value = blogRepository.findById(intId);
    //     return value.orElseThrow(() -> new ResourceNotFoundException("id bestaat niet"));
    // }

    // @PostMapping("/blog/search")
    // public List<Blog> search(@RequestBody Map<String, String> body) {
    //     String searchTerm = body.get("text");
    //     return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    // }

    @PostMapping
    public Blog create(@RequestBody BlogCreateDTO body) {
        Blog blog = modelMapper.map(body, Blog.class);
        return blogRepository.save(blog);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Blog update2(@RequestBody BlogUpdateDTO body) {
        // int blogId = body.getId();
        // return blogRepository.findById(blogId).map(blog -> {
        //     blog.setTitle(body.get("title"));
        //     blog.setContent(body.get("content"));
        //     return blogRepository.save(blog);
        // }).orElseThrow(() -> new ResourceNotFoundException("id bestaat niet"));
        Blog blog = modelMapper.map(body, Blog.class);
        return blogRepository.save(blog);
    }
    

//     @DeleteMapping("blog/{id}")
//     public boolean delete(@PathVariable String id) {
//         Integer blogId = Integer.parseInt(id);
//         blogRepository.deleteById(blogId);
//         return true;
//     }
}