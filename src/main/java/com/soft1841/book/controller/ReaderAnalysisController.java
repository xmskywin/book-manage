package com.soft1841.book.controller;

import com.soft1841.book.dao.ReaderDAO;
import com.soft1841.book.service.ReaderService;
import com.soft1841.book.utils.DAOFactory;
import com.soft1841.book.utils.ServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ReaderAnalysisController implements Initializable {
    @FXML
    private StackPane departmentPieChart, rolePieChart;

    private String[] departments = {"机械工程学院", "电气工程学院", "航空工程学院", "交通工程学院",
            "计算机与软件学院", "经济管理学院", "商务贸易学院", "艺术设计学院"};
    private String[] roles = {"教师", "学生"};
    private ReaderService readerService = ServiceFactory.getReaderServiceInstance();

    private ObservableList<PieChart.Data> pieChartData1 = FXCollections.observableArrayList();

    private ObservableList<PieChart.Data> pieChartData2 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDepartmentPieChart();
        initRolePieChart();
    }

    private void initDepartmentPieChart() {
        for (String department : departments) {
            int count = readerService.countByDepartment(department);
            pieChartData1.add(new PieChart.Data(department, count));
        }
        final PieChart chart = new PieChart(pieChartData1);
        chart.setTitle("按院系统计饼图");
        departmentPieChart.getChildren().add(chart);
    }

    private void initRolePieChart() {
        for (String role : roles) {
            int count = readerService.countByRole(role);
            pieChartData2.add(new PieChart.Data(role, count));
        }
        final PieChart chart = new PieChart(pieChartData2);
        chart.setTitle("按角色统计饼图");
        rolePieChart.getChildren().add(chart);
    }
}
