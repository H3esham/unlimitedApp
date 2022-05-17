package com.example.unlimitedApp;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.unlimitedApp.models.Category;
import com.example.unlimitedApp.models.Tool;
import com.example.unlimitedApp.recyclerviewlist.CategoryAdapter;
import com.example.unlimitedApp.utility.BaseActivity;
public class HomePageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.home_page_title));
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
                new Category("اسلامي","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها." ,R.drawable.background_design,
                        new Tool[]{
                                new Tool("القبلة (beta)",text,R.drawable.icon, com.example.unlimitedApp.tools.qibla.MainActivity.class),
                                new Tool("unlimitedApp",text,R.drawable.icon, com.example.unlimitedApp.tools.praise.MainActivity.class),
                        }

                     ),
                new Category("رياضة","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool(" (beta) اله حاسبة",text,R.drawable.icon, com.example.unlimitedApp.tools.calculator.MainActivity.class),
                        }
                ),
                new Category("تحويلات", "هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.",R.drawable.background_design,
                        new Tool[]{
                                // translate massConverter to arabic

                            new Tool("محول المساحات",text,R.drawable.icon, com.example.unlimitedApp.tools.massConverter.MainActivity.class),
                            new Tool("محول الحرارة",text,R.drawable.icon, com.example.unlimitedApp.tools.temperature.MainActivity.class),
                            new Tool("محول السرعات",text,R.drawable.icon, com.example.unlimitedApp.tools.speedConvert.MainActivity.class),
                            new Tool("محول الاوزان",text,R.drawable.icon, com.example.unlimitedApp.tools.lenghtConverter.MainActivity.class)
                        }),
                new Category("متنوع","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                            new Tool("حساب العمر",text,R.drawable.icon,com.example.unlimitedApp.tools.calculatAge.MainActivity.class),
                            new Tool("ساعه الايقاف",text,R.drawable.icon,com.example.unlimitedApp.tools.stopwatch.MainActivity.class),
                            new Tool("qr",text,R.drawable.icon,com.example.unlimitedApp.tools.qrgenearator.MainActivity.class),
                            new Tool("randomPassword",text,R.drawable.icon,com.example.unlimitedApp.tools.randomPassword.MainActivity.class),
                            new Tool("todo",text,R.drawable.icon,com.example.unlimitedApp.tools.todo.MainActivity.class),
                            new Tool("notePad",text,R.drawable.icon,com.example.unlimitedApp.tools.notepad.MainActivity.class)
                        }
                        ),
                new Category("انترنت","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool("random Password",text,R.drawable.icon,com.example.unlimitedApp.tools.randomPassword.MainActivity.class),
                                new Tool("internet Speed",text,R.drawable.icon,com.example.unlimitedApp.tools.internetSpeed.MainActivity.class)
                        }),
                new Category("تشفير","هناك حقيقة مثبتة منذ زمن طويل وهي أن المحتوى المقروء لصفحة ما سيلهي القارئ عن التركيز على الشكل الخارجي للنص أو شكل توضع الفقرات في الصفحة التي يقرأها.", R.drawable.background_design,
                        new Tool[]{
                                new Tool("Md5 Generator",text,R.drawable.icon, com.example.unlimitedApp.tools.md5Generator.MainActivity.class),
                                new Tool("Sha1 Generator",text,R.drawable.icon, com.example.unlimitedApp.tools.sha1Generator.MainActivity.class),
                                new Tool("Sha256 Generator",text,R.drawable.icon, com.example.unlimitedApp.tools.sha256Generator.MainActivity.class),
                                new Tool("Caesar Cipher (beta)",text,R.drawable.icon, com.example.unlimitedApp.tools.caesarCipher.MainActivity.class),
                                new Tool("vigenere Cipher",text,R.drawable.icon, com.example.unlimitedApp.tools.vigenereCipher.MainActivity.class),
                        })
        };
    }

}