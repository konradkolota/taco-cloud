package pl.kk.tacocloud.models;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Data
public class Taco {


    private Long id;
    private Date createdAt;
    @NotNull
    @Size(min = 5, message = "Name should contains at least five characters!")
    private String name;
    @Size(min = 1, message = "You have to choose at leas one ingredient!")
    private List<Ingredient> ingredients;

}
