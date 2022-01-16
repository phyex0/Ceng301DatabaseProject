package Controllers;

import Model.ModelData;
import Model.ModelInterface;
import Model.NopModel;
import Views.MainMenuView;
import Views.ViewData;
import Views.ViewInterface;

public class Controller {

    private ViewInterface view;
    private ModelInterface model;

    public Controller(ViewInterface view, ModelInterface model) {
        this.view = view;
        this.model = model;
    }

    public ModelData executeModel(ViewData viewData) throws Exception {
        return model.execute(viewData);
    }

    public ViewData getView(ModelData modelData, String functionName, String operationName) throws Exception {
        return view.create(modelData, functionName, operationName);
    }

    @Override
    public String toString() {
        return "Controller with " + model + " and " + view;
    }

}
