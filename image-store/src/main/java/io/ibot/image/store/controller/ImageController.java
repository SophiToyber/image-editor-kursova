package io.ibot.image.store.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ibot.image.store.entity.YEditorBody;
import io.ibot.image.store.service.TelegramImageSenderService;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {

    private final TelegramImageSenderService telegramImageService;

    @PostMapping("/receive")
    public void receiveImage(@RequestBody YEditorBody body) {
        telegramImageService.getImageAndSendToTelegram(
                    body.getImageBase64(),
                    body.getToken(),
                    body.getDescription()
                );
    }
}
