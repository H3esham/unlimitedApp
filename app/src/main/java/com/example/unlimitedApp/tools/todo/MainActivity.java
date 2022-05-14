package com.example.unlimitedApp.tools.todo;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.unlimitedApp.R;
import com.example.unlimitedApp.models.Todo;
import com.example.unlimitedApp.recyclerviewlist.TodoAdapter;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {

    Todo[] todos = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_todo_activity_main);

        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.tools_todo_title));
            setSupportActionBar(myToolbar);
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TodoAdapter(todos));

    }
}