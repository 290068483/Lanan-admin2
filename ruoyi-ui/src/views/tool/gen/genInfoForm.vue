<template>
  <el-form ref="genInfoForm" :model="info" :rules="rules" label-width="150px">
    <el-row>
      <el-col :span="12">
        <el-form-item prop="tplCategory">
          <span slot="label">生成模板</span>
          <el-select v-model="info.tplCategory" @change="tplSelectChange">
            <el-option label="单表（增删改查）" value="crud" />
            <el-option label="树表（增删改查）" value="tree" />
            <el-option label="主子表（增删改查）" value="sub" />
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="tplWebType">
          <span slot="label">前端类型</span>
          <el-select v-model="info.tplWebType">
            <el-option label="Vue2 Element UI 模版" value="element-ui" />
            <el-option label="Vue3 Element Plus 模版" value="element-plus" />
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item prop="packageName">
          <span slot="label">
            生成包路径
            <el-tooltip content="生成在哪个java包下，例如 com.ruoyi.system" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-input v-model="info.packageName" />
        </el-form-item>
      </el-col>

      <el-col :span="12">
        <el-form-item prop="moduleName">
          <span slot="label">
            生成模块名
            <el-tooltip content="可理解为子系统名，例如 system" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-input v-model="info.moduleName" />
        </el-form-item>
      </el-col>

      <el-col :span="12">
        <el-form-item prop="businessName">
          <span slot="label">
            生成业务名
            <el-tooltip content="可理解为功能英文名，例如 user" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-input v-model="info.businessName" />
        </el-form-item>
      </el-col>

      <el-col :span="12">
        <el-form-item prop="functionName">
          <span slot="label">
            生成功能名
            <el-tooltip content="用作类描述，例如 用户" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-input v-model="info.functionName" />
        </el-form-item>
      </el-col>

      <el-col :span="12">
        <el-form-item prop="genType">
          <span slot="label">
            生成代码方式
            <el-tooltip content="默认为zip压缩包下载，也可以自定义生成路径" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-radio v-model="info.genType" label="0">zip压缩包</el-radio>
          <el-radio v-model="info.genType" label="1">自定义路径</el-radio>
        </el-form-item>
      </el-col>

      <el-col :span="12">
        <el-form-item>
          <span slot="label">
            上级菜单
            <el-tooltip content="分配到指定菜单下，例如 系统管理" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <treeselect
            :append-to-body="true"
            v-model="info.parentMenuId"
            :options="menus"
            :normalizer="normalizer"
            :show-count="true"
            placeholder="请选择系统菜单"
          />
        </el-form-item>
      </el-col>

      <el-col :span="24" v-if="info.genType == '1'">
        <el-form-item prop="genPath">
          <span slot="label">
            自定义路径
            <el-tooltip content="填写磁盘绝对路径，若不填写，则生成到当前Web项目下" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-input v-model="info.genPath">
            <el-dropdown slot="append">
              <el-button type="primary">
                最近路径快速选择
                <i class="el-icon-arrow-down el-icon--right"></i>
              </el-button>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item @click.native="info.genPath = '/'">恢复默认的生成基础路径</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </el-input>
        </el-form-item>
      </el-col>
    </el-row>

    <el-row v-show="info.tplCategory == 'tree'">
      <h4 class="form-header">其他信息</h4>
      <el-col :span="12">
        <el-form-item>
          <span slot="label">
            树编码字段
            <el-tooltip content="树显示的编码字段名， 如：dept_id" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-select v-model="info.treeCode" placeholder="请选择">
            <el-option
              v-for="(column, index) in info.columns"
              :key="index"
              :label="column.columnName + '：' + column.columnComment"
              :value="column.columnName"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item>
          <span slot="label">
            树父编码字段
            <el-tooltip content="树显示的父编码字段名， 如：parent_Id" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-select v-model="info.treeParentCode" placeholder="请选择">
            <el-option
              v-for="(column, index) in info.columns"
              :key="index"
              :label="column.columnName + '：' + column.columnComment"
              :value="column.columnName"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item>
          <span slot="label">
            树名称字段
            <el-tooltip content="树节点的显示名称字段名， 如：dept_name" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-select v-model="info.treeName" placeholder="请选择">
            <el-option
              v-for="(column, index) in info.columns"
              :key="index"
              :label="column.columnName + '：' + column.columnComment"
              :value="column.columnName"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-col>
    </el-row>
    <el-row v-show="info.tplCategory == 'sub'">
      <h4 class="form-header">关联信息</h4>
      
      <!-- 主子表模板配置 -->
      <el-col :span="12" v-if="info.tplCategory == 'sub'">
        <el-form-item>
          <span slot="label">
            子表关系类型
            <el-tooltip content="选择主子表关系类型，一对一或一对多" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-radio-group v-model="subTableType" @change="handleSubTableTypeChange">
            <el-radio :label="1">一对一</el-radio>
            <el-radio :label="2">一对多</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-col>
      
      <el-col :span="12" v-if="info.tplCategory == 'sub' && subTableType === 1">
        <el-form-item>
          <span slot="label">
            关联子表的表名
            <el-tooltip content="关联子表的表名， 如：sys_user" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-select v-model="info.subTableName" placeholder="请选择" @change="subSelectChange">
            <el-option
              v-for="(table, index) in tables"
              :key="index"
              :label="table.tableName + '：' + table.tableComment"
              :value="table.tableName"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12" v-show="info.tplCategory == 'sub' && subTableType === 1">
        <el-form-item>
          <span slot="label">
            子表关联的外键名
            <el-tooltip content="子表关联的外键名， 如：user_id" placement="top">
              <i class="el-icon-question"></i>
            </el-tooltip>
          </span>
          <el-select v-model="info.subTableFkName" placeholder="请选择">
            <el-option
              v-for="(column, index) in subColumns"
              :key="index"
              :label="column.columnName + '：' + column.columnComment"
              :value="column.columnName"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      
      <!-- 多个子表配置（一对多） -->
      <el-col :span="24" v-if="info.tplCategory == 'sub' && subTableType === 2">
        <el-divider>多子表配置</el-divider>
        <el-button type="primary" @click="addSubTableConfig">添加子表</el-button>
        <el-table :data="subTableConfigs" style="width: 100%; margin-top: 10px;">
          <el-table-column label="序号" type="index" width="50"></el-table-column>
          <el-table-column label="关联子表的表名">
            <template slot-scope="scope">
              <el-select v-model="scope.row.tableName" placeholder="请选择子表" @change="subTableChange(scope.row)">
                <el-option
                  v-for="(table, index) in tables"
                  :key="index"
                  :label="table.tableName + '：' + table.tableComment"
                  :value="table.tableName"
                ></el-option>
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="子表关联的外键名">
            <template slot-scope="scope">
              <el-select v-model="scope.row.fkName" placeholder="请选择外键">
                <el-option
                  v-for="(column, index) in scope.row.columns"
                  :key="index"
                  :label="column.columnName + '：' + column.columnComment"
                  :value="column.columnName"
                ></el-option>
              </el-select>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="80">
            <template slot-scope="scope">
              <el-button type="danger" icon="el-icon-delete" circle @click="removeSubTableConfig(scope.$index)"></el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
