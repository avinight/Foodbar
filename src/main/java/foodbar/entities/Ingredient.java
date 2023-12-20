package foodbar.entities;
import lombok.*;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@ToString
public class Ingredient {
    private String name;
    private float size;
}