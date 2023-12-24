package com.ecart.Ecart.service.imageDataService;

import com.ecart.Ecart.model.Image.ImageData;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public interface ImageDataService {

    ImageData getImageData(int id);
    List<ImageData> getAllImageData();
    byte[] getImage(String url) throws IOException;
    ImageData createImageData(ImageData imageData);
    ImageData patchImageData(ImageData imageData);
}
