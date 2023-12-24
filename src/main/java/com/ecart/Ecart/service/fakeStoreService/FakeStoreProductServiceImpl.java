package com.ecart.Ecart.service.fakeStoreService;

import com.ecart.Ecart.dto.productDto.ProductRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements IFakeStoreProductService {
    @Autowired
    RestTemplate restTemplate;
    HttpClient httpClient = HttpClient.newBuilder().build();
    @Override
    public List<ProductRequestDTO> getAllProducts() throws IOException, InterruptedException, URISyntaxException {
//        ResponseEntity<Object> forEntity = restTemplate.getForEntity("https://www.gov.uk/bank-holidays.json", Object.class);
//        System.out.println(forEntity.getBody());
        return null;

    }
}
