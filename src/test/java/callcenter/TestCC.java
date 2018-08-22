package callcenter;

import org.testng.annotations.Test;

public class TestCC extends AbstractTest {

    @Test
    public void testCallCenter() throws InterruptedException {
        page.loginPage().login();
        page.findPatientPage().findPatient();
        page.recordDoctorPage().recordDoctor();
       // page.waitingListPage().waitingList();
        page.patientRecordsPage().patientRecords();
       // page.apoinmentsPage().apoinmets();
       // page.patientRecordsPage().deleteRecord();
        page.callDoctorPage().calldoctor();
       // page.callCentreTests().callCentrPage();*/
    }


}
