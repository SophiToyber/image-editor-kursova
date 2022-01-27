package io.ibot.image.store.entity.model.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class From {
    private Integer id;
    private Boolean is_bot;
    private String first_name;
    private String last_name; 
    private String username; 
    private String language_code;
}
