# 任务进度接口 Mock 测试示例

## 接口需求说明

### 接口1: 默认查询
- 地址：`/custom/taskprogress/list`
- 请求方式：GET
- 功能说明：查询所有任务进度列表

### 接口2: 根据名称模糊查询
- 地址：`/custom/taskprogress/listByName/{taskName}`
- 请求方式：GET
- 功能说明：根据任务名称模糊匹配查询任务进度列表

### 接口3: 根据发布者模糊查询
- 地址：`/custom/taskprogress/listByPublisher/{publisher}`
- 请求方式：GET
- 功能说明：根据发布者模糊匹配查询任务进度列表

### 接口4: 根据开始日期和结束日期查询
- 地址：`/custom/taskprogress/listByDateRange`
- 请求方式：GET
- 功能说明：根据开始日期和结束日期范围查询任务进度列表

## 数据库表结构设计

```sql
CREATE TABLE cus_task_progress (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '任务进度ID',
    task_name VARCHAR(255) COMMENT '任务名称',
    publisher VARCHAR(100) COMMENT '发布者',
    start_date DATE COMMENT '开始日期',
    end_date DATE COMMENT '结束日期',
    progress DECIMAL(5,2) COMMENT '进度百分比',
    status VARCHAR(20) COMMENT '状态',
    create_time DATETIME COMMENT '创建时间',
    update_time DATETIME COMMENT '更新时间'
);
```

## 各层代码实现示例

### 实体类

```java
public class CusTaskProgress extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /** 任务进度ID */
    private Long id;
    
    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;
    
    /** 发布者 */
    @Excel(name = "发布者")
    private String publisher;
    
    /** 开始日期 */
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;
    
    /** 结束日期 */
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;
    
    /** 进度百分比 */
    @Excel(name = "进度百分比")
    private BigDecimal progress;
    
    /** 状态 */
    @Excel(name = "状态")
    private String status;
    
    // 省略 getter 和 setter 方法
}
```

### Mapper 接口

```java
@Mapper
public interface CusTaskProgressMapper {
    /**
     * 查询任务进度列表
     * 
     * @param cusTaskProgress 任务进度
     * @return 任务进度集合
     */
    public List<CusTaskProgress> selectCusTaskProgressList(CusTaskProgress cusTaskProgress);
    
    // 其他方法...
}
```

### Service 接口

```java
public interface ICusTaskProgressService {
    /**
     * 查询任务进度列表
     * 
     * @param cusTaskProgress 任务进度
     * @return 任务进度集合
     */
    public List<CusTaskProgress> selectCusTaskProgressList(CusTaskProgress cusTaskProgress);
    
    // 其他方法...
}
```

### Service 实现类

```java
@Service
public class CusTaskProgressServiceImpl implements ICusTaskProgressService {
    @Autowired
    private CusTaskProgressMapper cusTaskProgressMapper;
    
    /**
     * 查询任务进度列表
     * 
     * @param cusTaskProgress 任务进度
     * @return 任务进度
     */
    @Override
    public List<CusTaskProgress> selectCusTaskProgressList(CusTaskProgress cusTaskProgress) {
        return cusTaskProgressMapper.selectCusTaskProgressList(cusTaskProgress);
    }
    
    // 其他方法...
}
```

### Controller 控制器

```java
@RestController
@RequestMapping("/custom/taskprogress")
public class CusTaskProgressController extends BaseController {
    @Autowired
    private ICusTaskProgressService cusTaskProgressService;
    
    /**
     * 查询任务进度列表 - 默认查询接口
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:list')")
    @GetMapping("/list")
    public TableDataInfo list() {
        CusTaskProgress cusTaskProgress = new CusTaskProgress();
        startPage();
        List<CusTaskProgress> list = cusTaskProgressService.selectCusTaskProgressList(cusTaskProgress);
        return getDataTable(list);
    }
    
    /**
     * 根据名称模糊匹配查询
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:list')")
    @GetMapping("/listByName/{taskName}")
    public TableDataInfo listByName(@PathVariable("taskName") String taskName) {
        CusTaskProgress cusTaskProgress = new CusTaskProgress();
        cusTaskProgress.setTaskName(taskName);
        startPage();
        List<CusTaskProgress> list = cusTaskProgressService.selectCusTaskProgressList(cusTaskProgress);
        return getDataTable(list);
    }
    
    /**
     * 根据发布者模糊查询
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:list')")
    @GetMapping("/listByPublisher/{publisher}")
    public TableDataInfo listByPublisher(@PathVariable("publisher") String publisher) {
        CusTaskProgress cusTaskProgress = new CusTaskProgress();
        cusTaskProgress.setPublisher(publisher);
        startPage();
        List<CusTaskProgress> list = cusTaskProgressService.selectCusTaskProgressList(cusTaskProgress);
        return getDataTable(list);
    }
    
    /**
     * 根据开始日期和结束日期查询
     */
    @PreAuthorize("@ss.hasPermi('custom:taskprogress:list')")
    @GetMapping("/listByDateRange")
    public TableDataInfo listByDateRange(String startDate, String endDate) {
        CusTaskProgress cusTaskProgress = new CusTaskProgress();
        if (startDate != null && !startDate.isEmpty()) {
            cusTaskProgress.setStartDate(DateUtils.parseDate(startDate));
        }
        if (endDate != null && !endDate.isEmpty()) {
            cusTaskProgress.setEndDate(DateUtils.parseDate(endDate));
        }
        startPage();
        List<CusTaskProgress> list = cusTaskProgressService.selectCusTaskProgressList(cusTaskProgress);
        return getDataTable(list);
    }
    
    // 其他方法...
}
```

