package org.isoron.uhabits.activities.habits.template;

import org.isoron.uhabits.AppComponent;
import org.isoron.uhabits.activities.ActivityModule;
import org.isoron.uhabits.activities.ActivityScope;
import org.isoron.uhabits.utils.MidnightTimer;

import dagger.Component;

@ActivityScope
@Component(modules = { ActivityModule.class },
        dependencies = { AppComponent.class })
public interface TemplateHabitComponent {

    TemplateHabitController getController();

    TemplateHabitRootView getRootView();

    TemplateHabitScreen getScreen();

    MidnightTimer getMidnightTimer();
}
