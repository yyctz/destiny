package com.ctz.destiny.resource;

import com.ctz.destiny.resource.body.SizhuRankQueryBody;
import com.ctz.destiny.service.SizhuRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chentz on 2017/10/11.
 */
@RequestMapping("/sizhu")
@RestController
public class SizhuResource {
    @Autowired
    private SizhuRankService sizhuRankService;
    @RequestMapping("rank")
    @ResponseBody
    public String getSizhuRank(@RequestBody SizhuRankQueryBody body){
        return sizhuRankService.getSizhuRank(body);
    }
}
