package jasen.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CrawlerFirst {

    public static void main(String[] args) throws IOException {
        // 1. 打开浏览器, 创建 HttpClient 对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // 2. 输入网址, 发起get请求创建HttpGet对象
        HttpGet httpGet = new HttpGet("http://www.baidu.com/");

        // 3. 按回车, 发起请求, 返回响应
        CloseableHttpResponse response = httpClient.execute(httpGet);

        // 4. 解析响应, 获取数据
        // 判断状态码是否是 200
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf-8");
            System.out.println(content);
        }
    }
}
// 直接运行, 成功抓取到百度首页html并打印到控制台