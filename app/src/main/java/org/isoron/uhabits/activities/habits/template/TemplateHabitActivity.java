package org.isoron.uhabits.activities.habits.template;

import android.os.Bundle;

import org.isoron.uhabits.HabitsApplication;
import org.isoron.uhabits.activities.ActivityModule;
import org.isoron.uhabits.activities.BaseActivity;
import org.isoron.uhabits.activities.ThemeSwitcher;
import org.isoron.uhabits.preferences.Preferences;
import org.isoron.uhabits.utils.MidnightTimer;

public class TemplateHabitActivity extends BaseActivity {


    private TemplateHabitScreen screen;

    private TemplateHabitComponent component;

    private boolean pureBlack;

    private Preferences prefs;

    private MidnightTimer midnightTimer;
    private TemplateHabitRootView rootView;

    public TemplateHabitComponent getListHabitsComponent()
    {
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        HabitsApplication app = (HabitsApplication) getApplicationContext();

        component = DaggerTemplateHabitComponent
                .builder()
                .appComponent(app.getComponent())
                .activityModule(new ActivityModule(this))
                .build();

        TemplateHabitController controller = component.getController();
        
        rootView = component.getRootView();

        screen = component.getScreen();

        prefs = app.getComponent().getPreferences();
        pureBlack = prefs.isPureBlackEnabled();

        screen.setController(controller);

        midnightTimer = component.getMidnightTimer();

        setScreen(screen);
    }

    @Override
    protected void onPause()
    {
        midnightTimer.onPause();
        screen.onDettached();
        super.onPause();
    }

    @Override
    protected void onResume()
    {
        screen.onAttached();
        midnightTimer.onResume();

        if (prefs.getTheme() == ThemeSwitcher.THEME_DARK &&
                prefs.isPureBlackEnabled() != pureBlack)
        {
            restartWithFade();
        }

        super.onResume();
    }
}
