package boss.brs.xtrain.dataconvention.controller;


import boss.brs.xtrain.dataconvention.convention.CommonResponse;
import boss.brs.xtrain.dataconvention.pojo.vo.BaseVO;
import com.github.pagehelper.page.PageMethod;

public abstract class BaseController<D,T,Q,M,V> extends AbstractController {
    protected void doBeforePagination(int pageIndex,int pageSize) {
        PageMethod.startPage(pageIndex, pageSize);
    }

    protected CommonResponse<T> buildCommponResponse(T object){
        CommonResponse<T> commonResponse=new CommonResponse<>();
        commonResponse.setBody(object);
        return commonResponse;
    }

    protected  abstract BaseVO doObjectTransferVo(Object dto);
}
