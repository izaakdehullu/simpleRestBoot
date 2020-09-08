package nl.icisoft.blogpost.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogCreateDTO {

    @NotNull
    private String title;

    @NotNull
    private String content;

}
