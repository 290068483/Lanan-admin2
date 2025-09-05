# RuoYi-Vue 系统API接口文档

## 1. 系统接口

### 1.1 登录相关接口

#### 1.1.1 用户登录
- **接口地址**: `/login`
- **请求方式**: POST
- **请求参数**:
```json
{
  "username": "用户名",
  "password": "密码",
  "code": "验证码",
  "uuid": "验证码UUID"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "token": "登录令牌"
}
```

#### 1.1.2 获取用户信息
- **接口地址**: `/getInfo`
- **请求方式**: GET
- **请求参数**: 无
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "user": {
    "userId": 1,
    "userName": "admin",
    "nickName": "管理员",
    "deptId": 100,
    "dept": {
      "deptId": 100,
      "parentId": 0,
      "deptName": "研发部门",
      "orderNum": 1,
      "leader": "admin",
      "phone": "15888888888",
      "email": "admin@163.com",
      "status": "0"
    }
  },
  "roles": ["admin"],
  "permissions": ["*:*:*"]
}
```

#### 1.1.3 获取用户岗位信息
- **接口地址**: `/getPostInfo`
- **请求方式**: GET
- **请求参数**: 无
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "postNames": ["董事长", "总经理"],
  "posts": [
    {
      "postId": 1,
      "postCode": "CEO",
      "postName": "董事长",
      "postSort": 1,
      "status": "0",
      "remark": "董事长岗位"
    },
    {
      "postId": 2,
      "postCode": "GM",
      "postName": "总经理",
      "postSort": 2,
      "status": "0",
      "remark": "总经理岗位"
    }
  ]
}
```

当获取岗位信息失败时，会返回错误信息:
```json
{
  "code": 500,
  "msg": "获取岗位信息失败: 具体错误信息"
}
```

#### 1.1.4 获取路由信息
- **接口地址**: `/getRouters`
- **请求方式**: GET
- **请求参数**: 无
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": [
  ]
}
```

### 1.2 用户管理接口

#### 1.2.1 查询用户列表
- **接口地址**: `/system/user/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - userName: 用户名
  - phonenumber: 手机号
  - status: 状态
  - deptId: 部门ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [],
  "total": 0
}
```

#### 1.2.2 获取用户详细信息
- **接口地址**: `/system/user/{userId}`
- **请求方式**: GET
- **请求参数**: userId 用户ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {},
  "roles": [],
  "posts": []
}
```

#### 1.2.3 新增用户
- **接口地址**: `/system/user`
- **请求方式**: POST
- **请求参数**:
```json
{
  "deptId": 100,
  "userName": "用户名",
  "nickName": "昵称",
  "password": "密码",
  "phonenumber": "手机号",
  "email": "邮箱",
  "sex": "性别",
  "status": "状态",
  "remark": "备注",
  "postIds": [1, 2],
  "roleIds": [1]
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.2.4 修改用户
- **接口地址**: `/system/user`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "userId": 1,
  "deptId": 100,
  "userName": "用户名",
  "nickName": "昵称",
  "phonenumber": "手机号",
  "email": "邮箱",
  "sex": "性别",
  "status": "状态",
  "remark": "备注",
  "postIds": [1, 2],
  "roleIds": [1]
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.2.5 删除用户
- **接口地址**: `/system/user/{userIds}`
- **请求方式**: DELETE
- **请求参数**: userIds 用户ID列表，多个用逗号分隔
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.2.6 重置密码
- **接口地址**: `/system/user/resetPwd`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "userId": 1,
  "password": "新密码"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.2.7 修改用户状态
- **接口地址**: `/system/user/changeStatus`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "userId": 1,
  "status": "0"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.3 角色管理接口

#### 1.3.1 查询角色列表
- **接口地址**: `/system/role/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - roleName: 角色名
  - roleKey: 权限字符
  - status: 状态
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [],
  "total": 0
}
```

#### 1.3.2 获取角色详细信息
- **接口地址**: `/system/role/{roleId}`
- **请求方式**: GET
- **请求参数**: roleId 角色ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {},
  "checkedKeys": []
}
```

