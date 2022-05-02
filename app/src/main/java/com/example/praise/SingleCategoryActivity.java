package com.example.praise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.praise.models.Category;
import com.example.praise.recyclerviewlist.CategoryAdapter;
import com.example.praise.recyclerviewlist.ToolCategoryAdapter;

public class SingleCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_category);
        Intent intent = getIntent();
        //get category object from intent
        if (intent.hasExtra(CategoryAdapter.EXTRA_CATEGORY)) {
          try {
              Category category = (Category) intent.getSerializableExtra(CategoryAdapter.EXTRA_CATEGORY);

              setTitle(category.getName());
              TextView categoryName = findViewById(R.id.category_name);
              categoryName.setText(category.getName());
              TextView categoryDescription = findViewById(R.id.category_description);
              categoryDescription.setText(category.getDescription());
              ImageView categoryImage = findViewById(R.id.category_image);
              categoryImage.setImageResource(category.getImage());
              if (category.getTools().length > 0) {
                  RecyclerView recyclerView = findViewById(R.id.recyclerView);
                  recyclerView.setHasFixedSize(true);
                  recyclerView.setLayoutManager(new LinearLayoutManager(this));
                  recyclerView.setAdapter(new ToolCategoryAdapter(category.getTools()));
              }
          }catch (Exception e){
              e.printStackTrace();
              setTitle("Error");
          }
        }else{
            setTitle("Error");
        }
    }

}