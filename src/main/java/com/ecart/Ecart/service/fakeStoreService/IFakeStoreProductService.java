package com.ecart.Ecart.service.fakeStoreService;

import com.ecart.Ecart.dto.productDto.ProductRequestDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
@Service
public interface IFakeStoreProductService {
    List<ProductRequestDTO> getAllProducts() throws IOException, InterruptedException, URISyntaxException;
}
