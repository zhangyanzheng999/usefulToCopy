<template>
<div class="app-container" >
     <el-collapse-transition>
  <div class="configForm" v-if="showConfigItemTable" style="margin:0 0 30px 30px">
    <div style="margin:20px 40px 10px 50px">
        <el-button  @click="addConfigItem()" type="text" icon="el-icon-plus" style="margin:0 14px 0 0">添加</el-button>
        <el-button  @click="createPaperTop()" type="text" icon="el-icon-download" style="margin:0 14px 0 0">组卷</el-button>
        <el-button v-if = 'isSaveConfigItemShow' @click="saveConfigItem()" type="text" icon="el-icon-folder-checked" style="margin:0 14px 0 0">保存</el-button>
        <el-button @click="showConfigItemTable = false" type="text" icon="el-icon-close" style="margin:0 14px 0 0">取消</el-button>
      </div>
        <el-table :data="configItemTableData" stripe fit highlight-current-row style="margin:0 0 30px 50px;width:1180px;" >
        <el-table-column v-if="show" prop="id" label="ID"></el-table-column>
        <el-table-column v-if="show" prop="version" label="version"></el-table-column>
        <el-table-column v-if="show" prop="subjectTypeId" label="subjectTypeId"></el-table-column>
        <el-table-column v-if="show" prop="categoryId" label="categoryId"></el-table-column>
        <el-table-column
          property="categoryName"
          align="center"
          label="题目类别"
          width="180"

        ></el-table-column>
        <el-table-column
          property="subjectTypeName"
          align="center"
          label="题型"
          width="180"

        ></el-table-column>
        <el-table-column align="center" prop="num" label="题目数量" width="180"></el-table-column>
        <el-table-column
          property="difficult"
          align="center"
          label="题目难度"
          width="180"
          :formatter="showSubjectDifficult"
        ></el-table-column>
        <el-table-column property="score" align="center" label="题目分值" width="180"></el-table-column>
        <el-table-column align="center" label="操作" width="200">
          <template slot-scope="scope">
            <el-button  @click="updateConfigItem(scope.row,scope.$index)" size="small" type="primary" >编辑</el-button>
            <el-button  @click="deleteConfigItem(scope.$index,configItemTableData)" size="small" type="danger">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      </div>
      </el-collapse-transition>
      <div class="paperForm">
      <div style="margin:20px 40px 10px 40px">
        <el-button  @click="createPaperList()" type="text" icon="el-icon-upload" style="margin:0 14px 0 0">组卷</el-button>
        <el-button  @click="seePaperConfigsList()" type="text" icon="el-icon-edit-outline" style="margin:0 14px 0 0">查看</el-button>
      </div>
      <el-table
      v-loading="listLoading" element-loading-text="Loading..."
        :data="tableData"
        stripe
        fit
        highlight-current-row
        ref="multipleTable"
        style="margin-left:30px;width:1250px;"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column v-if="show" prop="id" label="ID"></el-table-column>
        <el-table-column v-if="show" prop="version" label="version"></el-table-column>
        <el-table-column align="center" prop="name" label="组卷配置" width="120"></el-table-column>
        <el-table-column
          align="center"
          prop="totalDifficultId"
          label="难度"
          width="120"
          :formatter="showPaperDifficult"
        ></el-table-column>
        <el-table-column align="center" prop="updateMan" label="修改人" width="120"></el-table-column>
        <el-table-column align="center" prop="companyName" label="公司" width="160"></el-table-column>
        <el-table-column align="center" prop="updatedTime" label="修改时间" width="160"></el-table-column>
        <el-table-column align="center" prop="remark" label="备注" width="200"></el-table-column>
        <el-table-column label="启用状态" width="90" align="center" >
            <template slot-scope="scope">
            <el-tag v-if="scope.row.status === '1'">启动</el-tag>
            <el-tag type="info" v-if="scope.row.status === '0'">禁用</el-tag>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作" width="220">
          <template slot-scope="scope">
            <el-button v-if = 'isSeePaperConfigsShow' @click="seePaperConfigs(scope.row)" size="small" type="primary">查看</el-button>
            <el-button @click="createPaper(scope.row)" size="small" type="danger">组卷</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div align="center"  style="margin:30px 0 20px 0">
        <el-pagination
          background
          layout="prev, pager, next"
          :page-size="6"
          :total="total"
          @current-change="page"
        ></el-pagination>
      </div>
    </div>
      <!-- 组卷弹窗 -->
  <el-dialog title="快速组卷" :visible.sync="createPaperTag" width="25%">
    <el-form :model="createPaperForm" :rules="createPaperRules" ref="createPaperForm" class="createPaperForm">
      <el-form-item label="试卷名称" :label-width="formLabelWidth" prop="paperName">
        <el-input v-model="createPaperForm.paperName" style="width:180px"></el-input>
      </el-form-item>
      <el-form-item label="试卷描述" :label-width="formLabelWidth" >
        <el-input v-model="createPaperForm.discribe" style="width:180px"></el-input>
      </el-form-item>
      <el-form-item label="试卷类型" :label-width="formLabelWidth" prop="paperType">
        <el-select v-model="createPaperForm.paperType" placeholder="请选择类型" style="width:180px">
          <el-option label="算法卷" value="1"></el-option>
          <el-option label="基础卷" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="试卷难度" :label-width="formLabelWidth" prop="difficulty">
        <el-select v-model="createPaperForm.difficulty" placeholder="请选择难度" style="width:180px">
          <el-option label="简单" value="0"></el-option>
          <el-option label="中等" value="1"></el-option>
          <el-option label="困难" value="2"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
     <div slot="footer" class="dialog-footer">
      <el-button @click="createPaperTag = false">取 消</el-button>
      <el-button v-if = 'isSubmitCreatePaperShow' type="primary" @click="submitCreatePaper()">确 定</el-button>
    </div>
  </el-dialog>
      <!-- 最上方组卷按钮对应弹窗 -->
  <el-dialog title="快速组卷" :visible.sync="createPaperTopTag" width="25%">
    <el-form :model="createPaperForm" :rules="createPaperRules" ref="createPaperForm" class="createPaperForm">
      <el-form-item label="试卷名称" :label-width="formLabelWidth" prop="paperName">
        <el-input v-model="createPaperForm.paperName" style="width:180px"></el-input>
      </el-form-item>
      <el-form-item label="试卷描述" :label-width="formLabelWidth" >
        <el-input v-model="createPaperForm.discribe" style="width:180px"></el-input>
      </el-form-item>
      <el-form-item label="试卷类型" :label-width="formLabelWidth" prop="paperType">
        <el-select v-model="createPaperForm.paperType" placeholder="请选择类型" style="width:180px">
          <el-option label="算法卷" value="1"></el-option>
          <el-option label="基础卷" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="试卷难度" :label-width="formLabelWidth" prop="difficulty">
        <el-select v-model="createPaperForm.difficulty" placeholder="请选择难度" style="width:180px">
          <el-option label="简单" value="0"></el-option>
          <el-option label="中等" value="1"></el-option>
          <el-option label="困难" value="2"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
     <div slot="footer" class="dialog-footer">
      <el-button @click="createPaperTopTag = false">取 消</el-button>
      <el-button v-if = 'isSubmitCreatePaperTopShow' type="primary" @click="submitCreatePaperTop()">确 定</el-button>
    </div>
  </el-dialog>
  <!-- 添加配置项弹窗 -->
    <el-dialog title="配置项添加" :visible.sync="configItemTag" width="25%">
    <el-form :model="addConfigItemForm" :rules="addConfigItemRules" ref="addConfigItemForm" class="addConfigItemForm">

      <el-form-item label="题目类别" :label-width="formLabelWidth" prop="categoryId">
        <el-select v-model="addConfigItemForm.categoryId" placeholder="请选择类型" style="width:180px">
              <el-option v-for="option in categoryOptions" :key="option.id"
                  :label="option.name"
                  :value="option.id">
              </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="题目题型" :label-width="formLabelWidth" prop="subjectTypeId">
            <el-select
              v-model="addConfigItemForm.subjectTypeId"
              placeholder="请选择题型"
              style="width:180px"
            >
             <el-option v-for="option in typeOptions" :key="option.id"
                  :label="option.subjectName"
                  :value="option.id">
             </el-option>
            </el-select>
          </el-form-item>
            <el-form-item label="题目数量" :label-width="formLabelWidth" prop="num">
            <el-input-number
              v-model="addConfigItemForm.num"
              style="width:180px"
              :min="1"
              :max="100"
            ></el-input-number>
          </el-form-item>
            <el-form-item label="题目分值" :label-width="formLabelWidth" prop="score">
            <el-input-number
              v-model="addConfigItemForm.score"
              style="width:180px"
              :min="1"
              :max="20"
            ></el-input-number>
          </el-form-item>
      <el-form-item label="题目难度" :label-width="formLabelWidth" prop="difficult">
        <el-select v-model="addConfigItemForm.difficult" placeholder="请选择难度" style="width:180px">
          <el-option label="简单" value="0"></el-option>
          <el-option label="中等" value="1"></el-option>
          <el-option label="困难" value="2"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
     <div slot="footer" class="dialog-footer">
      <el-button @click="configItemTag = false">取 消</el-button>
      <el-button type="primary" @click="submitAddConfigItem('addConfigItemForm',addConfigItemForm.index)">确 定</el-button>
    </div>
  </el-dialog>
  <!-- 修改配置项弹窗 -->
    <el-dialog title="配置项添加" :visible.sync="updateConfigItemTag" width="25%">
    <el-form :model="updateConfigItemForm" :rules="addConfigItemRules" ref="updateConfigItemForm" class="updateConfigItemForm">

      <el-form-item label="题目类别" :label-width="formLabelWidth" prop="categoryId">
        <el-select v-model="updateConfigItemForm.categoryId" placeholder="请选择类型" style="width:180px">
               <el-option v-for="option in categoryOptions" :key="option.id"
                  :label="option.name"
                  :value="option.id">
              </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="题目题型" :label-width="formLabelWidth" prop="subjectTypeId">
            <el-select
              v-model="updateConfigItemForm.subjectTypeId"
              placeholder="请选择题型"
              style="width:180px"
            >
               <el-option v-for="option in typeOptions" :key="option.id"
                  :label="option.subjectName"
                  :value="option.id">
              </el-option>
            </el-select>
          </el-form-item>
            <el-form-item label="题目数量" :label-width="formLabelWidth" prop="num">
            <el-input-number
              v-model="updateConfigItemForm.num"
              style="width:180px"
              :min="1"
              :max="100"
            ></el-input-number>
          </el-form-item>
            <el-form-item label="题目分值" :label-width="formLabelWidth" prop="score">
            <el-input-number
              v-model="updateConfigItemForm.score"
              style="width:180px"
              :min="1"
              :max="20"
            ></el-input-number>
          </el-form-item>
      <el-form-item label="题目难度" :label-width="formLabelWidth" prop="difficult">
        <el-select v-model="updateConfigItemForm.difficult" placeholder="请选择难度" style="width:180px">
          <el-option label="简单" value="0"></el-option>
          <el-option label="中等" value="1"></el-option>
          <el-option label="困难" value="2"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
     <div slot="footer" class="dialog-footer">
      <el-button @click="updateConfigItemTag = false">取 消</el-button>
      <el-button type="primary" @click="submitUpdateConfigItem('updateConfigItemForm',updateConfigItemForm.index)">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>
