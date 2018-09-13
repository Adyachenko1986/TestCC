package pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import pages.AbstractPage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Map;

    public class SQL extends AbstractPage {
        private static String connectionUrl = "jdbc:sqlserver://12.8.1.66";
        private static String databaseName = "hlt_demonstration";
        private static String userName = "sa";
        private static String password = "sagfhjkzYES!";

//        @Step("завершаю последний вызов пациента")
//        public static void finalizeTestCalls() {
//            String url = connectionUrl +
//                    ";databaseName=" + databaseName +
//                    ";user=" + userName +
//                    ";password=" + password;
//            try {
//                System.out.print("Connecting to SQL Server ... ");
//                try (Connection connection = DriverManager.getConnection(url)) {
//                    String sql =
//                            "update hlt_calldoctor " +
//                                    "set rf_CallDoctorStatusID = 4 " +
//                                    "where CallDoctorID = (select MAX (CallDoctorID) from hlt_calldoctor where Family = 'Астахова')";
//
//                    try (Statement statement = connection.createStatement()) {
//                        statement.executeUpdate(sql);
//                        System.out.println("Finalize is done.");
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println();
//                e.printStackTrace();
//            }
//        }
//
//        @Step("удаляю последнюю запись к врачу")
//        public static void finalizeTestRecord() {
//            String url = connectionUrl +
//                    ";databaseName=" + databaseName +
//                    ";user=" + userName +
//                    ";password=" + password;
//            try {
//                System.out.print("Connecting to SQL Server ... ");
//                try (Connection connection = DriverManager.getConnection(url)) {
//                    String sql =
//                            "delete top 1 * from hlt_DoctorVisitTable where rf_MKABID = 2723288 order by DoctorVisitTableID desc";
//
//                    try (Statement statement = connection.createStatement()) {
//                        statement.executeUpdate(sql);
//                        System.out.println("Finalize is done.");
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println();
//                e.printStackTrace();
//            }
//        }
//
//        @Step("Удаляю расписание врача {docprvdid} (Селевич Николай Николаевич)")
//        public static void deleteSheduleByPrvdid(String docprvdid) {
//            String url = connectionUrl +
//                    ";databaseName=" + databaseName +
//                    ";user=" + userName +
//                    ";password=" + password;
//            try {
//                System.out.print("Connecting to SQL Server ... ");
//                try (Connection connection = DriverManager.getConnection(url)) {
//                    String sql =
//                            "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable where rf_DocPRVDID = '1290'";
//                    try (Statement statement = connection.createStatement()) {
//                        statement.executeUpdate(sql);
//                        System.out.println("Table DTT is clean.");
//                        statement.close();
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println();
//                e.printStackTrace();
//            }
//        }
//
//        @Step("Создаю расписание для врача {docprvdid} (Селевич Николай Николаевич)")
//        public static void createShedule(String docprvdid) throws FileNotFoundException {
//            //сгенерировать одну ячейку на сегодня
//            FileInputStream fstream = new FileInputStream("src/main/resources/sql/" + "select_top_10000___from_hlt_DoctorTimeTa.tsv");
//            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
//
//            String url = connectionUrl +
//                    ";databaseName=" + databaseName +
//                    ";user=" + userName +
//                    ";password=" + password;
//            try {
//                System.out.print("Connecting to SQL Server ... ");
//                try (Connection connection = DriverManager.getConnection(url)) {
//
//                    String sql2 = br.readLine();
//
//                    try (Statement statement = connection.createStatement()) {
//                        statement.executeUpdate(sql2);
//                        System.out.println("Complete!");
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

