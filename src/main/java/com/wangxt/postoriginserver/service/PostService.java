package com.wangxt.postoriginserver.service;

import com.wangxt.postoriginserver.domain.vo.ResultVo;
import org.springframework.stereotype.Service;

/**
 *
 * 服务层
 * @author wangxt
 * @date 2021/06/07 15:36
 */
@Service
public interface PostService {

    /**
     *
     * 执行脚本方法
     * @param path 脚本路径
     * @author wangxt
     * @date 2021/6/7 15:48
     * @return 执行结果
     */
    ResultVo<String> post2Server(String path, String secret);

    String generate();
}
