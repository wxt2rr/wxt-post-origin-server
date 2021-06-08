package com.wangxt.postoriginserver.service.impl;

import com.wangxt.postoriginserver.domain.vo.ResultVo;
import com.wangxt.postoriginserver.service.PostService;
import com.wangxt.postoriginserver.util.StreamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

/**
 *
 * 服务层实现
 * @author wangxt
 * @date 2021/06/07 15:36
 */
@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    private Environment environment;

    /**
     *
     * 执行脚本方法
     * @param path 脚本路径
     * @author wangxt
     * @date 2021/6/7 15:48
     * @return 执行结果
     */
    @Override
    public ResultVo<String> post2Server(String path, String secret) {
        if (!StringUtils.hasLength(secret) || !secret.equals(environment.getProperty("secret"))) {
            return new ResultVo<>(-103, "token error", "");
        }

        Runtime rt = Runtime.getRuntime();
        try (InputStream is = rt.exec(String.format("sh %s", path), null, null).getInputStream()) {
            String s = StreamUtil.inputStream2Str(is);
            return new ResultVo<>(200, "success", s);
        } catch (Exception e) {
            return new ResultVo<>(-104, "exec error", e.getMessage());
        }
    }
}
