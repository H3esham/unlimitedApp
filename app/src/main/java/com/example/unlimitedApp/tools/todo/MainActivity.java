package com.example.unlimitedApp.tools.todo;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.models.Todo;
import com.example.unlimitedApp.recyclerviewlist.TodoAdapter;
import com.example.unlimitedApp.utility.BaseActivity;

import java.util.Objects;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;
    ImageButton add_btn;
    EditText newItem;
    MenuItem action_delete_all;
    MainActivity activity;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_main, menu);
        action_delete_all = menu.findItem(R.id.action_delete_all);
        action_delete_all.setVisible(true);
        return  true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View view = new View(this);
        switch (item.getItemId()) {
            case R.id.action_delete_all:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(R.string.tools_todo_delete_all_title));
                builder.setMessage(getString(R.string.tools_todo_delete_all_message));
                builder.setPositiveButton(getString(R.string.tools_todo_delete_all_positive), (dialog, which) -> {
                    ((TodoAdapter) Objects.requireNonNull(recyclerView.getAdapter())).deleteAll();
                    Toast.makeText(this, "delete all items", Toast.LENGTH_SHORT).show();
                });
                builder.setNegativeButton(getString(R.string.tools_todo_delete_all_negative), (dialog, which) -> {
                    dialog.dismiss();
                });
                builder.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_todo_activity_main);

        activity = this;

        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.tools_todo_title));
            // show delete icon in action bar
            setSupportActionBar(myToolbar);
        }

        // check if the activity is being restored
        if (savedInstanceState != null) {
            // restore the recycler view state
            Objects.requireNonNull(recyclerView.getLayoutManager()).onRestoreInstanceState(savedInstanceState.getParcelable("recyclerViewState"));
        }


        add_btn = (ImageButton) findViewById(R.id.add_btn);
        newItem = (EditText) findViewById(R.id.newItem);
        Todo[] todos = {};
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TodoAdapter(todos));

        add_btn.setOnClickListener(v -> {
            String title = newItem.getText().toString();
            if (title.length() > 0) {
                Todo todo = new Todo(title, false);
                ((TodoAdapter) Objects.requireNonNull(recyclerView.getAdapter())).addTodo(todo);
                newItem.setText("");
            }else{
                newItem.setError(getString(R.string.tools_todo_error_empty_title));
                newItem.requestFocus();
            }

        });

    }


}