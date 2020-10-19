package xyz.nekotori.util;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import xyz.nekotori.model.CommonResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Author: Dengjay
 * Date: 2020/10/19
 * Time: 11:09
 */
public class HttpUtil {
    private static final OkHttpClient client = OKHttpClientBuilder.
            buildOKHttpClient().
            callTimeout(60, TimeUnit.SECONDS).
            readTimeout(60,TimeUnit.SECONDS).
            writeTimeout(60,TimeUnit.SECONDS).
            connectTimeout(60,TimeUnit.SECONDS).
            build();
    public static CommonResponse get(String url) throws IOException {

        final Request request = new Request.
                Builder().
                url(url).
                get().
                removeHeader("User-Agent").
                addHeader("Connection", "keep-alive").
                addHeader("Host","konachan.com").
                build();
        client.newCall(request).enqueue(
        new Callback() {
          public void onFailure(@NotNull Call call, @NotNull IOException e) {
            System.out.println("request failed!");
            e.printStackTrace();
          }

          public void onResponse(@NotNull Call call, @NotNull Response response)
              throws IOException {
              InputStream inputStream = Objects.requireNonNull(response.body()).byteStream();
              byte[] data = new byte[1024];
              int len = 0;
              FileOutputStream fileOutputStream = null;
              try {
                  fileOutputStream = new FileOutputStream("test1.jpg");
                  while ((len = inputStream.read(data)) != -1) {
                      fileOutputStream.write(data, 0, len);
                  }
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

          }
        });
        return new CommonResponse();
    }
}
