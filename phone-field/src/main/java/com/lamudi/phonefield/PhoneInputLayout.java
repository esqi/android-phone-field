package com.lamudi.phonefield;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;

/**
 * Implementation of PhoneField that uses {@link TextInputLayout}
 * Created by Ismail on 5/6/16.
 */
public class PhoneInputLayout extends PhoneField {

    private TextInputLayout mTextInputLayout;

    private String mPrompt;

    private String mHint;

    public PhoneInputLayout(Context context) {
        this(context, null);
    }

    public PhoneInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PhoneInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.PhoneInputLayout,
                0, 0);

        try {
            setPrompt(a.getString(R.styleable.PhoneInputLayout_prompt));
            setHint(a.getString(R.styleable.PhoneInputLayout_hint));
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void updateLayoutAttributes() {
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        setGravity(Gravity.TOP);
        setOrientation(HORIZONTAL);
    }

    @Override
    protected void prepareView() {
        super.prepareView();
        mTextInputLayout = (TextInputLayout) findViewWithTag(getResources().getString(R.string.com_lamudi_phonefield_til_phone));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.phone_text_input_layout;
    }

    @Override
    public void setHint(int resId) {
        mHint = getContext().getString(resId);
        mTextInputLayout.setHint(mHint);
    }

    @Override
    public void setHint(String hint) {
        mHint = hint;
        mTextInputLayout.setHint(mHint);
    }

    public void setPrompt(String prompt){
        this.mPrompt = prompt;
        getSpinner().setPrompt(mPrompt);
    }

    @Override
    public void setError(String error) {
        if (error == null || error.length() == 0) {
            mTextInputLayout.setErrorEnabled(false);
        } else {
            mTextInputLayout.setErrorEnabled(true);
        }
        mTextInputLayout.setError(error);
    }

    public TextInputLayout getTextInputLayout() {
        return mTextInputLayout;
    }
}
