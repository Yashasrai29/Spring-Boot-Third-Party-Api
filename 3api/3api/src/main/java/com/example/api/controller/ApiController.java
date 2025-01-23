package com.example.api.controller;

import com.example.api.model.Objects;
import com.example.api.repository.RepositoryLayer;
import com.example.api.service.SequenceGeneratorService;
import com.example.api.service.ServiceLayer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



import static com.example.api.model.Objects.SEQUENCE_NAME;


@RestController
@RequestMapping("/request")
public class ApiController {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private ServiceLayer serviceLayer;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RepositoryLayer repositoryLayer;

    @GetMapping()
    public Objects getData(){
        return serviceLayer.consumeApi();
    }
    @GetMapping("/{id}")
    public Objects getData(@PathVariable ObjectId id){
        return serviceLayer.getById(id);    }

    @PostMapping()
    public Objects addObjects(){
        Objects o=restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", Objects.class);
        o.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
     return  repositoryLayer.save(o);

    }

    @PostMapping("/many")
    public Objects addMany(@RequestBody Objects objects) {
        objects.setId(sequenceGeneratorService.getSequenceNumber(SEQUENCE_NAME));
        return serviceLayer.addAll(objects);

    }

    @PostMapping("/new")
    public Objects BigConsume(@RequestBody String url){
        return serviceLayer.bigDataConsume(url);
    }


//    @GetMapping("/one")
//    public Objects getData2(){
//        return serviceLayer.consumeData();
//    }

}
