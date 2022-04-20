package com.example.praise.recyclerviewlist;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.praise.R;
import com.example.praise.models.Tool;

public class ToolCategoryAdapter  extends RecyclerView.Adapter<ToolCategoryAdapter.ViewHolder> {
    private Tool[] tools;
    public static final String EXTRA_Tool = "com.example.praise.recyclerviewlist.Tool";

    public ToolCategoryAdapter(Tool[] tools) {
        System.out.println("ToolCategoryAdapter");
        this.tools = tools;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tool tool = tools[position];
        holder.name.setText(tool.getName());
        holder.description.setText(tool.getDescription());
        holder.image.setImageResource(tool.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), tool.getActivity());
                intent.putExtra(EXTRA_Tool, (String) tool.getUniqueId());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tools.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.category_name);
            description = (TextView) itemView.findViewById(R.id.category_description);
            image = (ImageView) itemView.findViewById(R.id.category_image);
        }
    }
}
