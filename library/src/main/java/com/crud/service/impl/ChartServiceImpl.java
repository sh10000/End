package com.crud.service.impl;

import com.crud.Dao.ChartDao;
import com.crud.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {
    @Autowired
    private ChartDao chartDao;

    @Override
    public List<Double> getChart(Integer file_id) {
        String fileName = chartDao.getChartName(file_id);
        String basePath = "src/main/java/com/crud/csv";
        if (fileName.startsWith("restaurant")) {
            basePath = "D:/zuomian/毕业论文/python/Gas_Anomaly_Detection/D2AE/2testing/Dataset/raw_test";
        } else {
            basePath = "D:/zuomian/毕业论文/python/Gas_Anomaly_Detection/D2AE_1/2testing/Dataset/user";
        }
        String completePath = Paths.get(basePath, fileName ).toString();
        String lastLine = "";

        try (BufferedReader br = new BufferedReader(new FileReader(completePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lastLine = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将最后一行数据（字符串）分割并转换为double类型的列表
        List<Double> results = Arrays.stream(lastLine.split(","))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        return results;
    }

    @Override
    public Map<String, List<Double>> getEChart(Integer FileName) {
        String fileName = chartDao.getChartName(FileName);
        String basePath = "src/main/java/com/crud/csv";
        if (fileName.startsWith("restaurant")) {
            basePath = "D:/zuomian/毕业论文/python/Gas_Anomaly_Detection/D2AE/2testing/Dataset/raw_test";
        } else {
            basePath = "D:/zuomian/毕业论文/python/Gas_Anomaly_Detection/D2AE_1/2testing/Dataset/user";
        }
        String completePathActual = Paths.get(basePath, fileName).toString();
        String completePathPredicted = Paths.get(basePath, fileName.replace(".csv", "p.csv")).toString();

        String lastLineActual = "";
        String lastLinePredicted= "";

        try (BufferedReader br = new BufferedReader(new FileReader(completePathActual))) {
            String line;
            while ((line = br.readLine()) != null) {
                lastLineActual = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(completePathPredicted))) {
            String line;
            while ((line = br.readLine()) != null) {
                lastLinePredicted = line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将最后一行数据（字符串）分割并转换为double类型的列表
        List<Double> resultsActual = Arrays.stream(lastLineActual.split(","))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        List<Double> resultsPredicted = Arrays.stream(lastLinePredicted.split(","))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        Map<String, List<Double>> results = new HashMap<>();
        results.put("actual", resultsActual);
        results.put("predicted", resultsPredicted);

        return results;
    }
}
