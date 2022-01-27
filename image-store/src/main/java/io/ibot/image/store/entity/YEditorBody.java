package io.ibot.image.store.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YEditorBody {
    private String imageBase64;
    private String token;
    private String description;
}
