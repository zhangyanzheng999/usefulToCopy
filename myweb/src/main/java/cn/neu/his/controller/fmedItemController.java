package cn.neu.his.controller;

import cn.neu.his.bean.Msg;
import cn.neu.his.service.fmedItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class fmedItemController {
    @Autowired
    fmedItemService fmedItemService;

    @ResponseBody
    @RequestMapping("/load_detail_item")
    public Msg loadItem(@RequestParam("itemCode") String itemCode) {
        return Msg.success().add("detailList", fmedItemService.loadItem(itemCode));
    }

    @ResponseBody
    @RequestMapping("/load_like_item")
    public Msg loadLikeItem(@RequestParam("itemName") String itemName){
        return  Msg.success().add("list",fmedItemService.loadLikeItem(itemName));
    }
}
