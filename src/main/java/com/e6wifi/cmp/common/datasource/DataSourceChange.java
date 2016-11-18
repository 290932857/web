package com.e6wifi.cmp.common.datasource;

public class DataSourceChange {

	/**
	 * 切换数据源工具类，将数据源切换为16wifi_record
	 * 
	 * @param dataSource
	 */
	public static void dataToRecord() {
		String oldSource = DataSourceContextHolder.getDataSourceType();
		if (!(DataSourceType.dataSource_16wifi_record.equals(oldSource))) {
			DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_16wifi_record);
		}
	}

	/**
	 * 切换数据源工具类，将数据源切换为16wifi_device
	 * 
	 * @param dataSource
	 */
	public static void dataToDevice() {
		String oldSource = DataSourceContextHolder.getDataSourceType();
		if (!(DataSourceType.dataSource_16wifi_device.equals(oldSource))) {
			DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_16wifi_device);
		}
	}

	/**
	 * 切换数据源工具类，将数据源切换为16wifi_content_platform
	 * 
	 * @param dataSource
	 */
	public static void dataToPlatform() {
		String oldSource = DataSourceContextHolder.getDataSourceType();
		if (!(DataSourceType.dataSource_16wifi_content_platform.equals(oldSource))) {
			DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource_16wifi_content_platform);
		}
	}

}
