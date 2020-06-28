package neu.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        //异常处理器携带的数据
        Map<String,Object> ext = (Map<String,Object> )webRequest.getAttribute("ext", 0);

        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

        map.put("ext",ext);
        map.put("company","atguigu");
        return map;
    }
}
