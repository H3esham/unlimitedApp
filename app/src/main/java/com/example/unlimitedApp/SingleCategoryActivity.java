package com.example.unlimitedApp;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.unlimitedApp.models.Category;
import com.example.unlimitedApp.recyclerviewlist.CategoryAdapter;
import com.example.unlimitedApp.recyclerviewlist.ToolCategoryAdapter;
import com.example.unlimitedApp.utility.BaseActivity;
import com.example.unlimitedApp.R;
public class SingleCategoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_category);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
        }
        Intent intent = getIntent();
        //get category object from intent
        if (intent.hasExtra(CategoryAdapter.EXTRA_CATEGORY)) {
          try {
              Category category = (Category) intent.getSerializableExtra(CategoryAdapter.EXTRA_CATEGORY);
              //set category name
              if (myToolbar != null) {
                  myToolbar.setTitle(category.getName());

              }
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
                  recyclerView.setAdapter(new ToolCategoryAdapter(category));
              }
          }catch (Exception e){
              e.printStackTrace();
              if (myToolbar != null) {
                  myToolbar.setTitle(getString(R.string.error));
              }
          }
        }else{
            if (myToolbar != null) {
                myToolbar.setTitle(getString(R.string.error));
            }
        }

        if (myToolbar != null) {
            setSupportActionBar(myToolbar);
        }
    }

}