package unsa.edu.ges.model;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Dish extends DocumentDatabase {
    private String name;
    private String description;
    //This path is linked with google firebase storage
    private String pathPhoto;
    private Double cost;
    private Double discount;
}
