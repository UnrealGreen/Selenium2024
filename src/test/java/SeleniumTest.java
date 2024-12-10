import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import java.io.File;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class SeleniumTest {
    public static  ChromeOptions options;
    public static WebDriver driver;
    public static File complaintUploadFile = new File("C:\\Users\\thatr\\Documents\\Java\\AutomationTestingMaven\\MavenAutomationTesting\\src\\test\\resources\\FilesToUpload\\FilingExample.pdf");


    @BeforeTest
    public  static void Setup(){
        //Test


        options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thatr\\Documents\\Java\\AutomationTestingMaven\\MavenAutomationTesting\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver(options);



        driver.get("https://testefile.courtswva.com/Default.aspx?ReturnUrl=%2fPages%2fDesktop.aspx");

    }

    @Test
    void LogIntoWV() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(By.id("ctl00_MainHolder_cpnlDefault_ASPxRoundPanel1_txtUserId_I")).sendKeys("kgreen@i3verticals.com");
        driver.findElement(By.id("ctl00_MainHolder_cpnlDefault_ASPxRoundPanel1_txtPassword_I")).sendKeys("Playstationvsxbox88!");
        driver.findElement(By.id("ctl00_MainHolder_cpnlDefault_ASPxRoundPanel1_btnLogin_CD")).click();

        //click on complaints dropdown
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_mnuMain_DXI1_P")).click();
        driver.findElement(By.id("ctl00_mnuMain_DXI1i0_")).click();
        driver.findElement(By.linkText("New Complaint")).click();

        //File the complaint
        WebElement countyDropdown = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlComplaint_cpnlNewCase_lstCounty_I"));
        WebElement CaseTypeDropdown = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlComplaint_cpnlNewCase_lstCaseType_I"));


        //CountyDropdown
        countyDropdown.click();
        countyDropdown.sendKeys("test");
        countyDropdown.click();

        //Case Type Dropdown
        CaseTypeDropdown.click();
        CaseTypeDropdown.sendKeys("Civil");
        Thread.sleep(2000);
        CaseTypeDropdown.sendKeys(Keys.DOWN);
        CaseTypeDropdown.click();



        //Complaint Type
        Thread.sleep(2000);
        WebElement complaintType = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlComplaint_cpnlNewCase_lstCaseSubType_I"));
        complaintType.click();

        for (int i = 0; i < 3; i++ ){
            complaintType.sendKeys(Keys.DOWN);

        }

        complaintType.click();

        //Click Next
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlComplaint_cpnlNewCase_btnNewCaseNext_CD")).click();

        //Planitiffs tab
        Thread.sleep(5000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_mnuParty_DXI1_Img")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtFirstName_I")).sendKeys("Darrel");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtMiddleName_I")).sendKeys("Harlen");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtLastName_I")).sendKeys("Smith");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtAddress1_I")).sendKeys("87 East Break Road");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtCity_I")).sendKeys("Shreveport");

        WebElement stateDropDown = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_lstState_B-1Img"));
        stateDropDown.click();
        Thread.sleep(2000);
        stateDropDown.click();
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtZip_I")).sendKeys("71004");
        WebElement genderDropdown = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_lstSex_I"));
        Thread.sleep(2000);
        genderDropdown.sendKeys("Male");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtDateOfBirth_I")).sendKeys("04/11/1992");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_popEditParty_TPCFm1_btnOk_CD")).click();
        Thread.sleep(2000);
        driver.findElement((By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPlaintiffs_cpnlEditParty_btnNext_CD"))).click();

        //Defendants tab
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_mnuParty_DXI1_T")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_lstServiceType_B-1")).click();
        Thread.sleep(2000);
        WebElement serviceType = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_lstServiceType_I"));//ServiceType
        serviceType.sendKeys(Keys.DOWN);
        serviceType.sendKeys(Keys.ENTER);
        Thread.sleep(2000); // Page Reloads after selecting a service type
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtFirstName_I")).sendKeys("Darrel");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtMiddleName_I")).sendKeys("Harlen");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtLastName_I")).sendKeys("Smith");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtAddress1_I")).sendKeys("87 East Break Road");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtCity_I")).sendKeys("Shreveport");

        WebElement stateDropDown2 = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_lstState_B-1Img"));
        stateDropDown2.click();
        Thread.sleep(2000);
        stateDropDown2.click();
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtZip_I")).sendKeys("71004");
        WebElement genderDropdown2 = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_lstSex_I"));
        Thread.sleep(2000);
        genderDropdown2.sendKeys("Male");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_pgEditParty_ctrlEditParty_txtDateOfBirth_I")).sendKeys("04/11/1992");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_popEditParty_TPCFm1_btnOk_CD")).click();
        Thread.sleep(2000);
        driver.findElement((By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDefendants_cpnlEditParty_btnNext_CD"))).click();

        //CIS tab
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlCIS_btnNext_CD")).click();

        //Documents Tab
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDocuments_mnuDocument_DXI1_T")).click();
        Thread.sleep(2000);
        //Uploading Document
        WebElement documentUpload = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDocuments_cpnlEditDocument_pnlEditDocument_popEditDocument_uplDocument_TextBox0_Input"));
        Thread.sleep(2000);
        documentUpload.sendKeys(complaintUploadFile.getAbsolutePath());
        //Choosing the type
        WebElement fileType = driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDocuments_cpnlEditDocument_pnlEditDocument_popEditDocument_lstDocumentType_I"));
        fileType.click();
        Thread.sleep(2000);
        fileType.sendKeys(Keys.DOWN);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDocuments_cpnlEditDocument_pnlEditDocument_popEditDocument_txtDescription_I")).sendKeys("Test Description");
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDocuments_cpnlEditDocument_pnlEditDocument_popEditDocument_TPCFm1_btnUpload_CD")).click();
        Thread.sleep(6000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlDocuments_btnNext_CD")).click();

        //Payment Summary tab
        Thread.sleep(6000);
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPaymentSummary_cpnlPaymentSummary_chkDisclaimer_S_D")).click();
        driver.findElement(By.id("ctl00_MainHolder_cpnlNewFiling_pnlNewFiling_pgNewFiling_ctrlPaymentSummary_cpnlPaymentSummary_btnNext_CD")).click();







        






    }



}
