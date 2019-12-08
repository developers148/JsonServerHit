package com.example.jsonserverhit;

public class Contact {

    String id;
    String name;
    String types;
    String colorofeyes;
    String image;


    public  Contact(String id, String name,String types,String colorofeyes, String image){


        this.setId(id);
        this.setName(name);
        this.setTypes(types);
        this.setColorofeyes(colorofeyes);
        this.setImage(image);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypes() {
        return types;
    }

    public String getColorofeyes() {
        return colorofeyes;
    }

    public String getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public void setColorofeyes(String colorofeyes) {
        this.colorofeyes = colorofeyes;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
