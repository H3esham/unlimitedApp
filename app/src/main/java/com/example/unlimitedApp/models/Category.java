package com.example.unlimitedApp.models;

public class Category extends BaseItem {

    private Tool[] tools;

    public Category(String name, String description, int image, Tool[] tools) {
        super(name, description, image);
        this.tools = tools;
    }

    public Tool[] getTools() {
        return tools;
    }

    public void setTools(Tool[] tools) {
        this.tools = tools;
    }

    public void addTool(Tool tool) {
        if (tools == null) {
            tools = new Tool[1];
            tools[0] = tool;
        } else {
            Tool[] tempTools = new Tool[tools.length + 1];
            for (int i = 0; i < tools.length; i++) {
                tempTools[i] = tools[i];
            }
            tempTools[tempTools.length - 1] = tool;
            tools = tempTools;
        }
    }

}
