package com.naive.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.naive.domain.Test;
import org.springframework.stereotype.Repository;

/**
 * @author YechenGu
 * @date 2021/6/28 4:25 下午
 */
@Repository
public interface PaperMapper extends BaseMapper<Test> {
}
