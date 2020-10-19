package xyz.nekotori;

import okhttp3.HttpUrl;
import xyz.nekotori.util.HttpUtil;

import java.io.IOException;

/**
 * Author: Dengjay
 * Date: 2020/10/19
 * Time: 11:08
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        HttpUtil.get("https://www.konachan.com/image/8fa613ccaaa7524eadad98d9acd8790f/Konachan.com%20-%20317346%20applecaramel_%28acaramel%29%20bronya_zaychik%20building%20flowers%20honkai_impact%20seele_vollerei%20skirt%20twintails%20veliona%20water.png");
    }
}