## 完整的 Mock 测试案例

### Service 层测试

```java
@ExtendWith(MockitoExtension.class)
public class CusTaskProgressServiceTest {
    
    @InjectMocks
    private CusTaskProgressServiceImpl cusTaskProgressService;
    
    @Mock
    private CusTaskProgressMapper cusTaskProgressMapper;
    
    @Test
    public void testSelectCusTaskProgressList() {
        // 准备测试数据
        List<CusTaskProgress> mockList = new ArrayList<>();
        CusTaskProgress task1 = new CusTaskProgress();
        task1.setId(1L);
        task1.setTaskName("网站开发项目");
        task1.setPublisher("张三");
        task1.setStartDate(DateUtils.parseDate("2025-09-01"));
        task1.setEndDate(DateUtils.parseDate("2025-09-30"));
        task1.setProgress(new BigDecimal("65.50"));
        task1.setStatus("进行中");
        mockList.add(task1);
        
        CusTaskProgress task2 = new CusTaskProgress();
        task2.setId(2L);
        task2.setTaskName("移动应用开发");
        task2.setPublisher("李四");
        task2.setStartDate(DateUtils.parseDate("2025-08-15"));
        task2.setEndDate(DateUtils.parseDate("2025-10-15"));
        task2.setProgress(new BigDecimal("30.00"));
        task2.setStatus("进行中");
        mockList.add(task2);
        
        // 定义行为
        when(cusTaskProgressMapper.selectCusTaskProgressList(any(CusTaskProgress.class)))
            .thenReturn(mockList);
        
        // 执行测试
        CusTaskProgress queryParam = new CusTaskProgress();
        List<CusTaskProgress> result = cusTaskProgressService.selectCusTaskProgressList(queryParam);
        
        // 验证结果
        assertEquals(2, result.size());
        assertEquals("网站开发项目", result.get(0).getTaskName());
        assertEquals("移动应用开发", result.get(1).getTaskName());
        
        // 验证方法调用
        verify(cusTaskProgressMapper, times(1))
            .selectCusTaskProgressList(any(CusTaskProgress.class));
    }
    
    @Test
    public void testSelectCusTaskProgressListByName() {
        // 准备测试数据
        List<CusTaskProgress> mockList = new ArrayList<>();
        CusTaskProgress task = new CusTaskProgress();
        task.setId(1L);
        task.setTaskName("网站开发项目");
        task.setPublisher("张三");
        task.setStartDate(DateUtils.parseDate("2025-09-01"));
        task.setEndDate(DateUtils.parseDate("2025-09-30"));
        task.setProgress(new BigDecimal("65.50"));
        task.setStatus("进行中");
        mockList.add(task);
        
        // 定义行为
        when(cusTaskProgressMapper.selectCusTaskProgressList(any(CusTaskProgress.class)))
            .thenReturn(mockList);
        
        // 执行测试
        CusTaskProgress queryParam = new CusTaskProgress();
        queryParam.setTaskName("网站");
        List<CusTaskProgress> result = cusTaskProgressService.selectCusTaskProgressList(queryParam);
        
        // 验证结果
        assertEquals(1, result.size());
        assertEquals("网站开发项目", result.get(0).getTaskName());
        
        // 验证方法调用
        verify(cusTaskProgressMapper, times(1))
            .selectCusTaskProgressList(any(CusTaskProgress.class));
    }
}
```

### Controller 层测试

