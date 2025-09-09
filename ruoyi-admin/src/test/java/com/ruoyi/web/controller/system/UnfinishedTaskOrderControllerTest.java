package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.system.domain.UnfinishedTaskOrder;
import com.ruoyi.system.service.IUnfinishedTaskOrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = RuoYiApplication.class)
public class UnfinishedTaskOrderControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IUnfinishedTaskOrderService unfinishedTaskOrderService;

    @InjectMocks
    private UnfinishedTaskOrderController unfinishedTaskOrderController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(unfinishedTaskOrderController).build();
    }

    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<UnfinishedTaskOrder> tasks = new ArrayList<>();
        UnfinishedTaskOrder task = new UnfinishedTaskOrder();
        task.setTaskId(1L);
        task.setUserId(1L);
        task.setTaskCode("TC001");
        task.setTaskName("Test Task");
        task.setTaskDescription("Test Description");
        task.setTaskStatus(0);
        tasks.add(task);

        // 模拟服务层返回
        when(unfinishedTaskOrderService.selectUnfinishedTaskOrderList(any(UnfinishedTaskOrder.class))).thenReturn(tasks);

        // 执行测试
        mockMvc.perform(get("/unfinishedTaskOrder/list")
                .param("userId", "1")
                .param("taskCode", "TC001"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unfinishedTaskOrderService, times(1)).selectUnfinishedTaskOrderList(any(UnfinishedTaskOrder.class));
    }

    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
        UnfinishedTaskOrder task = new UnfinishedTaskOrder();
        task.setTaskId(1L);
        task.setUserId(1L);
        task.setTaskCode("TC001");
        task.setTaskName("Test Task");
        task.setTaskDescription("Test Description");
        task.setTaskStatus(0);

        // 模拟服务层返回
        when(unfinishedTaskOrderService.selectUnfinishedTaskOrderById(1L)).thenReturn(task);

        // 执行测试
        mockMvc.perform(get("/unfinishedTaskOrder/{taskId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));

        // 验证服务层方法被调用
        verify(unfinishedTaskOrderService, times(1)).selectUnfinishedTaskOrderById(1L);
    }

    @Test
    public void testAdd() throws Exception {
        // 准备测试数据
        UnfinishedTaskOrder task = new UnfinishedTaskOrder();
        task.setUserId(1L);
        task.setTaskCode("TC001");
        task.setTaskName("Test Task");
        task.setTaskDescription("Test Description");
        task.setTaskStatus(0);

        // 模拟服务层返回
        when(unfinishedTaskOrderService.insertUnfinishedTaskOrder(task)).thenReturn(1);

        // 执行测试
        mockMvc.perform(post("/unfinishedTaskOrder")
                .contentType("application/json")
                .content("{\"userId\":1,\"taskCode\":\"TC001\",\"taskName\":\"Test Task\",\"taskDescription\":\"Test Description\",\"taskStatus\":0}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unfinishedTaskOrderService, times(1)).insertUnfinishedTaskOrder(any(UnfinishedTaskOrder.class));
    }

    @Test
    public void testEdit() throws Exception {
        // 准备测试数据
        UnfinishedTaskOrder task = new UnfinishedTaskOrder();
        task.setTaskId(1L);
        task.setUserId(1L);
        task.setTaskCode("TC001");
        task.setTaskName("Updated Task");
        task.setTaskDescription("Updated Description");
        task.setTaskStatus(1);

        // 模拟服务层返回
        when(unfinishedTaskOrderService.updateUnfinishedTaskOrder(task)).thenReturn(1);

        // 执行测试
        mockMvc.perform(put("/unfinishedTaskOrder")
                .contentType("application/json")
                .content("{\"taskId\":1,\"userId\":1,\"taskCode\":\"TC001\",\"taskName\":\"Updated Task\",\"taskDescription\":\"Updated Description\",\"taskStatus\":1}"))
                .andExpect(status().isOk());

        // 验证服务层方法被调用
        verify(unfinishedTaskOrderService, times(1)).updateUnfinishedTaskOrder(any(UnfinishedTaskOrder.class));
    }
}