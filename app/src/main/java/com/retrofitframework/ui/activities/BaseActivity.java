package com.igniva.framework.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by igniva-andriod-11 on 29/4/16.
 */
public abstract class BaseActivity extends AppCompatActivity{

    protected abstract void setUpLayout();
    protected abstract void setDataInViewObjects();
    protected abstract void setUpToolbar();

}
