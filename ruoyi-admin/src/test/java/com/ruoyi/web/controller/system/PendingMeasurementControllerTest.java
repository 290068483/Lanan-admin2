package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.PendingMeasurement;
import com.ruoyi.system.service.IPendingMeasurementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 待测量管理Controller层测试类
 *
 * @author ruoyi
 */
@SpringBootTest(classes = RuoYiApplication.class)
public class PendingMeasurementControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IPendingMeasurementService pendingMeasurementService;

    @InjectMocks
    private PendingMeasurementController pendingMeasurementController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(pendingMeasurementController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<PendingMeasurement> measurements = new ArrayList<>();
        PendingMeasurement measurement = new PendingMeasurement();
        measurement.setMeasurementId(1L);
        measurement.setCustomId(1L);
        measurement.setCustomerName("测试客户");
        measurement.setUrgency(1);
        measurement.setDeposit(new BigDecimal("1000.00"));
        measurement.setCustomerDate(new Date());
        measurement.setCurrentStatus("待测量");
        measurement.setFocusStyle("现代风格");
        measurement.setPendingMeasurementDate(new Date());
        measurement.setCustomerSource("线上推广");
        measurement.setSalesman("张三");
        measurement.setDetails("详细信息");
        measurements.add(measurement);

        // 模拟服务层返回
        when(pendingMeasurementService.selectPendingMeasurementList(any(PendingMeasurement.class))).thenReturn(measurements);

        // 执行测试
        mockMvc.perform(get("/customer/pending-measurements/list")
                .param("customerName", "测试客户"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingMeasurementService, times(1)).selectPendingMeasurementList(any(PendingMeasurement.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
        PendingMeasurement measurement = new PendingMeasurement();
        measurement.setMeasurementId(1L);
        measurement.setCustomId(1L);
        measurement.setCustomerName("测试客户");
        measurement.setUrgency(1);
        measurement.setDeposit(new BigDecimal("1000.00"));
        measurement.setCustomerDate(new Date());
        measurement.setCurrentStatus("待测量");
        measurement.setFocusStyle("现代风格");
        measurement.setPendingMeasurementDate(new Date());
        measurement.setCustomerSource("线上推广");
        measurement.setSalesman("张三");
        measurement.setDetails("详细信息");

        // 模拟服务层返回
        when(pendingMeasurementService.selectPendingMeasurementById(1L)).thenReturn(measurement);

        // 执行测试
        mockMvc.perform(get("/customer/pending-measurements/{measurementId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(pendingMeasurementService, times(1)).selectPendingMeasurementById(1L);
    }

    @Test
    public void testAdd() throws Exception {
        // 准备测试数据
        PendingMeasurement measurement = new PendingMeasurement();
        measurement.setCustomId(1L);
        measurement.setCustomerName("测试客户");
        measurement.setUrgency(1);
        measurement.setDeposit(new BigDecimal("1000.00"));
        measurement.setCustomerDate(new Date());
        measurement.setCurrentStatus("待测量");
        measurement.setFocusStyle("现代风格");
        measurement.setPendingMeasurementDate(new Date());
        measurement.setCustomerSource("线上推广");
        measurement.setSalesman("张三");
        measurement.setDetails("详细信息");

        // 模拟服务层返回
        when(pendingMeasurementService.insertPendingMeasurement(measurement)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/customer/pending-measurements")
                .contentType("application/json")
                .content("{\"customId\":1,\"customerName\":\"测试客户\",\"urgency\":1,\"deposit\":1000.00,\"customerDate\":\"2023-06-01\",\"currentStatus\":\"待测量\",\"focusStyle\":\"现代风格\",\"pendingMeasurementDate\":\"2023-06-01\",\"customerSource\":\"线上推广\",\"salesman\":\"张三\",\"details\":\"详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingMeasurementService, times(1)).insertPendingMeasurement(any(PendingMeasurement.class));
    }

    @Test
    public void testEdit() throws Exception {
        // 准备测试数据
        PendingMeasurement measurement = new PendingMeasurement();
        measurement.setMeasurementId(1L);
        measurement.setCustomId(1L);
        measurement.setCustomerName("更新客户");
        measurement.setUrgency(2);
        measurement.setDeposit(new BigDecimal("2000.00"));
        measurement.setCustomerDate(new Date());
        measurement.setCurrentStatus("已完成");
        measurement.setFocusStyle("北欧风格");
        measurement.setPendingMeasurementDate(new Date());
        measurement.setCustomerSource("线下门店");
        measurement.setSalesman("李四");
        measurement.setDetails("更新详细信息");

        // 模拟服务层返回
        when(pendingMeasurementService.updatePendingMeasurement(measurement)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/customer/pending-measurements")
                .contentType("application/json")
                .content("{\"measurementId\":1,\"customId\":1,\"customerName\":\"更新客户\",\"urgency\":2,\"deposit\":2000.00,\"customerDate\":\"2023-07-01\",\"currentStatus\":\"已完成\",\"focusStyle\":\"北欧风格\",\"pendingMeasurementDate\":\"2023-07-01\",\"customerSource\":\"线下门店\",\"salesman\":\"李四\",\"details\":\"更新详细信息\"}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingMeasurementService, times(1)).updatePendingMeasurement(any(PendingMeasurement.class));
    }

    @Test
    public void testRemove() throws Exception {
        // 准备测试数据
        Long[] ids = {1L, 2L, 3L};

        // 模拟服务层返回
        when(pendingMeasurementService.deletePendingMeasurementByIds(ids)).thenReturn(3);

        // 执行测试
        mockMvc.perform(delete("/customer/pending-measurements/{measurementIds}", "1,2,3"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(pendingMeasurementService, times(1)).deletePendingMeasurementByIds(ids);
    }
}