CREATE TABLE pending_event_details (
                                       detail_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '详情ID',
                                       event_id INT NOT NULL COMMENT '事件ID',
                                       detail_content TEXT COMMENT '详情内容',
                                       detail_type VARCHAR(50) COMMENT '详情类型',
                                       create_time DATETIME COMMENT '创建时间',
                                       update_time DATETIME COMMENT '更新时间',
                                       FOREIGN KEY (event_id) REFERENCES pending_events(event_id)
);
-- 插入第一条数据
INSERT INTO pending_event_details (event_id, detail_content, detail_type, create_time, update_time)
VALUES (
           1,
           '用户提交了退款申请，金额 299 元',
           'REFUND_APPLY',
           '2025-09-01 09:30:00',
           '2025-09-01 09:30:00'
       );

-- 插入第二条数据
INSERT INTO pending_event_details (event_id, detail_content, detail_type, create_time, update_time)
VALUES (
           2,
           '系统检测到订单异常，已触发人工审核流程',
           'ORDER_EXCEPTION',
           '2025-09-01 14:20:00',
           '2025-09-01 14:20:00'
       );

CREATE TABLE unread_message (
                                message_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '消息ID',
                                user_id INT NOT NULL COMMENT '用户ID',
                                message_title VARCHAR(255) COMMENT '消息标题',
                                message_content TEXT COMMENT '消息内容',
                                message_type VARCHAR(50) COMMENT '消息类型',
                                is_read CHAR(1) DEFAULT '0' COMMENT '是否已读（0未读 1已读）',
                                create_time DATETIME COMMENT '创建时间',
                                update_time DATETIME COMMENT '更新时间'
);
-- 插入第一条数据
INSERT INTO unread_message (user_id, message_title, message_content, message_type, create_time, update_time)
VALUES (
           1,
           '订单异常通知',
           '您的订单状态异常，请及时处理',
           'ORDER_EXCEPTION',
           '2025-09-01 14:20:00',
           '2025-09-01 14:20:00'
       );

CREATE TABLE unfinished_customer_order (
                                           order_id BIGINT AUTO_INCREMENT AUTO_INCREMENT PRIMARY KEY COMMENT '客户单ID',
                                           user_id INT NOT NULL COMMENT '用户ID',
                                           order_code VARCHAR(50) COMMENT '客户单编号',
                                           customer_name VARCHAR(255) COMMENT '客户名称',
                                           order_amount DECIMAL(10,2) COMMENT '订单金额',
                                           order_status VARCHAR(50) COMMENT '订单状态',
                                           create_time DATETIME COMMENT '创建时间',
                                           update_time DATETIME COMMENT '更新时间'
);
CREATE TABLE unfinished_task_order (
                                       task_id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '任务单ID',
                                       user_id INT NOT NULL COMMENT '用户ID',
                                       task_code VARCHAR(50) COMMENT '任务单编号',
                                       task_name VARCHAR(255) COMMENT '任务名称',
                                       task_description TEXT COMMENT '任务描述',
                                       task_status INT COMMENT '任务状态（0未完工 1完工）',
                                       create_time DATETIME COMMENT '创建时间',
                                       update_time DATETIME COMMENT '更新时间'
);

-- 为unread_message表插入一条数据
INSERT INTO unread_message (user_id, message_title, message_content, message_type, create_time, update_time)
VALUES (
           2,
           '系统维护通知',
           '系统将于今晚00:00-02:00进行维护，请提前做好准备',
           'SYSTEM_MAINTENANCE',
           NOW(),
           NOW()
       );

-- 为unfinished_customer_order表插入一条数据
INSERT INTO unfinished_customer_order (user_id, order_code, customer_name, order_amount, order_status, create_time, update_time)
VALUES (
           101,
           'CO20250906001',
           '张三',
           1599.00,
           'PENDING',
           NOW(),
           NOW()
       );

