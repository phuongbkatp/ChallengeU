package org.isoron.uhabits.activities.habits.edit;

import android.graphics.drawable.Drawable;

import org.isoron.uhabits.R;
import org.isoron.uhabits.commands.Command;
import org.isoron.uhabits.models.Frequency;


public class CreateHabitWithTemplateDialog extends BaseDialog {

    @Override
    protected int getTitle()
    {
        return R.string.create_habit;
    }

    @Override
    protected void initializeHabits()
    {
        String name = (String) getArguments().getString("name");
        String description = (String) getArguments().getString("description");
        int iconUrl = (int) getArguments().getInt("icon");
        Drawable icon = getResources().getDrawable(iconUrl);
        modifiedHabit = modelFactory.buildHabit();
        modifiedHabit.setFrequency(Frequency.DAILY);
        modifiedHabit.setName(name);
        modifiedHabit.setHabitIcon(icon);
        modifiedHabit.setDescription(description);
        modifiedHabit.setColor(
                prefs.getDefaultHabitColor(modifiedHabit.getColor()));
    }

    @Override
    protected void saveHabit()
    {
        Command command = appComponent
                .getCreateHabitCommandFactory()
                .create(habitList, modifiedHabit);
        commandRunner.execute(command, null);
    }

}
