# Mock测试使用案例

## 1. 概述

本文档提供了一个完整的Mock测试使用案例，展示如何为新添加的获取待处理事件接口编写测试。该案例基于pending_events表，演示了如何使用Mock技术进行单元测试。

## 2. 接口需求

### 2.1 功能描述
新增一个获取待处理事件的接口，用于查询pending_events表中的待处理事件。

### 2.2 接口定义
- **接口地址**: `/pendingEvents/list`
- **请求方式**: GET
- **请求参数**: 
  - userId: 用户ID（必需）
  - status: 事件状态（可选，默认为待处理状态）
  - pageNum: 页码（可选，默认为1）
  - pageSize: 每页条数（可选，默认为10）
- **说明**: 
  - 该接口根据提供的userId返回相应用户的待处理事件列表
  - 普通用户只能查询自己的待处理事件（userId必须是当前用户ID）
  - 管理员用户可以查询任意用户的待处理事件
- **返回结果**:
``json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [
    {
      "eventId": 1,
      "userId": 1,
      "eventName": "订单处理",
      "eventDetail": "订单号：ORD20250905001",
      "eventStatus": "未处理",
      "createTime": "2025-09-05 10:00:00",
      "updateTime": "2025-09-05 10:00:00"
    }
  ],
  "total": 1
}
```

## 3. 数据库表结构

### 3.1 pending_events表结构
``sql
CREATE TABLE pending_events (
    event_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '待处理事件的唯一标识，自增长整数',
    user_id BIGINT NOT NULL COMMENT '关联的系统用户 ID，表明事件所属用户，不可为空',
    event_name VARCHAR(255) NOT NULL COMMENT '事件的名称，最长 255 个字符，不能为空',
    event_detail TEXT COMMENT '事件的详细描述内容，文本类型',
    event_status ENUM('未处理', '处理中', '已处理') DEFAULT '未处理' COMMENT '事件的状态，包括未处理、处理中、已处理等，默认未处理',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '事件创建的时间，默认为当前时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '事件最后更新的时间，记录更新时自动更新为当前时间',
    FOREIGN KEY (user_id) REFERENCES sys_user(user_id)
) COMMENT '用于存储待处理事件相关信息的表';
```

## 4. 实体类设计

### 4.1 PendingEvent实体类
``java
package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 待处理事件对象 pending_events
 * 
 * @author ruoyi
 */
public class PendingEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 事件ID */
    private Long eventId;

    /** 用户ID */
    private Long userId;

    /** 事件名称 */
    private String eventName;

    /** 事件详细描述 */
    private String eventDetail;

    /** 事件状态（未处理/处理中/已处理） */
    private String eventStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    public PendingEvent() {
    }

    public PendingEvent(Long eventId) {
        this.eventId = eventId;
    }

    // Getter和Setter方法
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
```

## 5. Mapper层设计

### 5.1 PendingEventMapper接口
``java
package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.PendingEvent;

import java.util.List;

/**
 * 待处理事件Mapper接口
 * 
 * @author ruoyi
 */
public interface PendingEventMapper 
{
    /**
     * 查询待处理事件列表
     * 
     * @param pendingEvent 待处理事件
     * @return 待处理事件集合
     */
    public List<PendingEvent> selectPendingEventList(PendingEvent pendingEvent);

    /**
     * 查询待处理事件
     * 
     * @param eventId 事件ID
     * @return 待处理事件
     */
    public PendingEvent selectPendingEventById(Long eventId);

    /**
     * 新增待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    public int insertPendingEvent(PendingEvent pendingEvent);

    /**
     * 修改待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    public int updatePendingEvent(PendingEvent pendingEvent);

    /**
     * 删除待处理事件
     * 
     * @param eventId 事件ID
     * @return 结果
     */
    public int deletePendingEventById(Long eventId);

    /**
     * 批量删除待处理事件
     * 
     * @param eventIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePendingEventByIds(Long[] eventIds);
}
```

## 6. Service层设计

### 6.1 IPendingEventService接口
``java
package com.ruoyi.system.service;

import com.ruoyi.system.domain.PendingEvent;

import java.util.List;

/**
 * 待处理事件Service接口
 * 
 * @author ruoyi
 */
public interface IPendingEventService 
{
    /**
     * 查询待处理事件
     * 
     * @param eventId 事件ID
     * @return 待处理事件
     */
    public PendingEvent selectPendingEventById(Long eventId);

