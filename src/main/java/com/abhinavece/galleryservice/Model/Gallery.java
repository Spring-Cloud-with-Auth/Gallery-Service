package com.abhinavece.galleryservice.Model;

import java.util.List;

public class Gallery {

    private int id;
    private List<Object> Images;

    public Gallery() {
    }

    public Gallery(int id, List<Object> images) {
        this.id = id;
        Images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Object> getImages() {
        return Images;
    }

    public void setImages(List<Object> images) {
        Images = images;
    }
}
