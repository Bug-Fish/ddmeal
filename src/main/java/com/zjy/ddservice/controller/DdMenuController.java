package com.zjy.ddservice.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.ddservice.entity.DdMenu;
import com.zjy.ddservice.entity.vo.MenuQuery;
import com.zjy.ddservice.service.DdMenuService;
import com.zjy.ddservice.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Education_ZH
 * @since 2020-12-05
 */
@RestController
@RequestMapping("/ddservice/dd-menu")
@CrossOrigin
public class DdMenuController {

    @Autowired
    private DdMenuService ddMenuService;


    @GetMapping("findAll")
    public R findAll() {
        return R.ok().data("allMenu", ddMenuService.list(null));
    }


    @PostMapping("pageMenuCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable long current, @PathVariable long limit,
                                  @RequestBody(required = false) MenuQuery menuQuery) {
        Page<DdMenu> page = new Page<>(current, limit);
        QueryWrapper<DdMenu> wrapper = new QueryWrapper<>();
        String name = menuQuery.getName();
        String menu = menuQuery.getMenu();
        String begin = menuQuery.getBegin();
        String end = menuQuery.getEnd();
        if (! StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (! StringUtils.isEmpty(menu)) {
            wrapper.like("menu", menu);
        }
        if (! StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (! StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);
        }
        wrapper.orderByDesc("gmt_create");

        ddMenuService.page(page, wrapper);

        long total = page.getTotal();
        List<DdMenu> records = page.getRecords();

        return R.ok().data("total", total).data("records", records);
    }



    //添加讲师
    @PostMapping("addMenu")
    public R addTeacher(@RequestBody DdMenu ddMenu){
        boolean save = ddMenuService.save(ddMenu);
        if (save){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @DeleteMapping("delMenu/{id}")
    public R removeById(@PathVariable String id){
        boolean flag = ddMenuService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }

    }



}

