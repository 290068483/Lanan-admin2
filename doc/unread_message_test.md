# 未读消息接口Mock测试文档

## 接口需求说明

### 接口地址与方法
- 获取未读消息列表: GET /unreadMessage/list
- 获取未读消息详情: GET /unreadMessage/{messageId}
- 新增未读消息: POST /unreadMessage
- 修改未读消息: PUT /unreadMessage
- 删除未读消息: DELETE /unreadMessage/{messageIds}

### 请求参数说明
1. 获取列表参数:
   - userId: 用户ID（可选）
   - messageType: 消息类型（可选）
   - isRead: 是否已读（可选）

2. 获取详情参数:
   - messageId: 消息ID（路径参数）

3. 新增消息参数:
   - userId: 用户ID
   - messageTitle: 消息标题
   - messageContent: 消息内容
   - messageType: 消息类型
   - isRead: 是否已读

4. 修改消息参数:
   - messageId: 消息ID
   - userId: 用户ID
   - messageTitle: 消息标题
   - messageContent: 消息内容
   - messageType: 消息类型
   - isRead: 是否已读

5. 删除消息参数:
   - messageIds: 消息ID列表（路径参数）

## 数据库表结构设计

```sql
CREATE TABLE unread_message (
  message_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '消息ID',
  user_id BIGINT NOT NULL COMMENT '用户ID',
  message_title VARCHAR(255) COMMENT '消息标题',
  message_content TEXT COMMENT '消息内容',
  message_type VARCHAR(50) COMMENT '消息类型',
  is_read CHAR(1) DEFAULT '0' COMMENT '是否已读（0未读 1已读）',
  create_time DATETIME COMMENT '创建时间',
  update_time DATETIME COMMENT '更新时间'
);
```

## 各层代码实现示例

### 实体类 (UnreadMessage.java)
```java
public class UnreadMessage extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    private Long messageId;
    private Long userId;
    private String messageTitle;
    private String messageContent;
    private String messageType;
    private String isRead;
    private Date createTime;
    private Date updateTime;
    
    // Getters and Setters
}
```

### Mapper接口 (UnreadMessageMapper.java)
```java
public interface UnreadMessageMapper {
    public UnreadMessage selectUnreadMessageById(Long messageId);
    public List<UnreadMessage> selectUnreadMessageList(UnreadMessage unreadMessage);
    public int insertUnreadMessage(UnreadMessage unreadMessage);
    public int updateUnreadMessage(UnreadMessage unreadMessage);
    public int deleteUnreadMessageById(Long messageId);
    public int deleteUnreadMessageByIds(Long[] messageIds);
}
```

### Service接口 (IUnreadMessageService.java)
```java
public interface IUnreadMessageService {
    public UnreadMessage selectUnreadMessageById(Long messageId);
    public List<UnreadMessage> selectUnreadMessageList(UnreadMessage unreadMessage);
    public int insertUnreadMessage(UnreadMessage unreadMessage);
    public int updateUnreadMessage(UnreadMessage unreadMessage);
    public int deleteUnreadMessageByIds(Long[] messageIds);
    public int deleteUnreadMessageById(Long messageId);
}
```

### Service实现类 (UnreadMessageServiceImpl.java)
```java
@Service
public class UnreadMessageServiceImpl implements IUnreadMessageService {
    @Autowired
    private UnreadMessageMapper unreadMessageMapper;
    
    @Override
    public UnreadMessage selectUnreadMessageById(Long messageId) {
        return unreadMessageMapper.selectUnreadMessageById(messageId);
    }
    
    @Override
    public List<UnreadMessage> selectUnreadMessageList(UnreadMessage unreadMessage) {
        return unreadMessageMapper.selectUnreadMessageList(unreadMessage);
    }
    
    @Override
    public int insertUnreadMessage(UnreadMessage unreadMessage) {
        return unreadMessageMapper.insertUnreadMessage(unreadMessage);
    }
    
    @Override
    public int updateUnreadMessage(UnreadMessage unreadMessage) {
        return unreadMessageMapper.updateUnreadMessage(unreadMessage);
    }
    
    @Override
    public int deleteUnreadMessageByIds(Long[] messageIds) {
        return unreadMessageMapper.deleteUnreadMessageByIds(messageIds);
    }
    
    @Override
    public int deleteUnreadMessageById(Long messageId) {
        return unreadMessageMapper.deleteUnreadMessageById(messageId);
    }
}
```

