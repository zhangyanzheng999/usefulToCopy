package boss.brs.xtrain.dataconvention.controller;

import com.github.pagehelper.PageHelper;

/**
 * @description: 请分析所有的controller 可能存在哪些公用的功能
 * <br> 定义通用的方法在该控制器下 例如分页插件的管理
 * @author: Xiong
 * @create: 2020-07-01 20:09
 * @since
 **/
public abstract  class AbstractController {
    protected void doBeforePagination(int pageIndex,int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
    }
}
