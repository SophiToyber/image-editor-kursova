package io.ibot.image.store.entity.model;

import io.ibot.image.store.entity.model.message.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer update_id;
    private Message message;
}
