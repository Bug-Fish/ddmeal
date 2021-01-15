package com.zjy.ddservice.mapper;

import com.zjy.ddservice.entity.DdMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Education_ZH
 * @since 2020-12-05
 */
public interface DdMenuMapper extends BaseMapper<DdMenu> {

    List<String> findAll();

}
