package com.lead.common.fastdfs;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName FdfsConfiguration
 * @date 2021/5/29 14:26
 * @Version 1.0
 * @Author ShyBoy
 */
@Configuration
@PropertySource("fast_dfs.properties")
@Import(FdfsClientConfig.class) // 导入FastDFS-Client组件
public class FdfsConfiguration {
}
