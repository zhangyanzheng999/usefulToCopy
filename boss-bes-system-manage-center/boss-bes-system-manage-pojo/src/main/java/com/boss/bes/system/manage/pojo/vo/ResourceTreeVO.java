package com.boss.bes.system.manage.pojo.vo;

import com.boss.bes.system.manage.pojo.vo.common.BaseTreeVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:资源的树节点
 * @author:zyz
 * @time:2020/7/11-9:31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResourceTreeVO extends BaseTreeVO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    /**
     * 是否是叶子结点
     */
    private Boolean leaf;
    /**
     * 因为有的资源节点下没有数据但是不是叶子结点只好先赋值，然后叶子结点给成null
     * 如果在前端处理要有一个isLeaf属性去结合load实现
     */
    private List<ResourceTreeVO> children = new ArrayList<>();
}
