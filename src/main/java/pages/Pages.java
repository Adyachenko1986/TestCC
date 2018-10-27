package pages;

import pages.callCenter.*;

import static com.codeborne.selenide.Selenide.page;

public class Pages extends AbstractPage {

    public Pages() {
    }

    public LoginPage loginPage() {
//        LoginPage loginPage = new LoginPage();//.initElements(driver, LoginPage.class);
        return page(LoginPage.class);
    }

    public FindPatientPage findPatientPage() {
//        FindPatientPage findPatientPage = new FindPatientPage();//.initElements(driver, FindPatientPage.class);
        return page(FindPatientPage.class);
    }

    public RecordDoctorPage recordDoctorPage() {
//        RecordDoctorPage recordDoctorPage = new RecordDoctorPage();//.initElements(driver, RecordDoctorPage.class);
        return page(RecordDoctorPage.class);
    }

    public WaitingListPage waitingListPage() {
//        WaitingListPage waitingListPage = new WaitingListPage();//.initElements(driver, WaitingListPage.class);
        return page(WaitingListPage.class);
    }

    public DirectionsPage apoinmentsPage() {
//        DirectionsPage directionsPage = new DirectionsPage();//.initElements(driver, DirectionsPage.class);
        return page(DirectionsPage.class);
    }

    public PatientRecordsPage patientRecordsPage() {
//        PatientRecordsPage patientRecordsPage = new PatientRecordsPage();//.initElements(driver, PatientRecordsPage.class);
        return page(PatientRecordsPage.class);
    }

    public CallDoctorPage callDoctorPage() {
//        CallDoctorPage callDoctorPage = new CallDoctorPage();//.initElements(driver, CallDoctorPage.class);
        return page(CallDoctorPage.class);
    }

    public CallCenterTests callCentreTests() {
//        CallCenterTests callCenterTests = new CallCenterTests();//.initElements(driver, CallCenterTests.class);
        return page(CallCenterTests.class);
    }

    public Mis mis() {
//        Mis mis = new Mis();//.initElements(driver, CallCenterTests.class);
        return page(Mis.class);
    }

    public Utils utils() {
        return page(Utils.class);
    }

    public TestResponseCode testResponseCode() {
        return page(TestResponseCode.class);
    }

}

//    public steps.AdmissionSchedule admissionSchedule() {
//        steps.AdmissionSchedule admissionSchedule = PageFactory.initElements(driver, steps.AdmissionSchedule.class);
//        return page(admissionSchedule;
//    }
//
//    public steps.TransferRecords transferRecords() {
//        steps.TransferRecords transferRecords = PageFactory.initElements(driver, steps.TransferRecords.class);
//        return page(transferRecords;
//    }
//
//    public steps.LoginPage loginPage() {
//        steps.LoginPage loginPage = PageFactory.initElements(driver, steps.LoginPage.class);
//        return page(loginPage;
//    }


