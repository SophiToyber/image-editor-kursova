
package io.ibot.image.store.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramImageSenderService {
    
    private final ImageService imageService;
    private final TelegramBotService telegramBotService;
    
    public void getImageAndSendToTelegram(String imageInBase64, String token, String description) {
        try {
            byte[] image = imageService.convertBase64StringToByte(imageInBase64);
            telegramBotService.sendImageToTelegram(image, token, description);
            log.info("Image size: {}", image.length);
            
        } catch (IOException e) {
            log.info("Error while trying to send bot message: {}", e.getMessage());
        }
    }
}
