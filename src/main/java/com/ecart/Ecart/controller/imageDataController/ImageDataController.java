package com.ecart.Ecart.controller.imageDataController;

import com.ecart.Ecart.dto.imageDataDto.ImageDataRequestDto;
import com.ecart.Ecart.dto.imageDataDto.ImageDataResponseDto;
import com.ecart.Ecart.model.Image.ImageData;
import com.ecart.Ecart.service.imageDataService.ImageDataService;
import com.ecart.Ecart.utils.imageDataMapping.ImageDataMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageDataController {
    @Autowired
    private ImageDataService imageDataService;

    @GetMapping("/")
    public ResponseEntity<List<ImageDataResponseDto>> getAllImageData(){
        System.out.println("******** Get Image Data All *********");
        List<ImageData> allImageData = this.imageDataService.getAllImageData();
        List<ImageDataResponseDto> allImage = ImageDataMapping.convertAllToImageDataResponseDto(allImageData);
        return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.APPLICATION_JSON).body(allImage);
    }
    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage(@RequestParam String url) throws IOException {
        System.out.println("******** Get Image By url " + url + " *********");
        byte[] image = this.imageDataService.getImage(url);

        return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body(image);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ImageDataResponseDto> getImageData(@PathVariable int id){
        System.out.println("******** Get Image Data By Id " + id + " *********");
        ImageData imageData = this.imageDataService.getImageData(id);
        ImageDataResponseDto responseDto = ImageDataMapping.convertToImageDataDto(imageData);
        return ResponseEntity.status(HttpStatus.FOUND).contentType(MediaType.APPLICATION_JSON).body(responseDto);
    }


    @PostMapping("/")
    public ResponseEntity<ImageDataResponseDto> createImageData(@RequestBody ImageDataRequestDto imageDataRequestDto){
        ImageData imageData = ImageDataMapping.convertImageDataRequestDtoToImageData(imageDataRequestDto);
        ImageData response = this.imageDataService.createImageData(imageData);
        ImageDataResponseDto imageDataResponseDto = ImageDataMapping.convertToImageDataDto(response);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageDataResponseDto);
    }

    @PatchMapping("/")
    public ResponseEntity<ImageDataResponseDto> patchImageData(@RequestBody ImageDataRequestDto imageDataRequestDto){
        ImageData imageData = ImageDataMapping.convertImageDataRequestDtoToImageData(imageDataRequestDto);
        ImageData response = this.imageDataService.patchImageData(imageData);
        ImageDataResponseDto imageDataResponseDto = ImageDataMapping.convertToImageDataDto(response);
        return ResponseEntity.status(HttpStatus.CREATED).body(imageDataResponseDto);
    }



}
