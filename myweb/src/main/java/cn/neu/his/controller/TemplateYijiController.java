package cn.neu.his.controller;

import cn.neu.his.bean.Msg;
import cn.neu.his.service.TemplateYijiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TemplateYijiController {
    @Autowired
    TemplateYijiService templateYijiService;

    @ResponseBody
    @RequestMapping("/find_template_yiji")
    public Msg findTemplate(@RequestParam("templateName") String templateName,
                            @RequestParam("templateRange") String templateRange,
                            @RequestParam("templateType") String templateType) {
        return Msg.success().add("templateList",templateYijiService.findTemplate(templateName,templateRange,templateType));
    }

    @ResponseBody
    @RequestMapping("/add_new_template")
    public  Msg addNewTemplate(@RequestParam("templateName") String templateName,@RequestParam("templateRange") String templateRange,@RequestParam("templateType") String templateType){
        templateYijiService.addNewTemplate(templateName,templateRange,templateType);
        return Msg.success();

    }


    @ResponseBody
    @RequestMapping("/delete_template")
    public Msg deleteTemplate(@RequestParam("templateID") String templateID){

        templateYijiService.deleteTemplate(templateID);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping("/modify_template")
    public Msg modifyTemplate(@RequestParam("templateID") String templateID,@RequestParam("templateName") String templateName,@RequestParam("templateRange") String templateRange,@RequestParam("templateType") String templateType){
        templateYijiService.modifyTemplate(templateID,templateName,templateRange,templateType);
        return Msg.success();
    }
}
