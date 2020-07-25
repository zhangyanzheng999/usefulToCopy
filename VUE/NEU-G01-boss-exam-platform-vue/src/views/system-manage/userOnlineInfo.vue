<template>
  <div>
    <div>
      <el-row :gutter="20">
        <el-col :span="4">
        </el-col>
        <el-col :span="3">
          <el-input
            placeholder="请输入用户名"
            prefix-icon="el-icon-search"
            style="width: 150px"
            size="mini"
            v-model="listQuery.username">
          </el-input>
        </el-col>
        <el-col :span="3">
          <el-input
            placeholder="请输入工号"
            prefix-icon="el-icon-search"
            style="width: 150px"
            size="mini"
            v-model="listQuery.code">
          </el-input>
        </el-col>
        <el-col :span="3">
          <el-date-picker
            v-model="listQuery.onlineTime"
            align="right"
            type="date"
            placeholder="请选择上线时间"
            style="width: 150px"
            size="mini"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-col>
        <el-col :span="3">
          <el-date-picker
            v-model="listQuery.offlineTime"
            align="right"
            type="date"
            placeholder="请选择下线时间"
            style="width: 150px"
            size="mini"
            :picker-options="pickerOptions">
          </el-date-picker>
        </el-col>
        <el-col :span="3">
          <el-button
            type="primary"
            icon="el-icon-search"
            size="mini"
            v-if="isSearchShow"
            @click="getOnlineUsersWithPage()"
          >搜索</el-button>
        </el-col>
      </el-row>
    </div>
    <div style="margin-top:20px">
      <el-card class="box-card">
        <div>
          <el-button
            size="mini"
            icon="el-icon-warning-outline"
            style="margin-left:0px;color:#dc143c"
            v-if="isOfflineShow"
            @click="deleteUserOnlineInfo()"
          >强制下线</el-button>
          <el-button
            size="mini"
            @click="multiHandleExport()"
            icon="el-icon-download"
            style="margin-left:0px;color:#9400D3"
            v-if="isExportShow"
          >导出</el-button>
        </div>
        <div style="margin-top:20px">
          <el-table
            ref="onlineUserTableData"
            :data="onlineUserTableData"
            style="width: 100%;font-size:12px"
            :header-cell-style="{'text-align':'center'}"
            :cell-style="{'text-align':'center'}"
            :row-style="{height:'20px'}"
            row-key="id"
            @selection-change="clickCheckBox"
          >
            <el-table-column type="selection" :reserve-selection="true" width="50px" />
            <el-table-column prop="name" label="用户名" width="100px" />
            <el-table-column prop="code" label="工号" width="100px" />
            <el-table-column prop="ip" label="IP" width="100px" />
            <el-table-column prop="onlineTime" label="上线时间" width="200px" />
            <el-table-column prop="offlineTime" label="下线时间" width="200px" />
            <el-table-column prop="stopTime" label="在线时长" width="100px" />
            <el-table-column prop="status" label="状态" width="50px" />
            <el-table-column fixed="right" label="操作" width="200px">
              <template slot-scope="scope">
                <el-tooltip
                  class="item"
                  effect="dark"
                  content="强制下线"
                  placement="top-start"
                >
                  <el-button
                    type="danger"
                    icon="el-icon-warning-outline"
                    circle
                    size="mini"
                    v-if="isOfflineShow"
                    @click="forceOffline(scope.row)"
                  />
                </el-tooltip>
                <el-tooltip
                  class="item"
                  effect="dark"
                  content="导出"
                  placement="top-start"
                >
                  <el-button
                    type="success"
                    icon="el-icon-download"
                    circle
                    size="mini"
                    v-if="isExportShow"
                    @click="handleExport(scope.row)"
                  />
                </el-tooltip>
              </template>
            </el-table-column>
          </el-table>
          <!-- 分页 -->
          <pagination
            v-show="totalNum>0"
            :total="totalNum"
            :page.sync="listQuery.pageNum"
            :limit.sync="listQuery.pageSize"
            @pagination="getOnlineUsersWithPage"
          />
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
  import * as userOnline from "@/api/userOnlineInfo";
  import Pagination from '../../components/SystemManage/Pagination'
  import {cloneObject, showMessage} from "@/utils/method";

  export default {
    components: { Pagination },
    inject: ['reload'],
    data() {
      // 这里存放数据

      return {
        isOfflineShow: true,
        isDownloadShow: true,
        isExportShow: true,
        isSearchShow: true,
        /**
         * 快捷选择日期
         */
        pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
        // 基础url
        //requestURL: 'org',
        //baseURL: 'http://localhost:9003/education/bes/v1/system-manager-center/org/',
        onlineUserTableData: [{ id: '' }],
        checkBoxData: [],
        /**分页查询信息 */
        listQuery: {
          pageSize: 5,
          pageNum: 1,
          name: '',
          code: '',
          onlineTime: '',
          offlineTime: ''
        },
        totalNum: 100,
        dialogVisible: false,
        dialogTile: null,
        /*存放在线用户信息*/
        userOnlineForm: {
          id: null,
          name: null,
          code: null,
          ip: null,
          onlineTime: null,
          offlineTime: null,
          stopTime: null,
          state: null,
          createdBy: null,
          createdTime: null,
          updatedBy: null,
          updatedTime: null
        },
      };
    },

    methods: {
      async queryParam(){
        const { resources } = await this.$store.dispatch('user/getInfo')
        if (resources.indexOf('100901') === -1) {
          this.isOfflineShow = false
        }
        if (resources.indexOf('100902') === -1) {
          this.isSearchShow = false
        }
      },
      /**
       * 用来判断多选框
       */
      clickCheckBox(val) {
        this.checkBoxData = val
      },
      /**
       * 批量操作强制下线多个用户
       */
      deleteUserOnlineInfo() {
        if (this.checkBoxData.length > 0) {
          if (confirm('确认强制下线') === true) {
            userOnline.deleteUserOnlineInfo(this.checkBoxData).then(resp =>{
              if (resp.data.head.code === '200') {
                showMessage(this, '批量强制下线成功!', 'success')
                this.reload()
              } else if(resp.data.head.code ==='26001'){
                showMessage(this, row.name + '----->用户已下线或下线失败!', 'error')
              }else{
                showMessage(this, row.name + '----->所选用户已有下线!', 'error')
                this.reload()
              }
            })
          }
        } else {
          showMessage(this, '请选择要强制下线的用户', 'error')
        }
      },

      /**
       * 强制下线单个用户
       */
      forceOffline(row) {
        if (confirm('确认强制下线') === true) {
           userOnline.logoutOne({id: row.id, version: row.version}).then(resp => {
            if (resp.data.head.code === '200') {
              showMessage(this, row.name + '----->强制下线成功!', 'success')
              this.reload()

            } else if(resp.data.head.code ==='26001'){
              showMessage(this, row.name + '----->用户已下线，无需重复操作!', 'error')
            }else {
              showMessage(this, row.name + '----->强制下线失败!', 'error')
            }
          })
        }
      },
      /**
       * 获取在线用户的分页信息
       */
      getOnlineUsersWithPage() {
        userOnline.queryUserOnlineInfo(this.listQuery).then(resp => {
          this.onlineUserTableData = resp.data.body.list
          this.totalNum = resp.data.body.total
        })
      },

      getAll() {
        userOnline.getAll(this.listQuery).then(resp => {
          this.onlineUserTableData = resp.data.body.list
          this.totalNum = resp.data.body.total
        })

      },

      /**
       * 处理导出
       */
      handleExport(){

      },
      /**
       * 批量处理导出
       */
      multiHandleExport(){

      }
    },
    created() {
      //调用方法
      this.getAll()
      this.queryParam()
    }

  }
</script>

<style scoped>
  .el-row {
    margin-bottom: 20px;

  &
  :last-child {
    margin-bottom: 0;
  }

  }
  .el-col {
    border-radius: 4px;
  }
</style>