import Treeselect from "@riophae/vue-treeselect"
import "@riophae/vue-treeselect/dist/vue-treeselect.css"

export default {
  components: { Treeselect },
  props: {
    info: {
      type: Object,
      default: null
    },
    tables: {
      type: Array,
      default: null
    },
    menus: {
      type: Array,
      default: []
    }
  },
  data() {
    return {
      subColumns: [],
      subTableConfigs: [], // 多个子表配置
      subTableType: 1, // 子表关系类型：1-一对一，2-一对多
      rules: {
        tplCategory: [
          { required: true, message: "请选择生成模板", trigger: "blur" }
        ],
        packageName: [
          { required: true, message: "请输入生成包路径", trigger: "blur" }
        ],
        moduleName: [
          { required: true, message: "请输入生成模块名", trigger: "blur" }
        ],
        businessName: [
          { required: true, message: "请输入生成业务名", trigger: "blur" }
        ],
        functionName: [
          { required: true, message: "请输入生成功能名", trigger: "blur" }
        ]
      }
    }
  },
  watch: {
    'info.subTableName': function(val) {
      this.setSubTableColumns(val)
    },
    'info.tplWebType': function(val) {
      if (val === '') {
        this.info.tplWebType = "element-ui"
      }
    },
    subTableConfigs: {
      handler(newVal) {
        // 更新info中的subTableNames和subTableFkNames
        let tableNames = [];
        let fkNames = [];
        newVal.forEach(item => {
          if (item.tableName && item.fkName) {
            tableNames.push(item.tableName);
            fkNames.push(item.fkName);
          }
        });
        this.info.subTableNames = tableNames.join(',');
        this.info.subTableFkNames = fkNames.join(',');
      },
      deep: true
    }
  },
  created() {
    // 初始化子表关系类型
    this.initSubTableType();
    // 初始化多个子表配置
    this.initSubTableConfigs();
  },
  methods: {
    /** 转换菜单数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children
      }
      return {
        id: node.menuId,
        label: node.menuName,
        children: node.children
      }
    },
    /** 选择子表名触发 */
    subSelectChange(value) {
      this.info.subTableFkName = ''
    },
    /** 选择生成模板触发 */
    tplSelectChange(value) {
      if(value !== 'sub') {
        this.info.subTableName = ''
        this.info.subTableFkName = ''
        this.subTableConfigs = []
      } else {
        // 重新初始化子表类型
        this.initSubTableType();
        this.initSubTableConfigs();
      }
    },
    /** 设置关联外键 */
    setSubTableColumns(value) {
      for (var item in this.tables) {
        const name = this.tables[item].tableName
        if (value === name) {
          this.subColumns = this.tables[item].columns
          break
        }
      }
    },
    /** 初始化子表关系类型 */
    initSubTableType() {
      // 检查是否有subTableType字段
      if (this.info.subTableType !== undefined && this.info.subTableType !== null) {
        this.subTableType = this.info.subTableType;
        return;
      }
      
      // 如果已经配置了多个子表，则默认为一对多
      if (this.info.subTableNames && this.info.subTableFkNames) {
        const tableNames = this.info.subTableNames.split(',');
        if (tableNames.length > 1 || (tableNames.length === 1 && tableNames[0])) {
          this.subTableType = 2;
        } else {
          this.subTableType = 1;
        }
      } else if (this.info.subTableName && this.info.subTableFkName) {
        // 如果已经配置了单个子表，则默认为一对一
        this.subTableType = 1;
      } else {
        // 默认为一对一
        this.subTableType = 1;
      }
    },
    /** 初始化多个子表配置 */
    initSubTableConfigs() {
      // 如果已经有subTableNames和subTableFkNames，则解析它们
      if (this.info.subTableNames && this.info.subTableFkNames) {
        const tableNames = this.info.subTableNames.split(',');
        const fkNames = this.info.subTableFkNames.split(',');
        
        // 清空现有配置
        this.subTableConfigs = [];
        
        for (let i = 0; i < Math.max(tableNames.length, fkNames.length); i++) {
          const tableName = tableNames[i] || '';
          const fkName = fkNames[i] || '';
          
          // 获取该表的列信息
          let columns = [];
          for (let j = 0; j < this.tables.length; j++) {
            if (this.tables[j].tableName === tableName) {
              columns = this.tables[j].columns;
              break;
            }
          }
          
          this.subTableConfigs.push({
            tableName: tableName,
            fkName: fkName,
            columns: columns
          });
        }
      }
    },
    /** 添加子表配置 */
    addSubTableConfig() {
      this.subTableConfigs.push({
        tableName: '',
        fkName: '',
        columns: []
      });
    },
    /** 删除子表配置 */
    removeSubTableConfig(index) {
      this.subTableConfigs.splice(index, 1);
    },
    /** 子表更改时更新列信息 */
    subTableChange(row) {
      // 清空外键选择
      row.fkName = '';
      
      // 更新列信息
      for (let i = 0; i < this.tables.length; i++) {
        if (this.tables[i].tableName === row.tableName) {
          row.columns = this.tables[i].columns;
          break;
        }
      }
    },
    /** 处理子表关系类型切换 */
    handleSubTableTypeChange(value) {
      if (value === 1) {
        // 切换到一对一，清空多子表配置
        this.subTableConfigs = [];
        this.info.subTableNames = "";
        this.info.subTableFkNames = "";
      } else {
        // 切换到一对多，清空单子表配置
        this.info.subTableName = "";
        this.info.subTableFkName = "";
        this.subColumns = [];
      }
    }
  }
}
</script>