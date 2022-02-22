package nds.training.other.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import nds.training.other.model.ProductModel;

@Service
public class RequestService implements Serializable {
    
    public String getAll(){
        String uri = "http://localhost:8080/product/all";
        RestTemplate rTemplate = new RestTemplate();
        return rTemplate.getForObject(uri, String.class);
    }

    public ResponseEntity<String> add(ProductModel model){
        String uri = "http://localhost:8080/product/add";
        RestTemplate rTemplate = new RestTemplate();
        String body = null;
        try {
            body = rTemplate.postForEntity(uri, model, String.class).getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("response body: "+e.getResponseBodyAsString());

            return new ResponseEntity<>(
                e.getResponseBodyAsString(),
                HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(body,HttpStatus.OK);
    }

    public ResponseEntity<String> update(ProductModel model){
        String uri = "http://localhost:8080/product/update";
        RestTemplate rTemplate = new RestTemplate();
        String body = null;
        try {
            body = rTemplate.postForEntity(uri, model, String.class).getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("response body: "+e.getResponseBodyAsString());

            return new ResponseEntity<>(
                e.getResponseBodyAsString(),
                HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(body,HttpStatus.OK);
    }

    public ResponseEntity<String> delete(ProductModel model){
        String uri = "http://localhost:8080/product/delete";
        RestTemplate rTemplate = new RestTemplate();
        String body = null;
        try {
            body = rTemplate.postForEntity(uri, model, String.class).getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("response body: "+e.getResponseBodyAsString());

            return new ResponseEntity<>(
                e.getResponseBodyAsString(),
                HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(body,HttpStatus.OK);
    }

    public ResponseEntity<String> addBatch(List<ProductModel> models) {
        String uri = "http://localhost:8080/product/add-batch";
        RestTemplate rTemplate = new RestTemplate();
        String body = null;
        try {
            body = rTemplate.postForEntity(uri, models, String.class).getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("response body: "+e.getResponseBodyAsString());

            return new ResponseEntity<>(
                e.getResponseBodyAsString(),
                HttpStatus.BAD_REQUEST);
        } catch (HttpServerErrorException e) {
            System.out.println("response body: "+e.getResponseBodyAsString());

            return new ResponseEntity<>(
                e.getResponseBodyAsString(),
                HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(body,HttpStatus.OK);
    }

    public ResponseEntity<String> pickData(ProductModel model) {
        String uri = "http://localhost:8080/product/data";
        RestTemplate rTemplate = new RestTemplate();
        String body = null;
        try {
            body = rTemplate.postForEntity(uri, model, String.class).getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("response body: "+e.getResponseBodyAsString());

            return new ResponseEntity<>(
                e.getResponseBodyAsString(),
                HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(body,HttpStatus.OK);
    }

    public ResponseEntity<String> byCategory(ProductModel model) {
        String uri = "http://localhost:8080/product/search-by-category";
        RestTemplate rTemplate = new RestTemplate();
        String body = null;
        try {
            body = rTemplate.postForEntity(uri, model, String.class).getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("response body: "+e.getResponseBodyAsString());

            return new ResponseEntity<>(
                e.getResponseBodyAsString(),
                HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(body,HttpStatus.OK);
    }
}