#### 1.3.3 新增角色
- **接口地址**: `/system/role`
- **请求方式**: POST
- **请求参数**:
```json
{
  "roleName": "角色名",
  "roleKey": "权限字符",
  "roleSort": 1,
  "status": "0",
  "remark": "备注",
  "menuIds": [1, 2, 3]
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.3.4 修改角色
- **接口地址**: `/system/role`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "roleId": 1,
  "roleName": "角色名",
  "roleKey": "权限字符",
  "roleSort": 1,
  "status": "0",
  "remark": "备注",
  "menuIds": [1, 2, 3]
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.3.5 删除角色
- **接口地址**: `/system/role/{roleIds}`
- **请求方式**: DELETE
- **请求参数**: roleIds 角色ID列表，多个用逗号分隔
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.3.6 导出角色
- **接口地址**: `/system/role/export`
- **请求方式**: POST
- **请求参数**:
  - roleName: 角色名
  - roleKey: 权限字符
  - status: 状态
- **返回结果**: Excel文件

### 1.4 菜单管理接口

#### 1.4.1 查询菜单列表
- **接口地址**: `/system/menu/list`
- **请求方式**: GET
- **请求参数**:
  - menuName: 菜单名
  - status: 状态
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": []
}
```

#### 1.4.2 获取菜单详细信息
- **接口地址**: `/system/menu/{menuId}`
- **请求方式**: GET
- **请求参数**: menuId 菜单ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {}
}
```

#### 1.4.3 新增菜单
- **接口地址**: `/system/menu`
- **请求方式**: POST
- **请求参数**:
```json
{
  "menuName": "菜单名",
  "parentId": 0,
  "menuType": "M",
  "icon": "图标",
  "orderNum": 1,
  "isFrame": "1",
  "path": "路径",
  "component": "组件路径",
  "perms": "权限标识",
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.4.4 修改菜单
- **接口地址**: `/system/menu`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "menuId": 1,
  "menuName": "菜单名",
  "parentId": 0,
  "menuType": "M",
  "icon": "图标",
  "orderNum": 1,
  "isFrame": "1",
  "path": "路径",
  "component": "组件路径",
  "perms": "权限标识",
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.4.5 删除菜单
- **接口地址**: `/system/menu/{menuId}`
- **请求方式**: DELETE
- **请求参数**: menuId 菜单ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.5 部门管理接口

#### 1.5.1 查询部门列表
- **接口地址**: `/system/dept/list`
- **请求方式**: GET
- **请求参数**:
  - deptName: 部门名
  - status: 状态
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": []
}
```

#### 1.5.2 获取部门详细信息
- **接口地址**: `/system/dept/{deptId}`
- **请求方式**: GET
- **请求参数**: deptId 部门ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {}
}
```

#### 1.5.3 新增部门
- **接口地址**: `/system/dept`
- **请求方式**: POST
- **请求参数**:
```json
{
  "parentId": 0,
  "deptName": "部门名",
  "orderNum": 1,
  "leader": "负责人",
  "phone": "联系电话",
  "email": "邮箱",
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.5.4 修改部门
- **接口地址**: `/system/dept`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "deptId": 1,
  "parentId": 0,
  "deptName": "部门名",
  "orderNum": 1,
  "leader": "负责人",
  "phone": "联系电话",
  "email": "邮箱",
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.5.5 删除部门
- **接口地址**: `/system/dept/{deptId}`
- **请求方式**: DELETE
- **请求参数**: deptId 部门ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.6 岗位管理接口

#### 1.6.1 查询岗位列表
- **接口地址**: `/system/post/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - postCode: 岗位编码
  - postName: 岗位名称
  - status: 状态
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [],
  "total": 0
}
```

#### 1.6.2 获取岗位详细信息
- **接口地址**: `/system/post/{postId}`
- **请求方式**: GET
- **请求参数**: postId 岗位ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {}
}
```

#### 1.6.3 新增岗位
- **接口地址**: `/system/post`
- **请求方式**: POST
- **请求参数**:
```json
{
  "postCode": "岗位编码",
  "postName": "岗位名称",
  "postSort": 1,
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.6.4 修改岗位
- **接口地址**: `/system/post`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "postId": 1,
  "postCode": "岗位编码",
  "postName": "岗位名称",
  "postSort": 1,
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.6.5 删除岗位
- **接口地址**: `/system/post/{postIds}`
- **请求方式**: DELETE
- **请求参数**: postIds 岗位ID列表，多个用逗号分隔
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.7 字典管理接口

#### 1.7.1 查询字典类型列表
- **接口地址**: `/system/dict/type/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - dictName: 字典名称
  - dictType: 字典类型
  - status: 状态
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [],
  "total": 0
}
```

#### 1.7.2 获取字典类型详细信息
- **接口地址**: `/system/dict/type/{dictId}`
- **请求方式**: GET
- **请求参数**: dictId 字典ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {}
}
```

