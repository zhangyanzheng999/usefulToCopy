<template>
  <div>
    <el-card class="middle">
      <div slot="header" class="clearfix">
        题目<el-input placeholder="请输入题目名称"
                  size="small"
                  clearable
                  @clear="initSubjects"
                  style="width: 150px;margin-right: 10px" v-model="query.name"></el-input>
        题目类别<el-input placeholder="请输入题目类别名称"
                    size="small"
                    clearable
                    @clear="initSubjects"
                    style="width: 150px;margin-right: 10px" v-model="query.categoryName"></el-input>
        题目类型<el-input placeholder="请输入题目类型名称"
                      size="small"
                      clearable
                      @clear="initSubjects"
                      style="width: 150px;margin-right: 10px" v-model="query.subjectTypeName"></el-input>
        <el-button icon="el-icon-search" v-if="isSearchShow" type="primary" @click="initSubjects"  size="small">
          搜索
        </el-button>
        <el-button type="primary" v-if="isAddShow" icon="el-icon-circle-plus-outline" size="small" plain @click="addSubject">新增</el-button>
        <el-button type="danger" v-if="isDeletesShow" icon="el-icon-remove-outline" size="small" plain @click="deleteSubjects">删除</el-button>
        <el-button type="success" v-if="isImportShow" icon="el-icon-upload2" size="small" plain @click="importDialogVisible=true">导入</el-button>
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
          prop="name"
          label="题目"
          width="200">
        </el-table-column>
        <el-table-column
          prop="updatedTime"
          label="更新时间"
          width="199">
        </el-table-column>
        <el-table-column
          prop="status"
          label="状态"
          width="159"
        >
          <template slot-scope="scope">
            <el-tag v-if="scope.row.status=='1'">已启用</el-tag>
            <el-tag v-if="scope.row.status=='0'">未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column
          prop="categoryName"
          label="题目类别"
          width="170"
        >
        </el-table-column>
        <el-table-column
          prop="subjectTypeName"
          label="题目类型"
          width="170"
        >
        </el-table-column>
        <el-table-column
          label="操作"
          show-overflow-tooltip>
          <template slot-scope="scope">
            <el-button v-if="isUpdateShow" @click="updateSubject(scope.row)" style="padding: 3px" size="medium" type="info" plain>修改</el-button>
            <el-button v-if="isDeletesShow" @click="deleteSubject(scope.row)" style="padding: 3px" size="medium" type="danger" plain>删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @current-change="initSubjects"
        :current-page.sync="query.pageNum"
        :page-size="query.pageSize"
        layout="total, prev, pager, next, jumper"
        :total="totalNum">
      </el-pagination>
    </el-card>
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="50%">
      <div>
        <el-form :model="subject" ref="subjectForm" label-width="90px" :rules="rules">
          <el-form-item label="题目类别" prop="categoryId">
            <el-select v-model="subject.categoryId" placeholder="请选择题目类别">
              <el-option
                v-for="item in categoryoptions"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目类型" prop="subjectTypeId">
            <!--<el-input size="medium" style="width: 150px" prefix-icon="el-icon-edit" v-model="subject.categoryId"
                      placeholder="请输入题目类别"></el-input>-->
            <el-select v-model="subject.subjectTypeId" placeholder="请选择题目类型">
              <el-option
                v-for="item in options"
                :key="item.id"
                :label="item.subjectName"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目难度" prop="dictionaryId">
            <el-select v-model="subject.dictionaryId" placeholder="请选择题目难度">
              <el-option
                v-for="item in dictionaryoptions"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目" style="width: 750px" prop="name">
            <el-input
              style="width: 410px"
              type="textarea"
              :rows="3"
              placeholder="请输入题目内容"
              v-model="subject.name">
            </el-input>
          </el-form-item>
          <el-form-item label="备注信息">
            <el-input
              style="width: 410px"
              type="textarea"
              :rows="3"
              placeholder="请输入备注信息"
              v-model="subject.remark">
            </el-input>
          </el-form-item>
          <el-form-item label="是否启用">
            <el-radio v-model="subject.status" label="1" border>是</el-radio>
            <el-radio v-model="subject.status" label="0" border>否</el-radio>
          </el-form-item>
          <!--<el-form-item label="上传图片">
          </el-form-item>-->
          <el-form-item
            v-for="(domain, index) in subject.subjectAnswerDTOList"
            :label="'答案' + index"
            :key="domain.key"
            :prop="'subjectAnswerDTOList.' + index + '.answer'"
            :rules="{required: true, message: '答案不能为空', trigger: 'blur'}">
            <el-input v-model="domain.answer" style="width: 200px;margin-right: 10px;"></el-input>
            <el-radio v-model="domain.rightAnswer" label="1">是</el-radio>
            <el-radio v-model="domain.rightAnswer" label="0">否</el-radio>
            <el-button @click.prevent="removeDomain(domain)" type="danger" plain style="margin-left:10px">删除</el-button>
          </el-form-item>
          <el-form-item>
            <el-button @click="addDomain" type="primary" plain>新增答案</el-button>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="doAdd">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog title="导出题目" :visible.sync="exportDialogVisible" :close-on-click-modal="false">
      <label class="radio-label" style="padding-left:0;">文件名:</label>
      <el-input style="width:340px;" placeholder="请输入文件名" prefix-icon="el-icon-document" v-model="filename"></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button size="medium" type="danger" plain @click="exportDialogVisible=false">取消</el-button>
        <el-button plain type="success" icon="document" @click="handleDownload(multipleSelection)" :loading="downloadLoading">导出excel</el-button>
      </span>
    </el-dialog>
    <el-dialog title="导入题目" :visible.sync="importDialogVisible" :close-on-click-modal="false">
      <upload-excel-component :on-success='handleSuccess' :before-upload="beforeUpload"></upload-excel-component>
      <el-table :data="excelData" border highlight-current-row style="width: 100%;margin-top:20px;">
        <el-table-column v-for='item of excelHeader' :prop="item" :label="item" :key='item'>
        </el-table-column>
      </el-table>
      <div slot="footer" class="dialog-footer">
        <el-button size="medium" type="primary" @click="downloadTemplate">下载模板</el-button>
        <el-button size="medium" type="danger" @click="importDialogVisible=false">取消</el-button>
        <el-button size="medium" type="primary" @click="handleImport">导入</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
 /* import {
    addSubject,
    batchAddSubject,
    batchDeleteSubjects,
    getSubjectTypeList,
    initSubjects, queryCategoryList,
    updateSubject
  } from "../../api/basedata";*/
  import * as basedata from '../../api/basedata'
  import uploadExcelComponent from '@/components/UploadExcel'
  export default {
    components: {
      uploadExcelComponent
    },
    name: "Subject",
    data() {
      return {
        isSearchShow: true,
        isAddShow: true,
        isDeletesShow: true,
        isUpdateShow: true,
        isImportShow: true,
        isExportShow: true,
        rules: {
          name: [{required: true, message: '请输入题目类别名称', trigger: 'blur'}],
          categoryId: [
            {required: true, message: '请选择题目类别名称', trigger: 'change'}
          ],
          subjectTypeId: [
            {required: true, message: '请选择题目类型名称', trigger: 'change'}
          ],
          dictionaryId: [
            {required: true, message: '请选择难度', trigger: 'change'}
          ]
        },
        importDialogVisible:false,
        excelHeader: [],
        excelData: [],
        filename: '',
        exportDialogVisible: false,
        downloadLoading: false,
        dictionaryoptions:[
          {
            id: '0',
            name: '简单'
          }, {
            id: '1',
            name: '中等'
          },{
            id: '2',
            name: '困难'
          }
        ],
        options: [],
        categoryoptions:[],
        dialogVisible: false,
        query:{
          name:"",
          categoryName:"",
          subjectTypeName:"",
          pageNum:1,
          pageSize:10,
        },
        tableData: [],
        multipleSelection: [],
        totalNum:0,
        subject:{
          id:null,
          imageUrl:"",
          status:"1",
          remark:"",
          name:"",
          dictionaryId:"",
          subjectTypeId:"",
          categoryId:"",
          /*answer: '',
          rightAnswer:"1"*/
          subjectAnswerDTOList: []
        }
      }
    },
    mounted() {
      this.initSubjectTypeLists();
      this.initSubjects();
      //查询类别列表
      this.queryCategoryList()
    },
    created() {
      this.queryParam()
    },
    methods: {
      async queryParam(){
        const { resources } = await this.$store.dispatch('user/getInfo')
        if (resources.indexOf('1000615') === -1) {
          this.isAddShow = false
        }
        if (resources.indexOf('1000616') === -1) {
          this.isDeletesShow = false
        }
        if (resources.indexOf('1000617') === -1) {
          this.isSearchShow = false
        }
        if (resources.indexOf('1000618') === -1) {
          this.isUpdateShow = false
        }
      },
      queryCategoryList(){
        basedata.queryCategoryList(
          {}
        ).then(resp => {
          this.categoryoptions=resp.data.body;
        })
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
        //console.log(this.excelHeader)
        for (const item of this.excelData) {
          const temp = { name: item.题目,dictionaryId: item.题目难度, remark: item.备注信息,answers:item.题目答案,rightAnswerItems:item.是否正确 }
          temp.status = item.状态 === '是' ? "1" : "0"
          if (JSON.stringify(this.excelHeader).indexOf('题目') === -1 || JSON.stringify(this.excelHeader).indexOf('题目难度') === -1 ||
            JSON.stringify(this.excelHeader).indexOf('备注信息') === -1 || JSON.stringify(this.excelHeader).indexOf('题目答案') === -1 ||
            JSON.stringify(this.excelHeader).indexOf('是否正确') === -1 || JSON.stringify(this.excelHeader).indexOf('状态') === -1) {
            this.$message.warning('题目导入失败')
            this.$notify.error({
              title: '200409',
              message: '题目header解析错误',
              duration: 0
            })
            return
          } else if (item.题目 === undefined || item.题目难度 === undefined || item.备注信息 === undefined || item.题目答案 === undefined || item.是否正确 === undefined || item.状态 === undefined) {
            this.$message.warning('题目导入失败')
            this.$notify.error({
              title: '200408',
              message: '题目存在空的必填项',
              duration: 0
            })
            return
          }
          importVO.push(temp)
        }
        if (this.excelData.length < 1) {
          this.$message.warning('未选择文件')
          this.importDialogVisible = false
          return
        } else {
          basedata.batchAddSubject(
            importVO
          ).then(res => {
            if (res) {
              this.$notify({
                title: 'success',
                message: '题目导入成功',
                type: 'success'
              })
              this.excelData = null
              this.excelHeader = null
            } else {
              this.$notify.error({
                //title: res.data.header.responseCode,
                //message: res.data.header.message,
                duration: 0
              })
              this.excelData = null
              this.excelHeader = null
            }
            this.initSubjects()
          })
          this.importDialogVisible = false
        }
      },
      downloadTemplate() {
        import('@/vendor/Export2Excel').then(excel => {
          const tHeader = ['题目', '状态', '备注信息', '题目难度', '题目答案', '是否正确'];
          const filterVal = ['name', 'status', 'remark', 'difficulty', 'answer', 'rightAnswer'];
          const list = [
            {
              difficulty: '填写数字，0代表简单，1代表中等，2代表复杂',
              name: '题目名称',
              remark: '这是一条示例数据,导入请删除',
              status: '填写是或否',
              answer: '答案1,答案2,答案3,答案4(以逗号分隔)',
              rightAnswer: '正确,错误,错误,错误(以逗号分隔)'
            }
          ];
          const data = list.map(v => filterVal.map(j => {
            return v[j]
            /*if (j === 'status') {
              return v[j] === 0 ? '是' : '否'
            } else {
              return v[j]
            }*/
          }))
          excel.export_json_to_excel({
            header: tHeader,
            data,
            filename: '题目导入模板',
            autoWidth: true
          })
        })
      },

      handleDownload(list) {
        this.downloadLoading = true;
        import('@/vendor/Export2Excel').then(excel => {
          const tHeader = ['题目', '题目类别', '题型','状态', '备注信息','难度'];
          const filterVal = ['name',  'categoryName', 'subjectTypeName', 'status', 'remark','dictionaryId'];
          const data = list.map(v => filterVal.map(j => {
            if(j==='status'){
              return v[j] === '0' ? '否' : '是'
            }else if(j==='dictionaryId'){
              if(v[j] === '0') {return '简单';}
              else if (v[j] === '1') {return '中等'}
              else{return '困难'}
            }else{
              return v[j]
            }

            /*if (j === 'status') {
              return v[j] === '0' ? '否' : '是'
            } else {
              return v[j]
            }*/

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
          message: '题目导出成功',
          type: 'success'
        });
        this.downloadLoading = false;
        this.exportDialogVisible=false;
      },
      handleMultipleExport() {
        if (this.multipleSelection.length < 1) {
          this.$message.warning('未选择任何数据');
          return
        }
        //this.exportArr = this.multipleSelection
        //console.log(this.exportArr)
        this.exportDialogVisible = true;
      },

      handleSelectionChange(val) {
        this.multipleSelection = val;
        //this.multipleSelection=this.multipleSelection.map(item=>{id:item.id,version:item.version})
      },
      deleteSubjects(){
        if(this.multipleSelection.length<1){
          this.$message({
            type: 'info',
            message: '未选中数据'
          });
        }else {
          this.$confirm('此操作将永久删除【' + this.multipleSelection.length + '】条数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            basedata.batchDeleteSubjects(
              this.multipleSelection
            ).then(resp => {
              if (resp) {
                this.initSubjects();
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
      deleteSubject(data){
        this.$confirm('此操作将永久删除所选中的【' +data.name+ '】数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          basedata.batchDeleteSubjects([
              {
                id: data.id,
                version: data.version
              }
            ]
          ).then(resp => {
            if (resp) {
              this.initSubjects();
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      updateSubject(data){
        //console.log(data);

        this.title="修改题目";
        this.subject=JSON.parse(JSON.stringify(data));
        /*this.subject.subjectAnswerDTOList=JSON.parse(JSON.stringify(data.subjectAnswerVOList));;
        this.subject.subjectAnswerDTOList.push({
          answer: "1",
          rightAnswer:"1",
          key: Date.now()
        });*/
        console.log(this.subject);
        //this.subject.subjectAnswerDTOList=JSON.parse(JSON.stringify(data.subjectAnswerVOList));
        /*var answers=JSON.parse(JSON.stringify(data.subjectAnswerVOList));
        console.log(answers);
        //var that=this;
        for (var i=0;i<answers.length;i++)
        {*/
          /*this.subject.subjectAnswerDTOList.push({
            answer: "1",
            rightAnswer:"1",
            key: Date.now()
          });*/
        //}
        //console.log(that.subject.subjectAnswerDTOList);
        //this.subject.subjectAnswerDTOList=JSON.parse(JSON.stringify(data.subjectAnswerVOList));
        //console.log(this.subject.subjectAnswerDTOList);
        this.dialogVisible=true;
      },
      doAdd(){
        if(this.subject.id==null) {
          this.$refs['subjectForm'].validate(valid => {
            if (valid) {
              basedata.addSubject(
                this.subject
              ).then(resp => {
                this.initSubjects();
                this.$notify({
                  title: "成功",
                  message: "题目(包括答案)添加成功",
                  type: "success",
                  duration: 1500
                });
                this.dialogVisible = false;
              }).catch(() => {
                this.$message({
                  type: "error",
                  message: "题目(包括答案)添加失败",
                  duration: 1000
                });
              });
            }
          });
        }else{
          this.$refs['subjectForm'].validate(valid => {
            if (valid) {
              basedata.updateSubject(
                this.subject
              )
                .then(resp => {
                  this.initSubjects();
                  this.$notify({
                    title: "成功",
                    message: "题目(包括答案)修改成功",
                    type: "success",
                    duration: 1500
                  });
                  this.dialogVisible = false;
                })
                .catch(() => {
                  this.$message({
                    type: "error",
                    message: "题目(包括答案)修改失败",
                    duration: 1000
                  });
                });
            }
          })
        }
      },
      cancel(){
        this.dialogVisible = false;
      },
      initSubjectTypeLists(){
        basedata.getSubjectTypeList(
          {}
        ).then(resp => {
          this.options = resp.data.body;
        })
      },
      removeDomain(item) {
        var index = this.subject.subjectAnswerDTOList.indexOf(item)
        if (index !== -1) {
          this.subject.subjectAnswerDTOList.splice(index, 1)
        }
      },
      addDomain() {
        this.subject.subjectAnswerDTOList.push({
          answer: '',
          rightAnswer:"1",
          key: Date.now()
        });
      },
      initSubjects() {
        basedata.initSubjects(
          this.query
        ).then(resp => {
          this.tableData = resp.data.body.list;
          this.totalNum = resp.data.body.total;
        })
      },
      addSubject(){
        this.empty();
        this.title = '新增题目';
        this.dialogVisible = true;
      },
      empty() {
        this.subject = {
          id: null,
          imageUrl: "",
          status: "1",
          remark: "",
          name: "",
          dictionaryId: "",
          subjectTypeId: "",
          categoryId: "",
          subjectAnswerDTOList: [{
            answer: '',
            rightAnswer: "1"
          }]
        }
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

  .middle{
    margin-left: 30px;
    margin-top: 30px;
    margin-right: 30px;
  }
</style>
