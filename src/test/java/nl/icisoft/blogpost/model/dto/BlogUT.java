package nl.icisoft.blogpost.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import nl.icisoft.blogpost.model.Blog;

public class BlogUT {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    void checkBLogMapping() {
        BlogCreateDTO blogCreateDTO = new BlogCreateDTO();
        blogCreateDTO.setTitle("title");
        blogCreateDTO.setContent("content");
        Blog blog = modelMapper.map(blogCreateDTO, Blog.class);
        assertEquals(blogCreateDTO.getTitle(), blog.getTitle());
        assertEquals(blogCreateDTO.getContent(), blog.getContent());
    }
}