    /**
     * 查询待处理事件列表
     * 
     * @param pendingEvent 待处理事件
     * @return 待处理事件集合
     */
    public List<PendingEvent> selectPendingEventList(PendingEvent pendingEvent);

    /**
     * 新增待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    public int insertPendingEvent(PendingEvent pendingEvent);

    /**
     * 修改待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    public int updatePendingEvent(PendingEvent pendingEvent);

    /**
     * 批量删除待处理事件
     * 
     * @param eventIds 需要删除的事件ID
     * @return 结果
     */
    public int deletePendingEventByIds(Long[] eventIds);

    /**
     * 删除待处理事件信息
     * 
     * @param eventId 事件ID
     * @return 结果
     */
    public int deletePendingEventById(Long eventId);
}
```

### 6.2 PendingEventServiceImpl实现类
``java
package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.PendingEvent;
import com.ruoyi.system.mapper.PendingEventMapper;
import com.ruoyi.system.service.IPendingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 待处理事件Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class PendingEventServiceImpl implements IPendingEventService
{
    @Autowired
    private PendingEventMapper pendingEventMapper;

    /**
     * 查询待处理事件
     * 
     * @param eventId 事件ID
     * @return 待处理事件
     */
    @Override
    public PendingEvent selectPendingEventById(Long eventId)
    {
        return pendingEventMapper.selectPendingEventById(eventId);
    }

    /**
     * 查询待处理事件列表
     * 
     * @param pendingEvent 待处理事件
     * @return 待处理事件
     */
    @Override
    public List<PendingEvent> selectPendingEventList(PendingEvent pendingEvent)
    {
        return pendingEventMapper.selectPendingEventList(pendingEvent);
    }

    /**
     * 新增待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    @Override
    public int insertPendingEvent(PendingEvent pendingEvent)
    {
        return pendingEventMapper.insertPendingEvent(pendingEvent);
    }

    /**
     * 修改待处理事件
     * 
     * @param pendingEvent 待处理事件
     * @return 结果
     */
    @Override
    public int updatePendingEvent(PendingEvent pendingEvent)
    {
        return pendingEventMapper.updatePendingEvent(pendingEvent);
    }

    /**
     * 删除待处理事件对象
     * 
     * @param eventIds 需要删除的事件ID
     * @return 结果
     */
    @Override
    public int deletePendingEventByIds(Long[] eventIds)
    {
        return pendingEventMapper.deletePendingEventByIds(eventIds);
    }

    /**
     * 删除待处理事件信息
     * 
     * @param eventId 事件ID
     * @return 结果
     */
    @Override
    public int deletePendingEventById(Long eventId)
    {
        return pendingEventMapper.deletePendingEventById(eventId);
    }
}
```

## 7. Controller层设计

### 7.1 PendingEventController控制器
``java
package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PendingEvent;
import com.ruoyi.system.service.IPendingEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 待处理事件Controller
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/pendingEvents")
public class PendingEventController extends BaseController
{
    @Autowired
    private IPendingEventService pendingEventService;

