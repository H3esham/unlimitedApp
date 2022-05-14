package com.example.unlimitedApp.models;

public class Tool extends BaseItem {

    private Class activity;
    public Tool(String name, String description, int image, Class activity) {
        super(name, description, image);
        this.activity = activity;
    }


    public void setActivity(Class activity){
        this.activity = activity;
    }

    public Class getActivity(){
        return this.activity;
    }


}
