# 未完工客户单接口Mock测试文档

## 接口需求说明

### 接口地址与方法
- 获取未完工客户单列表: GET /unfinishedCustomerOrder/list
- 获取未完工客户单详情: GET /unfinishedCustomerOrder/{orderId}
- 新增未完工客户单: POST /unfinishedCustomerOrder
- 修改未完工客户单: PUT /unfinishedCustomerOrder
- 删除未完工客户单: DELETE /unfinishedCustomerOrder/{orderIds}

### 请求参数说明
1. 获取列表参数:
   - userId: 用户ID（可选）
   - orderCode: 客户单编号（可选）
   - customerName: 客户名称（可选）
   - orderStatus: 订单状态（可选）

2. 获取详情参数:
   - orderId: 客户单ID（路径参数）

3. 新增客户单参数:
   - userId: 用户ID
   - orderCode: 客户单编号
   - customerName: 客户名称
   - orderAmount: 订单金额
   - orderStatus: 订单状态

4. 修改客户单参数:
   - orderId: 客户单ID
   - userId: 用户ID
   - orderCode: 客户单编号
   - customerName: 客户名称
   - orderAmount: 订单金额
   - orderStatus: 订单状态

5. 删除客户单参数:
   - orderIds: 客户单ID列表（路径参数）

## 数据库表结构设计

```sql
CREATE TABLE unfinished_customer_order (
  order_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '客户单ID',
  user_id BIGINT NOT NULL COMMENT '用户ID',
  order_code VARCHAR(50) COMMENT '客户单编号',
  customer_name VARCHAR(255) COMMENT '客户名称',
  order_amount DECIMAL(10,2) COMMENT '订单金额',
  order_status VARCHAR(50) COMMENT '订单状态',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
);
```

## 各层代码实现示例

### 实体类 (UnfinishedCustomerOrder.java)
```java
public class UnfinishedCustomerOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    private Long orderId;
    private Long userId;
    private String orderCode;
    private String customerName;
    private Double orderAmount;
    private String orderStatus;
    private Date createTime;
    private Date updateTime;
    
    // Getters and Setters
}
```

### Mapper接口 (UnfinishedCustomerOrderMapper.java)
```java
public interface UnfinishedCustomerOrderMapper {
    public UnfinishedCustomerOrder selectUnfinishedCustomerOrderById(Long orderId);
    public List<UnfinishedCustomerOrder> selectUnfinishedCustomerOrderList(UnfinishedCustomerOrder unfinishedCustomerOrder);
    public int insertUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder);
    public int updateUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder);
    public int deleteUnfinishedCustomerOrderById(Long orderId);
    public int deleteUnfinishedCustomerOrderByIds(Long[] orderIds);
}
```

### Service接口 (IUnfinishedCustomerOrderService.java)
```java
public interface IUnfinishedCustomerOrderService {
    public UnfinishedCustomerOrder selectUnfinishedCustomerOrderById(Long orderId);
    public List<UnfinishedCustomerOrder> selectUnfinishedCustomerOrderList(UnfinishedCustomerOrder unfinishedCustomerOrder);
    public int insertUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder);
    public int updateUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder);
    public int deleteUnfinishedCustomerOrderByIds(Long[] orderIds);
    public int deleteUnfinishedCustomerOrderById(Long orderId);
}
```

### Service实现类 (UnfinishedCustomerOrderServiceImpl.java)
```java
@Service
public class UnfinishedCustomerOrderServiceImpl implements IUnfinishedCustomerOrderService {
    @Autowired
    private UnfinishedCustomerOrderMapper unfinishedCustomerOrderMapper;
    
    @Override
    public UnfinishedCustomerOrder selectUnfinishedCustomerOrderById(Long orderId) {
        return unfinishedCustomerOrderMapper.selectUnfinishedCustomerOrderById(orderId);
    }
    
    @Override
    public List<UnfinishedCustomerOrder> selectUnfinishedCustomerOrderList(UnfinishedCustomerOrder unfinishedCustomerOrder) {
        return unfinishedCustomerOrderMapper.selectUnfinishedCustomerOrderList(unfinishedCustomerOrder);
    }
    
    @Override
    public int insertUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder) {
        return unfinishedCustomerOrderMapper.insertUnfinishedCustomerOrder(unfinishedCustomerOrder);
    }
    
    @Override
    public int updateUnfinishedCustomerOrder(UnfinishedCustomerOrder unfinishedCustomerOrder) {
        return unfinishedCustomerOrderMapper.updateUnfinishedCustomerOrder(unfinishedCustomerOrder);
    }
    
    @Override
    public int deleteUnfinishedCustomerOrderByIds(Long[] orderIds) {
        return unfinishedCustomerOrderMapper.deleteUnfinishedCustomerOrderByIds(orderIds);
    }
    
    @Override
    public int deleteUnfinishedCustomerOrderById(Long orderId) {
        return unfinishedCustomerOrderMapper.deleteUnfinishedCustomerOrderById(orderId);
    }
}
```

