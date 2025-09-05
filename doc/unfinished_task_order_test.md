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
   - taskStatus: 任务状态（可选）

2. 获取详情参数:
   - taskId: 任务单ID（路径参数）

3. 新增任务单参数:
   - userId: 用户ID
   - taskCode: 任务单编号
   - taskName: 任务名称
   - taskDescription: 任务描述
   - taskStatus: 任务状态

4. 修改任务单参数:
   - taskId: 任务单ID
   - userId: 用户ID
   - taskCode: 任务单编号
   - taskName: 任务名称
   - taskDescription: 任务描述
   - taskStatus: 任务状态

5. 删除任务单参数:
   - taskIds: 任务单ID列表（路径参数）

## 数据库表结构设计

```sql
CREATE TABLE unfinished_task_order (
  task_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '任务单ID',
  user_id BIGINT NOT NULL COMMENT '用户ID',
  task_code VARCHAR(50) COMMENT '任务单编号',
  task_name VARCHAR(255) COMMENT '任务名称',
  task_description TEXT COMMENT '任务描述',
  task_status VARCHAR(50) COMMENT '任务状态',
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
    private String taskStatus;
    private Date createTime;
    private Date updateTime;
    
    // Getters and Setters
}
```

### Mapper接口 (UnfinishedTaskOrderMapper.java)
```java
public interface UnfinishedTaskOrderMapper {
    public UnfinishedTaskOrder selectUnfinishedTaskOrderById(Long taskId);
    public List<UnfinishedTaskOrder> selectUnfinishedTaskOrderList(UnfinishedTaskOrder unfinishedTaskOrder);
    public int insertUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder);
    public int updateUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder);
    public int deleteUnfinishedTaskOrderById(Long taskId);
    public int deleteUnfinishedTaskOrderByIds(Long[] taskIds);
}
```

### Service接口 (IUnfinishedTaskOrderService.java)
```java
public interface IUnfinishedTaskOrderService {
    public UnfinishedTaskOrder selectUnfinishedTaskOrderById(Long taskId);
    public List<UnfinishedTaskOrder> selectUnfinishedTaskOrderList(UnfinishedTaskOrder unfinishedTaskOrder);
    public int insertUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder);
    public int updateUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder);
    public int deleteUnfinishedTaskOrderByIds(Long[] taskIds);
    public int deleteUnfinishedTaskOrderById(Long taskId);
}
```

### Service实现类 (UnfinishedTaskOrderServiceImpl.java)
```java
@Service
public class UnfinishedTaskOrderServiceImpl implements IUnfinishedTaskOrderService {
    @Autowired
    private UnfinishedTaskOrderMapper unfinishedTaskOrderMapper;
    
    @Override
    public UnfinishedTaskOrder selectUnfinishedTaskOrderById(Long taskId) {
        return unfinishedTaskOrderMapper.selectUnfinishedTaskOrderById(taskId);
    }
    
    @Override
    public List<UnfinishedTaskOrder> selectUnfinishedTaskOrderList(UnfinishedTaskOrder unfinishedTaskOrder) {
        return unfinishedTaskOrderMapper.selectUnfinishedTaskOrderList(unfinishedTaskOrder);
    }
    
    @Override
    public int insertUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder) {
        return unfinishedTaskOrderMapper.insertUnfinishedTaskOrder(unfinishedTaskOrder);
    }
    
    @Override
    public int updateUnfinishedTaskOrder(UnfinishedTaskOrder unfinishedTaskOrder) {
        return unfinishedTaskOrderMapper.updateUnfinishedTaskOrder(unfinishedTaskOrder);
    }
    
    @Override
    public int deleteUnfinishedTaskOrderByIds(Long[] taskIds) {
        return unfinishedTaskOrderMapper.deleteUnfinishedTaskOrderByIds(taskIds);
    }
    
    @Override
    public int deleteUnfinishedTaskOrderById(Long taskId) {
        return unfinishedTaskOrderMapper.deleteUnfinishedTaskOrderById(taskId);
    }
}
```

