package org.isoron.uhabits.activities.habits.edit;

import android.os.Bundle;
import android.support.annotation.NonNull;

import org.isoron.uhabits.models.Habit;

import javax.inject.Inject;

public class CreateHabitWithTemplateDialogFactory {

    @Inject
    public CreateHabitWithTemplateDialogFactory() {

    }

    public CreateHabitWithTemplateDialog create(String name, String description)
    {

        CreateHabitWithTemplateDialog dialog = new CreateHabitWithTemplateDialog();
        Bundle args = new Bundle();
        args.putString("name", name);
        args.putString("description", description);
        dialog.setArguments(args);
        return dialog;
    }
}
