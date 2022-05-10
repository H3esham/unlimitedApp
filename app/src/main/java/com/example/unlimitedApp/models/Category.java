package com.example.unlimitedApp.models;

public class Category extends BaseItem {

    private Tool[] tools;

    public Category(String uniqueId,String name, String description, int image, Tool[] tools) {
        super(uniqueId, name, description, image);
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

    public void removeTool(Tool tool) {
        if (tools != null) {
            for (int i = 0; i < tools.length; i++) {
                if (tools[i].getUniqueId().equals(tool.getUniqueId())) {
                    Tool[] tempTools = new Tool[tools.length - 1];
                    for (int j = 0; j < i; j++) {
                        tempTools[j] = tools[j];
                    }
                    for (int j = i; j < tempTools.length; j++) {
                        tempTools[j] = tools[j + 1];
                    }
                    tools = tempTools;
                    return;
                }
            }
        }
    }

}
