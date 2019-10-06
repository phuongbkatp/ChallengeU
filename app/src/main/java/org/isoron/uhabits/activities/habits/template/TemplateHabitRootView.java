package org.isoron.uhabits.activities.habits.template;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;

import org.isoron.uhabits.R;
import org.isoron.uhabits.activities.ActivityContext;
import org.isoron.uhabits.activities.ActivityScope;
import org.isoron.uhabits.activities.BaseActivity;
import org.isoron.uhabits.activities.BaseRootView;
import org.isoron.uhabits.activities.BaseSystem;

import javax.inject.Inject;

import butterknife.ButterKnife;

@ActivityScope
public class TemplateHabitRootView extends BaseRootView {

    @Inject
    public TemplateHabitRootView (@ActivityContext Context context) {
        super(context);
        addView(inflate(getContext(), R.layout.template_habit_activity, null));
        ButterKnife.bind(this);
    }
    @NonNull
    @Override
    public Toolbar getToolbar() {
        return null;
    }
}
