package com.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Created by bigjsd on 2017/7/8.
 */
public class ProxyTest {
	//测试IP代理
	/*网上IP代理的例子
	 *Properties prop = System.getProperties();
        // 设置http访问要使用的代理服务器的地址
        prop.setProperty("http.proxyHost", "192.168.0.254");
        // 设置http访问要使用的代理服务器的端口
        prop.setProperty("http.proxyPort", "8080");
        // 设置不需要通过代理服务器访问的主机，可以使用*通配符，多个地址用|分隔
        prop.setProperty("http.nonProxyHosts", "localhost|192.168.0.*");
        // 设置安全访问使用的代理服务器地址与端口
        // 它没有https.nonProxyHosts属性，它按照http.nonProxyHosts 中设置的规则访问
        prop.setProperty("https.proxyHost", "192.168.0.254");
        prop.setProperty("https.proxyPort", "443");
        // 使用ftp代理服务器的主机、端口以及不需要使用ftp代理服务器的主机
        prop.setProperty("ftp.proxyHost", "192.168.0.254");
        prop.setProperty("ftp.proxyPort", "2121");
        prop.setProperty("ftp.nonProxyHosts", "localhost|192.168.0.*");
        // socks代理服务器的地址与端口
        prop.setProperty("socksProxyHost", "192.168.0.254");
        prop.setProperty("socksProxyPort", "8000");
        // 设置登陆到代理服务器的用户名和密码 
	 * */
	@Test
	public void aa() throws Exception {
		//经过测试，经过该方法设置的环境代理是与整个进程进程绑定在一起的临时变量
		//不与JVM环境绑定
		//进程销毁即变量销毁
		System.setProperty("http.proxySet", "true");
		System.getProperties().setProperty("http.proxyHost", "124.89.33.59");
		System.getProperties().setProperty("http.proxyPort", "53281");
		Connection connection = Jsoup.connect("http://ip.chinaz.com/");
		connection.ignoreContentType(true);
		Document document = connection.get();
		String content = document.toString();
		System.out.println(content);
	}

}