#### 1.7.3 新增字典类型
- **接口地址**: `/system/dict/type`
- **请求方式**: POST
- **请求参数**:
```json
{
  "dictName": "字典名称",
  "dictType": "字典类型",
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.7.4 修改字典类型
- **接口地址**: `/system/dict/type`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "dictId": 1,
  "dictName": "字典名称",
  "dictType": "字典类型",
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.7.5 删除字典类型
- **接口地址**: `/system/dict/type/{dictIds}`
- **请求方式**: DELETE
- **请求参数**: dictIds 字典ID列表，多个用逗号分隔
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.7.6 查询字典数据列表
- **接口地址**: `/system/dict/data/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - dictType: 字典类型
  - dictLabel: 字典标签
  - status: 状态
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [],
  "total": 0
}
```

#### 1.7.7 根据字典类型查询字典数据信息
- **接口地址**: `/system/dict/data/type/{dictType}`
- **请求方式**: GET
- **请求参数**: dictType 字典类型
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": []
}
```

#### 1.7.8 获取字典数据详细信息
- **接口地址**: `/system/dict/data/{dictCode}`
- **请求方式**: GET
- **请求参数**: dictCode 字典数据ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {}
}
```

#### 1.7.9 新增字典数据
- **接口地址**: `/system/dict/data`
- **请求方式**: POST
- **请求参数**:
```json
{
  "dictType": "字典类型",
  "dictLabel": "字典标签",
  "dictValue": "字典键值",
  "cssClass": "样式属性",
  "listClass": "回显样式",
  "isDefault": "是否默认",
  "dictSort": 1,
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.7.10 修改字典数据
- **接口地址**: `/system/dict/data`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "dictCode": 1,
  "dictType": "字典类型",
  "dictLabel": "字典标签",
  "dictValue": "字典键值",
  "cssClass": "样式属性",
  "listClass": "回显样式",
  "isDefault": "是否默认",
  "dictSort": 1,
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.7.11 删除字典数据
- **接口地址**: `/system/dict/data/{dictCodes}`
- **请求方式**: DELETE
- **请求参数**: dictCodes 字典数据ID列表，多个用逗号分隔
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.8 参数管理接口

#### 1.8.1 查询参数列表
- **接口地址**: `/system/config/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - configName: 参数名称
  - configKey: 参数键名
  - configType: 系统内置
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [],
  "total": 0
}
```

#### 1.8.2 获取参数详细信息
- **接口地址**: `/system/config/{configId}`
- **请求方式**: GET
- **请求参数**: configId 参数ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {}
}
```

#### 1.8.3 新增参数
- **接口地址**: `/system/config`
- **请求方式**: POST
- **请求参数**:
```json
{
  "configName": "参数名称",
  "configKey": "参数键名",
  "configValue": "参数键值",
  "configType": "系统内置",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.8.4 修改参数
- **接口地址**: `/system/config`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "configId": 1,
  "configName": "参数名称",
  "configKey": "参数键名",
  "configValue": "参数键值",
  "configType": "系统内置",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.8.5 删除参数
- **接口地址**: `/system/config/{configIds}`
- **请求方式**: DELETE
- **请求参数**: configIds 参数ID列表，多个用逗号分隔
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.9 通知公告接口

#### 1.9.1 查询通知公告列表
- **接口地址**: `/system/notice/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - noticeTitle: 公告标题
  - createBy: 创建者
  - status: 状态
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [],
  "total": 0
}
```

#### 1.9.2 获取通知公告详细信息
- **接口地址**: `/system/notice/{noticeId}`
- **请求方式**: GET
- **请求参数**: noticeId 公告ID
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {}
}
```

#### 1.9.3 新增通知公告
- **接口地址**: `/system/notice`
- **请求方式**: POST
- **请求参数**:
```json
{
  "noticeTitle": "公告标题",
  "noticeType": "公告类型",
  "noticeContent": "公告内容",
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.9.4 修改通知公告
- **接口地址**: `/system/notice`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "noticeId": 1,
  "noticeTitle": "公告标题",
  "noticeType": "公告类型",
  "noticeContent": "公告内容",
  "status": "0",
  "remark": "备注"
}
```
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.9.5 删除通知公告
- **接口地址**: `/system/notice/{noticeIds}`
- **请求方式**: DELETE
- **请求参数**: noticeIds 公告ID列表，多个用逗号分隔
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.10 待处理事件接口

#### 1.10.1 查询待处理事件列表
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
```json
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

