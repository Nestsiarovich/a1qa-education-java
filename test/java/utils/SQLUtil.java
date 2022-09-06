package utils;

import java.sql.*;
import static utils.LoggerUtil.*;
import static utils.JsonReader.getConfig;

public class SQLUtil {

    public static String callStoredProcedureAndPrint1ColumnResult(String storedProcedure) {
        try (Connection connection = DriverManager.getConnection(getConfig("dbURL"), getConfig("dbUsername"), getConfig("dbPassword"));
             CallableStatement callableStatement = connection.prepareCall("CALL " + storedProcedure);
             ResultSet resultSet = callableStatement.executeQuery()){
            logInfo("---Result---");
            String queryResultAsString = "";
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                logInfo(String.format("%s - %s;",
                        resultSetMetaData.getColumnLabel(1), resultSet.getString(1)));
                queryResultAsString += resultSet.getString(1);
            }
            return queryResultAsString;
        } catch (SQLException e) {
            throw new RuntimeException("Error print 1 column result");
        }
    }

    public static String callStoredProcedureAndPrint2ColumnResult(String storedProcedure) {
        try (Connection connection = DriverManager.getConnection(getConfig("dbURL"), getConfig("dbUsername"), getConfig("dbPassword"));
             CallableStatement callableStatement = connection.prepareCall("CALL " + storedProcedure);
             ResultSet resultSet = callableStatement.executeQuery()){
            logInfo("---Result---");
            String queryResultAsString = "";
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                logInfo(String.format("%s - %s; %s - %s",
                        resultSetMetaData.getColumnLabel(1), resultSet.getString(1),
                        resultSetMetaData.getColumnLabel(2), resultSet.getString(2)));
                queryResultAsString += resultSet.getString(1) + " " + resultSet.getString(2);
            }
            return queryResultAsString;
        } catch (SQLException e) {
            throw new RuntimeException("Error print 2 column result");
        }
    }

    public static String callStoredProcedureAndPrint3ColumnResult(String storedProcedure) {
        try (Connection connection = DriverManager.getConnection(getConfig("dbURL"), getConfig("dbUsername"), getConfig("dbPassword"));
             CallableStatement callableStatement = connection.prepareCall("CALL " + storedProcedure);
             ResultSet resultSet = callableStatement.executeQuery()){
            logInfo("---Result---");
            String queryResultAsString = "";
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                logInfo(String.format("%s - %s; %s - %s; %s - %s",
                        resultSetMetaData.getColumnLabel(1), resultSet.getString(1),
                        resultSetMetaData.getColumnLabel(2), resultSet.getString(2),
                        resultSetMetaData.getColumnLabel(3), resultSet.getString(3)));
                queryResultAsString += resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3);
            }
            return queryResultAsString;
        } catch (SQLException e) {
            throw new RuntimeException("Error print 3 column result");
        }
    }
}
