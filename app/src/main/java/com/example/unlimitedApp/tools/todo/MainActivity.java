package com.example.unlimitedApp.tools.todo;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.models.Todo;
import com.example.unlimitedApp.recyclerviewlist.TodoAdapter;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    ImageButton add_btn;
    EditText newItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_todo_activity_main);

        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.tools_todo_title));
            setSupportActionBar(myToolbar);
        }

        add_btn = (ImageButton) findViewById(R.id.add_btn);
        newItem = (EditText) findViewById(R.id.newItem);

        Todo[] todos = {
                new Todo("Todo 1", false),
        };
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TodoAdapter(todos));

        add_btn.setOnClickListener(v -> {
            String title = newItem.getText().toString();
            if (title.length() > 0) {
                Todo todo = new Todo(title, false);
                ((TodoAdapter) recyclerView.getAdapter()).addTodo(todo);
                newItem.setText("");
            }else{
                newItem.setError(getString(R.string.tools_todo_error_empty_title));
                newItem.requestFocus();
            }

        });

    }
}