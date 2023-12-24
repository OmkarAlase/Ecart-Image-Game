package com.ecart.Ecart.utils.imageDataMapping;

import com.ecart.Ecart.dto.imageDataDto.ImageDataRequestDto;
import com.ecart.Ecart.dto.imageDataDto.ImageDataResponseDto;
import com.ecart.Ecart.model.Image.ImageData;

import java.util.ArrayList;
import java.util.List;

public class ImageDataMapping {
    public static ImageDataResponseDto convertToImageDataDto(ImageData imageData){
        ImageDataResponseDto dto = new ImageDataResponseDto();
        dto.setId(imageData.getId());
        dto.setImageUrl(imageData.getImageUrl());
        dto.setName(imageData.getName());

        return dto;
    }

    public static List<ImageDataResponseDto> convertAllToImageDataResponseDto(List<ImageData> imageData){
        List<ImageDataResponseDto> list = new ArrayList<>();
        for (ImageData imageDatum : imageData) {
            list.add(ImageDataMapping.convertToImageDataDto(imageDatum));
        }

        return list;
    }

    public static ImageData convertImageDataRequestDtoToImageData(ImageDataRequestDto imageDataRequestDto){
        ImageData imageData = new ImageData();
        imageData.setImageUrl(imageDataRequestDto.getImageUrl());
        imageData.setName(imageDataRequestDto.getName());
        imageData.setId(imageDataRequestDto.getId());
        return imageData;
    }
}
