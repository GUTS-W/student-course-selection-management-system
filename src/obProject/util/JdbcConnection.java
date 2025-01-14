package obProject.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/*
* 提供三个接口分别是getConnection，返回Connection类型的对象
*               disconnect，断开连接
*               closeAll，断开connection、rs和stmt
*               ExecuteUpdate，通过给定的sql语句和obj信息，进行增删改操作
* */
public class JdbcConnection {
    private static final String driver,url,username,password;
    static Logger logger=Log.getLogger();
    static{
        try {
            InputStream input=JdbcConnection.class.getResourceAsStream("/jdbc.properties");
            Properties properties=new Properties();
            properties.load(input);
            driver=properties.getProperty("driver");
            url= properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        Connection conn;
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,username,password);
            logger.debug("sql连接成功");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static void disconnected(Connection conn){
        if(conn==null){
            logger.warn("conn为空");
            return;
        }
        try {
            conn.close();
            logger.debug("sql关闭连接");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeAll(Connection conn, ResultSet rs, PreparedStatement pStmt){
        disconnected(conn);
        try {
            pStmt.close();
            logger.debug("stmt关闭");
            rs.close();
            logger.debug("rs关闭");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int ExecuteUpdate(String sql,Object[] obj){
        int update=0;
        try {
            Connection conn=JdbcConnection.getConnection();
            PreparedStatement pStmt=conn.prepareStatement(sql);
            for(int i=0;i<obj.length;i++)
                pStmt.setObject(i+1,obj[i]);
            logger.debug("stmt创建成功"+pStmt);
            update=pStmt.executeUpdate();
            logger.debug("sql执行成功，共变化了"+update+"行");
            JdbcConnection.disconnected(conn);
            pStmt.close();
            logger.debug("stmt关闭");
            return update;
        } catch (SQLException e) {
            logger.debug("sql执行失败");
            return update;
            //throw new RuntimeException(e);
        }
    }
}
