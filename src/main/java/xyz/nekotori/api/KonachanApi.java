package xyz.nekotori.api;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import xyz.nekotori.model.PostModel;
import xyz.nekotori.util.OKHttpClientBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/** Author: Dengjay Date: 2020/10/19 Time: 11:09 */
public class KonachanApi {
  private static final OkHttpClient client =
      OKHttpClientBuilder.buildOKHttpClient()
          .callTimeout(3000, TimeUnit.SECONDS)
          .readTimeout(3000, TimeUnit.SECONDS)
          .writeTimeout(3000, TimeUnit.SECONDS)
          .connectTimeout(3000, TimeUnit.SECONDS)
          .build();

  public static boolean downloadPic(String url){
    return true;
  }

  public static boolean downloadPic(String url, String fileName) throws IOException {
    String formatUrl = url;
    formatUrl = formatUrl.replace("https://konachan.com", "https://www.konachan.com/");
    final Request request =
        new Request.Builder()
            .url(formatUrl)
            .get()
            .removeHeader("User-Agent")
            .addHeader("Connection", "keep-alive")
            .addHeader("Host", "konachan.com")
            .build();
    Response response = client.newCall(request).execute();
    InputStream inputStream = Objects.requireNonNull(response.body()).byteStream();
    byte[] data = new byte[512*1024];
    int len = 0;
    FileOutputStream fileOutputStream = null;
    File file = new File(fileName);
    file.createNewFile();
    try {
      fileOutputStream = new FileOutputStream(file);
      while ((len = inputStream.read(data)) != -1) {
        fileOutputStream.write(data, 0, len);
      }
      System.out.println("download success!");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (fileOutputStream != null) {
        try {
          fileOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return true;
  }

  public static List<PostModel> getNewestPost(int limit) throws IOException {

    String url = "https://www.konachan.com/post.xml?limit=" + limit;
    final Request request =
        new Request.Builder()
            .url(url)
            .get()
            .removeHeader("User-Agent")
            .addHeader("Connection", "keep-alive")
            .addHeader("Host", "konachan.com")
            .build();
    Response response = client.newCall(request).execute();

    String xml = Objects.requireNonNull(response.body()).string();
    JSONObject json = XML.toJSONObject(xml).getJSONObject("posts");
    List<PostModel> posts = new ArrayList<>();
    Gson gson = new Gson();
    if (limit > 1) {
      JSONArray postList;
      postList = json.getJSONArray("post");
      for (Object post : postList) {
        posts.add(gson.fromJson(String.valueOf(post), PostModel.class));
      }
    } else {
      Object post;
      post = json.get("post");
      posts.add(gson.fromJson(String.valueOf(post), PostModel.class));
    }
    return posts;
  }
}
