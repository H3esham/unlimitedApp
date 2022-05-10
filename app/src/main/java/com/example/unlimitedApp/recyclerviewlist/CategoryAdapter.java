package com.example.unlimitedApp.recyclerviewlist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.unlimitedApp.R;
import com.example.unlimitedApp.SingleCategoryActivity;
import com.example.unlimitedApp.models.Category;


public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private final Category[] categories;
    public static final String EXTRA_CATEGORY = "com.example.unlimitedApp.recyclerviewlist.CATEGORY";

    public CategoryAdapter(Category[] categories) {
        this.categories = categories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category category = categories[position];
        holder.name.setText(category.getName());
        holder.description.setText(category.getDescription());
        holder.image.setImageResource(category.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SingleCategoryActivity.class);
                //send the category object to the next activity
                intent.putExtra(EXTRA_CATEGORY, category);

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
