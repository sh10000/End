package com.crud.service;

import java.util.List;
import java.util.Map;

public interface ChartService {
    List<Double> getChart(Integer FileName);
    Map<String, List<Double>> getEChart(Integer FileName);
}
