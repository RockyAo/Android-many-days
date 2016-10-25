package com.ao.rocky.firstandroid.Common;

/**
 * Created by Administrator on 2016/10/25 0025.
 *
 * 配置接口请求地址
 */

public class AppNetConfig {

	public static final String host = "192.168.1.121:8080";
	public static final String baseURL = "http://" + host +"/P2PInvest/";
	public static final String login = baseURL + "login";
	public static final String product = baseURL + "product";
	public static final String home = baseURL + "index";
}
