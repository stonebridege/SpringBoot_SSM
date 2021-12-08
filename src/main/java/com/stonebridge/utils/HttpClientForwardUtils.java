package com.stonebridge.utils;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpClientForwardUtils {

    private static final int STATUS = 404;

    private static final int BYTELEN = 4096;

    /**
     * Json传输格式
     *
     * @param appParamMap Map格式参数集
     * @param url         请求地址
     * @return 返回请求信息
     * @throws Exception 抛出异常
     */
    @SuppressWarnings({"unchecked", "deprecation"})
    public static JSONObject forwardPostNew(Map<String, String> appParamMap, String url) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<>();
        Iterator<String> iterator = appParamMap.keySet().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            String value = appParamMap.get(name);
            params.add(new BasicNameValuePair(name, value));
        }
        try {
            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e1) {
            log.error("forwardPostNew方法错误：", e1);
        }
        JSONObject rtnJson = new JSONObject();
        try {
            HttpResponse httpResponse = client.execute(post);
            int resStatu = httpResponse.getStatusLine().getStatusCode();
            rtnJson.put("resStatu", resStatu);
            if (resStatu == HttpStatus.SC_OK) {
                String result = "";
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, HTTP.UTF_8);
                }
                rtnJson.put("code", "succ");
                rtnJson.put("data", result);
            } else {
                rtnJson.put("code", "fail");
                rtnJson.put("data", resStatu);
            }
        } catch (Exception e) {
            log.error("forwardPostNew方法错误：", e);
            rtnJson.put("code", "fail");
            rtnJson.put("data", "系统错误！");
        } finally {
            client.getConnectionManager().shutdown();
        }
        return rtnJson;
    }

    /**
     * Json传输格式
     *
     * @param appParamMap JSONObject格式参数集
     * @param url         请求地址
     * @return 返回请求信息
     * @throws Exception 抛出异常
     */
    @SuppressWarnings({"unchecked", "deprecation"})
    public static JSONObject forwardPostNewJson(JSONObject appParamMap, String url) throws Exception {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        try {
            StringEntity entity = new StringEntity(appParamMap.toString(), HTTP.UTF_8);
            entity.setContentType("application/json");
            entity.setContentEncoding("UTF-8");
            post.setEntity(entity);
        } catch (Exception e1) {
            log.error("forwardPostNewJson方法错误：", e1);
        }
        JSONObject rtnJson = new JSONObject();
        try {
            HttpResponse httpResponse = client.execute(post);
            int resStatu = httpResponse.getStatusLine().getStatusCode();
            rtnJson.put("resStatu", resStatu);
            if (resStatu == HttpStatus.SC_OK) {
                String result = "";
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, HTTP.UTF_8);
                }
                rtnJson.put("code", "succ");
                rtnJson.put("data", result);
            } else {
                rtnJson.put("code", "fail");
                rtnJson.put("data", resStatu);
            }
        } catch (Exception e) {
            log.error("forwardPostNewJson方法错误：", e);
            rtnJson.put("code", "fail");
            rtnJson.put("data", "系统错误！");
        } finally {
            client.getConnectionManager().shutdown();
        }
        return rtnJson;
    }

    /**
     * @param url            远程文件路径
     * @param remoteFileName 文件名
     * @param localFileName  下载到本地文件路径
     */
    public static void downLoad(String url, String remoteFileName, String localFileName) {
        HttpClient httpClient = new DefaultHttpClient();
        OutputStream out = null;
        InputStream in = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("username", "tdh");
            httpGet.addHeader("password", "tdh");
            httpGet.addHeader("fileName", remoteFileName);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            in = entity.getContent();
            File file = new File(localFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file);
            byte[] buffer = new byte[BYTELEN];
            int readLength = 0;
            while ((readLength = in.read(buffer)) > 0) {
                byte[] bytes = new byte[readLength];
                System.arraycopy(buffer, 0, bytes, 0, readLength);
                out.write(bytes);
            }
            out.flush();
        } catch (IOException e) {
            log.error("downLoad方法出错：", e);
        } catch (Exception e) {
            log.error("downLoad方法出错：", e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("downLoad方法关闭输入流对象出错：", e);
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                log.error("downLoad方法关闭输出流对象出错：", e);
            }
        }
    }

    /**
     * post请求
     *
     * @param url      请求地址
     * @param paramMap 参数集
     * @return 返回请求信息
     * @throws IOException 抛出异常
     */
    @SuppressWarnings({"unchecked", "deprecation"})
    public static JSONObject post(String url, Map<String, String> paramMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        List<NameValuePair> params = new ArrayList<>();
        Iterator<String> iterator = paramMap.keySet().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            String value = paramMap.get(name);
            params.add(new BasicNameValuePair(name, value));
        }
        JSONObject rtnJson = new JSONObject();
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse mHttpResponse = httpClient.execute(httpPost);
            int resStatu = mHttpResponse.getStatusLine().getStatusCode();
            rtnJson.put("resStatu", resStatu);
            if (resStatu == HttpStatus.SC_OK) {
                String result = "";
                HttpEntity entity = mHttpResponse.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, HTTP.UTF_8);
                }
                rtnJson.put("code", "succ");
                rtnJson.put("data", result);
            } else {
                rtnJson.put("code", "fail");
                rtnJson.put("data", resStatu);
            }
        } catch (Exception e) {
            log.error("post方法错误：", e);
            rtnJson.put("code", "fail");
            rtnJson.put("data", "系统错误！");
        } finally {
            httpClient.close();
        }
        return rtnJson;
    }

    /**
     * 检查URL是否能正常访问
     *
     * @param xturl 待校验url地址
     * @return true：可访问，false：不可访问
     */
    public static boolean checkUrl(String xturl) {
        boolean isExists = true;
        HttpURLConnection httpurlconnection = null;
        try {
            URL url = new URL(xturl);
            httpurlconnection = (HttpURLConnection) url.openConnection();
            httpurlconnection.connect();
            int code = httpurlconnection.getResponseCode();
            if (code == STATUS) {
                isExists = false;
            }
        } catch (Exception e) {
            log.error("checkUrl方法错误：", e);
            isExists = false;
        }
        return isExists;
    }

    /**
     * 根据文件路径下载文件
     *
     * @param urlStr 文件路径
     * @return byte[]
     * @throws IOException
     */
    public static byte[] downLoadFromUrl(String urlStr) throws Exception {
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);////允许写入
            conn.setDoOutput(true);//允许写出
            conn.setUseCaches(false);
            conn.setConnectTimeout(60 * 1000);
            conn.setReadTimeout(60 * 1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                inputStream = conn.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while ((len = inputStream.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.flush();
                return bos.toByteArray();
            }
        } catch (Exception e) {
            log.error("根据URL下载文件错误：", e);
            throw e;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return null;
    }
}
