package com.pengpenghuyu.supportplat.quartzdemo.controller;

import com.pengpenghuyu.supportplat.quartzdemo.service.IQuartzService;
import com.pengpenghuyu.supportplat.quartzdemo.task.ButtonTimerJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * @author wangyh
 * @date 2019/06/20
 */
@Controller
@RequestMapping(value = "/quartzCont")
public class QuartzController {

    @Autowired
    private IQuartzService quartzService;

    @RequestMapping(value = "")
    @ResponseBody
    public Object updateQuartzInfo() {
        quartzService.addJob("", ButtonTimerJob.class, "");
        return "";
    }
}
