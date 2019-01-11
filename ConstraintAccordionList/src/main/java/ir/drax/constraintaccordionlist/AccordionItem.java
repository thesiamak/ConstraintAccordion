package ir.drax.constraintaccordionlist;

import android.graphics.Paint;
import android.view.ViewGroup;

public class AccordionItem{
    private String title;
    private String text;
    private Paint.Align alignment = null;
    private ViewGroup view;
    private boolean isText = true;

    public AccordionItem(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public AccordionItem(String title, String text, Paint.Align alignment) {
        this.title = title;
        this.text = text;
        this.alignment = alignment;
    }

    public AccordionItem(String title, String text, ViewGroup view) {
        this.title = title;
        this.text = text;
        this.view = view;
        if (text.trim().length()>6)//it must be at least 7 character to be html tag : '<b></b>'
            if (text.trim().startsWith("<") && text.trim().endsWith(">"))//so probably text has html tags
                isText = false;
    }

    public AccordionItem(String title, String text, Paint.Align alignment, ViewGroup view) {
        this.title = title;
        this.text = text;
        this.alignment = alignment;
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

    public boolean isText() {
        return isText;
    }

    public void parseMarkup(boolean yes) {
        isText = !yes;
    }

    public Paint.Align getAlignment() {
        return alignment;
    }
}
