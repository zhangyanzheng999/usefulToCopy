package boss.brs.xtrain.dataconvention.pojo.dto;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author XIONG
 * 对分页信息进行封装
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class CommonPageDTO<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;
    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public  CommonPageDTO<T> doPage(List<T> list) {
        CommonPageDTO<T> result = new CommonPageDTO<>();
        PageInfo pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    public  CommonPageDTO<T> doPage(Page pageInfo, List list) {
        CommonPageDTO<T> result = new CommonPageDTO<>();
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(list);
        return result;
    }
}
