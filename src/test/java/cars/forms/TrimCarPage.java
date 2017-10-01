package cars.forms;

import cars.forms.elements.TrimTable;
import framework.BaseForm;

public class TrimCarPage extends BaseForm{
    private TrimTable trimTable = new TrimTable();

    public TrimTable getTrimTable() {
        return trimTable;
    }
}
