package com.ecart.Ecart.service.imageDataService;

import com.ecart.Ecart.model.Image.ImageData;
import com.ecart.Ecart.repository.imageDataRepository.ImageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ImageDataServiceImpl implements ImageDataService{
    private static final String folderPath = "C:/Users/omkar.alase/Pictures/Screenshots";
    @Autowired
    private ImageDataRepository imageDataRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public ImageData getImageData(int id) {
        Optional<ImageData> imageData =  imageDataRepository.findById(id);
        return imageData.get();
    }

    @Override
    public List<ImageData> getAllImageData() {
        List<ImageData> all = imageDataRepository.findAll();
        return all;
    }

    @Override
    public byte[] getImage(String url) throws IOException {
        try {
            ResponseEntity<byte[]> imageMicro = restTemplate.getForEntity(url, byte[].class);
            return imageMicro.getBody();
        }
        catch (Exception e){
            return getOneRandomImage();
        }
    }

    @Override
    public ImageData createImageData(ImageData imageData) {
        return this.imageDataRepository.save(imageData);
    }

    @Override
    public ImageData patchImageData(ImageData imageData) {
        final ImageData[] updatedImageData = new ImageData[1];
        this.imageDataRepository.findById(imageData.getId()).ifPresent(data -> {
            data.setImageUrl(imageData.getImageUrl());
            data.setName(imageData.getName());
            updatedImageData[0] = this.imageDataRepository.save(data);
        });

        return updatedImageData[0];
    }

    private byte[] getOneRandomImage() throws IOException {
        final File folder = new File(folderPath);
        File[] files = folder.listFiles();
        int length = files.length;

        Random random = new Random();
        int index = random.nextInt(length - 1);
        return Files.readAllBytes(files[index].toPath());
    }
}
