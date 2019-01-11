package ir.drax.accordiontest;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import ir.drax.constraintaccordionlist.AccordionItem;
import ir.drax.constraintaccordionlist.AccordionList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // step 1
        ArrayList<AccordionItem> accordionItems = new ArrayList<>();

        accordionItems.add(new AccordionItem("title 1" , "Lorem ipsum dolor sit amet, case legendos pericula mei an, per te consul putent. Delenit dolorem ei nec, id per placerat disputationi. Cum persius scribentur at. Ut laoreet consequat efficiantur duo, pro fabulas honestatis cu. Adhuc quidam mei no, alia mucius denique cu his.\n" +
                "\n" +
                "Soleat vituperata efficiantur pro id, at nihil adipisci pri. Ius id sint elitr. Stet eirmod definitionem at nam, ius everti nusquam prodesset ad, at eos novum torquatos definitionem. Te ius regione efficiantur, ea qui nusquam theophrastus. Cum iisque dolores cu. Menandri voluptatibus concludaturque vim ut.\n" +
                "\n" +
                "Urbanitas vulputate comprehensam usu ne, te temporibus ullamcorper cum. Adipisci deterruisset usu ad, commodo ullamcorper id duo. Sea ei clita facilis dignissim. Cu has homero altera, diam constituto usu id. Ad qui bonorum nusquam, id omnium epicuri pertinacia quo, vis eruditi debitis conceptam cu.\n" +
                "\n" +
                "Vim et ferri mandamus voluptatibus. Ea inani viderer mel, per no saepe rationibus, nec dictas euismod ad. At quo iisque oportere concludaturque. Discere theophrastus eu his, sea id suavitate definitionem.\n" +
                "\n" +
                "Ea eos movet civibus. Habeo dicant ne duo, quot principes referrentur ei mei. Eu sea timeam bonorum definitionem, docendi menandri volutpat ea pro. Exerci vivendo molestiae est at, est enim instructior ne. Vis et ferri dissentias. His ad aperiri sanctus.\n" +
                "\n" +
                "Rebum iusto maiestatis ut vel, usu wisi latine facilis an, usu cu aliquam definiebas. Mel ei dico tractatos. Ei nonumes consulatu mel. Mei id quidam incorrupte disputando, sonet ceteros moderatius usu ei. Mel te eripuit numquam, porro vitae quaeque est an.\n" +
                "\n" +
                "Nihil doctus iisque cu mel. Facete utroque omittantur vim ne, vix amet diceret fabellas ut. Est alia persecuti et, pri te veri menandri recteque. Alterum deterruisset ut mel, corpora mnesarchum ea nec. Cu dolor nominavi scaevola pro, oporteat lucilius nam ex."));

        accordionItems.add(new AccordionItem("title 2" , "أي وقد وبغطاء وصافرات بمعارضة, ثم فقد الشمل الفترة لإنعدام. الدمج بالرغم المتحدة ما عدد, عقبت الدمج وحرمان و لها, مدن تعديل مشاركة المنتصر إذ. أخر ثانية فرنسية بـ, كُلفة لإعادة وبولندا قام أي. ثم فقد عشوائية الحيلولة الموسوعة, أجزاء اكتوبر استرجاع كما ٣٠. حيث الأمم وصافرات عسكرياً تم.\n" +
                "\n" +
                "نفس إعمار استدعى أي, كلّ كل تسبب الخاسرة. كما و وإقامة الأرواح المجتمع, إذ القادة موالية استراليا، أما. بال حالية انذار وإعلان بـ, فقد في الآخر والحزب. شيء الأرض أعمال ولكسمبورغ بل, ان ومن بسبب تكبّد إنطلاق. أضف المارق التقليدية هو, أم غينيا الوزراء استراليا، بين. الله قبضتهم اوروبا فصل ثم.\n" +
                "\n" +
                "به، الجنود الحدود التكاليف عن, وقد لم إجلاء العسكري, يرتبط الأرضية الإيطالية كل قام. هذا لم بقعة الأولى عسكرياً, النفط أعمال الأسيوي يكن ٣٠. دفّة وسفن وإعلان أن وتم. أجزاء الشتوية بالإنزال من دون. عدم تحرير اليابانية التقليدية إذ. إذ دول ٢٠٠٤ الرئيسية ولكسمبورغ.\n" +
                "\n" +
                "من الدمج بخطوط دار, عل حين الأخذ معارضة ومحاولة. كما تونس أعلنت المؤلّفة مع. التي تحرّك اعتداء في حتى, يتم قد واُسدل والمانيا. من مدن رجوعهم بولندا، لبلجيكا،.\n" +
                "\n" +
                "معقل لهذه عالمية ذات إذ, لكل وبالرغم الصعداء بالمحور هو. دون تصفح الأخذ المبرمة عن. الأحمر الإمداد شيء عن, هُزم لعدم وفنلندا أم يبق, بـ الشهير الضروري ولكسمبورغ إيو. سياسة أواخر كلّ ثم, كل جيما علاقة واشتدّت لمّ. نفس قادة تغييرات ان. ومن كانت الصعداء هو, البرية التبرعات أن بها.\n" +
                "\n" +
                "ان الا وسفن وحرمان, بعض وبداية واشتدّت أن, مما بسبب الثالث أم. لفشل تكاليف قبل ان. ديسمبر السيطرة لها لم, كان قد للسيطرة وايرلندا. هنا؟ وسفن ألمانيا أن حدى. عل وحتّى المتحدة الفرنسية بعد, لم تلك تنفّس الهجوم عشوائية. قبل نتيجة النفط تم, أسر مئات تسبب أي."
                , Paint.Align.RIGHT));

        AccordionList accordionList = findViewById(R.id.accordion);
        accordionList.push(accordionItems)
                .build();

        accordionItems=new ArrayList<>();
        accordionItems.add(new AccordionItem("title 3" ,"Mollis saperet perfecto ex quo. Ut mei fugit ponderum, at sit suas invidunt recusabo. Vis quaeque fastidii ex, pro esse mandamus an ."));

        accordionItems.add(new AccordionItem("title 4" , "Nec no duis dicta eligendi, debet oportere an nec. Mei alia tation concludaturque no. Ea quas utamur his. Usu adhuc nostro et. Et case eius quo, ex legendos corrumpit vix.\n" +
                "\n" +
                "Et sea etiam integre. Suas nulla contentiones no eos, at tractatos mnesarchum percipitur vis, at iusto tincidunt ullamcorper eum. Altera dolores ei eos, ei vix pertinax splendide, duis error adversarium ex pri. Vide torquatos intellegat no vel, justo fabulas cu nam. Ex eam purto animal qualisque, ea ius falli latine perpetua, est eros atomorum ei.\n"));
        accordionItems.add(new AccordionItem("title 5" , "Amet tritani vivendo vix no, ex sed iudico nonumes. Ignota salutandi theophrastus ut sea. Congue euismod vim id, omnesque delectus singulis ad vis, vel at latine veritus. Alterum oporteat mnesarchum his eu, nam id tation quodsi ancillae, vel te quando honestatis. Iriure invenire deseruisse eum ei, numquam splendide ex mea, autem perpetua rationibus ut quo.\n" +
                "\n" +
                "Dicta possim voluptua ea eos, ut scripta suscipit efficiendi nec. Accusam conclusionemque id pro. Usu no nibh decore atomorum, usu ea alia scriptorem. Quo ad legere sadipscing. Fierent suavitate mei cu, ut numquam convenire has, sit ei consul accusata.\n"));
        accordionItems.add(new AccordionItem("title 6" , "Sed quando quaeque at. Facer scripta deterruisset nec et. Est an zril quaeque feugiat. Sed ut equidem albucius, wisi maiorum mel ea. Wisi epicurei intellegam pro ei.\n" +
                "\n" +
                "Pri clita mucius apeirian at, mollis saperet perfecto ex quo. Ut mei fugit ponderum, at sit suas invidunt recusabo. Vis quaeque fastidii ex, pro esse mandamus an. Cu probatus eleifend per, cu nec alii civibus aliquando, sit ne quis suas eirmod. In sea nostro dolorem, vis ea mandamus euripidis. At wisi meis his, eu sit insolens adversarium, ne aliquam legendos nec.\n" +
                "\n" +
                "Eirmod dolorum pri ne, tation utinam et pri. Vero altera deseruisse quo eu, libris dissentiunt sit eu. Quo in salutandi laboramus. Enim saperet facilis sea et, mutat laoreet vim cu. Ad quaestio voluptaria instructior ius, eam ferri vivendum philosophia no.\n" +
                "\n" +
                "Est in utamur insolens. Aliquid abhorreant ut vim. At vivendum scripserit nec, velit euripidis eos at. Aeque alienum te vel."));
        accordionItems.add(new AccordionItem("title 7" , "Nec no duis dicta eligendi, debet oportere an nec. Mei alia tation concludaturque no. Ea quas utamur his. Usu adhuc nostro et. Et case eius quo, ex legendos corrumpit vix.\n" +
                "\n" +
                "Et sea etiam integre. Suas nulla contentiones no eos, at tractatos mnesarchum percipitur vis, at iusto tincidunt ullamcorper eum. Altera dolores ei eos, ei vix pertinax splendide, duis error adversarium ex pri. Vide torquatos intellegat no vel, justo fabulas cu nam. Ex eam purto animal qualisque, ea ius falli latine perpetua, est eros atomorum ei.\n"));
        accordionItems.add(new AccordionItem("title 8" , "Amet tritani vivendo vix no, ex sed iudico nonumes. Ignota salutandi theophrastus ut sea. Congue euismod vim id, omnesque delectus singulis ad vis, vel at latine veritus. Alterum oporteat mnesarchum his eu, nam id tation quodsi ancillae, vel te quando honestatis. Iriure invenire deseruisse eum ei, numquam splendide ex mea, autem perpetua rationibus ut quo.\n" +
                "\n" +
                "Dicta possim voluptua ea eos, ut scripta suscipit efficiendi nec. Accusam conclusionemque id pro. Usu no nibh decore atomorum, usu ea alia scriptorem. Quo ad legere sadipscing. Fierent suavitate mei cu, ut numquam convenire has, sit ei consul accusata.\n"));
        accordionItems.add(new AccordionItem("title 9" , "Sed quando quaeque at. Facer scripta deterruisset nec et. Est an zril quaeque feugiat. Sed ut equidem albucius, wisi maiorum mel ea. Wisi epicurei intellegam pro ei.\n" +
                "\n" +
                "Pri clita mucius apeirian at, mollis saperet perfecto ex quo. Ut mei fugit ponderum, at sit suas invidunt recusabo. Vis quaeque fastidii ex, pro esse mandamus an. Cu probatus eleifend per, cu nec alii civibus aliquando, sit ne quis suas eirmod. In sea nostro dolorem, vis ea mandamus euripidis. At wisi meis his, eu sit insolens adversarium, ne aliquam legendos nec.\n" +
                "\n" +
                "Eirmod dolorum pri ne, tation utinam et pri. Vero altera deseruisse quo eu, libris dissentiunt sit eu. Quo in salutandi laboramus. Enim saperet facilis sea et, mutat laoreet vim cu. Ad quaestio voluptaria instructior ius, eam ferri vivendum philosophia no.\n" +
                "\n" +
                "Est in utamur insolens. Aliquid abhorreant ut vim. At vivendum scripserit nec, velit euripidis eos at. Aeque alienum te vel."));

        accordionList
                .push(accordionItems)
                .build();

    }


}
