package com.e6wifi.cmp.common.datasource;

/**
 * DataSource切换工具类
 * 
 * @author Lijiacheng
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSourceType(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDataSourceType() {
        return ((String) contextHolder.get());
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

}
