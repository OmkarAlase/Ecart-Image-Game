package com.ecart.Ecart.repository.imageDataRepository;

import com.ecart.Ecart.model.Image.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDataRepository extends JpaRepository<ImageData,Integer>{
}
