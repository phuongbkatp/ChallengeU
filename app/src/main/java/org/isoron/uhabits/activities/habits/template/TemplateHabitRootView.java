package org.isoron.uhabits.activities.habits.template;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import org.isoron.uhabits.R;
import org.isoron.uhabits.activities.ActivityContext;
import org.isoron.uhabits.activities.ActivityScope;
import org.isoron.uhabits.activities.BaseActivity;
import org.isoron.uhabits.activities.BaseRootView;
import org.isoron.uhabits.activities.BaseSystem;
import org.isoron.uhabits.activities.habits.edit.CreateHabitDialogFactory;
import org.isoron.uhabits.activities.habits.edit.CreateHabitWithTemplateDialogFactory;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

@ActivityScope
public class TemplateHabitRootView extends BaseRootView {

    @NonNull
    private final CreateHabitDialogFactory createHabitDialogFactory;
    @NonNull
    private final CreateHabitWithTemplateDialogFactory createHabitWithTemplateDialogFactory;

    @NonNull
    private final BaseActivity activity;

    @OnClick(R.id.your_own_challenge)
    public void onYourOwnChallenge(LinearLayout linearLayout) {
        showCreateSimpleHabitScreen();
    }

    @OnClick(R.id.early_morning_walks)
    public void onEarlyMorningWalk(LinearLayout linearLayout) {
        showCreateEarlyMorningWalkScreen();
    }

    @Inject
    public TemplateHabitRootView (@ActivityContext Context context,
                                  @NonNull BaseActivity activity,
                                  @NonNull CreateHabitDialogFactory createHabitDialogFactory,
                                  @NonNull CreateHabitWithTemplateDialogFactory createHabitWithTemplateDialogFactory) {
        super(context);
        addView(inflate(getContext(), R.layout.template_habit_activity, null));
        ButterKnife.bind(this);
        this.createHabitDialogFactory = createHabitDialogFactory;
        this.createHabitWithTemplateDialogFactory = createHabitWithTemplateDialogFactory;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Toolbar getToolbar() {
        return null;
    }

    public void showCreateSimpleHabitScreen()
    {
        activity.showDialog(createHabitDialogFactory.create(), "editHabit");
    }
    public void showCreateEarlyMorningWalkScreen()
    {
        activity.showDialog(createHabitWithTemplateDialogFactory.create("Early morning walk", "Do you get up early today?", R.drawable.target), "templateHabit");
    }
}
