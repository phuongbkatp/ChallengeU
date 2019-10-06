package org.isoron.uhabits.activities.habits.template;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.isoron.uhabits.activities.BaseActivity;
import org.isoron.uhabits.activities.BaseScreen;

import javax.inject.Inject;

public class TemplateHabitScreen extends BaseScreen {

    @Nullable
    private TemplateHabitController controller;

    public TemplateHabitScreen(@NonNull BaseActivity activity) {
        super(activity);
    }

    @Inject
    public TemplateHabitScreen(@NonNull BaseActivity activity,
                               @NonNull TemplateHabitRootView rootView) {
        super(activity);
        setRootView(rootView);
    };

    public void setController(@Nullable TemplateHabitController controller) {
        this.controller = controller;
    }

    public void onDettached() {
    }

    public void onAttached() {

    }


}
