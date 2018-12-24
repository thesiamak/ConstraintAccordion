package ir.drax.accordiontest;

import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import ir.drax.accordiontest.accordionList.AccordionItem;
import ir.drax.accordiontest.accordionList.AccordionList;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // step 1
        ArrayList<AccordionItem> accordionItems = new ArrayList<>();
        accordionItems.add(new AccordionItem("title 11" , "Also, how would I go about finding the answer in the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not that of the documentation"));
        accordionItems.add(new AccordionItem("title 2" , "Also, how would I go about finding the answer in the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not that of the documentation"));
        accordionItems.add(new AccordionItem("title 2" , "Also, how would I go about \nfinding the answer \n\n\nin the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not that of the documentationAlso, how would I go about finding the answer in the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not that of the documentationAlso, how would I go about finding the answer in the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not that of the documentation"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
     /*   accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 5" , "Texxxxxadsadsdsaa "));
        accordionItems.add(new AccordionItem("title 5" , "Texxxxxadsadsdsaa "));
      */  accordionItems.add(new AccordionItem("title 6" , "sda;lakdas;lTexxxxx"));
        accordionItems.add(new AccordionItem("title 6" , "sda;lakdas;lTexxxxx"));
        accordionItems.add(new AccordionItem("title 7" , "das;lkd;la;lask;dl,amsdl;as;ldkmas;lkdjasdkasmdsam;lkmdalskmdklas d"));

        AccordionList accordionList = findViewById(R.id.accordion);
        accordionList
                .setARROW_ICON(R.mipmap.left_arrow_icon)
                .push(accordionItems)
                .build();
        //setContentView(constraintLayout);

        //buildConstraintLayout();
    }


}
