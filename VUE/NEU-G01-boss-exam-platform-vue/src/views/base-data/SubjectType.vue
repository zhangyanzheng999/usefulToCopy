<template>
  <div>
    <el-card class="middle">
      <div slot="header" class="clearfix">
        <el-input placeholder="请输入题目类型名称进行搜索，可以直接回车搜索" prefix-icon="el-icon-search"
                  size="small"
                  clearable
                  @clear="initSubjectTypes"
                  style="width: 350px;margin-right: 10px" v-model="query.name"
                  @keydown.enter.native="initSubjectTypes" ></el-input>
        <el-button icon="el-icon-search" v-if="isSearchShow" type="primary" @click="initSubjectTypes"  size="small">
          搜索
        </el-button>
        <el-button type="primary" v-if="isAddShow" icon="el-icon-circle-plus-outline" size="small" plain @click="addSubjectType">新增</el-button>
        <el-button type="danger" v-if="isDeletesShow" icon="el-icon-remove-outline" size="small" plain @click="deleteSubjectTypes">删除</el-button>
        <el-button type="success" v-if="isImportShow" icon="el-icon-upload2" size="small" plain  @click="importDialogVisible=true">导入</el-button>
        <el-button type="warning" v-if="isExportShow" icon="el-icon-download" size="small" plain @click="handleMultipleExport">导出</el-button>
      </div>
      <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange">
        <el-table-column
          type="selection"
          width="55">
        </el-table-column>
        <el-table-column
          prop="subjectName"
          label="题目类型"
          width="130">
        </el-table-column>
        <el-table-column
          prop="attribute"
          label="属性"
          width="130"
        >
        </el-table-column>
        <el-table-column
          prop="updatedTime"
          label="更新时间"
          width="199">
        </el-table-column>
        <el-table-column
          prop="status"
          label="状态"
        >
          <template slot-scope="scope">
            <el-tag v-if="scope.row.status==1">已启用</el-tag>
            <el-tag v-if="scope.row.status==0">未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="remark"
          label="备注信息"
        >
        </el-table-column>
        <el-table-column
          label="操作"
          show-overflow-tooltip>
          <template slot-scope="scope">
            <el-button @click="updateSubjectType(scope.row)" v-if="isUpdateShow" style="padding: 3px" size="medium" type="info" plain>修改</el-button>
            <el-button @click="deleteSubjectType(scope.row)" v-if="isDeletesShow" style="padding: 3px" size="medium" type="danger" plain>删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @current-change="initSubjectTypes"
        :current-page.sync="query.pageNum"
        :page-size="query.pageSize"
        layout="total, prev, pager, next, jumper"
        :total="totalNum">
      </el-pagination>
    </el-card>
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="40%">
      <div>
        <el-form :model="subjectType" :rules="rules" ref="subjectForm" label-width="80px">
          <el-form-item label="题目类型" prop="subjectName">
            <el-input size="medium" style="width: 150px" prefix-icon="el-icon-edit" v-model="subjectType.subjectName"
                      placeholder="请输入题目类型"></el-input>
          </el-form-item>
          <el-form-item label="题目属性" prop="attribute">
            <el-input size="medium" style="width: 150px" prefix-icon="el-icon-edit" v-model="subjectType.attribute"
                      placeholder="请输入题目属性"></el-input>
          </el-form-item>
          <el-form-item label="是否启用">
            <el-radio v-model="subjectType.status" label="1" border>是</el-radio>
            <el-radio v-model="subjectType.status" label="0" border>否</el-radio>
          </el-form-item>
          <el-form-item label="备注信息">
            <el-input
              style="width: 80%"
              v-model="subjectType.remark"
              type="textarea"
              :rows="2"
              placeholder="请输入备注"
            >
            </el-input>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
      <el-button @click="cancel">取 消</el-button>
      <el-button type="primary" @click="doAdd">确 定</el-button>
    </span>
    </el-dialog>
    <el-dialog title="导出题型" :visible.sync="exportDialogVisible">
      <label class="radio-label" style="padding-left:0;">文件名:</label>
      <el-input style="width:340px;" placeholder="请输入文件名" prefix-icon="el-icon-document" v-model="filename"></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button size="medium" type="danger" plain @click="exportDialogVisible=false">取消</el-button>
        <el-button  type="success" icon="document" plain @click="handleDownload(multipleSelection)" :loading="downloadLoading">导出excel</el-button>
       </span>
    </el-dialog>
    <el-dialog title="导入题型" :visible.sync="importDialogVisible" :close-on-click-modal="false">
      <upload-excel-component :on-success='handleSuccess' :before-upload="beforeUpload"></upload-excel-component>
      <el-table :data="excelData" border highlight-current-row style="width: 100%;margin-top:20px;">
        <el-table-column v-for='item of excelHeader' :prop="item" :label="item" :key='item'>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button size="medium" type="success" plain @click="downloadTemplate">下载模板</el-button>
        <el-button size="medium" type="danger" plain @click="importDialogVisible=false">取消</el-button>
        <el-button size="medium" type="primary" plain @click="handleImport">导入</el-button>
      </div>
    </el-dialog>


  </div>
