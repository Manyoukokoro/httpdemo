package xyz.nekotori.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.nekotori.api.KonachanApi;
import xyz.nekotori.common.CommonResponse;
import xyz.nekotori.model.PostModel;

import java.io.IOException;
import java.util.List;

/**
 * Author: Dengjay
 * Date: 2020/10/21
 * Time: 14:03
 */

@RestController
@RequestMapping("/konachan")
public class KonachanController {

    @GetMapping("/newest")
    public CommonResponse<PostModel> getPost(){
        try{
        List<PostModel> ls = KonachanApi.getNewestPost(1);
        return new CommonResponse<PostModel>("OK")
                .withMessage("get successful.")
                .withContent(ls.get(0));
        }catch (IOException e){
            return new CommonResponse<PostModel>("ERROR")
                    .withMessage("server error.");
        }
    }
}
