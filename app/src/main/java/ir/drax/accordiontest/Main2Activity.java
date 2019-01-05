package ir.drax.accordiontest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import ir.drax.constraintaccordionlist.AccordionItem;
import ir.drax.constraintaccordionlist.AccordionList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_accordion_content);

        // step 1
        ArrayList<AccordionItem> accordionItems = new ArrayList<>();
        accordionItems.add(new AccordionItem("title 11" , "Also, how would I go about \nfinding the answer \n\n\nin the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not \n\n\n\n\nthat of the documentationAlso, how would I go about finding the answer in the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not that of the documentationAlso, how would I go about finding the answer in the \n\ndocumentation? It's mentioned here, but \n\nI don't see any explanation of how it's actually used. Actually, I rarely seem to\n\n find the documentation useful, but I'm hoping that's my fault and not that of the documentation"));
        accordionItems.add(new AccordionItem("title 2" , "Also, how would I go about finding the answer in the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not that of the documentation"));
        accordionItems.add(new AccordionItem("title 2" , "Also, how would I go about \nfinding the answer \n\n\nin the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not \n\n\n\n\nthat of the documentationAlso, how would I go about finding the answer in the documentation? It's mentioned here, but I don't see any explanation of how it's actually used. Actually, I rarely seem to find the documentation useful, but I'm hoping that's my fault and not that of the documentationAlso, how would I go about finding the answer in the \n\ndocumentation? It's mentioned here, but \n\nI don't see any explanation of how it's actually used. Actually, I rarely seem to\n\n find the documentation useful, but I'm hoping that's my fault and not that of the documentation"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 3" , "dsasda"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        /*accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        */
        AccordionList accordionList = findViewById(R.id.accordion);
        accordionList.push(accordionItems)
        .build();

        accordionItems.add(new AccordionItem("title 4" , "Texxxxdasdsax"));
        accordionItems.add(new AccordionItem("title 5" , "Texxxxxadsadsdsaa "));
        accordionItems.add(new AccordionItem("title 5" , "Texxxxxadsadsdsaa "));
        accordionItems.add(new AccordionItem("title 6" , "sda;lakdas;lTexxxxx"));

        accordionList.push(accordionItems).build();
        //setContentView(constraintLayout);

        //buildConstraintLayout();
    }


}
