import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SteamPage {
    public SteamPage() {
        PageFactory.initElements(Singleton.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='supernav_container']//a[starts-with(@href,'https://store.steampowered.com/about/')]")
    private WebElement btnAbout;

    @FindBy(xpath = "//div[@class='supernav_container']//a[@data-tooltip-content='.submenu_store']")
    private WebElement btnStore;

    @FindBy(xpath = "//div[contains(@class,'gamers_online')]//parent::div[@class='online_stat']")
    private WebElement txtOnline;

    @FindBy(xpath = "//div[contains(@class,'gamers_in_game')]//parent::div[@class='online_stat']")
    private WebElement txtOnlineInGame;

    public void clickBtnAbout(){
        btnAbout.click();
    }

    public void clickBtnStore(){
        btnStore.click();
    }

    private Integer getTxtOnline(){
        return Integer.parseInt(txtOnline.getText().replaceAll("[^0-9]", ""));
    }

    private Integer getTxtOnlineInGame(){
        return Integer.parseInt(txtOnlineInGame.getText().replaceAll("[^0-9]", ""));
    }

    public boolean isOnlineMoreThenInGame() {
        if (getTxtOnline() > getTxtOnlineInGame())
            return true;
        else
            return false;
    }
}
