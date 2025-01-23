package com.example.api.service;

import com.example.api.model.Objects;
import com.example.api.repository.RepositoryLayer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceLayer {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RepositoryLayer repositoryLayer;


    public Objects consumeApi(){
        return  restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", Objects.class);
    }

    public Objects getById(ObjectId id) {
//        Integer ids = Integer.valueOf(id);
//        Integer ids = Integer.valueOf(str);
        return repositoryLayer.findByNewId(id);
    }

    public Objects bigDataConsume(String url) {

        return repositoryLayer.save(restTemplate.getForObject(url, Objects.class));
    }

    public Objects addAll(Objects objects) {
        return repositoryLayer.save(objects);
    }


//    public Objects consumeData(){
//        return  restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", Objects.class);
//    }

}
