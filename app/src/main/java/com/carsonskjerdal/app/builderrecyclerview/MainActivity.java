package com.carsonskjerdal.app.builderrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AddItemInterface{


    AddItemAdapter myAdapter;
    RecyclerView customRecycler;
    Button button;
    int position = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Todo perhaps build the library into a class to call these things easier in one method, rather than having the user still do all this work..

        setContentView(R.layout.activity_main);

        customRecycler = findViewById(R.id.recycler);

        //custom LayoutManager for adjusting speed
        ScrollSpeedLinearLayoutManager llm = new ScrollSpeedLinearLayoutManager(this, 50);
        //llm.setStackFromEnd(true);
        // myRecycler.setLayoutManager(llm);
        customRecycler.setLayoutManager(llm);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(customRecycler.getContext(), llm.getOrientation());
        customRecycler.addItemDecoration(dividerItemDecoration);
        NewItems player = new NewItems("", 0);
        List<NewItems> list = new ArrayList<>();
        list.add(player);

        myAdapter = new AddItemAdapter(list) {
            @Override
            public void listListener() {
               //Log.e("Main Activity","Scroll To Position");
                position = myAdapter.getSize();
                //customRecycler.smoothScrollToPosition(position - 1);

                customRecycler.post(new Runnable() {
                    @Override
                    public void run() {
                        customRecycler.smoothScrollToPosition(position - 1);
                    }
                });

            }
        };
        customRecycler.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        customRecycler.scrollToPosition(myAdapter.getItemCount());

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> listSend = new ArrayList<>();
                List<NewItems> updateList = myAdapter.getList();
                Log.e("main", "recieving " + updateList.get(0).getName());

                //child count is length so minus one we can get all the items we need
                for (int x = 0; x < customRecycler.getAdapter().getItemCount() - 1; x++) {
                    NewItems player = updateList.get(x);
                    String title = player.getName();
                    //check to ensure title has a character
                    if (!title.equals("")){
                        listSend.add(title);
                        Log.e("main", "name is " + title);
                    }
                }

                Log.e("list send", "list: " + listSend);
                //add list into intent
                //intent.putStringArrayListExtra("playersList", listSend);

            }
        });
    }


    @Override
    public void addPlayer() {

    }

    @Override
    public void deletePlayer() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void editPlayer(String name, int position) {

    }

    @Override
    public void listListener() {

    }
}
