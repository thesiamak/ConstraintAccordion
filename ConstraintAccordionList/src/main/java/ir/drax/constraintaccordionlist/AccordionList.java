package ir.drax.constraintaccordionlist;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.text.method.ScrollingMovementMethod;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class AccordionList extends ScrollView {

    private Paint.Align TEXT_ALIGNMENT = Paint.Align.LEFT;
    private String TITLE_LAYOUT_NAME = "constraint_accordion_title";
    private String HEADER_TITLE_COLOR = "#ffffffff";
    private String HEADER_BG_COLOR = "#FF827717";
    private int CONTENT_PADDING_TOP = 12;
    private int CONTENT_PADDING_BOTTOM = 42;

    private int count,selected = 0;

    private LinearLayout contentView;
    private ArrayList<AccordionItem> accordionItems = new ArrayList<>();
    private int CONTENT_VIEW_ID = Util.genRandId();
    private int TITLE_VIEW_ID = Util.genRandId();
    private int CONTENT_ARROW_ID = Util.genRandId();
    private int ARROW_ICON = android.R.drawable.ic_media_play;
    private int density ;
    private Typeface face;
    private String TAG = getClass().getSimpleName();
    private ConstraintLayout root;
    private int CONTENT_MIN_HEIGHT = 500;
    private String CONTENT_LAYOUT_NAME = "constraint_accordion_content";

    private void preConfig(){
        setFillViewport(true);
        density = (int) (4/getContext().getResources().getDisplayMetrics().density) ;
        contentView = getContentView();
        root = getConstraintLayout();
    }

    public AccordionList(Context context) {
        super(context);
        preConfig();
    }

    public AccordionList(Context context, AttributeSet attrs) {
        super(context, attrs);
        preConfig();
    }

    public AccordionList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        preConfig();
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
        removeAllViews();

        if (root != null)
            root.removeAllViews();

        if (contentView.getParent() == null)
            root.addView(contentView);

        count = accordionItems.size();

        for (int i = 0; i < count; i++) {

            LinearLayout titleView = getTitleView(i);
            titleView.setId( i + 1);

            TextView title = titleView.findViewById(TITLE_VIEW_ID);
            title.setText(accordionItems.get(i).getTitle());

            accordionItems.set(i , new AccordionItem(
                    accordionItems.get(i).getTitle()
                    ,accordionItems.get(i).getText()
                    ,accordionItems.get(i).getAlignment()
                    ,titleView));

        }

        ConstraintSet set = new ConstraintSet();

        for (int i = 0; i < count; i++) {
            View view = accordionItems.get(i).getView();
            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClicked((ViewGroup) view, finalI);
                }
            });


            root.addView(view);


            set.clone(root);

            set.connect(view.getId(), ConstraintSet.TOP, i == 0 ? ConstraintSet.PARENT_ID : accordionItems.get(i-1).getView().getId(), i == 0 ? ConstraintSet.TOP : ConstraintSet.BOTTOM);
            set.connect(view.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
            set.connect(view.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

            set.applyTo(root);
        }

        set.clone(root);
        set.connect(contentView.getId(), ConstraintSet.TOP, accordionItems.get(count-1).getView().getId(), ConstraintSet.BOTTOM);
        set.connect(contentView.getId(), ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START);
        set.connect(contentView.getId(), ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END);

        set.applyTo(root);

        if (getChildCount()==0){
            addView(root);
        }

        itemClicked(accordionItems.get(selected).getView(),selected);//select first item as default
    }

    private ConstraintLayout getConstraintLayout() {
        ConstraintLayout layout = new ConstraintLayout(getContext());
        layout.setLayoutParams(new ScrollView.LayoutParams(
                ScrollView.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT
        ));


        return layout;
    }

    private LinearLayout getContentView() {
        LinearLayout contentLayout;
        final JustifiedTextView content;

        int layoutId = getContext().getResources().getIdentifier(CONTENT_LAYOUT_NAME,"layout",getContext().getPackageName());
        Log.e(TAG,layoutId + "");

        if (layoutId > 0){
            contentLayout = (LinearLayout) ((Activity) getContext()).getLayoutInflater().inflate(layoutId, null);
            contentLayout.addOnLayoutChangeListener(new OnLayoutChangeListener() {
                @Override
                public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                    if (contentView.getHeight() < CONTENT_MIN_HEIGHT){
                        configParentsToHandleContentNewHeight();
                    }
                }
            });

            content = contentLayout.findViewWithTag(CONTENT_LAYOUT_NAME);

        }else {
            contentLayout = new LinearLayout(getContext()) {
                @Override
                protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                    super.onLayout(changed, left, top, right, bottom);
                    if (changed)
                        if (contentView.getHeight() < CONTENT_MIN_HEIGHT) {
                            configParentsToHandleContentNewHeight();
                        }
                }
            };
            contentLayout.setPadding(12, CONTENT_PADDING_TOP, 12, CONTENT_PADDING_BOTTOM);

            content = new JustifiedTextView(getContext());
            content.setGravity(Gravity.END);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                content.setTextDirection(View.TEXT_DIRECTION_LOCALE);
                content.setLayoutDirection(View.LAYOUT_DIRECTION_LOCALE);
            }

            contentLayout.addView(content);
        }

        content.setId(CONTENT_VIEW_ID);
        contentLayout.setId(CONTENT_VIEW_ID - 1);

        LayoutParams layout_764 = new LayoutParams(0, 0);
        contentLayout.setLayoutParams(layout_764);

        content.setLinksClickable(true);



        content.setVerticalScrollBarEnabled(true);
        content.setOverScrollMode(OVER_SCROLL_ALWAYS);
        content.setScrollBarStyle(SCROLLBARS_INSIDE_INSET);
        content.setMovementMethod(new ScrollingMovementMethod());

        content.setTypeface(face);


        content.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (v.getId() == CONTENT_VIEW_ID) {
                    if ((v.getHeight() + (CONTENT_PADDING_BOTTOM+CONTENT_PADDING_TOP)) <contentView.getHeight()) return false;//if no need to scroll
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_UP:
                            v.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });

        content.getViewTreeObserver()
                .addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        if (!content.canScrollVertically(1)) {//to continue scrolling the list if content scrolling ended from bottom
                            // bottom of scroll view
                            content.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                        if (!content.canScrollVertically(-1)) {//to continue scrolling the list if content scrolling ended from top
                            // top of scroll view
                            content.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                });

        LinearLayout.LayoutParams layout_36 = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        content.setLayoutParams(layout_36);

        return contentLayout;
    }


    private void itemClicked(ViewGroup clickedView, int index) {
        ConstraintSet set = new ConstraintSet();
        set.clone(root);

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

        JustifiedTextView textView = contentView.findViewById(CONTENT_VIEW_ID);
        textView.setText(accordionItems.get(index).getText(),true);

        if (accordionItems.get(index).getAlignment() != null)
            JustifiedTextView._align = accordionItems.get(index).getAlignment();
        else
            JustifiedTextView._align = TEXT_ALIGNMENT;

        clickedView
                .findViewById(CONTENT_ARROW_ID)
                .animate()
                .rotation(90)
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
        set.applyTo(root);
        contentView.findViewById(CONTENT_VIEW_ID)
                .scrollTo(0,0);

        selected = index;
    }

    private LinearLayout getTitleView(int index){
        LinearLayout layout;
        TextView tv;
        ImageView arrow;

        int layoutId = getContext().getResources().getIdentifier(TITLE_LAYOUT_NAME,"layout",getContext().getPackageName());
        Log.e(TAG,layoutId + "");

        if (layoutId > 0){
            layout = (LinearLayout) ((Activity) getContext()).getLayoutInflater().inflate(layoutId, null);

            tv = layout.findViewWithTag(TITLE_LAYOUT_NAME);
            arrow = layout.findViewWithTag(TITLE_LAYOUT_NAME+"_arrow");


            Drawable background = layout.getBackground();
            if (background instanceof ColorDrawable)
                layout.setBackgroundColor(index%2>0 ? ((ColorDrawable) background).getColor() : ((ColorDrawable) background).getColor()+20);



        }else {
            layout = new LinearLayout(getContext());
            layout.setOrientation(LinearLayout.HORIZONTAL);
            tv = new TextView(getContext());
            tv.setMaxLines(1);
            //tv.setBackgroundResource(backgroundResource);
            tv.setTextColor(Color.parseColor(HEADER_TITLE_COLOR));

            tv.setPadding(density * 12
                    ,density * 2
                    ,density * 12
                    ,density * 2);
            tv.setTypeface(face);
            tv.setGravity(Gravity.START);
            LinearLayout.LayoutParams layout_765 = new LinearLayout.LayoutParams(0,LayoutParams.WRAP_CONTENT);
            layout_765.weight = 0.9f;
            layout_765.bottomMargin = (int) (density * 2);
            layout_765.topMargin = (int) (density * 2);

            layout_765.setMargins(density * 8 , 0 , density * 8 , 0);
            tv.setLayoutParams(layout_765);
            tv.setGravity(Gravity.CENTER_VERTICAL);

            layout.addView(tv);

            arrow = new ImageView(getContext());
            LinearLayout.LayoutParams layout_766 = new LinearLayout.LayoutParams(0
                    , LinearLayout.LayoutParams.WRAP_CONTENT);

            layout_766.weight = 0.1f;
            layout_766.setMargins(density * 8 , 0 , density * 8 , 0);
            arrow.setLayoutParams(layout_766);
            arrow.setRotation(0);
            arrow.setImageResource(ARROW_ICON);

            layout.addView(arrow);

            layout.setBackgroundColor(index%2>0 ? Color.parseColor(HEADER_BG_COLOR) : Color.parseColor(HEADER_BG_COLOR)+20);
        }

        ConstraintLayout.LayoutParams layout_763 = new ConstraintLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(layout_763);

        arrow.setId(CONTENT_ARROW_ID);
        tv.setId(TITLE_VIEW_ID);


/*
        int[] attrs = new int[]{R.attr.selectableItemBackground};
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);

        typedArray.recycle();*/



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

    public AccordionList setCONTENT_MIN_HEIGHT(int min_height) {
        this.CONTENT_MIN_HEIGHT= min_height;
        return this;
    }

    public void setFace(int face) {
        //this.face = ResourcesCompat.getFont(getContext(),face);

    }

    public void setFace(String face) {
        //this.face = ResourcesCompat.getFont(getContext(),face);
        this.face = Typeface.createFromAsset(getResources().getAssets(),face);

    }

    private void configParentsToHandleContentNewHeight(){
        ConstraintLayout.LayoutParams layout_765 = (ConstraintLayout.LayoutParams) contentView.getLayoutParams();
        layout_765.height = CONTENT_MIN_HEIGHT;

        contentView.setLayoutParams(layout_765);

        ScrollView.LayoutParams layout_769 = (ScrollView.LayoutParams) root.getLayoutParams();
        layout_769.height = LayoutParams.WRAP_CONTENT;
        root.setLayoutParams(layout_769);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (changed){
            CONTENT_MIN_HEIGHT=getHeight()/2;
            build();
            //itemClicked(accordionItems.get(selected).getView(),selected);//select first item as default
        }
    }

    public AccordionList setTextAlign(Paint.Align textAlign){
        TEXT_ALIGNMENT=textAlign;
        return this;
    }
}

