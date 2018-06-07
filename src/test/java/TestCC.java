import org.testng.annotations.Test;

public class TestCC extends TestBase {

    @Test
    public void testCallCentr() throws InterruptedException {
        page.loginPage().login();
        page.findPatientPage().findPatient();
        page.recordDoctorPage().recordDoctor();
        page.waitingListPage().waitingList();
        page.apoinmentsPage().apoinmets();
        page.patientRecordsPage().patientRecords();
       // page.callCentreTests().callCentrPage();
        page.callDoctorPage().calldoctor();

    }


}
