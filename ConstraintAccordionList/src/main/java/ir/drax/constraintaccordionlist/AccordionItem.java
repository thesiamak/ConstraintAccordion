package ir.drax.constraintaccordionlist;

import android.widget.RelativeLayout;

public class AccordionItem{
    private String title;
    private String text;
    private RelativeLayout view;

    public AccordionItem(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RelativeLayout getView() {
        return view;
    }

    void setView(RelativeLayout view) {
        this.view = view;
    }
}