### Controller控制器 (UnfinishedCustomerOrderController.java)
```java
@RestController
@RequestMapping("/unfinishedCustomerOrder")
public class UnfinishedCustomerOrderController extends BaseController {
    @Autowired
    private IUnfinishedCustomerOrderService unfinishedCustomerOrderService;
    
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(UnfinishedCustomerOrder unfinishedCustomerOrder) {
        startPage();
        List<UnfinishedCustomerOrder> list = unfinishedCustomerOrderService.selectUnfinishedCustomerOrderList(unfinishedCustomerOrder);
        return getDataTable(list);
    }
    
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId) {
        return AjaxResult.success(unfinishedCustomerOrderService.selectUnfinishedCustomerOrderById(orderId));
    }
    
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:add')")
    @Log(title = "未完工客户单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UnfinishedCustomerOrder unfinishedCustomerOrder) {
        return toAjax(unfinishedCustomerOrderService.insertUnfinishedCustomerOrder(unfinishedCustomerOrder));
    }
    
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:edit')")
    @Log(title = "未完工客户单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UnfinishedCustomerOrder unfinishedCustomerOrder) {
        return toAjax(unfinishedCustomerOrderService.updateUnfinishedCustomerOrder(unfinishedCustomerOrder));
    }
    
    @PreAuthorize("@ss.hasPermi('unfinishedCustomerOrder:remove')")
    @Log(title = "未完工客户单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds) {
        return toAjax(unfinishedCustomerOrderService.deleteUnfinishedCustomerOrderByIds(orderIds));
    }
}
```

## 完整的Mock测试案例

### Service层测试 (UnfinishedCustomerOrderServiceTest.java)
```java
@SpringBootTest(classes = RuoYiApplication.class)
public class UnfinishedCustomerOrderServiceTest {
    @Mock
    private UnfinishedCustomerOrderMapper unfinishedCustomerOrderMapper;
    
    @InjectMocks
    private UnfinishedCustomerOrderServiceImpl unfinishedCustomerOrderService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testSelectUnfinishedCustomerOrderList() {
        // 准备测试数据
        List<UnfinishedCustomerOrder> expectedList = new ArrayList<>();
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setOrderId(1L);
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Test Customer");
        order.setOrderAmount(100.0);
        order.setOrderStatus("PROCESSING");
        expectedList.add(order);
        
        // 模拟Mapper层返回
        when(unfinishedCustomerOrderMapper.selectUnfinishedCustomerOrderList(any(UnfinishedCustomerOrder.class))).thenReturn(expectedList);
        
        // 执行测试
        List<UnfinishedCustomerOrder> actualList = unfinishedCustomerOrderService.selectUnfinishedCustomerOrderList(new UnfinishedCustomerOrder());
        
        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("OC001", actualList.get(0).getOrderCode());
        
        // 验证Mapper方法被调用
        verify(unfinishedCustomerOrderMapper, times(1)).selectUnfinishedCustomerOrderList(any(UnfinishedCustomerOrder.class));
    }
    
    @Test
    public void testSelectUnfinishedCustomerOrderById() {
        // 准备测试数据
        UnfinishedCustomerOrder expectedOrder = new UnfinishedCustomerOrder();
        expectedOrder.setOrderId(1L);
        expectedOrder.setUserId(1L);
        expectedOrder.setOrderCode("OC001");
        expectedOrder.setCustomerName("Test Customer");
        expectedOrder.setOrderAmount(100.0);
        expectedOrder.setOrderStatus("PROCESSING");
        
        // 模拟Mapper层返回
        when(unfinishedCustomerOrderMapper.selectUnfinishedCustomerOrderById(1L)).thenReturn(expectedOrder);
        
        // 执行测试
        UnfinishedCustomerOrder actualOrder = unfinishedCustomerOrderService.selectUnfinishedCustomerOrderById(1L);
        
        // 验证结果
        assertNotNull(actualOrder);
        assertEquals("OC001", actualOrder.getOrderCode());
        
        // 验证Mapper方法被调用
        verify(unfinishedCustomerOrderMapper, times(1)).selectUnfinishedCustomerOrderById(1L);
    }
    
    // 其他测试方法...
}
```

### Controller层测试 (UnfinishedCustomerOrderControllerTest.java)
```java
@SpringBootTest(classes = RuoYiApplication.class)
public class UnfinishedCustomerOrderControllerTest {
    private MockMvc mockMvc;
    
    @Mock
    private IUnfinishedCustomerOrderService unfinishedCustomerOrderService;
    
    @InjectMocks
    private UnfinishedCustomerOrderController unfinishedCustomerOrderController;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(unfinishedCustomerOrderController).build();
    }
    
    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<UnfinishedCustomerOrder> orders = new ArrayList<>();
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setOrderId(1L);
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Test Customer");
        order.setOrderAmount(100.0);
        order.setOrderStatus("PROCESSING");
        orders.add(order);
        
        // 模拟服务层返回
        when(unfinishedCustomerOrderService.selectUnfinishedCustomerOrderList(any(UnfinishedCustomerOrder.class))).thenReturn(orders);
        
        // 执行测试
        mockMvc.perform(get("/unfinishedCustomerOrder/list")
                .param("userId", "1")
                .param("orderCode", "OC001"))
                .andExpect(status().isOk());
        
        // 验证服务层方法被调用
        verify(unfinishedCustomerOrderService, times(1)).selectUnfinishedCustomerOrderList(any(UnfinishedCustomerOrder.class));
    }
    
    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
        UnfinishedCustomerOrder order = new UnfinishedCustomerOrder();
        order.setOrderId(1L);
        order.setUserId(1L);
        order.setOrderCode("OC001");
        order.setCustomerName("Test Customer");
        order.setOrderAmount(100.0);
        order.setOrderStatus("PROCESSING");
        
        // 模拟服务层返回
        when(unfinishedCustomerOrderService.selectUnfinishedCustomerOrderById(1L)).thenReturn(order);
        
        // 执行测试
        mockMvc.perform(get("/unfinishedCustomerOrder/{orderId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        // 验证服务层方法被调用
        verify(unfinishedCustomerOrderService, times(1)).selectUnfinishedCustomerOrderById(1L);
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