package obProject.test;

import obProject.graph.Layout_overall;
import obProject.graph.myDemo;
import obProject.util.JdbcConnection;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        new Layout_overall();
//        Connection conn=JdbcConnection.getConnection();
//        JdbcConnection.disconnected(conn);
    }
}