#### 1.10.2 获取待处理事件详细信息
- **接口地址**: `/pendingEvents/{eventId}`
- **请求方式**: GET
- **请求参数**: eventId 事件ID
- **说明**: 
  - 该接口根据事件ID获取详细信息
  - 用户只能访问自己有权限查看的事件详情
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {
    "eventId": 1,
    "userId": 1,
    "eventName": "订单处理",
    "eventDetail": "订单号：ORD20250905001",
    "eventStatus": "未处理",
    "createTime": "2025-09-05 10:00:00",
    "updateTime": "2025-09-05 10:00:00"
  }
}
```

#### 1.10.3 新增待处理事件
- **接口地址**: `/pendingEvents`
- **请求方式**: POST
- **请求参数**:
```json
{
  "userId": 1,
  "eventName": "事件名称",
  "eventDetail": "事件详细描述",
  "eventStatus": "未处理"
}
```
- **说明**: 
  - 新增待处理事件
  - 事件创建者为当前登录用户
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.10.4 修改待处理事件
- **接口地址**: `/pendingEvents`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "eventId": 1,
  "userId": 1,
  "eventName": "事件名称",
  "eventDetail": "事件详细描述",
  "eventStatus": "处理中"
}
```
- **说明**: 
  - 修改待处理事件
  - 用户只能修改自己有权限处理的事件
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.10.5 删除待处理事件
- **接口地址**: `/pendingEvents/{eventIds}`
- **请求方式**: DELETE
- **请求参数**: eventIds 事件ID列表，多个用逗号分隔
- **说明**: 
  - 删除待处理事件
  - 用户只能删除自己有权限处理的事件
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.11 未读消息接口

#### 1.11.1 查询未读消息列表
- **接口地址**: `/unreadMessage/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - userId: 用户ID
  - messageType: 消息类型
  - isRead: 是否已读
- **说明**: 
  - 查询未读消息列表
  - 支持按用户ID、消息类型和是否已读进行筛选
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [
    {
      "messageId": 1,
      "userId": 1,
      "messageTitle": "系统通知",
      "messageContent": "这是一条系统通知",
      "messageType": "NOTICE",
      "isRead": "0",
      "createTime": "2023-01-01 12:00:00",
      "updateTime": "2023-01-01 12:00:00"
    }
  ],
  "total": 1
}
```

#### 1.11.2 获取未读消息详细信息
- **接口地址**: `/unreadMessage/{messageId}`
- **请求方式**: GET
- **请求参数**: messageId 消息ID
- **说明**: 
  - 获取未读消息详细信息
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {
    "messageId": 1,
    "userId": 1,
    "messageTitle": "系统通知",
    "messageContent": "这是一条系统通知",
    "messageType": "NOTICE",
    "isRead": "0",
    "createTime": "2023-01-01 12:00:00",
    "updateTime": "2023-01-01 12:00:00"
  }
}
```

#### 1.11.3 新增未读消息
- **接口地址**: `/unreadMessage`
- **请求方式**: POST
- **请求参数**:
```json
{
  "userId": 1,
  "messageTitle": "消息标题",
  "messageContent": "消息内容",
  "messageType": "消息类型",
  "isRead": "是否已读"
}
```
- **说明**: 
  - 新增未读消息
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.11.4 修改未读消息
- **接口地址**: `/unreadMessage`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "messageId": 1,
  "userId": 1,
  "messageTitle": "更新后的消息标题",
  "messageContent": "更新后的消息内容",
  "messageType": "更新后的消息类型",
  "isRead": "更新后的是否已读状态"
}
```
- **说明**: 
  - 修改未读消息
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.11.5 删除未读消息
- **接口地址**: `/unreadMessage/{messageIds}`
- **请求方式**: DELETE
- **请求参数**: messageIds 消息ID列表，多个用逗号分隔
- **说明**: 
  - 删除未读消息
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.12 未完工客户单接口

#### 1.12.1 查询未完工客户单列表
- **接口地址**: `/unfinishedCustomerOrder/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - userId: 用户ID
  - orderCode: 客户单编号
  - customerName: 客户名称
  - orderStatus: 订单状态
- **说明**: 
  - 查询未完工客户单列表
  - 支持按用户ID、客户单编号、客户名称和订单状态进行筛选
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [
    {
      "orderId": 1,
      "userId": 1,
      "orderCode": "OC001",
      "customerName": "张三",
      "orderAmount": 1000.00,
      "orderStatus": "PROCESSING",
      "createTime": "2023-01-01 12:00:00",
      "updateTime": "2023-01-01 12:00:00"
    }
  ],
  "total": 1
}
```

