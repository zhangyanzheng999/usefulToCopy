package cn.neu.his.controller;

import cn.neu.his.bean.Msg;
import cn.neu.his.service.DetailTemplateYijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DetailTemplateYijiController {

    @Autowired
    DetailTemplateYijiService detailTemplateYijiService;


    @ResponseBody
    @RequestMapping("/load_detail_template_yiji")
    public Msg loadTemplate(@RequestParam("templateID") String templateID) {

        return Msg.success().add("detailList", detailTemplateYijiService.loadTemplate(templateID));
    }

    @ResponseBody
    @RequestMapping("/delete_template_item")
    public Msg deleteTemplateItem(@RequestParam("itemCode") String itemCode,@RequestParam("templateID") String templateID){
        detailTemplateYijiService.deleteTemplateItem(itemCode,templateID);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping("/add_new_item")
    public Msg addTemplateItem(@RequestParam("templateID") String templateID,@RequestParam("itemCode") String itemCode){

        detailTemplateYijiService.addTemplateItem(templateID,itemCode);
        return  Msg.success();
    }

    @ResponseBody
    @RequestMapping("/delete_detail_template")
    public Msg deleteDetailTemplate(@RequestParam("templateID") String templateID){

        detailTemplateYijiService.deleteDetailTemplate(templateID);
        return Msg.success();
    }
}
