package ru.alexrojer31.tzinch.technologist.drawings.crystallizerDrawings;

import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import ru.alexrojer31.tzinch.kernel.abstractions.Form;

public class CrystallizerDrawingForm extends Form {

    private final IntegerField size = new IntegerField("Типоразмер");
    private final IntegerField diameter = new IntegerField("Диаметр, мм");
    private final TextField drawing = new TextField("№ Чертежа");

    public CrystallizerDrawingForm() {
        super(new BeanValidationBinder<>(CrystallizerDrawing.class));
        binder.bindInstanceFields(this);
        add(
                size,
                diameter,
                drawing,
                createButtonLayout()
        );
        init();
    }

    private void init() {
        size.setValue(0);
        diameter.setValue(0);
        drawing.setRequired(true);
    }

}
