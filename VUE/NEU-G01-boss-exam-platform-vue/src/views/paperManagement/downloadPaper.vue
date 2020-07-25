<template>
  <div class="app-container">
    <el-form :inline="true" :model="ruleForm" ref="ruleForm" class="radio-label">
      <el-form-item label="模板名: " prop="paperName">
        <el-input
          v-model="ruleForm.paperName"
          size="small"
          placeholder="请输入模板名"
          style="width:125px;margin-right:5px"
        />
      </el-form-item>
      <el-form-item label="组卷人: " prop="combExamMan">
        <el-input
          v-model="ruleForm.combExamMan"
          size="small"
          placeholder="请输入组卷人"
          style="width:125px;margin-right:5px"
        />
      </el-form-item>
      <el-form-item label="组卷时间: " prop="datetime">
        <el-date-picker
          v-model="ruleForm.datetime"
          type="daterange"
          size="small"
          format="yyyy-MM-dd HH:mm:ss"
          value-format="yyyy-MM-dd HH:mm:ss"
          style="width:210px;margin-right:5px"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="模板难度: " prop="difficultyType">
        <el-select
          v-model="ruleForm.difficultyType"
          style="width:120px;margin-right:5px"
          size="small"
          placeholder="请选择难度"
        >
          <el-option label="简单" value="0"></el-option>
          <el-option label="中等" value="1"></el-option>
          <el-option label="困难" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="模板类型: " prop="paperType">
        <el-select
          v-model="ruleForm.paperType"
          style="width:120px;margin-right:5px"
          size="small"
          placeholder="请选择类型"
        >
          <el-option label="算法卷" value="1"></el-option>
          <el-option label="基础卷" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button
         v-if = 'isFindShow'
          @click="findPapers('ruleForm')"
          type="primary"
          icon="el-icon-search"
          size="small"
        >查询</el-button>
        <el-button
          @click="resetForm('ruleForm')"
          size="small"
          style="margin:0 0 0 10px;"
          icon="el-icon-refresh"
        >重置</el-button>
      </el-form-item>
    </el-form>
    <div class="paperForm" >
      <div style="margin:20px 40px 0 40px">
        <el-button @click="downloadList()" type="text" icon="el-icon-download">下载试卷</el-button>
      </div>
      <el-table :data="tableData" stripe fit highlight-current-row  ref="multipleTable" style="margin-left:20px;width:1280px;"
      v-loading="listLoading" element-loading-text="正在下载试卷中...">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column v-if="show" prop="id" label="ID" ></el-table-column>
        <el-table-column v-if="show" prop="version" label="version" ></el-table-column>
        <el-table-column align="center" prop="paperName" label="模板名" width="110"></el-table-column>
        <el-table-column align="center" prop="combExamMan" label="组卷人" width="80"></el-table-column>
        <el-table-column
          align="center"
          prop="paperType"
          label="模板类型"
          width="80"
          :formatter="showPaperType"
        ></el-table-column>
        <el-table-column
          align="center"
          prop="difficulty"
          label="模板难度"
          width="80"
          :formatter="showPaperDifficult"
        ></el-table-column>
        <el-table-column align="center" prop="combExamTime" label="组卷时间" width="150"></el-table-column>
        <el-table-column align="center" prop="updatedTime" label="更新时间" width="150"></el-table-column>
        <el-table-column align="center" prop="score" label="模板总分" width="80"></el-table-column>
        <el-table-column align="center" prop="discribe" label="模板描述" width="140"></el-table-column>
        <el-table-column align="center" prop="downloadTimes" label="下载次数" width="80"></el-table-column>
        <el-table-column label="状态" width="90" align="center">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.status === 1">启用</el-tag>
            <el-tag type="info" v-if="scope.row.status === 0">未启用</el-tag>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作" width="180">
          <template slot-scope="scope">
            <el-button v-if = 'isDownloadShow' @click="download(scope.row)" type="text" icon="el-icon-download">下载模板</el-button>
            <el-button v-if = 'isPreviewShow' @click="preview(scope.row)" type="text" icon="el-icon-view">预览</el-button>
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
    <!-- 弹窗 -->
    <!-- 预览 -->
    <el-dialog title="预览试卷" :visible.sync="previewTag" width="28%">
      <el-form :model="paperMessageForm" ref="paperMessageForm" class="paperMessageForm">
        <el-form-item>
          <el-switch
            v-model="paperMessageForm.showAnswerTag"
            active-text="显示答案"
            inactive-text="不显示答案"
          ></el-switch>
        </el-form-item>
        <el-form-item v-for="(domain, index) in paperMessageForm.domains" :key="domain.key">
         <p style="margin:-10px 0 -10px 0" v-if="domain.questionType===1">
            {{index+1+'. [单选题] '+ domain.subject}}</p>
            <p style="margin:-10px 0 -10px 0" v-if="domain.questionType===2">
            {{index+1+'. [多选题] '+ domain.subject}}</p>
            <p style="margin:-10px 0 -10px 0" v-if="domain.questionType===3">
            {{index+1+'. [填空题] '+ domain.subject}}</p>
            <p style="margin:-10px 0 -10px 0" v-if="domain.questionType===4">
            {{index+1+'. [编程题] '+ domain.subject}}</p>
            <p style="margin:-10px 0 -10px 0" v-if="domain.questionType===5">
            {{index+1+'. [简答题] '+ domain.subject}}</p>
            <p style="margin:-10px 0 -10px 0" v-if="domain.questionType===6">
            {{index+1+'. [应用题] '+ domain.subject}}</p>
            <p style="margin:-10px 0 -10px 0" v-if="domain.questionType!=1&domain.questionType!=2&domain.questionType!=3
            &domain.questionType!=4&domain.questionType!=5&domain.questionType!=6">
            {{index+1+'. [其他] '+ domain.subject}}</p>
          <div v-if="paperMessageForm.showAnswerTag==true">
            <div
              v-for="domain1 in domain.answers"
              :key="domain1.key"
              style="display:inline;margin-left:10px;"
            >
              <el-checkbox
                v-model="domain1.rightAnswer"
                style="margin-right:10px;"
                disabled
              >{{domain1.answer}}</el-checkbox>
            </div>
          </div>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 下载弹窗 -->
    <el-dialog title="下载模板" :visible.sync="downloadPaperTag" width="25%">
    <el-form :model="downloadPaperForm" :rules="downloadPaperRules" ref="downloadPaperForm" class="downloadPaperForm">
      <el-form-item label="试卷名称" :label-width="formLabelWidth" prop="paperName">
        <el-input v-model="downloadPaperForm.paperName" style="width:180px"></el-input>
      </el-form-item>
      <el-form-item label="试卷描述" :label-width="formLabelWidth" >
        <el-input v-model="downloadPaperForm.discribe" style="width:180px"></el-input>
      </el-form-item>
      <el-form-item label="试卷类型" :label-width="formLabelWidth" prop="paperType">
        <el-select v-model="downloadPaperForm.paperType" placeholder="请选择类型" style="width:180px">
          <el-option label="算法卷" value="1"></el-option>
          <el-option label="基础卷" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="试卷难度" :label-width="formLabelWidth" prop="difficulty">
        <el-select v-model="downloadPaperForm.difficulty" placeholder="请选择难度" style="width:180px">
          <el-option label="简单" value="0"></el-option>
          <el-option label="中等" value="1"></el-option>
          <el-option label="困难" value="2"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
     <div slot="footer" class="dialog-footer">
      <el-button @click="downloadPaperTag = false">取 消</el-button>
      <el-button v-if = 'isSubmitDownloadShow' type="primary" @click="submitDownloadPaper()">确 定</el-button>
    </div>
  </el-dialog>
  </div>