### Controller控制器 (UnfinishedTaskOrderController.java)
```java
@RestController
@RequestMapping("/unfinishedTaskOrder")
public class UnfinishedTaskOrderController extends BaseController {
    @Autowired
    private IUnfinishedTaskOrderService unfinishedTaskOrderService;
    
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(UnfinishedTaskOrder unfinishedTaskOrder) {
        startPage();
        List<UnfinishedTaskOrder> list = unfinishedTaskOrderService.selectUnfinishedTaskOrderList(unfinishedTaskOrder);
        return getDataTable(list);
    }
    
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId) {
        return AjaxResult.success(unfinishedTaskOrderService.selectUnfinishedTaskOrderById(taskId));
    }
    
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:add')")
    @Log(title = "未完工任务单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UnfinishedTaskOrder unfinishedTaskOrder) {
        return toAjax(unfinishedTaskOrderService.insertUnfinishedTaskOrder(unfinishedTaskOrder));
    }
    
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:edit')")
    @Log(title = "未完工任务单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UnfinishedTaskOrder unfinishedTaskOrder) {
        return toAjax(unfinishedTaskOrderService.updateUnfinishedTaskOrder(unfinishedTaskOrder));
    }
    
    @PreAuthorize("@ss.hasPermi('unfinishedTaskOrder:remove')")
    @Log(title = "未完工任务单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds) {
        return toAjax(unfinishedTaskOrderService.deleteUnfinishedTaskOrderByIds(taskIds));
    }
}
```

## 完整的Mock测试案例

### Service层测试 (UnfinishedTaskOrderServiceTest.java)
```java
@SpringBootTest(classes = RuoYiApplication.class)
public class UnfinishedTaskOrderServiceTest {
    @Mock
    private UnfinishedTaskOrderMapper unfinishedTaskOrderMapper;
    
    @InjectMocks
    private UnfinishedTaskOrderServiceImpl unfinishedTaskOrderService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testSelectUnfinishedTaskOrderList() {
        // 准备测试数据
        List<UnfinishedTaskOrder> expectedList = new ArrayList<>();
        UnfinishedTaskOrder task = new UnfinishedTaskOrder();
        task.setTaskId(1L);
        task.setUserId(1L);
        task.setTaskCode("TC001");
        task.setTaskName("Test Task");
        task.setTaskDescription("Test Description");
        task.setTaskStatus("PROCESSING");
        expectedList.add(task);
        
        // 模拟Mapper层返回
        when(unfinishedTaskOrderMapper.selectUnfinishedTaskOrderList(any(UnfinishedTaskOrder.class))).thenReturn(expectedList);
        
        // 执行测试
        List<UnfinishedTaskOrder> actualList = unfinishedTaskOrderService.selectUnfinishedTaskOrderList(new UnfinishedTaskOrder());
        
        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("TC001", actualList.get(0).getTaskCode());
        
        // 验证Mapper方法被调用
        verify(unfinishedTaskOrderMapper, times(1)).selectUnfinishedTaskOrderList(any(UnfinishedTaskOrder.class));
    }
    
    @Test
    public void testSelectUnfinishedTaskOrderById() {
        // 准备测试数据
        UnfinishedTaskOrder expectedTask = new UnfinishedTaskOrder();
        expectedTask.setTaskId(1L);
        expectedTask.setUserId(1L);
        expectedTask.setTaskCode("TC001");
        expectedTask.setTaskName("Test Task");
        expectedTask.setTaskDescription("Test Description");
        expectedTask.setTaskStatus("PROCESSING");
        
        // 模拟Mapper层返回
        when(unfinishedTaskOrderMapper.selectUnfinishedTaskOrderById(1L)).thenReturn(expectedTask);
        
        // 执行测试
        UnfinishedTaskOrder actualTask = unfinishedTaskOrderService.selectUnfinishedTaskOrderById(1L);
        
        // 验证结果
        assertNotNull(actualTask);
        assertEquals("TC001", actualTask.getTaskCode());
        
        // 验证Mapper方法被调用
        verify(unfinishedTaskOrderMapper, times(1)).selectUnfinishedTaskOrderById(1L);
    }
    
    // 其他测试方法...
}
```

### Controller层测试 (UnfinishedTaskOrderControllerTest.java)
```java
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
        task.setTaskStatus("PROCESSING");
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
        task.setTaskStatus("PROCESSING");
        
        // 模拟服务层返回
        when(unfinishedTaskOrderService.selectUnfinishedTaskOrderById(1L)).thenReturn(task);
        
        // 执行测试
        mockMvc.perform(get("/unfinishedTaskOrder/{taskId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        // 验证服务层方法被调用
        verify(unfinishedTaskOrderService, times(1)).selectUnfinishedTaskOrderById(1L);
    }
    
    // 其他测试方法...
}
```

## 测试方法和最佳实践

### 测试覆盖率
1. Service层测试应覆盖所有业务逻辑方法
2. Controller层测试应覆盖所有接口方法
3. 对于每个方法，应测试正常流程和异常流程

### 边界条件测试
1. 测试空参数情况
2. 测试无效参数情况
3. 测试数据库异常情况

### 测试数据准备
1. 使用真实但不敏感的测试数据
2. 确保测试数据的完整性和一致性
3. 在测试结束后清理测试数据

### 验证方法调用
1. 使用Mockito.verify()验证方法调用次数
2. 使用Mockito.verify()验证方法调用参数
3. 确保所有Mock方法都有相应的验证