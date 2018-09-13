package pages;

import pages.callCenter.*;

public class Pages extends AbstractPage {

    public Pages() {
    }

    public LoginPage loginPage() {
        LoginPage loginPage = new LoginPage();//.initElements(driver, LoginPage.class);
        return loginPage;
    }

    public FindPatientPage findPatientPage() {
        FindPatientPage findPatientPage = new FindPatientPage();//.initElements(driver, FindPatientPage.class);
        return findPatientPage;
    }

    public RecordDoctorPage recordDoctorPage() {
        RecordDoctorPage recordDoctorPage = new RecordDoctorPage();//.initElements(driver, RecordDoctorPage.class);
        return recordDoctorPage;
    }

    public WaitingListPage waitingListPage() {
        WaitingListPage waitingListPage = new WaitingListPage();//.initElements(driver, WaitingListPage.class);
        return waitingListPage;
    }

    public DirectionsPage apoinmentsPage() {
        DirectionsPage directionsPage = new DirectionsPage();//.initElements(driver, DirectionsPage.class);
        return directionsPage;
    }

    public PatientRecordsPage patientRecordsPage() {
        PatientRecordsPage patientRecordsPage = new PatientRecordsPage();//.initElements(driver, PatientRecordsPage.class);
        return patientRecordsPage;
    }

    public CallDoctorPage callDoctorPage() {
        CallDoctorPage callDoctorPage = new CallDoctorPage();//.initElements(driver, CallDoctorPage.class);
        return callDoctorPage;
    }

    public CallCenterTests callCentreTests() {
        CallCenterTests callCenterTests = new CallCenterTests();//.initElements(driver, CallCenterTests.class);
        return callCenterTests;
    }

    public Mis mis() {
        Mis mis = new Mis();//.initElements(driver, CallCenterTests.class);
        return mis;
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


