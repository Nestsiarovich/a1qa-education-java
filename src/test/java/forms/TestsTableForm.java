package forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import java.util.*;
import java.util.concurrent.TimeoutException;
import static utils.managers.SettingsManager.getTimeoutCondition;

public class TestsTableForm extends BaseForm{
    private static By baseElementLocator = By.xpath("//table[@class = 'table']");
    private ILabel baseElement = getElementFactory().getLabel(baseElementLocator, "BaseElement");
    List<List<ILabel>> cells;
    List<ILabel> headings;
    ILabel dangerAlert;

    protected TestsTableForm() {
        super(baseElementLocator, "TestsTableForm");
        headings = baseElement.findChildElements(By.xpath("//tr[1]//th"), ElementType.LABEL);
        dangerAlert = baseElement.findChildElement(By.xpath("//div[contains(@class, 'alert-danger')]"), ElementType.LABEL);
        getCells();
    }

    private void getCells() {
        List<ILabel> rows = baseElement.findChildElements(By.xpath("//tr"), ElementType.LABEL);
        rows.remove(0);
        cells = new ArrayList<>();
        for (ILabel row : rows) {
            List<ILabel> rowCells = row.findChildElements(By.xpath("//td"), ElementType.LABEL);
            cells.add(rowCells);
        }
    }

    public List<ILabel> getCellsFormColumnByName(String columnName) {
        List<ILabel> columnCells = new ArrayList<>();
        for (int i = 0; i < headings.size(); i++){
            if (headings.get(i).getText().equals(columnName)){
                for (int j = 0; j < cells.size(); j++)
                {
                    columnCells.add(cells.get(j).get(i));
                }
                return columnCells;
            }
        }
        return null;
    }

    public void waitDangerAlertIsNotDisplayed(){
        try {
            AqualityServices.getConditionalWait().waitForTrue(() -> !dangerAlert.state().isDisplayed());
        } catch (TimeoutException timeoutException) {
            throw new RuntimeException(String.format("Form %s doesn't open during %s sec", dangerAlert.getName(), getTimeoutCondition()));
        }
    }
}
