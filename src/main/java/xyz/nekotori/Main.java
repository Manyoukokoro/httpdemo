package xyz.nekotori;

import xyz.nekotori.model.PostModel;
import xyz.nekotori.api.KonachanApi;

import java.io.IOException;
import java.util.List;

/**
 * Author: Dengjay
 * Date: 2020/10/19
 * Time: 11:08
 */
public class Main {
        public static void main(String[] args) throws IOException {
            List<PostModel> ls = KonachanApi.getNewestPost(10);
    System.out.println("got url");
            for(PostModel p:ls){
      System.out.println(p.getFileUrl());
      System.out.println(p.getFileSize());

                KonachanApi.downloadPic(p.getSampleUrl(),p.getId().toString());
                KonachanApi.downloadPic(p.getSampleUrl());
            }
        }

}