    /**
     * 查询待处理事件列表
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:list')")
    @GetMapping("/list")
    public TableDataInfo list(PendingEvent pendingEvent)
    {
        startPage();
        List<PendingEvent> list = pendingEventService.selectPendingEventList(pendingEvent);
        return getDataTable(list);
    }

    /**
     * 获取待处理事件详细信息
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:query')")
    @GetMapping(value = "/{eventId}")
    public AjaxResult getInfo(@PathVariable("eventId") Long eventId)
    {
        return AjaxResult.success(pendingEventService.selectPendingEventById(eventId));
    }

    /**
     * 新增待处理事件
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:add')")
    @Log(title = "待处理事件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PendingEvent pendingEvent)
    {
        return toAjax(pendingEventService.insertPendingEvent(pendingEvent));
    }

    /**
     * 修改待处理事件
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:edit')")
    @Log(title = "待处理事件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PendingEvent pendingEvent)
    {
        return toAjax(pendingEventService.updatePendingEvent(pendingEvent));
    }

    /**
     * 删除待处理事件
     */
    @PreAuthorize("@ss.hasPermi('pendingEvents:remove')")
    @Log(title = "待处理事件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{eventIds}")
    public AjaxResult remove(@PathVariable Long[] eventIds)
    {
        return toAjax(pendingEventService.deletePendingEventByIds(eventIds));
    }
}
```

## 8. Mock测试案例

### 8.1 测试类设计
``java
package com.ruoyi.system.service;

import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.system.domain.PendingEvent;
import com.ruoyi.system.mapper.PendingEventMapper;
import com.ruoyi.system.service.impl.PendingEventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * 待处理事件Service层Mock测试
 * 
 * @author ruoyi
 */
public class PendingEventServiceMockTest {

    @Mock
    private PendingEventMapper pendingEventMapper;

    @InjectMocks
    private PendingEventServiceImpl pendingEventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // 设置分页参数
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(1);
        pageDomain.setPageSize(10);
        TableSupport.buildPageRequest(pageDomain);
    }

    /**
     * 测试查询待处理事件列表
     */
    @Test
    public void testSelectPendingEventList() {
        // 准备测试数据
        List<PendingEvent> mockEvents = new ArrayList<>();
        PendingEvent event1 = new PendingEvent();
        event1.setEventId(1L);
        event1.setEventType("订单处理");
        event1.setEventContent("订单号：ORD20250905001");
        event1.setStatus("0");
        event1.setCreateTime(new Date());
        mockEvents.add(event1);

        PendingEvent event2 = new PendingEvent();
        event2.setEventId(2L);
        event2.setEventType("库存补货");
        event2.setEventContent("商品ID：PROD001");
        event2.setStatus("0");
        event2.setCreateTime(new Date());
        mockEvents.add(event2);

        // 设置mock行为
        when(pendingEventMapper.selectPendingEventList(any(PendingEvent.class))).thenReturn(mockEvents);

        // 执行测试
        PendingEvent pendingEvent = new PendingEvent();
        pendingEvent.setStatus("0");
        List<PendingEvent> result = pendingEventService.selectPendingEventList(pendingEvent);

        // 验证结果
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("订单处理", result.get(0).getEventType());
        assertEquals("库存补货", result.get(1).getEventType());

        // 验证mock方法被调用
        verify(pendingEventMapper, times(1)).selectPendingEventList(any(PendingEvent.class));
    }

    /**
     * 测试根据ID查询待处理事件
     */
    @Test
    public void testSelectPendingEventById() {
        // 准备测试数据
        PendingEvent mockEvent = new PendingEvent();
        mockEvent.setEventId(1L);
        mockEvent.setEventType("订单处理");
        mockEvent.setEventContent("订单号：ORD20250905001");
        mockEvent.setStatus("0");
        mockEvent.setCreateTime(new Date());

        // 设置mock行为
        when(pendingEventMapper.selectPendingEventById(1L)).thenReturn(mockEvent);

        // 执行测试
        PendingEvent result = pendingEventService.selectPendingEventById(1L);

        // 验证结果
        assertNotNull(result);
        assertEquals(1L, result.getEventId().longValue());
        assertEquals("订单处理", result.getEventType());
        assertEquals("订单号：ORD20250905001", result.getEventContent());

        // 验证mock方法被调用
        verify(pendingEventMapper, times(1)).selectPendingEventById(1L);
    }

    /**
     * 测试新增待处理事件
     */
    @Test
    public void testInsertPendingEvent() {
        // 准备测试数据
        PendingEvent pendingEvent = new PendingEvent();
        pendingEvent.setEventType("订单处理");
        pendingEvent.setEventContent("订单号：ORD20250905001");
        pendingEvent.setStatus("0");

        // 设置mock行为
        when(pendingEventMapper.insertPendingEvent(any(PendingEvent.class))).thenReturn(1);

        // 执行测试
        int result = pendingEventService.insertPendingEvent(pendingEvent);

        // 验证结果
        assertEquals(1, result);

        // 验证mock方法被调用
        verify(pendingEventMapper, times(1)).insertPendingEvent(any(PendingEvent.class));
    }

    /**
}
```

### 8.2 控制器层Mock测试
``java
package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.system.domain.PendingEvent;
import com.ruoyi.system.service.IPendingEventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * 待处理事件Controller层Mock测试
 * 
 * @author ruoyi
 */
public class PendingEventControllerMockTest {

    @Mock
    private IPendingEventService pendingEventService;