</template>

<script>


  import * as basedata from '../../api/basedata'
  import uploadExcelComponent from '@/components/UploadExcel'
  export default {
    components: {
      uploadExcelComponent
    },

    name: 'SubjectType',
    data() {
      return {
        isSearchShow: true,
        isAddShow: true,
        isDeletesShow: true,
        isUpdateShow: true,
        isImportShow: true,
        isExportShow: true,
        importDialogVisible:false,
        excelData: [],
        downloadLoading: false,
        filename: '',
        excelHeader: [],
        tableData: [],
        multipleSelection: [],
        title:"",
        exportDialogVisible:false,
        dialogVisible: false,
        rules: {
          subjectName: [{required: true, message: '请输入题目类型名称', trigger: 'blur'}],
          attribute:[{required: true, message: '请输入题目属性名称', trigger: 'blur'}]
        },
        subjectType: {
          id:null,
          attribute:"",
          subjectName: "",
          status:"1",
          remark:"",
          createdBy:null,
          orgId:null,
          updatedBy:null,
          version:null,
        },
        query:{
          name:"",
          pageNum:1,
          pageSize:10,
        },
        totalNum:0,
      }
    },
    mounted() {
      this.initSubjectTypes();
    },
    created() {
      this.queryParam()
    },
    methods: {
      async queryParam(){
        const { resources } = await this.$store.dispatch('user/getInfo')
        if (resources.indexOf('1000608') === -1) {
          this.isAddShow = false
        }
        if (resources.indexOf('1000610') === -1) {
          this.isDeletesShow = false
        }
        if (resources.indexOf('1000612') === -1) {
          this.isSearchShow = false
        }
        if (resources.indexOf('1000613') === -1) {
          this.isUpdateShow = false
        }
      },
      beforeUpload(file) {
        const isLt2M = file.size / 1024 / 1024 < 1

        if (isLt2M) {
          return true
        }
        this.$message({
          message: 'Please do not upload files larger than 2m in size.',
          type: 'warning'
        })
        return false
      },
      handleSuccess({ results, header }) {
        this.excelData = results
        this.excelHeader = header
      },
      handleImport() {
        const importVO = []
        for (const item of this.excelData) {
          const temp = { subjectName: item.题目类型, attribute: item.属性, remark: item.备注信息 }
          temp.status = item.状态 === '是' ? "1" : "0"
          //temp.orgId = getOrgId()
          importVO.push(temp)
        }
        if (this.excelData.length < 1) {
          this.$message.warning('未选择文件')
          this.importDialogVisible = false
          return
        } else {
          basedata.batchAddSubjectType(
            importVO
          ).then(res => {
            if (res) {
              this.$notify({
                title: 'success',
                message: '题目类型导入成功',
                type: 'success'
              })
            } else {
              this.$notify.error({
                //title和message是错误码和信息
                //title: res.data.header.responseCode,
                //message: res.data.header.message,
                duration: 0
              })
            }
            this.initSubjectTypes()
          })
          this.importDialogVisible = false
        }
      },

      downloadTemplate() {
        import('@/vendor/Export2Excel').then(excel => {
          const tHeader = ['题目类型', '属性', '状态', '备注信息']
          const filterVal = ['subjectName', 'attribute', 'status', 'remark']
          const list = [
            {
              subjectName: '单选题',
              attribute: '主观题',
              status: '是',
              remark: '这是一条示例,导入请删除'
            }
          ]
          const data = list.map(v => filterVal.map(j => {
            if (j === 'status') {
              return v[j] === 0 ? '否' : '是'
            } else {
              return v[j]
            }
          }))
          excel.export_json_to_excel({
            header: tHeader,
            data,
            filename: '题目类型导入模板',
            autoWidth: true
          })
        })
      },

      handleDownload(list) {
        this.downloadLoading = true;
        import('@/vendor/Export2Excel').then(excel => {
          const tHeader = ['题目类型', '属性', '状态', '备注信息'];
          const filterVal = ['subjectName', 'attribute', 'status', 'remark'];
          const data = list.map(v => filterVal.map(j => {
            if (j === 'status') {
              return v[j] === 0 ? '否' : '是'
            } else {
              return v[j]
            }
          }));
          excel.export_json_to_excel({
            header: tHeader,
            data,
            filename: this.filename,
            autoWidth: true
          })
        });
        this.$notify({
          title: 'success',
          message: '题目类型导出成功',
          type: 'success'
        });
        this.downloadLoading = false;
        this.exportDialogVisible=false;
      },

      handleMultipleExport() {
        if (this.multipleSelection.length < 1) {
          this.$message.warning('未选择任何数据')
          return
        }
        //this.exportArr = this.multipleSelection
        //console.log(this.exportArr)
        this.exportDialogVisible = true
      },

      initSubjectTypes(){
        basedata.initSubjectTypes(
          this.query
        ).then(resp => {
          this.tableData=resp.data.body.list;
          this.totalNum=resp.data.body.total;
        })
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
        //this.multipleSelection=this.multipleSelection.map(item=>{id:item.id,version:item.version})
      },
      addSubjectType(){
        this.empty();
        this.title = '新增题目类型';
        this.dialogVisible = true;
      },
      updateSubjectType(data){
        this.title="修改题目类型";
        this.subjectType=JSON.parse(JSON.stringify(data));
        this.dialogVisible=true;
      },
      empty() {
        this.subjectType = {
          id:null,
          attribute:"",
          subjectName: "",
          status:"1",
          remark:"",
          createdBy:null,
          orgId:null,
          updatedBy:null,
          version:null,
        }
      },
      doAdd(){
        if(this.subjectType.id==null) {
          this.$refs['subjectForm'].validate(valid => {
            if (valid) {
              basedata.addSubjectType(
                this.subjectType
              ).then(resp => {
                this.initSubjectTypes();
                this.$notify({
                  title: "成功",
                  message: "题目类型添加成功",
                  type: "success",
                  duration: 1500
                });
                this.dialogVisible = false;
              }).catch(() => {
                this.$message({
                  type: "error",
                  message: "题目类型添加失败",
                  duration: 1000
                });
              });
            }
          });
        }else{
          this.$refs['subjectForm'].validate(valid => {
            if (valid) {
              basedata.updateSubjectType(
                this.subjectType
              )
                .then(resp => {
                  this.initSubjectTypes();
                  this.$notify({
                    title: "成功",
                    message: "题目类型修改成功",
                    type: "success",
                    duration: 1500
                  });
                  this.dialogVisible = false;
                })
                .catch(() => {
                  this.$message({
                    type: "error",
                    message: "题目类型修改失败",
                    duration: 1000
                  });
                });
            }
          })
        }
      },
      deleteSubjectTypes(){
        if(this.multipleSelection.length<1){
          this.$message({
            type: 'info',
            message: '未选中数据'
          });
        }else{
          this.$confirm('此操作将永久删除【' + this.multipleSelection.length + '】条数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            basedata.batchDeleteSubjectTypes(
              this.multipleSelection
            ).then(resp => {
              if (resp) {
                this.initSubjectTypes();
              }
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        }
      },
      deleteSubjectType(data){
        this.$confirm('此操作将永久删除所选中的【' +data.subjectName+ '】数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          basedata.batchDeleteSubjectTypes(
             [
              {
                id: data.id,
                version: data.version
              }
            ]
          ).then(resp => {
            if (resp) {
              this.initSubjectTypes();
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      cancel(){
        this.dialogVisible = false;
      }
    }
  }
</script>

<style scoped>
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    margin-top: 30px;
    margin-left: 30px;
    width: 21%;
    float: left;
  }

  .middle{
    margin-left: 30px;
    margin-top: 30px;
    margin-right: 30px;
  }
</style>
