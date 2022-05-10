package com.example.praise;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.praise.models.Category;
import com.example.praise.models.Tool;
import com.example.praise.recyclerviewlist.CategoryAdapter;
import com.example.praise.utility.BaseActivity;

public class HomePageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle("HomePage");
            myToolbar.setNavigationIcon(null);
            setSupportActionBar(myToolbar);
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CategoryAdapter(getAllCategoriesList()));

    }

    public static Category[] getAllCategoriesList(){
        String text = "";
        return new Category[]{
                new Category(
                        "unique1","اسلامي","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها." ,R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one","القبلة (beta)",text,R.drawable.icon, com.example.praise.tools.qibla.MainActivity.class),
                                new Tool("tools_two","praise",text,R.drawable.icon, com.example.praise.tools.praise.MainActivity.class),
                        }

                     ),
                new Category("unique2","رياضة","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one"," (beta) اله حاسبة",text,R.drawable.icon, com.example.praise.tools.calculator.MainActivity.class),
                        }
                ),
                new Category("unique3","تحويلات", "هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.",R.drawable.background_design,
                        new Tool[]{
                                // translate massConverter to arabic

                            new Tool("tools_one","محول المساحات",text,R.drawable.icon, com.example.praise.tools.massConverter.MainActivity.class),
                            new Tool("tools_two","محول الحرارة",text,R.drawable.icon, com.example.praise.tools.temperature.MainActivity.class),
                            new Tool("tools_three","محول السرعات",text,R.drawable.icon, com.example.praise.tools.speedConvert.MainActivity.class),
                        }),
                new Category("unique4","متنوع","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{

                        }
                        ),
                new Category("unique5","انترنت","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                        }),
                new Category("unique6","تشفير","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one","Md5 Generator",text,R.drawable.icon, com.example.praise.tools.md5Generator.MainActivity.class),
                                new Tool("tools_two","Sha1 Generator",text,R.drawable.icon, com.example.praise.tools.sha1Generator.MainActivity.class),
                                new Tool("tools_three","Sha256 Generator",text,R.drawable.icon, com.example.praise.tools.sha256Generator.MainActivity.class),
                                new Tool("tools_four","Caesar Cipher (beta)",text,R.drawable.icon, com.example.praise.tools.caesarCipher.MainActivity.class),
                        })
        };
    }

}