package com.carsonskjerdal.app.builderrecyclerview;

/**
 * Created by Carson on 3/30/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
interface AddItemInterface {
    void addPlayer();

    void deletePlayer();

    int getSize();

    void editPlayer(String name, int position);

    void listListener();
}