<script>
import {getUserId, getCompanyId, getOrganizationId} from "@/utils/userInfo";
export default {
    name: "QuickCreatePaper",
    data(){
        return{
            isSaveConfigItemShow: true,
            isSeePaperConfigsShow: true,
            isSubmitCreatePaperShow: true,
            isSubmitCreatePaperTopShow: true,
            isPaperShow: true,
            userId: getUserId(),
            companyId: getCompanyId(),
            organizationId: getOrganizationId(),
            listLoading: true,
            formLabelWidth:"100px",
            show: false,
            // 表格页数
            createPaperTag:false,
            createPaperTopTag:false,
            configItemTag:false,
            updateConfigItemTag:false,
            addConfigItemForm:{
                categoryId:'',
                categoryName:'',
                subjectTypeId:'',
                subjectTypeName:'',
                num:1,
                difficult:'',
                score:1,
                index:null
            },
            updateConfigItemForm:{
                categoryId:'',
                categoryName:'',
                subjectTypeId:'',
                subjectTypeName:'',
                num:1,
                difficult:'',
                score:1,
                index:null
            },
            typeOptions:[{
               id:'',
               subjectName:''
            }],
            categoryOptions:[{
              id:'',
              name:''
            }],
            createPaperForm:{
              configId:'',
              paperName:'',
              discribe:'',
              paperType:'',
              difficulty:''
            },
            total: null,
            id:'',
            version:'',
            // 配置项表格数据
            tableData: null,
            // 配置信息表格数据
            configItemTableData:null,
            token: "",
            // 多选框
            tableDataAmount: [],
            showConfigItemTable:false,
            createPaperRules:{
              paperName: [
                { required: true, message: "请输入试卷名", trigger: "blur" }
              ],
              difficulty: [
                { required: true, message: "请选择试卷难度", trigger: "change" }
              ],
              paperType: [
                { required: true, message: "请选择试卷类型", trigger: "change" }
              ]
            },
             addConfigItemRules:{
                categoryId:[
                    { required: true, message: "请选择题目类别", trigger: "change" }
                ],
                subjectTypeId:[
                    { required: true, message: "请选择题目题型", trigger: "change" }
                ],
                difficult:[
                    { required: true, message: "请选择题目难度", trigger: "change" }
                ]
            },
        }
    },
    created(){
        axios.post("/education/bes/v1/boss-bes-paper-center/configItem/paperQueryCombExamConfig", {
          name:"",
          pageNum:1,
          pageSize:6
      })
      .then(resp => {
        this.listLoading = false
        this.tableData = resp.data.body.list;
        this.total = resp.data.body.total;
      });
      // 加载题型下拉框内容
      axios.post("/education/bes/v1/boss-bes-paper-center/configItem/paperGetSubjectTypeList")
      .then(resp => {
          this.typeOptions = resp.data.body;
      });
      // 加载题目类别下拉框内容
      axios.post("/education/bes/v1/boss-bes-paper-center/configItem/paperQueryCategoryList")
      .then(resp => {
          this.categoryOptions = resp.data.body;
      });
      this.queryParam()
    },
    inject: ["reload"],
    methods:{
        async queryParam(){
          const { resources } = await this.$store.dispatch('user/getInfo')
          if (resources.indexOf('100225') === -1) {
            this.isSaveConfigItemShow = false
            this.isSubmitCreatePaperTopShow = false
          }
          if (resources.indexOf('100224') === -1) {
            this.isSeePaperConfigsShow = false
          }
          if (resources.indexOf('1002210') === -1) {
            this.isSubmitCreatePaperShow = false
          }
        },
        // 分页
        page(currentPage) {
        axios.post("/education/bes/v1/boss-bes-paper-center/configItem/paperQueryCombExamConfig", {
          name:"",
          pageNum:1,
          pageSize:6
            })
            .then(resp => {
                this.tableData = resp.data.body.list;
                this.total = resp.data.body.total;
            });
        },
        // 组卷配置查看按钮
        seePaperConfigs(row){
          axios.post("/education/bes/v1/boss-bes-paper-center/configItem/paperQueryCombExamConfigItemListByConfigId",
                row.id
            )
            .then(resp => {
                this.id =row.id;
                this.version = row.version;
                this.configItemTableData = resp.data.body;
            });
            this.showConfigItemTable = true;
        },
        // 组卷按钮
        createPaper(row){
            this.createPaperTag = true;
            this.createPaperForm.configId = row.id;
        },
        // 配置项明细表格上方组卷按钮
        createPaperTop(){
            this.createPaperTopTag = true;
        },
        // 配置项列表编辑按钮
        updateConfigItem(row,index){
            this.updateConfigItemForm = row;
            this.updateConfigItemForm.index=index
            this.updateConfigItemTag = true
        },
        // 配置项列表删除按钮
        deleteConfigItem(index,rows){
            rows.splice(index, 1);
        },
        // 表格上方组卷按钮
        createPaperList(){
            const checkBox = this.$refs.multipleTable.selection;
            if (this.$refs.multipleTable.selection.length > 1) {
                this.$message("一次只能生成一张试卷！");
            }else if(this.$refs.multipleTable.selection.length ==0){
                this.$message("请选择配置项！");
            }else{
                this.createPaper(checkBox[0])
            }
        },
        // 表格上方查看配置项按钮
        seePaperConfigsList(){
            const checkBox = this.$refs.multipleTable.selection;
            if (this.$refs.multipleTable.selection.length > 1) {
                this.$message("一次只能查看一个配置项！");
            }else if(this.$refs.multipleTable.selection.length ==0){
                this.$message("请选择配置项！");
            }else{
                this.seePaperConfigs(checkBox[0])
            }
        },
        // 配置项列表添加按钮
        addConfigItem(){
            this.addConfigItemForm.categoryId=null
            this.addConfigItemForm.subjectTypeId=null
            this.addConfigItemForm.num=1
            this.addConfigItemForm.difficult=null
            this.addConfigItemForm.score=1
            this.$nextTick(() => {
              this.$refs.addConfigItemForm.clearValidate();
            });
            this.configItemTag = true
        },
        // 配置项列表上方保存，与后端交互
        saveConfigItem(){
          const tag = 0;
          for(var i =0; i<this.configItemTableData.length;i++){
            // 错误：题目数超出题库
              if(this.configItemTableData[i].num > 10){
                  tag = 1;
              }
          }
          if(tag ==1){
              this.$message.error("题目数大于题库数(200313)");
          }else{
            axios.post("/education/bes/v1/boss-bes-paper-center/configItem/paperUpdateCombExamConfig",
               {id:this.id,
                version:this.version,
                combExamConfigItemDTOList:this.configItemTableData
               }
            )
            .then(resp => {
                this.$message({
                  message: '配置项已保存！',
                  type: 'success'
                });
                this.listLoading = true
                // 重新加载以刷新
                axios.post("/education/bes/v1/boss-bes-paper-center/configItem/paperQueryCombExamConfig", {
                    name:"",
                    pageNum:1,
                    pageSize:6
                })
                .then(resp => {
                  this.listLoading = false
                  this.tableData = resp.data.body.list;
                  this.total = resp.data.body.total;
                });
            });
          }
        },
        submitAddConfigItem(form, index){
             this.$refs[form].validate(valid => {
              if (valid) {
                for(var i = 0;i<this.typeOptions.length;i++){
                  if(this.typeOptions[i].id===this.addConfigItemForm.subjectTypeId){
                      this.addConfigItemForm.subjectTypeName = this.typeOptions[i].subjectName
                  }
                }
                for(var i = 0;i<this.categoryOptions.length;i++){
                  if(this.categoryOptions[i].id===this.addConfigItemForm.categoryId){
                      this.addConfigItemForm.categoryName = this.categoryOptions[i].name
                  }
                }
                var subjectList = {
                  categoryId: this.addConfigItemForm.categoryId,
                  subjectTypeId: this.addConfigItemForm.subjectTypeId,
                  categoryName: this.addConfigItemForm.categoryName,
                  subjectTypeName: this.addConfigItemForm.subjectTypeName,
                  num: this.addConfigItemForm.num,
                  score: this.addConfigItemForm.score,
                  difficult: this.addConfigItemForm.difficult
                };
                this.configItemTableData.push(subjectList);
                this.configItemTag = false;
                this.$message({
                message: '配置项增加成功！',
                type: 'success'
              });
              } else {
                return false;
              }
            });
        },
        submitUpdateConfigItem(form, index){
            this.$refs[form].validate(valid => {
              if (valid) {
                for(var i = 0;i<this.typeOptions.length;i++){
                  if(this.typeOptions[i].id===this.updateConfigItemForm.subjectTypeId){
                      this.updateConfigItemForm.subjectTypeName = this.typeOptions[i].subjectName
                  }
                }
                for(var i = 0;i<this.categoryOptions.length;i++){
                  if(this.categoryOptions[i].id===this.updateConfigItemForm.categoryId){
                      this.updateConfigItemForm.categoryName = this.categoryOptions[i].name
                  }
                }
                var subjectList = {
                  categoryId: this.updateConfigItemForm.categoryId,
                  subjectTypeId: this.updateConfigItemForm.subjectTypeId,
                  categoryName: this.updateConfigItemForm.categoryName,
                  subjectTypeName: this.updateConfigItemForm.subjectTypeName,
                  num: this.updateConfigItemForm.num,
                  score: this.updateConfigItemForm.score,
                  difficult: this.updateConfigItemForm.difficult
                };
                this.$set(this.configItemTableData, index, subjectList);
                this.updateConfigItemTag = false;
                this.$message({
                  message: '配置项修改成功！',
                  type: 'success'
                });
              } else {
                return false;
              }
            });
        },
        // 最上方组卷弹窗确认按钮
        submitCreatePaperTop(){
           const tag = 0;
          for(var i =0; i<this.configItemTableData.length;i++){
            // 错误：题目数超出题库
            if(this.configItemTableData[i].num > 10){
                tag = 1;
            }
          }
          if(tag ==1){
              this.$message.error("题目数大于题库数(200313)");
          }else{
          // 上方组卷按钮需要先调用保存方法
          axios.post("/education/bes/v1/boss-bes-paper-center/configItem/paperUpdateCombExamConfig",
               {id:this.id,
                version:this.version,
                combExamConfigItemDTOList:this.configItemTableData
               }
            )
            .then(resp => {
              // 组卷方法
              this.submitCreatePaper();
            });
          }
        },
        // 组卷弹窗确认按钮
        submitCreatePaper(){
            this.listLoading = true;
            axios.post("/education/bes/v1/boss-bes-paper-center/paper/paperCombPaper",
              this.createPaperForm.configId
            )
            .then(resp => {
                axios.post("/education/bes/v1/boss-bes-paper-center/paper/quickCreatePaper", {
                  paperName:this.createPaperForm.paperName,
                  paperType:this.createPaperForm.paperType,
                  discribe:this.createPaperForm.discribe,
                  difficulty:this.createPaperForm.difficulty,
                  combExamMan:this.userId,
                  //combExamMan:"yhy",
                  companyId:this.companyId,
                  organizationId:this.organizationId,
                  createdBy:this.userId,
                  updatedBy:this.userId
                })
                .then(resp => {
                    this.listLoading = false;
                    if(resp.data.body == "试卷名已存在" || resp.data.body == "快速组卷失败"){
                        this.$message.error(resp.data.body+"("+resp.data.head.code+")");
                    }else{
                        this.createPaperTag = false;
                        this.reload();
                        this.$message({
                          message: '组卷成功！',
                          type: 'success'
                        });
                    }
                });
            });
        },
        // 表格显示试卷难度
        showPaperDifficult(row) {
        if (row.totalDifficultId === "0") {
            return "简单";
        } else if (row.totalDifficultId === '1') {
            return "中等";
        } else if (row.totalDifficultId === '2') {
            return "困难";
        }
        },
        // 表格显示题目难度
        showSubjectDifficult(row) {
            if (row.difficult === 0 || row.difficult === "0") {
                return "简单";
            } else if (row.difficult === 1 || row.difficult === "1") {
                return "中等";
            } else if (row.difficult === 2 || row.difficult === "2") {
                return "困难";
            }
        },
    }

}
</script>
<style>
.paperForm {
  width: 1320px;
  border: 1px solid #dcdfe6;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 10px #e2e2e4;

}
.configForm{
  width: 1250px;
  border: 1px solid #dcdfe6;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 10px #e2e2e4;
}
</style>
