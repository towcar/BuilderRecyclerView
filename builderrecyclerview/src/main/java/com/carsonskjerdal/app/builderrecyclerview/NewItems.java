package com.carsonskjerdal.app.builderrecyclerview;

/**
 * Created by Carson on 3/30/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public class NewItems {

    private String name;
    private int position;

    public NewItems(String name, int position){

        this.name = name;
        this.position = position;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        //Log.e("getName","Name is: " + name);
        return name;
    }

    public void setPosition(int position){this.position = position;}

    public int getPosition(){return position;}

}
