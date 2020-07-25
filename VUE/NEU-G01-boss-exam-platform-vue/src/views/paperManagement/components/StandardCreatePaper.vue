<template>
<div class="app-container" >
    <div style="margin:10px 0 0 40px">
        <p class="typeface" style="margin:0 0 30px 0">配置组卷信息:</p>
        <el-form :inline="true" :model="configForm" class="typeface">
            <el-form-item label="配置项">
                <el-input v-model="configForm.config" placeholder="请填写配置项"></el-input>
            </el-form-item>
            <el-form-item label="是否启用" style="margin-left:40px">
                <template>
                    <el-radio v-model="configForm.status" label="1">启用</el-radio>
                    <el-radio v-model="configForm.status" label="0">禁用</el-radio>
                </template>
            </el-form-item>
        </el-form>
        <p class="typeface" style="margin:20px 0 30px 0">添加组卷明细:</p>
      <div style="margin:20px 40px 10px 0">
        <el-button  @click="addConfigItem()" type="text" icon="el-icon-plus" style="margin:0 14px 0 0">添加</el-button>
        <el-button @click="createPaper()" type="text" icon="el-icon-download" style="margin:0 14px 0 0">组卷</el-button>
        <el-button  @click="cancelCreate()" type="text" icon="el-icon-close" style="margin:0 14px 0 0">取消</el-button>
      </div>
        <el-table :data="configItemTableData" stripe fit highlight-current-row style="width:1180px;" >
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
            <el-button @click="deleteConfigItem(scope.$index,configItemTableData)" size="small" type="danger" >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!-- 添加配置项弹窗 -->
    <el-dialog title="配置项明细添加" :visible.sync="configItemTag" width="25%">
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
              style="width:180px">
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
              :max="10"
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
      <el-button  @click="configItemTag = false">取 消</el-button>
      <el-button  type="primary" @click="submitAddConfigItem('addConfigItemForm',addConfigItemForm.index)">确 定</el-button>
    </div>
  </el-dialog>
  <!-- 修改配置项弹窗 -->
    <el-dialog title="配置项明细修改" :visible.sync="updateConfigItemTag" width="25%">
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
              style="width:180px">
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
              :max="10"
            ></el-input-number>
          </el-form-item>
            <el-form-item label="题目分值" :label-width="formLabelWidth" prop="score">
            <el-input-number
              v-model="updateConfigItemForm.score"
              style="width:180px"
              :min="1"
              :max="100"
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
  <!-- 组卷弹窗 -->
  <el-dialog title="标准组卷" :visible.sync="createPaperTag" width="25%">
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
</div>
</template>
<script>
import {bus} from '@/router/modules/paperManage'
import {getUserId, getCompanyId, getOrganizationId} from "@/utils/userInfo";
export default {
    name: "StandardCreatePaper",
    data(){
        return{
            isSubmitCreatePaperShow:true,
            isPaperShow: true,
            userId: getUserId(),
            companyId: getCompanyId(),
            organizationId: getOrganizationId(),
            listLoading: true,
            show: false,
            // 表格页数
            total: null,
            token: "",
            formLabelWidth:"100px",
            configForm:{
                config:'',
                status:'1',
            },
            typeOptions:[{
               id:'',
               subjectName:''
            }],
            categoryOptions:[{
              id:'',
              name:''
            }],
            configItemTableData:[],
            configItemTag:false,
            updateConfigItemTag:false,
            createPaperTag:false,
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
            createPaperForm:{
              paperName:'',
              discribe:'',
              paperType:'',
              difficulty:''
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
            }
        }
    },
    created(){
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
    inject:['reload'],
    methods:{
      async queryParam(){
        const { resources } = await this.$store.dispatch('user/getInfo')
        if (resources.indexOf('1002211') === -1) {
          this.isSubmitCreatePaperShow = false
        }
      },
        createPaper(){
            if(this.configItemTableData == null){
                this.$message({
                    message: '请添加配置明细',
                    type: 'warning'
                });
            }else if(this.configForm.config == null || this.configForm.config== ''){
                this.$message({
                    message: '请添加配置项名称',
                    type: 'warning'
                });
            }else{
                this.createPaperTag = true;
            }
        },
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
        updateConfigItem(row,index){
            this.updateConfigItemForm = row;
            this.updateConfigItemForm.index=index;
            this.updateConfigItemTag = true;
        },
        deleteConfigItem(index,rows){
            rows.splice(index, 1);
        },
        cancelCreate(){
            bus.$emit('open',true);
        },
          submitAddConfigItem(form, index){
             this.$refs[form].validate(valid => {
              if (valid) {
                for(var i = 0;i<this.typeOptions.length;i++){
                  if(this.typeOptions[i].id===this.addConfigItemForm.subjectTypeId){
                      this.addConfigItemForm.subjectTypeName = this.typeOptions[i].subjectName;
                  }
                }
                for(var i = 0;i<this.categoryOptions.length;i++){
                  if(this.categoryOptions[i].id===this.addConfigItemForm.categoryId){
                      this.addConfigItemForm.categoryName = this.categoryOptions[i].name;
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
        // 唯一与后端交互，组卷弹窗确定按钮
        submitCreatePaper(){
            // 组卷算法
            axios.post("/education/bes/v1/boss-bes-paper-center/paper/paperStdCombPaper", {
                name:this.configForm.config,
                status:this.configForm.status,
                totalDifficultId:this.createPaperForm.difficulty,
                remark:this.createPaperForm.discribe,
                companyId:this.companyId,
                orgId:this.organizationId,
                createdBy:this.userId,
                updatedBy:this.userId,
                combExamConfigItemDTOList:this.configItemTableData
            })
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
                    if(resp.data.body == "试卷名已存在"){
                        this.$message.error(resp.data.body+"("+resp.data.head.code+")");
                    }else if(resp.data.body == "快速组卷失败"){
                        this.$message.error("标准组卷失败("+resp.data.head.code+")");
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
.typeface{
  font-weight: 700;
  font-display: "微软雅黑";
}

</style>