### Controller控制器 (UnreadMessageController.java)
```java
@RestController
@RequestMapping("/unreadMessage")
public class UnreadMessageController extends BaseController {
    @Autowired
    private IUnreadMessageService unreadMessageService;
    
    @PreAuthorize("@ss.hasPermi('unreadMessage:list')")
    @GetMapping("/list")
    public TableDataInfo list(UnreadMessage unreadMessage) {
        startPage();
        List<UnreadMessage> list = unreadMessageService.selectUnreadMessageList(unreadMessage);
        return getDataTable(list);
    }
    
    @PreAuthorize("@ss.hasPermi('unreadMessage:query')")
    @GetMapping(value = "/{messageId}")
    public AjaxResult getInfo(@PathVariable("messageId") Long messageId) {
        return AjaxResult.success(unreadMessageService.selectUnreadMessageById(messageId));
    }
    
    @PreAuthorize("@ss.hasPermi('unreadMessage:add')")
    @Log(title = "未读消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UnreadMessage unreadMessage) {
        return toAjax(unreadMessageService.insertUnreadMessage(unreadMessage));
    }
    
    @PreAuthorize("@ss.hasPermi('unreadMessage:edit')")
    @Log(title = "未读消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UnreadMessage unreadMessage) {
        return toAjax(unreadMessageService.updateUnreadMessage(unreadMessage));
    }
    
    @PreAuthorize("@ss.hasPermi('unreadMessage:remove')")
    @Log(title = "未读消息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{messageIds}")
    public AjaxResult remove(@PathVariable Long[] messageIds) {
        return toAjax(unreadMessageService.deleteUnreadMessageByIds(messageIds));
    }
}
```

## 完整的Mock测试案例

### Service层测试 (UnreadMessageServiceTest.java)
```java
@SpringBootTest(classes = RuoYiApplication.class)
public class UnreadMessageServiceTest {
    @Mock
    private UnreadMessageMapper unreadMessageMapper;
    
    @InjectMocks
    private UnreadMessageServiceImpl unreadMessageService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testSelectUnreadMessageList() {
        // 准备测试数据
        List<UnreadMessage> expectedList = new ArrayList<>();
        UnreadMessage message = new UnreadMessage();
        message.setMessageId(1L);
        message.setUserId(1L);
        message.setMessageTitle("Test Message");
        message.setMessageContent("Test Content");
        message.setMessageType("INFO");
        message.setIsRead("0");
        expectedList.add(message);
        
        // 模拟Mapper层返回
        when(unreadMessageMapper.selectUnreadMessageList(any(UnreadMessage.class))).thenReturn(expectedList);
        
        // 执行测试
        List<UnreadMessage> actualList = unreadMessageService.selectUnreadMessageList(new UnreadMessage());
        
        // 验证结果
        assertNotNull(actualList);
        assertEquals(1, actualList.size());
        assertEquals("Test Message", actualList.get(0).getMessageTitle());
        
        // 验证Mapper方法被调用
        verify(unreadMessageMapper, times(1)).selectUnreadMessageList(any(UnreadMessage.class));
    }
    
    @Test
    public void testSelectUnreadMessageById() {
        // 准备测试数据
        UnreadMessage expectedMessage = new UnreadMessage();
        expectedMessage.setMessageId(1L);
        expectedMessage.setUserId(1L);
        expectedMessage.setMessageTitle("Test Message");
        expectedMessage.setMessageContent("Test Content");
        expectedMessage.setMessageType("INFO");
        expectedMessage.setIsRead("0");
        
        // 模拟Mapper层返回
        when(unreadMessageMapper.selectUnreadMessageById(1L)).thenReturn(expectedMessage);
        
        // 执行测试
        UnreadMessage actualMessage = unreadMessageService.selectUnreadMessageById(1L);
        
        // 验证结果
        assertNotNull(actualMessage);
        assertEquals("Test Message", actualMessage.getMessageTitle());
        
        // 验证Mapper方法被调用
        verify(unreadMessageMapper, times(1)).selectUnreadMessageById(1L);
    }
    
    // 其他测试方法...
}
```

### Controller层测试 (UnreadMessageControllerTest.java)
```java
@SpringBootTest(classes = RuoYiApplication.class)
public class UnreadMessageControllerTest {
    private MockMvc mockMvc;
    
    @Mock
    private IUnreadMessageService unreadMessageService;
    
    @InjectMocks
    private UnreadMessageController unreadMessageController;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(unreadMessageController).build();
    }
    
    @Test
    public void testList() throws Exception {
        // 准备测试数据
        List<UnreadMessage> unreadMessages = new ArrayList<>();
        UnreadMessage message = new UnreadMessage();
        message.setMessageId(1L);
        message.setUserId(1L);
        message.setMessageTitle("Test Message");
        message.setMessageContent("Test Content");
        message.setMessageType("INFO");
        message.setIsRead("0");
        unreadMessages.add(message);
        
        // 模拟服务层返回
        when(unreadMessageService.selectUnreadMessageList(any(UnreadMessage.class))).thenReturn(unreadMessages);
        
        // 执行测试
        mockMvc.perform(get("/unreadMessage/list")
                .param("userId", "1")
                .param("messageType", "INFO"))
                .andExpect(status().isOk());
        
        // 验证服务层方法被调用
        verify(unreadMessageService, times(1)).selectUnreadMessageList(any(UnreadMessage.class));
    }
    
    @Test
    public void testGetInfo() throws Exception {
        // 准备测试数据
        UnreadMessage message = new UnreadMessage();
        message.setMessageId(1L);
        message.setUserId(1L);
        message.setMessageTitle("Test Message");
        message.setMessageContent("Test Content");
        message.setMessageType("INFO");
        message.setIsRead("0");
        
        // 模拟服务层返回
        when(unreadMessageService.selectUnreadMessageById(1L)).thenReturn(message);
        
        // 执行测试
        mockMvc.perform(get("/unreadMessage/{messageId}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
        
        // 验证服务层方法被调用
        verify(unreadMessageService, times(1)).selectUnreadMessageById(1L);
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