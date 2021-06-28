package com.naive.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.naive.domain.Problem;
import org.springframework.stereotype.Repository;

/**
 * @author YechenGu
 * @date 2021/6/28 3:40 下午
 */
@Repository
public interface QuestionMapper extends BaseMapper<Problem> {
}
