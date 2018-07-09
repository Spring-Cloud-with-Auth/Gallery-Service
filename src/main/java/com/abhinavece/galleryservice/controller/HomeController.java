package com.abhinavece.galleryservice.controller;

import com.abhinavece.galleryservice.Model.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/home")
    public String home(){
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.

        return "Gallery service running on port: "+ env.getProperty("local.server.port");
    }

    @RequestMapping("/{id}")
    public Gallery getGallery(@PathVariable("id") final int id){

        Gallery gallery = new Gallery();
        gallery.setId(id);
        List<Object> images = restTemplate.getForObject("http://image-service/images/", List.class);
        gallery.setImages(images);

        return gallery;
    }


    // Admin Area
    // This Area should be accessed by only admin role users.

    @RequestMapping("/admin")
    public String HomeAdmin(){
        return "This is the admin area of Gallery service running at port: "+env.getProperty("local.server.port");
    }

}
