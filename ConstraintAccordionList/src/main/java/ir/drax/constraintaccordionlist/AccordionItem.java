package ir.drax.constraintaccordionlist;

import android.view.ViewGroup;

public class AccordionItem{
    private String title;
    private String text;
    private ViewGroup view;

    public AccordionItem(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public AccordionItem(String title, String text, ViewGroup view) {
        this.title = title;
        this.text = text;
        this.view = view;
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

    public ViewGroup getView() {
        return view;
    }

    void setView(ViewGroup view) {
        this.view = view;
    }
}
