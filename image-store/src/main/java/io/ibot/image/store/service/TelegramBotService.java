package io.ibot.image.store.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;

import io.ibot.image.store.entity.model.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBotService {

    private final RestTemplate restTemplate;
    private Integer chatId;

    public void sendImageToTelegram(byte[] imageInByte, String token, String description) {
        if (chatId == null) {
            getChatId(token);
        }
        TelegramBot bot = new TelegramBot(token);

        bot.setUpdatesListener(updates -> {
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
        log.info("chatId in sendPhoto: {}", chatId);

        SendPhoto request = new SendPhoto(chatId, generateImageFile(imageInByte))
                .parseMode(ParseMode.HTML)
                .disableNotification(false)
                .caption(description);
        
        SendResponse imgResponse = bot.execute(request);
        log.info("Image responce status: {}", imgResponse.isOk());

    }

    public long getChatId(String token) {
        Update update = restTemplate.getForObject(String.format("https://api.telegram.org/bot%s/getUpdates", token),
                Update.class);
        if (chatId == null) {
            chatId = update.getResult()
                .get(0)
                .getMessage()
                .getChat()
                .getId();
        }
        log.info("chat id: {}", chatId);

        return (long) chatId;
    }

    private File generateImageFile(byte[] fileInBytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(fileInBytes);
            BufferedImage image = ImageIO.read(bis);
            File file = File.createTempFile("image", "png");
            ImageIO.write(image, "png", file);
            
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
