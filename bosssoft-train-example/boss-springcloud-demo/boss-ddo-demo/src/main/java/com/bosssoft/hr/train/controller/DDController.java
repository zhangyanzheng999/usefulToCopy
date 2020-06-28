package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.bean.DataDictionary;
import com.bosssoft.hr.train.service.DDService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author:zyz
 * @time:2020/6/14-22:05
 */
@RestController
@RequestMapping("/dd")
public class DDController {
    @Autowired
    DDService ddService;

    @GetMapping("/get/{id}")
    public DataDictionary getById(@PathVariable("id") Integer id) {
        return ddService.getDDById(id);
    }

    @GetMapping("/get")
    public PageInfo<DataDictionary> getWithPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return ddService.queryDDWithPage(pageNum, pageSize);
    }

    @PutMapping("/update")
    public String update(@RequestBody DataDictionary dataDictionary) {
        if (ddService.update(dataDictionary).getDdId() != null) {
            return "update success";
        } else {
            return "update failed";
        }
    }

    @PostMapping("/insert")
    public String insert(@RequestBody DataDictionary dataDictionary) {
        if (ddService.insert(dataDictionary).getDdId() != null) {
            return "insert success";
        } else {
            return "insert failed";
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        if (ddService.deleteById(id) > 0) {
            return "deleteById success";
        } else {
            return "deleteById failed";
        }
    }
}
