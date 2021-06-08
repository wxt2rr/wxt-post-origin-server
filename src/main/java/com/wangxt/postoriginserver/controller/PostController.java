package com.wangxt.postoriginserver.controller;

import com.wangxt.postoriginserver.domain.vo.ResultVo;
import com.wangxt.postoriginserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * 控制层
 * @author wangxt
 * @date 2021/06/07 15:36
 */
@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     *
     * 测试方式
     * @author wangxt
     * @date 2021/6/7 15:39
     * @return pong
     */
    @GetMapping("ping")
    public String ping(){
        return "pong!";
    }

    /**
     *
     * 执行脚本方法
     * @param path 脚本绝对路径
     * @param secret 在github设置的secret
     * @author wangxt
     * @date 2021/6/7 15:48
     * @return 执行结果
     */
    @RequestMapping("post2Server")
    @ResponseBody
    public ResultVo<String> post2Server(@RequestParam(value = "path", required = true) String path,
                                        @RequestParam(value = "secret", required = true) String secret){

        return postService.post2Server(path, secret);
    }
}
