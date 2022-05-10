package com.example.unlimitedApp.models;

public class Tool extends BaseItem {

    private Class activity;
    public Tool(String uniqueId, String name, String description, int image, Class activity) {
        super(uniqueId, name, description, image);
        this.activity = activity;
    }


    public void setActivity(Class activity){
        this.activity = activity;
    }

    public Class getActivity(){
        return this.activity;
    }


}