    @InjectMocks
    private PendingEventController pendingEventController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * 测试查询待处理事件列表接口
     */
    @Test
    public void testList() {
        // 准备测试数据
        List<PendingEvent> mockEvents = new ArrayList<>();
        PendingEvent event1 = new PendingEvent();
        event1.setEventId(1L);
        event1.setEventType("订单处理");
        event1.setEventContent("订单号：ORD20250905001");
        event1.setStatus("0");
        event1.setCreateTime(new Date());
        mockEvents.add(event1);

        // 设置mock行为
        when(pendingEventService.selectPendingEventList(any(PendingEvent.class))).thenReturn(mockEvents);

        // 执行测试
        PendingEvent pendingEvent = new PendingEvent();
        pendingEvent.setStatus("0");
        TableDataInfo result = pendingEventController.list(pendingEvent);

        // 验证结果
        assertNotNull(result);
        assertEquals(200, result.getCode());
        assertEquals(1, result.getTotal());
        assertEquals(1, result.getRows().size());

        // 验证mock方法被调用
        verify(pendingEventService, times(1)).selectPendingEventList(any(PendingEvent.class));
    }

    /**
     * 测试获取待处理事件详细信息接口
     */
    @Test
    public void testGetInfo() {
        // 准备测试数据
        PendingEvent mockEvent = new PendingEvent();
        mockEvent.setEventId(1L);
        mockEvent.setEventType("订单处理");
        mockEvent.setEventContent("订单号：ORD20250905001");
        mockEvent.setStatus("0");
        mockEvent.setCreateTime(new Date());

        // 设置mock行为
        when(pendingEventService.selectPendingEventById(1L)).thenReturn(mockEvent);

        // 执行测试
        AjaxResult result = pendingEventController.getInfo(1L);

        // 验证结果
        assertNotNull(result);
        assertEquals(200, result.getCode());
        assertNotNull(result.get("data"));

        PendingEvent returnedEvent = (PendingEvent) result.get("data");
        assertEquals(1L, returnedEvent.getEventId().longValue());
        assertEquals("订单处理", returnedEvent.getEventType());

        // 验证mock方法被调用
        verify(pendingEventService, times(1)).selectPendingEventById(1L);
    }

    /**
     * 测试新增待处理事件接口
     */
    @Test
    public void testAdd() {
        // 准备测试数据
        PendingEvent pendingEvent = new PendingEvent();
        pendingEvent.setEventType("订单处理");
        pendingEvent.setEventContent("订单号：ORD20250905001");
        pendingEvent.setStatus("0");

        // 设置mock行为
        when(pendingEventService.insertPendingEvent(any(PendingEvent.class))).thenReturn(1);

        // 执行测试
        AjaxResult result = pendingEventController.add(pendingEvent);

        // 验证结果
        assertNotNull(result);
        assertEquals(200, result.getCode());

        // 验证mock方法被调用
        verify(pendingEventService, times(1)).insertPendingEvent(any(PendingEvent.class));
    }

    /**
     * 测试修改待处理事件接口
     */
    @Test
    public void testEdit() {
        // 准备测试数据
        PendingEvent pendingEvent = new PendingEvent();
        pendingEvent.setEventId(1L);
        pendingEvent.setEventType("订单处理");
        pendingEvent.setEventContent("订单号：ORD20250905001");
        pendingEvent.setStatus("1"); // 已处理

        // 设置mock行为
        when(pendingEventService.updatePendingEvent(any(PendingEvent.class))).thenReturn(1);

        // 执行测试
        AjaxResult result = pendingEventController.edit(pendingEvent);

        // 验证结果
        assertNotNull(result);
        assertEquals(200, result.getCode());

        // 验证mock方法被调用
        verify(pendingEventService, times(1)).updatePendingEvent(any(PendingEvent.class));
    }

    /**
     * 测试删除待处理事件接口
     */
    @Test
    public void testRemove() {
        Long[] eventIds = {1L, 2L, 3L};

        // 设置mock行为
        when(pendingEventService.deletePendingEventByIds(any(Long[].class))).thenReturn(3);

        // 执行测试
        AjaxResult result = pendingEventController.remove(eventIds);

        // 验证结果
        assertNotNull(result);
        assertEquals(200, result.getCode());

        // 验证mock方法被调用
        verify(pendingEventService, times(1)).deletePendingEventByIds(any(Long[].class));
    }
}
```

## 9. 总结

通过以上Mock测试案例，我们可以看到：

1. **隔离依赖**：使用Mock技术可以隔离被测试类与其他依赖组件，使测试更加纯粹和可控。
2. **提高测试效率**：避免了真实数据库访问等耗时操作，大大提高了测试执行速度。
3. **增强测试覆盖**：可以轻松模拟各种边界条件和异常情况，提高测试覆盖率。
4. **验证交互行为**：不仅可以验证返回结果，还可以验证方法间的交互行为是否符合预期。

在实际开发中，建议为每个Service和Controller类都编写相应的Mock测试，确保代码质量和系统稳定性。