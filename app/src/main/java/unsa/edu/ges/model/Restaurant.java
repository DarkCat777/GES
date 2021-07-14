package unsa.edu.ges.model;

import java.time.LocalTime;
import java.util.List;

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
public class Restaurant extends DocumentDatabase {
    private String name;
    private String email;
    private Integer contactNumber;
    private String description;
    private LocalTime businessOpening;
    private LocalTime businessClosing;
    private String address;
    private Double locationLatitude;
    private Double LocationLongitude;
    private List<String> dishesIds;
}