#### 1.12.2 获取未完工客户单详细信息
- **接口地址**: `/unfinishedCustomerOrder/{orderId}`
- **请求方式**: GET
- **请求参数**: orderId 客户单ID
- **说明**: 
  - 获取未完工客户单详细信息
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {
    "orderId": 1,
    "userId": 1,
    "orderCode": "OC001",
    "customerName": "张三",
    "orderAmount": 1000.00,
    "orderStatus": "PROCESSING",
    "createTime": "2023-01-01 12:00:00",
    "updateTime": "2023-01-01 12:00:00"
  }
}
```

#### 1.12.3 新增未完工客户单
- **接口地址**: `/unfinishedCustomerOrder`
- **请求方式**: POST
- **请求参数**:
```json
{
  "userId": 1,
  "orderCode": "客户单编号",
  "customerName": "客户名称",
  "orderAmount": 1000.00,
  "orderStatus": "订单状态"
}
```
- **说明**: 
  - 新增未完工客户单
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.12.4 修改未完工客户单
- **接口地址**: `/unfinishedCustomerOrder`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "orderId": 1,
  "userId": 1,
  "orderCode": "更新后的客户单编号",
  "customerName": "更新后的客户名称",
  "orderAmount": 2000.00,
  "orderStatus": "更新后的订单状态"
}
```
- **说明**: 
  - 修改未完工客户单
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.12.5 删除未完工客户单
- **接口地址**: `/unfinishedCustomerOrder/{orderIds}`
- **请求方式**: DELETE
- **请求参数**: orderIds 客户单ID列表，多个用逗号分隔
- **说明**: 
  - 删除未完工客户单
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

### 1.13 未完工任务单接口

#### 1.13.1 查询未完工任务单列表
- **接口地址**: `/unfinishedTaskOrder/list`
- **请求方式**: GET
- **请求参数**:
  - pageNum: 页码
  - pageSize: 每页条数
  - userId: 用户ID
  - taskCode: 任务单编号
  - taskName: 任务名称
  - taskStatus: 任务状态
- **说明**: 
  - 查询未完工任务单列表
  - 支持按用户ID、任务单编号、任务名称和任务状态进行筛选
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "rows": [
    {
      "taskId": 1,
      "userId": 1,
      "taskCode": "TC001",
      "taskName": "开发任务",
      "taskDescription": "完成系统开发",
      "taskStatus": "PROCESSING",
      "createTime": "2023-01-01 12:00:00",
      "updateTime": "2023-01-01 12:00:00"
    }
  ],
  "total": 1
}
```

#### 1.13.2 获取未完工任务单详细信息
- **接口地址**: `/unfinishedTaskOrder/{taskId}`
- **请求方式**: GET
- **请求参数**: taskId 任务单ID
- **说明**: 
  - 获取未完工任务单详细信息
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功",
  "data": {
    "taskId": 1,
    "userId": 1,
    "taskCode": "TC001",
    "taskName": "开发任务",
    "taskDescription": "完成系统开发",
    "taskStatus": "PROCESSING",
    "createTime": "2023-01-01 12:00:00",
    "updateTime": "2023-01-01 12:00:00"
  }
}
```

#### 1.13.3 新增未完工任务单
- **接口地址**: `/unfinishedTaskOrder`
- **请求方式**: POST
- **请求参数**:
```json
{
  "userId": 1,
  "taskCode": "任务单编号",
  "taskName": "任务名称",
  "taskDescription": "任务描述",
  "taskStatus": "任务状态"
}
```
- **说明**: 
  - 新增未完工任务单
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.13.4 修改未完工任务单
- **接口地址**: `/unfinishedTaskOrder`
- **请求方式**: PUT
- **请求参数**:
```json
{
  "taskId": 1,
  "userId": 1,
  "taskCode": "更新后的任务单编号",
  "taskName": "更新后的任务名称",
  "taskDescription": "更新后的任务描述",
  "taskStatus": "更新后的任务状态"
}
```
- **说明**: 
  - 修改未完工任务单
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

#### 1.13.5 删除未完工任务单
- **接口地址**: `/unfinishedTaskOrder/{taskIds}`
- **请求方式**: DELETE
- **请求参数**: taskIds 任务单ID列表，多个用逗号分隔
- **说明**: 
  - 删除未完工任务单
- **返回结果**:
```json
{
  "code": 200,
  "msg": "操作成功"
}
```

