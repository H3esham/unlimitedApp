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

    public static Category[] getAllCategoriesList() {
        String text = "";
        return new Category[]{

                new Category("تحويلات",
                        "محول الوحدات يتيح أي مستخدم من التحويل بسرعة بين أي وحدات قياس - بما في ذلك الوحدات المخصصة ومجموعات الوحدات - في بضع خطوات بسيطة. تحويل الوحدات هو التحويل بين وحدات القياس المختلفة لنفس الكمية ، عادةً من خلال عوامل التحويل المضاعفة.",
                        R.drawable.ja,
                        new Tool[]{
                                // translate massConverter to arabic
                                new Tool("محول الكتل والاوزان ", text, R.drawable.km, com.example.unlimitedApp.tools.massConverter.MainActivity.class),
                                new Tool("محول الحرارة", text, R.drawable.ma, com.example.unlimitedApp.tools.temperature.MainActivity.class),
                                new Tool("محول السرعات", text, R.drawable.tr, com.example.unlimitedApp.tools.speedConvert.MainActivity.class),
                                new Tool("محول الاطوال", text, R.drawable.nx, com.example.unlimitedApp.tools.lenghtConverter.MainActivity.class),
                                new Tool("محول العملات ", text, R.drawable.mo, com.example.unlimitedApp.tools.currencyConvert.MainActivity.class)

                        }),

                new Category("رياضة", "هى اله حاسبة علمية و مجانية تتمتع بالعديد من المميزات القوية بالإضافة إلى الكثير من الوظائف الإضافية، يوفر لك هذا التطبيق العديد من المميزات الإضافية الموجودة في الحاسبة العلمية.", R.drawable.loka,
                        new Tool[]{
                                new Tool("اله حاسبة", text, R.drawable.mb, com.example.unlimitedApp.tools.calculator.MainActivity.class),
                                new Tool("محول الانظمة العددية ", text, R.drawable.ty, com.example.unlimitedApp.tools.numberConvert.MainActivity.class)

                        }
                ),
                new Category("متنوع", "سوف نعرفكم عن أهم هذه البرامج وذلك لتحقيق أكبر فائدة من هذا الهاتف الذي لا يمكن أن يستفيد منه المستخدم بأي شيء دون وجود التطبيقات عليه.", R.drawable.jg,
                        new Tool[]{
                                new Tool("حساب العمر", text, R.drawable.mn, com.example.unlimitedApp.tools.calculatAge.MainActivity.class),
                                new Tool("ساعه الايقاف", text, R.drawable.lm, com.example.unlimitedApp.tools.stopwatch.MainActivity.class),
                                new Tool("qr", text, R.drawable.nb, com.example.unlimitedApp.tools.qrgenearator.MainActivity.class),
                                new Tool("todo", text, R.drawable.kc, com.example.unlimitedApp.tools.todo.MainActivity.class),
                                new Tool("notePad", text, R.drawable.po, com.example.unlimitedApp.tools.notepad.MainActivity.class)
                        }
                ),
                new Category("انترنت", "هى برامج تطبيقيه يتم تشغيلها على خادم ويب، بخلاف البرامج المعتمدة على الكمبيوتر والتي يتم تشغيلها محليًا على نظام التشغيل (OS) للجهاز. يتم الوصول إلى تطبيقات الويب من قبل المستخدم من خلال مستعرض ويب مع اتصال شبكة نشط.", R.drawable.mos,
                        new Tool[]{
                                new Tool("random Password", text, R.drawable.mm, com.example.unlimitedApp.tools.randomPassword.MainActivity.class),
                                new Tool("internet Speed", text, R.drawable.ki, com.example.unlimitedApp.tools.internetSpeed.MainActivity.class)
                        }),
                new Category("تشفير", "من المؤكد أن جميع مستخدمي الأجهزة اللوحية أو الهواتف الذكية يتخذون منها مكانًا لتخزين كافة الملفات المهمة سواء كانت صورًا أو ما شابه ذلك، وقد تكون هناك ملفات خاصة لدرجة كبيرة أو مهمة بشكل كبير بحيث لا يرغب المستخدم للآخرين بالاطلاع عليها أو الوصول إليها، وهذا الأمر يتم أما عن طريق الاختراق أو السرقة.", R.drawable.hhhd,
                        new Tool[]{
                                new Tool("Md5 Generator", text, R.drawable.bv, com.example.unlimitedApp.tools.md5Generator.MainActivity.class),
                                new Tool("Sha1 Generator", text, R.drawable.hz, com.example.unlimitedApp.tools.sha1Generator.MainActivity.class),
                                new Tool("Sha256 Generator", text, R.drawable.jj, com.example.unlimitedApp.tools.sha256Generator.MainActivity.class),
                                new Tool("Caesar Cipher (beta)", text, R.drawable.hj, com.example.unlimitedApp.tools.caesarCipher.MainActivity.class),
                                new Tool("vigenere Cipher", text, R.drawable.kl, com.example.unlimitedApp.tools.vigenereCipher.MainActivity.class)
                        }),

                new Category("اسلامي", " تطبيق إسلامي يحتوي على العديد من الأدوات المفيدة لتسهيل حياة الفرد المسلم لممارسة الشعائر الإسلامية ومراجعه النفس.", R.drawable.moh,
                        new Tool[]{
                                new Tool("القبلة", text, R.drawable.vx, com.example.unlimitedApp.tools.qibla.MainActivity.class),
                                new Tool("السبحة", text, R.drawable.vc, com.example.unlimitedApp.tools.praise.MainActivity.class)
                        }

                ),
        };
    }
}