</template>

<script>
import {getUserId, getCompanyId, getOrganizationId} from "@/utils/userInfo";
export default {
  name: "MaintainPaper",
  components: {

  },
  data() {
    return {
      isFindShow: true,
      isDownloadShow: true,
      isPreviewShow: true,
      isSubmitDownloadShow: true,
      isPaperShow: true,
      userId: getUserId(),
      companyId: getCompanyId(),
      organizationId: getOrganizationId(),
      listLoading: false,
      previewTag:false,
      formLabelWidth:"100px",
      downloadPaperTag:false,
      show:false,
      total: null,
      tableData: null,
      token: "",
      tableDataAmount:[],
      // 预览表单
      paperMessageForm: {
        // 预览是否显示答案
        showAnswerTag: true,
        domains: [
          {
            id: "",
            subject: "",
            subjectCategory: "",
            answers: []
          }
        ],
        answerDomains: [
          {
            answer: "",
            rightAnswer: false
          }
        ]
      },
      ruleForm: {
        paperName: "",
        combExamMan: "",
        datetime: "",
        difficultyType: "",
        paperType: "",
      },
      downloadPaperForm:{
        paperName:'',
        discribe:'',
        paperType:'',
        difficulty:'',
        createdBy:'',
        updatedBy:'',
        organizationId:'',
        companyId:''
      },
      downloadPaperRules:{
        paperName: [
          { required: true, message: "请输入模板名", trigger: "blur" }
        ],
        difficulty: [
          { required: true, message: "请选择模板难度", trigger: "change" }
        ],
        paperType: [
          { required: true, message: "请选择模板类型", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.listLoading = true;
    axios.post("/education/bes/v1/boss-bes-paper-center/paper/findTemplateList", {
          paperName: "",
          pageNum: 1,
          pageSize: 6,
          combExamMan: "",
          combExamTime: "",
          difficulty: "",
          paperType: "",
          templateTag:""
      })
      .then(resp => {
        this.listLoading = false;
        this.tableData = resp.data.body.list;
        this.total = resp.data.body.total;
      });
      this.queryParam();
  },
  inject: ["reload"],
  methods: {
    async queryParam(){
      const { resources } = await this.$store.dispatch('user/getInfo')
      if (resources.indexOf('100221') === -1) {
        this.isFindShow = false
      }
      if (resources.indexOf('100213') === -1) {
        this.isDownloadShow = false
      }
      if (resources.indexOf('1000222') === -1) {
        this.isPreviewShow = false
      }
      if (resources.indexOf('100231') === -1) {
        this.isSubmitDownloadShow = false
      }
    },
    page(currentPage) {
      axios
        .post("/education/bes/v1/boss-bes-paper-center/paper/findTemplateList", {
            paperName: "",
            pageNum: currentPage,
            pageSize: 6,
            combExamMan: "",
            combExamTime: "",
            difficulty: "",
            paperType: "",
            templateTag:""
        })
        .then(resp => {
          this.tableData = resp.data.body.list;
          this.total = resp.data.body.total;
        });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    findPapers(formName) {
      axios
        .post("/education/bes/v1/boss-bes-paper-center/paper/findTemplateList", {
            paperName: this.ruleForm.paperName,
            pageNum: 1,
            pageSize: 6,
            combExamMan: this.ruleForm.combExamMan,
            startTime:this.ruleForm.datetime[0],
            endTime:this.ruleForm.datetime[1],
            difficulty: this.ruleForm.difficultyType,
            paperType: this.ruleForm.paperType,
            templateTag:""
        })
        .then(resp => {
          this.tableData = resp.data.body.list;
          this.total = resp.data.body.total;
        });
    },
    // 预览按钮
    preview(row) {
      //加载试卷中包括的试题
      axios
        .post("/education/bes/v1/boss-bes-paper-center/paperSubject/showSubjectWithAnswer/", {
            paperId: row.id
        })
        .then(resp => {
          this.paperMessageForm.domains = resp.data.body;
        });

      this.previewTag = true;
    },
    showPaperType(row) {
      if (row.paperType === 1) {
        return "算法卷";
      } else if (row.paperType === 2) {
        return "基础卷";
      }
    },
    showPaperDifficult(row) {
      if (row.difficulty === 0) {
        return "简单";
      } else if (row.difficulty === 1) {
        return "中等";
      } else if (row.difficulty === 2) {
        return "困难";
      }
    },
    download(row){
       //加载试卷信息
      axios.post("/education/bes/v1/boss-bes-paper-center/paper/getPaper/", {
            id: row.id
        })
        .then(resp => {
          this.downloadPaperForm = resp.data.body;
          this.downloadPaperForm.paperType = String(resp.data.body.paperType);
          this.downloadPaperForm.difficulty = String(resp.data.body.difficulty);
          this.downloadPaperForm.createdBy=this.userId;
          this.downloadPaperForm.updatedBy=this.userId;
          this.downloadPaperForm.organizationId=this.organizationId;
          this.downloadPaperForm.companyId=this.companyId;
        });
      this.downloadPaperTag=true;
    },
    downloadList(){
      const checkBox = this.$refs.multipleTable.selection;
      if (this.$refs.multipleTable.selection.length > 1) {
        this.$message("单次只能下载一份模板！");
      }else if(this.$refs.multipleTable.selection.length ==0){
        this.$message("请选择模板！");
      }else{
        this.download(checkBox[0])
      }
    },
    // 下载模板
    submitDownloadPaper(){
         // 下载模板到公司
        axios.post("/education/bes/v1/boss-bes-paper-center/paper/downloadPaper/",this.downloadPaperForm)
        .then(resp => {
          if(resp.data.body == "试卷名已存在" || resp.data.body == "下载试卷失败"){
              this.$message.error(resp.data.body+"("+resp.data.head.code+")");
          }else{
              this.downloadPaperTag = false;
              this.reload();
              this.$message({
                message: '下载成功！',
                type: 'success'
              });
          }
        });
    }
  }

};
</script>
<style>
.radio-label {
  font-size: 14px;
  color: #606266;
  font-weight: 700;
}
.paperForm {
  border: 1px solid #dcdfe6;
  border-radius: 5px;
  -webkit-border-radius: 5px;
  -moz-border-radius: 5px;
  box-shadow: 0 0 5px #e2e2e4;
  width: 1320px;
}
</style>