```java
@ExtendWith(MockitoExtension.class)
public class CusTaskProgressControllerTest extends BaseControllerTest {
    
    @InjectMocks
    private CusTaskProgressController cusTaskProgressController;
    
    @Mock
    private ICusTaskProgressService cusTaskProgressService;
    
    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<CusTaskProgress> mockList = new ArrayList<>();
        CusTaskProgress task = new CusTaskProgress();
        task.setId(1L);
        task.setTaskName("网站开发项目");
        task.setPublisher("张三");
        task.setStartDate(DateUtils.parseDate("2025-09-01"));
        task.setEndDate(DateUtils.parseDate("2025-09-30"));
        task.setProgress(new BigDecimal("65.50"));
        task.setStatus("进行中");
        mockList.add(task);
        
        // 定义行为
        when(cusTaskProgressService.selectCusTaskProgressList(any(CusTaskProgress.class)))
            .thenReturn(mockList);
        
        // 执行测试
        ResultActions result = mockMvc.perform(get("/custom/taskprogress/list")
                .contentType(MediaType.APPLICATION_JSON));
        
        // 验证结果
        result.andExpect(status().isOk())
              .andExpect(jsonPath("$.code").value(200))
              .andExpect(jsonPath("$.rows").isArray())
              .andExpect(jsonPath("$.rows.length()").value(1))
              .andExpect(jsonPath("$.rows[0].taskName").value("网站开发项目"));
        
        // 验证方法调用
        verify(cusTaskProgressService, times(1))
            .selectCusTaskProgressList(any(CusTaskProgress.class));
    }
    
    @Test
    public void testListByName() throws Exception {
        // 准备测试数据
        List<CusTaskProgress> mockList = new ArrayList<>();
        CusTaskProgress task = new CusTaskProgress();
        task.setId(1L);
        task.setTaskName("网站开发项目");
        task.setPublisher("张三");
        task.setStartDate(DateUtils.parseDate("2025-09-01"));
        task.setEndDate(DateUtils.parseDate("2025-09-30"));
        task.setProgress(new BigDecimal("65.50"));
        task.setStatus("进行中");
        mockList.add(task);
        
        // 定义行为
        when(cusTaskProgressService.selectCusTaskProgressList(any(CusTaskProgress.class)))
            .thenReturn(mockList);
        
        // 执行测试
        ResultActions result = mockMvc.perform(get("/custom/taskprogress/listByName/网站")
                .contentType(MediaType.APPLICATION_JSON));
        
        // 验证结果
        result.andExpect(status().isOk())
              .andExpect(jsonPath("$.code").value(200))
              .andExpect(jsonPath("$.rows").isArray())
              .andExpect(jsonPath("$.rows.length()").value(1))
              .andExpect(jsonPath("$.rows[0].taskName").value("网站开发项目"));
        
        // 验证方法调用
        verify(cusTaskProgressService, times(1))
            .selectCusTaskProgressList(any(CusTaskProgress.class));
    }
}
```

## 测试方法和最佳实践

### 测试数据准备

1. 为每个测试用例准备独立的测试数据
2. 使用真实场景的数据，包括边界值和异常值
3. 确保测试数据能够覆盖所有查询条件

### 边界条件测试

1. 测试空查询条件（默认查询）
2. 测试部分查询条件
3. 测试所有查询条件
4. 测试查询结果为空的情况
5. 测试查询结果包含多条记录的情况

### 验证点

1. 验证返回数据的正确性
2. 验证分页功能的正确性
3. 验证查询条件是否正确应用
4. 验证方法调用次数和参数
5. 验证权限控制是否生效

# 未完工任务单接口Mock测试文档

## 接口需求说明

### 接口地址与方法
- 获取未完工任务单列表: GET /unfinishedTaskOrder/list
- 获取未完工任务单详情: GET /unfinishedTaskOrder/{taskId}
- 新增未完工任务单: POST /unfinishedTaskOrder
- 修改未完工任务单: PUT /unfinishedTaskOrder
- 删除未完工任务单: DELETE /unfinishedTaskOrder/{taskIds}

### 请求参数说明
1. 获取列表参数:
   - userId: 用户ID（可选）
   - taskCode: 任务单编号（可选）
   - taskName: 任务名称（可选）
   - taskStatus: 任务状态（可选，0未完工 1完工）

2. 获取详情参数:
   - taskId: 任务单ID（路径参数）

3. 新增任务单参数:
   - userId: 用户ID
   - taskCode: 任务单编号
   - taskName: 任务名称
   - taskDescription: 任务描述
   - taskStatus: 任务状态（0未完工 1完工）

4. 修改任务单参数:
   - taskId: 任务单ID
   - userId: 用户ID
   - taskCode: 任务单编号
   - taskName: 任务名称
   - taskDescription: 任务描述
   - taskStatus: 任务状态（0未完工 1完工）

5. 删除任务单参数:
   - taskIds: 任务单ID列表（路径参数）

## 数据库表结构设计

```
CREATE TABLE unfinished_task_order (
  task_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '任务单ID',
  user_id BIGINT NOT NULL COMMENT '用户ID',
  task_code VARCHAR(50) COMMENT '任务单编号',
  task_name VARCHAR(255) COMMENT '任务名称',
  task_description TEXT COMMENT '任务描述',
  task_status INT COMMENT '任务状态（0未完工 1完工）',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
);
```

## 各层代码实现示例

### 实体类 (UnfinishedTaskOrder.java)
```java
public class UnfinishedTaskOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    private Long taskId;
    private Long userId;
    private String taskCode;
    private String taskName;
    private String taskDescription;
    private Integer taskStatus;
    private Date createTime;
    private Date updateTime;
    
    // Getters and Setters
}
```

