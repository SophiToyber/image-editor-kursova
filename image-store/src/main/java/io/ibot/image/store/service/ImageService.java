package io.ibot.image.store.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

@Service
public class ImageService {
    
    public byte[] convertBase64StringToByte(String base64Image) throws IOException {
        String split = base64Image.split(",")[1];
        String imageDataString = split.substring(0, split.length()-2);
        byte[] decodedBytes = Base64.getDecoder().decode(imageDataString);
        return decodedBytes;
    }

}
