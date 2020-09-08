package nl.icisoft.blogpost.model.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogUpdateDTO {

    @Id
    @NotNull
    private int id;

    @NotNull
    private String title;

    @NotNull
    private String content;

}
