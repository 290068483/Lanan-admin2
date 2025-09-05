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
    // ... 其他用户信息
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
    // 路由信息列表
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