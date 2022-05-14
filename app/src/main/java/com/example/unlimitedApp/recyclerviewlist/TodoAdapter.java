package com.example.unlimitedApp.recyclerviewlist;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.models.Todo;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.atomic.AtomicBoolean;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private Todo[] todos;
    private View App;

    public TodoAdapter(Todo[] todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_list_item, parent, false);
        return new ViewHolder(view);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Todo todo = todos[position];
        holder.title.setText(todo.getTitle());
        holder.check_btn.setChecked(todo.isDone());
        // hide divider if it last item
        if (position == todos.length - 1) {
            holder.divider.setVisibility(View.GONE);
        }else {
            holder.divider.setVisibility(View.VISIBLE);
        }
        // strike through text if done
        holder.check_btn.setOnClickListener(v -> {
           todo.setStatus(!todo.isDone());
           if (todo.isDone()) {
               holder.title.setPaintFlags(holder.title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
           }else{
               holder.title.setPaintFlags(holder.title.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
           }
        });
        // delete button
        holder.delete_btn.setOnClickListener(v -> {
            // check confirmation dialog
            AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).create();
            alertDialog.setTitle("Confirm");
            alertDialog.setMessage("Are you sure you want to delete this item?");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", (dialog, which) -> {
                // delete this item from the list
                deleteTodo(position);
            });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", (dialog, which) -> {
                dialog.dismiss();
            });
            alertDialog.show();

        });
    }

    public void deleteAll(){
        todos = new Todo[0];
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return  todos.length;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addTodo(Todo todo) {
        Todo[] newTodos = new Todo[todos.length + 1];
        for (int i = 0; i < todos.length; i++) {
            newTodos[i] = todos[i];
        }
        newTodos[todos.length] = todo;
        todos = newTodos;
        notifyDataSetChanged();
    }

    public void deleteTodo(int position) {
        Todo[] newTodos = new Todo[todos.length - 1];
        int j = 0;
        for (int i = 0; i < todos.length; i++) {
            if (i != position) {
                newTodos[j] = todos[i];
                j++;
            }
        }
        todos = newTodos;
        notifyDataSetChanged();
    }

    public boolean saveAll(){
        return true;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        CheckBox check_btn;
        ImageButton delete_btn;
        View divider;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            check_btn = itemView.findViewById(R.id.check_btn);
            delete_btn = itemView.findViewById(R.id.delete_btn);
            divider = itemView.findViewById(R.id.divider);


        }
    }
}
