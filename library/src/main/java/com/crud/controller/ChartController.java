package com.crud.controller;

import com.crud.Dao.UserInformDao;
import com.crud.controller.utils.R;
import com.crud.service.ChartService;
import com.crud.service.UserInformServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    private ChartService chartService;
    @Autowired
    private UserInformDao userInformDao;
    @GetMapping
    public R save(@RequestParam String username){
        Integer groupid= userInformDao.selectByUsername(username);
        List<Double> chart = chartService.getChart(groupid);
        return new R(true,chart);
    }
    @GetMapping("/e")
    public R saveE(@RequestParam String username){
        Integer groupid= userInformDao.selectByUsername(username);
        Map<String, List<Double>> eChart = chartService.getEChart(groupid);
        return new R(true,eChart);
    }
}
