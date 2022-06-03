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
        return new Category[]{

                new Category("تحويلات",
                        "محول الوحدات يتيح أي مستخدم من التحويل بسرعة بين أي وحدات قياس - بما في ذلك الوحدات المخصصة ومجموعات الوحدات - في بضع خطوات بسيطة. تحويل الوحدات هو التحويل بين وحدات القياس المختلفة لنفس الكمية ، عادةً من خلال عوامل التحويل المضاعفة.",
                        R.drawable.ja,
                        new Tool[]{
                                // translate massConverter to arabic
                                new Tool("محول الكتل والاوزان ", "حاسبة تحويل الاوزان هي حاسبة سهلة وبسيطة تساعدك في تحويل وحدة قياس وزن الى اخرى بكل سهولة ويسر ، مثل تحويل من باوند الى كيلو او طن الى كيلو او رطل الى كيلو والعكس ، الى اخره من التحويلات الاخرى .", R.drawable.km, com.example.unlimitedApp.tools.massConverter.MainActivity.class),
                                new Tool("محول الحرارة", "حاسبة تحويل درجات الحرارة هي حاسبة سهلة وبسيطة تساعدك في تحويل درجات الحرارة من  فهرنهايت الى درجة مئوية (سلسيوس) او العكس وكذلك التحويل درجات الحرارة من كلفن الى فهرنهايت او الى درجة مئوية (سلسيوس) والعكس ايضا .", R.drawable.ma, com.example.unlimitedApp.tools.temperature.MainActivity.class),
                                new Tool("محول السرعات", "حاسبة تحويل السرعات هي حاسبة بسيطة وسهلة الاستخدام لتحويل وحدة قياس سرعة الى وحدة قياس سرعة اخرى ، فمثلا يمكنك تحويل الميل الى كيلو ، القدم الى متر ، المتر الى ميل والعكس ، بالاضافة الى العديد من تحويلات وحدات السرعة الاخرى .", R.drawable.tr, com.example.unlimitedApp.tools.speedConvert.MainActivity.class),
                                new Tool("محول الاطوال", "حاسبة تحويل وحدات قياس الطول هي حاسبة سهلة وبسيطة تساعدك في تحويل وحدة قياس طول الى اخرى بكل سهولة ويسر ، مثل تحويل  القدم الى متر او الانش الى سم او الميل الى متر او القدم الى سم ، الى اخره من التحويلات الاخرى .", R.drawable.nx, com.example.unlimitedApp.tools.lenghtConverter.MainActivity.class),
                                new Tool("محول العملات ", "حوّل العملات الأكثر شيوعًا في العالم بأسعار صرف فعالة مع حاسبة تحويل العملات", R.drawable.mo, com.example.unlimitedApp.tools.currencyConvert.MainActivity.class)

                        }),

                new Category("رياضة", "هى اله حاسبة علمية و مجانية تتمتع بالعديد من المميزات القوية بالإضافة إلى الكثير من الوظائف الإضافية، يوفر لك هذا التطبيق العديد من المميزات الإضافية الموجودة في الحاسبة العلمية.", R.drawable.loka,
                        new Tool[]{
                                new Tool("اله حاسبة", "الآلة الحاسبة قادرة على إجراء جميع العمليات الحسابية الأساسية مثل الجمع والطرح والضرب والقسمة", R.drawable.mb, com.example.unlimitedApp.tools.calculator.MainActivity.class),
                                new Tool("محول الانظمة العددية ", "تحويل الأرقام من نظام العد العشري إلى مثيلتها في نظام العد الثنائي، ونظام العد السادس عشري، والنظام الثماني", R.drawable.ty, com.example.unlimitedApp.tools.numberConvert.MainActivity.class)

                        }
                ),
                new Category("متنوع", "سوف نعرفكم عن أهم هذه البرامج وذلك لتحقيق أكبر فائدة من هذا الهاتف الذي لا يمكن أن يستفيد منه المستخدم بأي شيء دون وجود التطبيقات عليه.", R.drawable.jg,
                        new Tool[]{
                                new Tool("حساب العمر", "حساب العمر خدمة تساعدك علي حساب عمرك بالسنوات والشهور والايام", R.drawable.mn, com.example.unlimitedApp.tools.calculatAge.MainActivity.class),
                                new Tool("ساعه الايقاف", "ساعة الإيقاف لتحديد الزمن لكل فعل مثلا : في انجاز المهام، المسابقات، العرض وأشياء كثيرة.", R.drawable.lm, com.example.unlimitedApp.tools.stopwatch.MainActivity.class),
                                new Tool("qr", "قارئ رمز qr اونلاين دون الحاجة لتطبيق او برنامج ... لم تعد بحاجة إلى برنامج أو تطبيق لقراءة رموز QR ", R.drawable.nb, com.example.unlimitedApp.tools.qrgenearator.MainActivity.class),
                                new Tool("todo", " إدارة مهام قائم على السحابة. يسمح للمستخدمين بإدارة مهامهم من الهاتف الذكي", R.drawable.kc, com.example.unlimitedApp.tools.todo.MainActivity.class),
                                new Tool("notePad", "محرر نصوص مخصص لكتابة الشيفرة المصدرية (الكود المصدري) ... والهدف منه هو الحصول على محرر نصوص قوي ولا يستهلك الكثير من موارد النظام", R.drawable.po, com.example.unlimitedApp.tools.notepad.MainActivity.class)
                        }
                ),
                new Category("انترنت", "هى برامج تطبيقيه يتم تشغيلها على خادم ويب، بخلاف البرامج المعتمدة على الكمبيوتر والتي يتم تشغيلها محليًا على نظام التشغيل (OS) للجهاز. يتم الوصول إلى تطبيقات الويب من قبل المستخدم من خلال مستعرض ويب مع اتصال شبكة نشط.", R.drawable.mos,
                        new Tool[]{
                                new Tool("random Password", "استخدام مولد كلمة السر هذا مجانا لإنشاء كلمات مرور آمنة للغاية التي من الصعب أن يتم إختراقها أو تخمينها. ما عليك سوى اختيار معايير كلمات المرور التي تحتاج إليها", R.drawable.mm, com.example.unlimitedApp.tools.randomPassword.MainActivity.class),
                                new Tool("internet Speed", "يمكنك بصورة عامة الحصول على هذه السرعة من خدمات الإنترنت الرائدة، والتي تستخدم خوادم منتشرة في جميع أنحاء العالم", R.drawable.ki, com.example.unlimitedApp.tools.internetSpeed.MainActivity.class)
                        }),
                new Category("تشفير", "من المؤكد أن جميع مستخدمي الأجهزة اللوحية أو الهواتف الذكية يتخذون منها مكانًا لتخزين كافة الملفات المهمة سواء كانت صورًا أو ما شابه ذلك، وقد تكون هناك ملفات خاصة لدرجة كبيرة أو مهمة بشكل كبير بحيث لا يرغب المستخدم للآخرين بالاطلاع عليها أو الوصول إليها، وهذا الأمر يتم أما عن طريق الاختراق أو السرقة.", R.drawable.hhhd,
                        new Tool[]{
                                new Tool("Md5 Generator", "This MD5 hash generator is useful for encoding passwords, credit cards numbers and other sensitive date into MySQL, Postgress or other databases.", R.drawable.bv, com.example.unlimitedApp.tools.md5Generator.MainActivity.class),
                                new Tool("Sha1 Generator", "This tool allows you to generate the SHA1 hash from any string. SHA1 is more secure than MD5. ", R.drawable.hz, com.example.unlimitedApp.tools.sha1Generator.MainActivity.class),
                                new Tool("Sha256 Generator", "This online tool allows you to generate the SHA256 hash of any string. SHA256 is designed by NSA, it's more reliable than SHA1.", R.drawable.jj, com.example.unlimitedApp.tools.sha256Generator.MainActivity.class),
                                new Tool("Caesar Cipher", "Tool to decrypt/encrypt with Caesar cipher (or Caesar code), a shift cipher, one of the most easy and most famous encryption systems.", R.drawable.hj, com.example.unlimitedApp.tools.caesarCipher.MainActivity.class),
                                new Tool("vigenere Cipher", "Tool to decrypt/encrypt Vigenere automatically. Vigenere cipher is a poly-alphabetic substitution system that use a key and a double-entry table.", R.drawable.kl, com.example.unlimitedApp.tools.vigenereCipher.MainActivity.class)
                        }),

                new Category("اسلامي", " تطبيق إسلامي يحتوي على العديد من الأدوات المفيدة لتسهيل حياة الفرد المسلم لممارسة الشعائر الإسلامية ومراجعه النفس.", R.drawable.moh,
                        new Tool[]{
                                new Tool("القبلة", "القِبلة هي الاتجاه الثابت نحو الكعبة في المسجد الحرام في مكّة المكرمة في المملكة العربية السعودية، وهي الاتجاه الذي يواجهه جميع المسلمين عند أداء صلواتهم", R.drawable.vx, com.example.unlimitedApp.tools.qibla.MainActivity.class),
                                new Tool("السبحة", "أبدآ يومك بقراءة الأذكار والقرآن والتسبيح عبر امتداد خفيف الوزن", R.drawable.vc, com.example.unlimitedApp.tools.praise.MainActivity.class)
                        }

                ),
        };
    }
}

