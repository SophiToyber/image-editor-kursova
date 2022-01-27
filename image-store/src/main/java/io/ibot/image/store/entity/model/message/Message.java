package io.ibot.image.store.entity.model.message;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer message_id;
    private From from;
    private Chat chat;
    private Integer date;
    private String text;
    private List<Object> entities;
}
