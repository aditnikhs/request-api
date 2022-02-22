package nds.training.other.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nds.training.other.model.ProductModel;
import nds.training.other.service.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {
    
    @Autowired
    RequestService service;
    
    @GetMapping(value = "/all")
    public String getAll(){
        return service.getAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody ProductModel model){
        return service.add(model);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody ProductModel model){
        return service.update(model);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestBody ProductModel model){
        return service.delete(model);
    }

    @PostMapping(value = "/add-batch")
    public ResponseEntity<String> addBatch(@RequestBody List<ProductModel> models){
        return service.addBatch(models);
    }

    @PostMapping(value = "/data")
    public ResponseEntity<String> pickData(@RequestBody ProductModel model){
        return service.pickData(model);
    }

    @PostMapping(value = "/product-by-category")
    public ResponseEntity<String> byCategory(@RequestBody ProductModel model){
        return service.byCategory(model);
    }
}
