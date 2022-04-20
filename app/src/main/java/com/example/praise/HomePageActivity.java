package com.example.praise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.praise.models.Category;
import com.example.praise.models.Tool;
import com.example.praise.recyclerviewlist.CategoryAdapter;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CategoryAdapter(getAllCategoriesList()));

    }

    public static Category[] getAllCategoriesList(){
        String text = "لوريم إيبسوم(Lorem Ipsum) هو ببساطة نص شكلي (بمعنى أن الغاية هي الشكل وليس المحتوى) ويُستخدم في صناعات المطابع ودور النشر. كان لوريم إيبسوم ولايزال المعيار للنص الشكلي منذ القرن الخامس عشر عندما قامت مطبعة مجهولة برص مجموعة من الأحرف بشكل عشوائي أخذتها من نص";
        return new Category[]{
                new Category(
                        "unique1","اسلامي","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها." ,R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one","القبلة",text,R.drawable.icon, com.example.praise.tools.qibla.MainActivity.class),
                                new Tool("tools_two","praise",text,R.drawable.icon, com.example.praise.tools.praise.MainActivity.class),
                        }

                     ),
                new Category("unique2","رياضة","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one","القبلة",text,R.drawable.icon, com.example.praise.tools.qibla.MainActivity.class),
                                new Tool("tools_two","praise",text,R.drawable.icon, com.example.praise.tools.praise.MainActivity.class),
                        }
                ),
                new Category("unique3","تحويلات", "هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.",R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one","القبلة",text,R.drawable.icon, com.example.praise.tools.qibla.MainActivity.class),
                                new Tool("tools_two","praise",text,R.drawable.icon, com.example.praise.tools.praise.MainActivity.class),
                        }),
                new Category("unique4","متنوع","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one","القبلة",text,R.drawable.icon, com.example.praise.tools.qibla.MainActivity.class),
                                new Tool("tools_two","praise",text,R.drawable.icon, com.example.praise.tools.praise.MainActivity.class),
                        }
                        ),
                new Category("unique5","انترنت","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one","القبلة",text,R.drawable.icon, com.example.praise.tools.qibla.MainActivity.class),
                                new Tool("tools_two","praise",text,R.drawable.icon, com.example.praise.tools.praise.MainActivity.class),
                        }),
                new Category("unique6","اي حاجه علشان العرض :)","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool("tools_one","القبلة",text,R.drawable.icon, com.example.praise.tools.qibla.MainActivity.class),
                                new Tool("tools_two","praise",text,R.drawable.icon, com.example.praise.tools.praise.MainActivity.class),
                        })
        };
    }

}