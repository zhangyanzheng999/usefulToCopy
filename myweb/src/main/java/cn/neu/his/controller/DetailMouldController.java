package cn.neu.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.neu.his.bean.DetailMould;
import cn.neu.his.bean.Mould;
import cn.neu.his.bean.Msg;
import cn.neu.his.service.DetailMouldService;

/**
 * @author zyz1010561415
 */
@Controller
public class DetailMouldController {
    @Autowired
    DetailMouldService dmouldService;

    @RequestMapping("/load_detailmould")
    @ResponseBody
    public Msg load_detailmould(@RequestParam("mould_id") Integer mould_id) {
        List<DetailMould> dmouldlist = dmouldService.load_detailmould(mould_id);

        return Msg.success().add("dmouldlist", dmouldlist);
    }

    @ResponseBody
    @RequestMapping("/add_new_med_into_mould")
    public Msg add_new_med(@RequestParam("mouldID") Integer mouldID, @RequestParam("drugID") Integer drugID, @RequestParam("howUse") String howUse, @RequestParam("howMuchUse") String howMuchUse, @RequestParam("howOfenUse") String howOfenUse) {

		dmouldService.addNewMed(mouldID,drugID,howUse,howMuchUse,howOfenUse);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping("/delete_drug_inMould")
    public Msg deleteDrug(@RequestParam("mouldID") String mouldID,@RequestParam("drugID") String drugID){
        System.out.println(mouldID+" "+drugID);
        dmouldService.deleteDrug(Integer.parseInt(mouldID),Integer.parseInt(drugID));
        return Msg.success();
    }
    @ResponseBody
    @RequestMapping("/delete_detail_west_mould")
    public Msg deleteDetailWestMould(@RequestParam("mouldID") String mouldID){
        dmouldService.deleteDetailWestMould(mouldID);
        return  Msg.success();
    }
}
