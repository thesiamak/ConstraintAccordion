package ir.drax.constraintaccordionlist;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.widget.CardView;
import android.text.method.ScrollingMovementMethod;
import android.text.util.Linkify;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AccordionList extends ConstraintLayout {

    private String HEADER_TITLE_COLOR = "#ffffffff";
    private String HEADER_BG_COLOR = "#FF827717";

    private int count,selected = 0;

    private CardView contentView;
    private ArrayList<AccordionItem> accordionItems = new ArrayList<>();
    private int CONTENT_VIEW_ID = 951753;
    private int CONTENT_ARROW_ID = 952753;
    private int ARROW_ICON = android.R.drawable.ic_media_play;
    private int density ;
    private Typeface face;


    public AccordionList(Context context) {
        super(context);
    }

    public AccordionList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AccordionList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AccordionList push(ArrayList<AccordionItem> accordionItems){
        this.accordionItems.addAll(accordionItems);
        return this;
    }

    public AccordionList push(AccordionItem accordionItem){
        this.accordionItems.add( accordionItem);
        return this;
    }

    public AccordionList clear(){
        this.accordionItems.clear();
        return this;
    }

    public void build(){
        density = (int) (4/getContext().getResources().getDisplayMetrics().density) ;
        contentView= getContentView();
        addView(contentView);
        count = accordionItems.size();
        for (int i = 0; i < count; i++) {

            RelativeLayout titleView = getTitleView();

            titleView.setId( (i+1) * 2505);
            ((TextView)titleView.findViewById(CONTENT_VIEW_ID))
                    .setText(accordionItems.get(i).getTitle());

            accordionItems.get(i).setView(titleView);
        }

        ConstraintSet set = new ConstraintSet();

        for (int i = 0; i < count; i++) {
            View view = accordionItems.get(i).getView();
            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClicked((RelativeLayout) view, finalI);
                }
            });
            addView(view);

            set.clone(this);

            set.connect(view.getId(), ConstraintSet.TOP, i == 0 ? ConstraintSet.PARENT_ID : accordionItems.get(i-1).getView().getId(), i == 0 ? ConstraintSet.TOP : ConstraintSet.BOTTOM);
            set.connect(view.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
            set.connect(view.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

            set.applyTo(this);

        }



        set.clone(this);
        set.connect(contentView.getId(), ConstraintSet.TOP, accordionItems.get(count-1).getView().getId(), ConstraintSet.BOTTOM);
        set.connect(contentView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(contentView.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

        set.applyTo(this);

        itemClicked((RelativeLayout) accordionItems.get(selected).getView(),selected);
    }

    private CardView getContentView() {
        CardView cardView = new CardView(getContext());
        cardView.setId(CONTENT_VIEW_ID - 1);
        cardView.setCardElevation(7.0f);
        //cardView.setcard

        cardView.setUseCompatPadding(true);

        cardView.setContentPadding(12, 12, 12, 12);
        //cardView.scrolla
        LayoutParams layout_764 = new LayoutParams(0, 0);
        cardView.setLayoutParams(layout_764);


        TextView content = new TextView(getContext());
        content.setId(CONTENT_VIEW_ID);
        content.setGravity(Gravity.END);
        content.setLinksClickable(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            content.setTextDirection(View.TEXT_DIRECTION_LOCALE);
            content.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
        }

        content.setVerticalScrollBarEnabled(true);
        content.setMovementMethod(new ScrollingMovementMethod());
        content.setTypeface(face);

        LayoutParams layout_36 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        content.setLayoutParams(layout_36);

        cardView.addView(content);

        return cardView;
    }


    private void itemClicked(RelativeLayout  clickedView, int index) {
        ConstraintSet set = new ConstraintSet();
        set.clone(this);

        for (int i = 0; i < count; i++) {

            View view = accordionItems.get(i).getView();
            set.clear(view.getId(), ConstraintSet.BOTTOM);
            set.connect(view.getId(), ConstraintSet.TOP, i == 0 ? ConstraintSet.PARENT_ID : accordionItems.get(i-1).getView().getId(), i == 0 ? ConstraintSet.TOP : ConstraintSet.BOTTOM);

            if (i==index)break;
        }


        for (int i = count -1; i >= 0; i-- ) {
            if (i==index)break;

            View view = accordionItems.get(i).getView();

            set.clear(view.getId(), ConstraintSet.TOP);

            boolean isLast = i == count - 1;

            set.connect(view.getId(), ConstraintSet.BOTTOM,isLast ? ConstraintSet.PARENT_ID : accordionItems.get(i+1).getView().getId(), isLast ? ConstraintSet.BOTTOM : ConstraintSet.TOP);
        }


        set.connect(contentView.getId(), ConstraintSet.TOP, accordionItems.get(index).getView().getId(), ConstraintSet.BOTTOM);
        set.connect(contentView.getId(), ConstraintSet.BOTTOM, index ==  count-1 ? ConstraintSet.PARENT_ID : accordionItems.get(index + 1 ).getView().getId(), index ==  count-1 ? ConstraintSet.BOTTOM : ConstraintSet.TOP);

        ((TextView)contentView.findViewById(CONTENT_VIEW_ID))
                .setText(accordionItems.get(index).getText());

        Linkify.addLinks((TextView)contentView.findViewById(CONTENT_VIEW_ID), Linkify.ALL);
        clickedView
                .findViewById(CONTENT_ARROW_ID)
                .animate()
                .rotation(-90)
                .start();

        if (selected != index)
            accordionItems.get(selected).getView()
                    .findViewById(CONTENT_ARROW_ID)
                    .animate()
                    .rotation(0)
                    .start();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            TransitionManager.beginDelayedTransition(this);
        }
        set.applyTo(this);
        contentView.findViewById(CONTENT_VIEW_ID)
                .scrollTo(0,0);

        selected = index;
    }

    private RelativeLayout getTitleView(){
        RelativeLayout layout = new RelativeLayout(getContext());
        LayoutParams layout_763 = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(layout_763);
        layout.setBackgroundColor(Color.parseColor(HEADER_BG_COLOR));
        /*int[] attrs = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);

        typedArray.recycle();
*/

        TextView tv = new TextView(getContext());
        tv.setMaxLines(1);
        //tv.setBackgroundResource(backgroundResource);
        tv.setTextColor(Color.parseColor(HEADER_TITLE_COLOR));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            tv.setPaddingRelative(density * 12
                    ,density * 2
                    ,density * 12
                    ,density * 2);
        }else
            tv.setPadding(density * 12
                    ,density * 2
                    ,density * 12
                    ,density * 2);
        tv.setTypeface(face);
        tv.setGravity(Gravity.START);
        RelativeLayout.LayoutParams layout_765 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        layout_765.bottomMargin = (int) (density * 2);
        layout_765.topMargin = (int) (density * 2);
        layout_765.addRule(RelativeLayout.ALIGN_PARENT_START, RelativeLayout.TRUE);
        layout_765.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        layout_765.setMargins(density * 8 , 0 , density * 8 , 0);
        tv.setLayoutParams(layout_765);
        tv.setGravity(Gravity.CENTER_VERTICAL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            tv.setId(CONTENT_VIEW_ID);
        }else
            tv.setId(CONTENT_VIEW_ID);
        layout.addView(tv);

        ImageView arrow = new ImageView(getContext());
        RelativeLayout.LayoutParams layout_766 = new RelativeLayout.LayoutParams(density * 10
                , density * 10);
        layout_766.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
        layout_766.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        layout_766.setMargins(density * 8 , 0 , density * 8 , 0);
        arrow.setLayoutParams(layout_766);
        arrow.setId(CONTENT_ARROW_ID);
        arrow.setRotation(0);
        arrow.setImageResource(ARROW_ICON);

        layout.addView(arrow);
        return layout;
    }

    public AccordionList setHEADER_TITLE_COLOR(String HEADER_TITLE_COLOR) {
        this.HEADER_TITLE_COLOR = HEADER_TITLE_COLOR;
        return this;
    }
    public AccordionList setHEADER_TITLE_COLOR(int HEADER_TITLE_COLOR) {
        this.HEADER_TITLE_COLOR = String.format("#%06X", 0xFFFFFF & getResources().getColor(HEADER_TITLE_COLOR));
        return this;
    }

    public AccordionList setHEADER_BG_COLOR(String HEADER_BG_COLOR) {
        this.HEADER_BG_COLOR = HEADER_BG_COLOR;
        return this;
    }

    public AccordionList setHEADER_BG_COLOR(int HEADER_BG_COLOR) {
        this.HEADER_BG_COLOR = String.format("#%06X", 0xFFFFFF & getResources().getColor(HEADER_BG_COLOR));
        return this;
    }

    public AccordionList setARROW_ICON(int ARROW_ICON) {
        this.ARROW_ICON = ARROW_ICON;
        return this;
    }

    public void setFace(int face) {
        //this.face = ResourcesCompat.getFont(getContext(),face);

    }

    public void setFace(String face) {
        //this.face = ResourcesCompat.getFont(getContext(),face);
        this.face = Typeface.createFromAsset(getResources().getAssets(),face);

    }
}

