package neu.showchart.controller;

import neu.showchart.entity.Info;
import neu.showchart.repository.InfoRepository;
import neu.showchart.repository.PageRepository;
import neu.showchart.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class InfoController {
    @Autowired
    InfoRepository infoRepository;

    @Autowired
    PageService pageService;
/*

    @GetMapping("/info/{id}")
    public Info getInfo(@PathVariable("id") Integer id) {
        Info info = infoRepository.findById(id).orElse(null);
        return info;
    }


    @GetMapping("/info")
    public Info insertInfo(Info info) {
        Info save = infoRepository.save(info);
        return save;
    }
*/


    @GetMapping("/infos")
    public String getAllInfo(Map<String, Object> map,@RequestParam(value = "page", defaultValue = "0") Integer page,
@RequestParam(value = "size", defaultValue = "15") Integer size) {
        Page<Info> infos = pageService.findInfoNoCriteria(page,size);
        map.put("infos", infos);
        return "list";
    }


    @GetMapping("/getinfos")
    @ResponseBody
    public Object getInfoToChart() {
        //只查出最近一小时的报警数量
        //因为只要求最近一小时的
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endDate=dateFormat.format(System.currentTimeMillis());
        String startDate=dateFormat.format(System.currentTimeMillis()-60*60*1000*1);


        List<Info> infos1 = infoRepository.findAllByTimeBetween(startDate, dateFormat.format(System.currentTimeMillis() - 50 * 60 * 1000 * 1));
        List<Info> infos2= infoRepository.findAllByTimeBetween(dateFormat.format(System.currentTimeMillis()-50*60*1000*1),dateFormat.format(System.currentTimeMillis()-40*60*1000*1));
        List<Info> infos3=infoRepository.findAllByTimeBetween(dateFormat.format(System.currentTimeMillis()-40*60*1000*1),dateFormat.format(System.currentTimeMillis()-30*60*1000*1));
        List<Info> infos4=infoRepository.findAllByTimeBetween(dateFormat.format(System.currentTimeMillis()-30*60*1000*1),dateFormat.format(System.currentTimeMillis()-20*60*1000*1));
        List<Info> infos5=infoRepository.findAllByTimeBetween(dateFormat.format(System.currentTimeMillis()-20*60*1000*1),dateFormat.format(System.currentTimeMillis()-10*60*1000*1));
        List<Info> infos6=infoRepository.findAllByTimeBetween(dateFormat.format(System.currentTimeMillis()-10*60*1000*1),endDate);
        Map<Object,Object> infos=new HashMap<>();
        infos.put(1,infos1);
        infos.put(2,infos2);
        infos.put(3,infos3);
        infos.put(4,infos4);
        infos.put(5,infos5);
        infos.put(6,infos6);


        return infos;
    }

}
