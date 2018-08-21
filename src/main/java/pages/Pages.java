package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.callDoctor.*;

public class Pages extends BasePage {

    public Pages(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginPage() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        return loginPage;
    }

    public FindPatientPage findPatientPage() {
        FindPatientPage findPatientPage = PageFactory.initElements(driver, FindPatientPage.class);
        return findPatientPage;
    }

    public RecordDoctorPage recordDoctorPage() {
        RecordDoctorPage recordDoctorPage = PageFactory.initElements(driver, RecordDoctorPage.class);
        return recordDoctorPage;
    }

    public WaitingListPage waitingListPage() {
        WaitingListPage waitingListPage = PageFactory.initElements(driver, WaitingListPage.class);
        return waitingListPage;
    }

    public ApoinmentsPage apoinmentsPage() {
        ApoinmentsPage apoinmentsPage = PageFactory.initElements(driver, ApoinmentsPage.class);
        return apoinmentsPage;
    }

    public PatientRecordsPage patientRecordsPage() {
        PatientRecordsPage patientRecordsPage = PageFactory.initElements(driver, PatientRecordsPage.class);
        return patientRecordsPage;
    }

    public CallDoctorPage callDoctorPage() {
        CallDoctorPage callDoctorPage = PageFactory.initElements(driver, CallDoctorPage.class);
        return callDoctorPage;
    }

    public CallCenterTests callCentreTests() {
        CallCenterTests callCenterTests = PageFactory.initElements(driver, CallCenterTests.class);
        return callCenterTests;
    }

}

//    public steps.AdmissionSchedule admissionSchedule() {
//        steps.AdmissionSchedule admissionSchedule = PageFactory.initElements(driver, steps.AdmissionSchedule.class);
//        return admissionSchedule;
//    }
//
//    public steps.TransferRecords transferRecords() {
//        steps.TransferRecords transferRecords = PageFactory.initElements(driver, steps.TransferRecords.class);
//        return transferRecords;
//    }
//
//    public steps.LoginPage loginPage() {
//        steps.LoginPage loginPage = PageFactory.initElements(driver, steps.LoginPage.class);
//        return loginPage;
//    }