-- 为unfinished_task_order表插入一条数据
INSERT INTO unfinished_task_order (user_id, task_code, task_name, task_description, task_status, create_time, update_time)
VALUES (
           201,
           'TO20250906001',
           '处理客户投诉',
           '处理客户关于产品质量的投诉，需要在24小时内完成',
           0,
           NOW(),
           NOW()
       );

-- 实际的cus_task_progress表结构
CREATE TABLE cus_task_progress (
  id BIGINT NOT NULL AUTO_INCREMENT COMMENT '任务ID（主键）',
  task_name varchar(100) NOT NULL COMMENT '任务名称',
  start_time datetime DEFAULT NULL COMMENT '任务开始时间（精确到时分秒）',
  completion_time datetime DEFAULT NULL COMMENT '任务完工时间（未完工时为NULL）',
  task_property enum('一次性','周期性') NOT NULL COMMENT '任务属性',
  publisher varchar(50) DEFAULT NULL COMMENT '任务发布者（姓名或ID）',
  task_description text COMMENT '任务说明（任务详情、要求等）',
  created_time datetime DEFAULT CURRENT_TIMESTAMP COMMENT '任务创建时间（自动生成）',
  updated_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '任务更新时间（自动更新）',
  is_deleted tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识（0-未删除，1-已删除）',
  PRIMARY KEY (id),
  KEY idx_task_name (task_name) COMMENT '任务名称索引（优化按名称查任务）',
  KEY idx_task_property (task_property) COMMENT '任务属性索引（优化按属性筛选任务）',
  KEY idx_start_completion_time (start_time,completion_time) COMMENT '时间范围索引（优化按时间查任务）',
  KEY idx_publisher (publisher) COMMENT '发布者索引（优化按发布者查任务）'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户任务进度表（存储客户相关任务进度）';

-- 插入测试数据
INSERT INTO cus_task_progress (task_name, start_time, completion_time, task_property, publisher, task_description, created_time, updated_time, is_deleted) 
VALUES 
    ('网站开发项目', '2025-09-01 09:00:00', '2025-09-30 18:00:00', '一次性', '张三', '完成公司网站开发任务', NOW(), NOW(), 0),
    ('移动应用开发', '2025-08-15 10:00:00', '2025-10-15 18:00:00', '一次性', '李四', '开发移动端应用程序', NOW(), NOW(), 0),
    ('系统维护任务', '2025-09-05 09:00:00', '2025-09-10 17:00:00', '一次性', '王五', '对公司服务器进行定期维护', NOW(), NOW(), 0);

-- 待下单表
CREATE TABLE pending_order (
    progress_id INT PRIMARY KEY AUTO_INCREMENT,
    custom_id INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL COMMENT '客户姓名',
    intention TINYINT NOT NULL COMMENT '意向度：0-低，1-中，2-高',
    estimated_order_time DATE COMMENT '预计定单时间',
    estimated_price DECIMAL(10,2) COMMENT '估算金额（单价）',
    current_status VARCHAR(50) COMMENT '当前状态',
    focus_style VARCHAR(100) COMMENT '关注风格',
    recent_contact DATETIME COMMENT '最近联系',
    customer_source VARCHAR(50) COMMENT '客户来源',
    salesman VARCHAR(50) COMMENT '业务员',
    details TEXT COMMENT '详情'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='待下单表';

-- 待测量表
CREATE TABLE pending_measurement (
    measurement_id INT PRIMARY KEY AUTO_INCREMENT,
    custom_id INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL COMMENT '客户姓名',
    urgency TINYINT NOT NULL COMMENT '紧急度：0-正常，1-紧急，2-非常紧急',
    deposit DECIMAL(10,2) COMMENT '定金',
    customer_date DATE COMMENT '客户日期',
    current_status VARCHAR(50) COMMENT '当前状态',
    focus_style VARCHAR(100) COMMENT '关注风格',
    pending_measurement_date DATE COMMENT '待测量日期',
    customer_source VARCHAR(50) COMMENT '客户来源',
    salesman VARCHAR(50) COMMENT '销售员',
    details TEXT COMMENT '详情'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='待测量表';

-- 待签合同表
CREATE TABLE pending_contract (
    contract_id INT PRIMARY KEY AUTO_INCREMENT,
    custom_id INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL COMMENT '客户姓名',
    urgency TINYINT NOT NULL COMMENT '紧急度：0-正常，1-紧急，2-非常紧急',
    deposit DECIMAL(10,2) COMMENT '定金',
    order_date DATE COMMENT '定单日期',
    measurement_date DATE COMMENT '测量日期',
    customer_source VARCHAR(50) COMMENT '客户来源',
    salesman VARCHAR(50) COMMENT '销售员',
    designer VARCHAR(50) COMMENT '设计师',
    details TEXT COMMENT '详情'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='待签合同表';

-- 待生产表
CREATE TABLE pending_production_order (
    pending_order_id INT PRIMARY KEY AUTO_INCREMENT,
    custom_id INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL COMMENT '客户姓名',
    contract_payment_time DATE COMMENT '合同款时间',
    total_contract_amount DECIMAL(12,2) COMMENT '合同总金额',
    delivery_date DATE COMMENT '交货日期',
    salesman VARCHAR(50) COMMENT '销售员',
    designer VARCHAR(50) COMMENT '设计师',
    current_progress TINYINT COMMENT '当前进度：0-设计，1-拆单',
    details TEXT COMMENT '详情',
    remarks TEXT COMMENT '备注',
    intention TINYINT COMMENT '意向度：0-低，1-中，2-高'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='待生产表';

-- 待出货表
CREATE TABLE pending_delivery (
    delivery_id INT PRIMARY KEY AUTO_INCREMENT,
    custom_id INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL COMMENT '客户姓名',
    contract_payment_time DATE COMMENT '合同款时间',
    total_contract_amount DECIMAL(12,2) COMMENT '合同总金额',
    delivery_date DATE COMMENT '交货日期',
    remaining_balance DECIMAL(12,2) COMMENT '当前尾款',
    salesman VARCHAR(50) COMMENT '销售员',
    designer VARCHAR(50) COMMENT '设计师',
    shipment_progress TINYINT COMMENT '出货进度：0-待安装，1-待送货，2-安装中'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='待出货表';

-- 待完工表
CREATE TABLE pending_completion (
    installation_id INT PRIMARY KEY AUTO_INCREMENT,
    custom_id INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL COMMENT '客户姓名',
    urgency TINYINT NOT NULL COMMENT '紧急度：0-正常，1-紧急，2-非常紧急',
    contract_payment_date DATE COMMENT '合同款日期',
    installation_date DATE COMMENT '安装日期',
    pending_processing_date DATE COMMENT '待处理日期',
    salesman VARCHAR(50) COMMENT '销售员',
    designer VARCHAR(50) COMMENT '设计师',
    installer VARCHAR(50) COMMENT '安装师傅',
    details TEXT COMMENT '详情'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='待完工表';

-- 待归档表
CREATE TABLE pending_archived (
    archive_id INT PRIMARY KEY AUTO_INCREMENT,
    custom_id INT NOT NULL,
    customer_name VARCHAR(100) NOT NULL COMMENT '客户姓名',
    customer_satisfaction TINYINT COMMENT '客户满意度：0-不满意，1-一般，2-满意',
    order_date DATE COMMENT '定单日期',
    completion_date DATE COMMENT '完工日期',
    total_contract_amount DECIMAL(12,2) COMMENT '合同总金额',
    salesman VARCHAR(50) COMMENT '销售员',
    designer VARCHAR(50) COMMENT '设计师',
    installer VARCHAR(50) COMMENT '安装师傅',
    measurement_count INT COMMENT '测量次数',
    after_sales_count INT COMMENT '售后次数',
    extended_relationship VARCHAR(100) COMMENT '延伸关系',
    details TEXT COMMENT '详情'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='待归档表';
