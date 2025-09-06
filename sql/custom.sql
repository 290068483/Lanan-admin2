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
