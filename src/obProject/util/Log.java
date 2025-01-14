package obProject.util;

import org.apache.log4j.Logger;
/*
* logger目的为便于调试
* 项目中需要调用static Logger logger=Log.getLogger();获取logger的对象（需要导入log4j包）
* 使用logger.调用对应级别，参量为输出内容
* properties文件中，第一行第一个参量为输出的最低级别，后面的参量为输出的位置，包括输出到控制台和文件
* 级别如下：
* FATAL:非常严重的错误，程序可能终止
* ERROR:有错误但可能能正确运行
* WARN:运行存在潜藏危害
* INFO:报告信息，突出程序运行的进程
* DEBUG:细节信息，用于调试
* */
public class Log {
    public static Logger getLogger(){
        return Logger.getLogger(Log.class.getName());
    }
}
