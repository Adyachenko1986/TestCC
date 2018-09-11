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

        @Step("завершаю последний вызов пациента")
        public static void finalizeTestCalls() {
            String url = connectionUrl +
                    ";databaseName=" + databaseName +
                    ";user=" + userName +
                    ";password=" + password;
            try {
                System.out.print("Connecting to SQL Server ... ");
                try (Connection connection = DriverManager.getConnection(url)) {
                    String sql =
                            "update hlt_calldoctor " +
                                    "set rf_CallDoctorStatusID = 4 " +
                                    "where CallDoctorID = (select MAX (CallDoctorID) from hlt_calldoctor where Family = 'Астахова')";

                    try (Statement statement = connection.createStatement()) {
                        statement.executeUpdate(sql);
                        System.out.println("Finalize is done.");
                    }
                }
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
        }

        @Step("удаляю последнюю запись к врачу")
        public static void finalizeTestRecord() {
            String url = connectionUrl +
                    ";databaseName=" + databaseName +
                    ";user=" + userName +
                    ";password=" + password;
            try {
                System.out.print("Connecting to SQL Server ... ");
                try (Connection connection = DriverManager.getConnection(url)) {
                    String sql =
                            "delete top 1 * from hlt_DoctorVisitTable where rf_MKABID = 2723288 order by DoctorVisitTableID desc";

                    try (Statement statement = connection.createStatement()) {
                        statement.executeUpdate(sql);
                        System.out.println("Finalize is done.");
                    }
                }
            } catch (Exception e) {
                System.out.println();
                e.printStackTrace();
            }
        }

}
