<template>
  <div class="app-container">
    <el-form :inline="true" :model="ruleForm" ref="ruleForm" class="radio-label">
      <el-form-item label="试卷名: " prop="paperName">
        <el-input
          v-model="ruleForm.paperName"
          size="small"
          placeholder="请输入试卷名"
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
      <el-form-item label="试卷难度: " prop="difficultyType">
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
      <el-form-item label="试卷类型: " prop="paperType">
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
    <div class="paperForm">
      <div style="margin:20px 40px 0 20px">
        <el-button  @click="previewList()" type="text" icon="el-icon-view" style="margin:0 14px 0 0">预览</el-button>
        <el-button @click="paperDetailsList()" type="text" icon="el-icon-more" style="margin:0 14px 0 0">详情</el-button>
        <el-button v-if = 'isDeleteListShow' @click="deleteList()" type="text" icon="el-icon-delete" style="margin:0 14px 20px 0">删除</el-button>
      </div>
      <el-table
      v-loading="listLoading" element-loading-text="Loading..."
        :data="tableData"
        stripe
        fit
        highlight-current-row
        ref="multipleTable"
        style="margin-left:20px;width: 1280px;"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column v-if="show" prop="id" label="ID"></el-table-column>
        <el-table-column v-if="show" prop="version" label="version"></el-table-column>
        <el-table-column align="center" prop="paperName" label="试卷名" width="110"></el-table-column>
        <el-table-column align="center" prop="combExamMan" label="组卷人" width="100"></el-table-column>
        <el-table-column
          align="center"
          prop="paperType"
          label="试卷类型"
          width="95"
          :formatter="showPaperType"
        ></el-table-column>
        <el-table-column
          align="center"
          prop="difficulty"
          label="试卷难度"
          width="95"
          :formatter="showPaperDifficult"
        ></el-table-column>
        <el-table-column align="center" prop="combExamTime" label="组卷时间" width="150"></el-table-column>
        <el-table-column align="center" prop="updatedTime" label="更新时间" width="150"></el-table-column>
        <el-table-column align="center" prop="score" label="试卷总分" width="80"></el-table-column>
        <el-table-column align="center" prop="discribe" label="试卷描述" width="150"></el-table-column>
        <el-table-column label="状态" width="90" align="center">
          <template slot-scope="scope">
            <el-tag v-if="scope.row.status === 1">已上传</el-tag>
            <el-tag type="info" v-if="scope.row.status === 0">未上传</el-tag>
            <el-tag v-if="scope.row.status === 5" type="success">已发布</el-tag>
          </template>
        </el-table-column>
        <el-table-column align="center" label="操作" width="200">
          <template slot-scope="scope">
            <el-button v-if = 'isPreviewShow' @click="preview(scope.row)" type="text" icon="el-icon-view">预览</el-button>
            <el-button v-if = 'isPaperDetailsShow' @click="paperDetails(scope.row)" type="text" icon="el-icon-more">详情</el-button>
            <el-button v-if = 'isDeleteShow' @click="deletePaper(scope.row)" type="text" icon="el-icon-delete">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div align="center" style="margin:30px 0 20px 0">
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
    <!-- 详情 -->
    <el-dialog title="题目" :visible.sync="details" width="500px">
      <el-form :model="subjectform" :rules="subjectRules" ref="subjectform" class="subjectform">
        <el-form-item label="试卷名称" :label-width="formLabelWidth" prop="paperName">
          <el-input v-model="subjectform.paperName" style="width:180px"></el-input>
        </el-form-item>
        <el-form-item label="试卷类型" :label-width="formLabelWidth" prop="paperType">
          <el-select v-model="subjectform.paperType" placeholder="请选择类型" style="width:180px">
            <el-option label="算法卷" value="1"></el-option>
            <el-option label="基础卷" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="试卷难度" :label-width="formLabelWidth" prop="difficulty">
          <el-select v-model="subjectform.difficulty" placeholder="请选择难度" style="width:180px">
            <el-option label="简单" value="0"></el-option>
            <el-option label="中等" value="1"></el-option>
            <el-option label="困难" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="组卷时间" :label-width="formLabelWidth" prop="combExamTime">
          <el-input
            v-model="subjectform.combExamTime"
            autocomplete="off"
            style="width:180px"
            readonly
          ></el-input>
        </el-form-item>
        <el-form-item label="试卷分数" :label-width="formLabelWidth" prop="score">
          <el-input v-model="subjectform.score" autocomplete="off" style="width:180px" readonly></el-input>
        </el-form-item>
        <el-form-item label="试卷描述" :label-width="formLabelWidth">
          <el-input v-model="subjectform.discribe" autocomplete="off" style="width:180px"></el-input>
        </el-form-item>
      </el-form>
      <el-table :data="subjectData">
        <el-table-column property="id" v-if="show"></el-table-column>
        <el-table-column property="subject" v-if="show"></el-table-column>
        <el-table-column property="subjectCategory" v-if="show"></el-table-column>
        <el-table-column property="answers" v-if="show"></el-table-column>
        <el-table-column property="version" v-if="show"></el-table-column>
        <el-table-column
          property="questionType"
          align="center"
          label="题型"
          width="100"
          :formatter="showSubjectType"
        ></el-table-column>
        <el-table-column property="score" align="center" label="分数" width="70"></el-table-column>
        <el-table-column
          property="difficult"
          align="center"
          label="题目难度"
          width="100"
          :formatter="showSubjectDifficult"
        ></el-table-column>
        <el-table-column label="操作" align="center" width="180">
          <template slot-scope="scope">
            <el-button @click="updateSubjectAndAnswer(scope.row,scope.$index)"
              type="primary" size="small">编辑</el-button>
            <el-button @click="deleteSubjectAndAnswer(scope.$index, subjectData)" type="danger" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 内嵌弹窗：修改题目 -->
      <el-dialog width="50%" title="修改题目" :visible.sync="updateSubjectTag" append-to-body>
        <el-form
          :model="updateSubjectForm"
          :rules="updateSubjectRules"
          ref="updateSubjectForm"
          class="updateSubjectForm"
        >
          <el-form-item label="题目分数" :label-width="formLabelWidth" prop="score">
            <el-input-number
              v-model="updateSubjectForm.score"
              style="width:180px"
              :min="1"
              :max="20"
            ></el-input-number>
          </el-form-item>
          <el-form-item label="题目类别" :label-width="formLabelWidth" prop="subjectCategory">
            <el-select
              v-model="updateSubjectForm.subjectCategory"
              placeholder="请选择类别"
              style="width:180px"
            >
              <el-option label="Java" value="Java"></el-option>
              <el-option label="C++" value="C++"></el-option>
              <el-option label="linux" value="linux"></el-option>
              <el-option label="Java高级知识" value="Java高级知识"></el-option>
              <el-option label="Java基础" value="Java基础"></el-option>
              <el-option label="设计模式" value="设计模式"></el-option>
              <el-option label="堆与栈" value="堆与栈"></el-option>
              <el-option label="队列" value="队列"></el-option>
              <el-option label="前端" value="前端"></el-option>
              <el-option label="树" value="树"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目题型" :label-width="formLabelWidth" prop="questionType">
            <el-select
              v-model="updateSubjectForm.questionType"
              placeholder="请选择题型"
              style="width:180px"
            >
              <el-option label="单选题" value="1"></el-option>
              <el-option label="多选题" value="2"></el-option>
              <el-option label="填空题" value="3"></el-option>
              <el-option label="编程题" value="4"></el-option>
              <el-option label="简答题" value="5"></el-option>
              <el-option label="应用题" value="6"></el-option>
              <el-option label="其他" value="0"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目难度" :label-width="formLabelWidth" prop="difficult">
            <el-select
              v-model="updateSubjectForm.difficult"
              placeholder="请选择难度"
              style="width:180px"
            >
              <el-option label="简单" value=0></el-option>
              <el-option label="中等" value=1></el-option>
              <el-option label="困难" value=2></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目" :label-width="formLabelWidth" prop="subject">
            <el-input
              type="textarea"
              :rows="2"
              v-model="updateSubjectForm.subject"
              style="width:600px"
            ></el-input>
          </el-form-item>
          <el-form-item
            v-for="(domain, index) in updateSubjectForm.answers"
            :label="'答案'"
            :key="domain.key"
            :prop="'answers.' + index + '.answer'"
            :rules="{
                  required: true, message: '答案不能为空', trigger: 'blur'
                }"
          >
            <el-input v-model="domain.answer" style="width:180px;margin-right:10px;"></el-input>
            <el-switch
              v-model="domain.rightAnswer"
              active-text="正确"
              inactive-text="错误"
              style="margin-right:30px;"
            ></el-switch>
            <el-button type="danger" size="small" @click.prevent="removeDomain(domain)">删除</el-button>
          </el-form-item>

          <el-form-item>
            <el-button type="success" @click="addAnswer(updateSubjectForm)" style="margin-top:20px;">添加答案</el-button>
            <el-button @click="updateSubjectTag = false">取消</el-button>
            <el-button
              type="primary"
              @click="updateSubject('updateSubjectForm',updateSubjectForm.index)"
            >确定</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

      <!-- 内嵌弹窗：添加题目 -->
      <el-dialog width="50%" title="添加题目" :visible.sync="insertSubjectTag" append-to-body>
        <el-form
          :model="insertSubjectForm"
          :rules="updateSubjectRules"
          ref="insertSubjectForm"
          class="updateSubjectForm"
        >
          <el-form-item label="题目分数" :label-width="formLabelWidth" prop="score">
            <el-input-number
              v-model="insertSubjectForm.score"
              style="width:180px"
              :min="1"
              :max="20"
            ></el-input-number>
          </el-form-item>
          <el-form-item label="题目类别" :label-width="formLabelWidth" prop="subjectCategory">
            <el-select
              v-model="insertSubjectForm.subjectCategory"
              placeholder="请选择类别"
              style="width:180px"
            >
              <el-option label="Java" value="Java"></el-option>
              <el-option label="C++" value="C++"></el-option>
              <el-option label="linux" value="linux"></el-option>
              <el-option label="Java高级知识" value="Java高级知识"></el-option>
              <el-option label="Java基础" value="Java基础"></el-option>
              <el-option label="设计模式" value="设计模式"></el-option>
              <el-option label="堆与栈" value="堆与栈"></el-option>
              <el-option label="队列" value="队列"></el-option>
              <el-option label="前端" value="前端"></el-option>
              <el-option label="树" value="树"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目题型" :label-width="formLabelWidth" prop="questionType">
            <el-select
              v-model="insertSubjectForm.questionType"
              placeholder="请选择题型"
              style="width:180px"
            >
              <el-option label="单选题" value="1"></el-option>
              <el-option label="多选题" value="2"></el-option>
              <el-option label="填空题" value="3"></el-option>
              <el-option label="编程题" value="4"></el-option>
              <el-option label="简答题" value="5"></el-option>
              <el-option label="应用题" value="6"></el-option>
              <el-option label="其他" value="0"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目难度" :label-width="formLabelWidth" prop="difficult">
            <el-select
              v-model="insertSubjectForm.difficult"
              placeholder="请选择难度"
              style="width:180px"
            >
              <el-option label="简单" value=0></el-option>
              <el-option label="中等" value=1></el-option>
              <el-option label="困难" value=2></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="题目" :label-width="formLabelWidth" prop="subject">
            <el-input
              type="textarea"
              :rows="2"
              v-model="insertSubjectForm.subject"
              style="width:600px"
            ></el-input>
          </el-form-item>
          <el-form-item
            v-for="(domain, index) in insertSubjectForm.answers"
            :label="'答案'"
            :key="domain.key"
            :prop="'answers.' + index + '.answer'"
            :rules="{
                  required: true, message: '答案不能为空', trigger: 'blur'
                }"
          >
            <el-input v-model="domain.answer" style="width:180px;margin-right:10px;"></el-input>
            <el-switch
              v-model="domain.rightAnswer"
              active-text="正确"
              inactive-text="错误"
              style="margin-right:30px;"
            ></el-switch>
            <el-button type="danger" size="small" @click.prevent="removeDomain1(domain)">删除</el-button>
          </el-form-item>

          <el-form-item>
            <el-button type="success" @click="addAnswer(insertSubjectForm)" style="margin-top:20px;">添加答案</el-button>
            <el-button @click="insertSubjectTag = false">取消</el-button>
            <el-button
              type="primary"
              @click="insertSubject('insertSubjectForm',insertSubjectForm.index)"
            >确定</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>

      <div slot="footer" class="dialog-footer">
        <el-button type="success" @click="addSubject()">添加题目</el-button>
        <el-button @click="details = false">取 消</el-button>
        <el-button v-if = 'isUpdatePaperShow' type="primary" @click="updatePaper('subjectform')">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "MaintainPaper",
  data() {
    return {
      isFindShow: true,
      isDeleteShow: true,
      isDeleteListShow: true,
      isPreviewShow: true,
      isPaperDetailsShow: true,
      isUpdatePaperShow: true,
      isPaperShow: true,
      listLoading: true,
      paperId: 0,
      formLabelWidth: "",
      show: false,
      // 表格页数
      total: null,
      // 表格数据
      tableData: null,
      // 弹窗中题目表格数据
      subjectData: null,
      token: "",
      // 预览弹出框标识
      previewTag: false,
      // 外部弹窗打开/关闭标识
      details: false,
      //内嵌修改题目框标识
      updateSubjectTag: false,
      //内嵌添加题目框标识
      insertSubjectTag:false,
      // 多选框
      tableDataAmount: [],

      answerChecked: false,
      // 查询表单
      ruleForm: {
        paperName: "",
        combExamMan: "",
        datetime: "",
        difficultyType: "",
        paperType: ""
      },
      // 弹框试卷表单
      subjectform: {
        id: "",
        paperName: "",
        datetime: "",
        difficulty: "",
        paperType: "",
        combExamTime: "",
        score: "",
        discribe: "",
        version:1,
        status:""
      },
      // 修改题目表单
      updateSubjectForm: {
        index: "",
        paperId: "",
        id: "",
        score: "",
        subjectCategory: "",
        questionType: "",
        difficult: "",
        subject: "",
        version: 1,
        // 动态增减答案项
        answers: [
          {
            subjectId: "",
            answer: "",
            // 内嵌框中答案是否正确
            rightAnswer: false,
            subjectId: "",
            companyId: null,
            createdBy: null,
            organizationId: null,
            pictureUrl: null,
            status: null,
            updatedBy: null,
            version: 1
          }
        ]
      },
      insertSubjectForm:{
        index: "",
        paperId: "",
        id: "",
        score: "",
        subjectCategory: "",
        questionType: "",
        difficult: "",
        subject: "",
        version: 1,
        // 动态增减答案项
        answers: [
          {
            subjectId: "",
            answer: "",
            // 内嵌框中答案是否正确
            rightAnswer: false,
            subjectId: "",
            companyId: null,
            createdBy: null,
            organizationId: null,
            pictureUrl: null,
            status: null,
            updatedBy: null,
            version: 1
          }
        ]
      },
      //打算删除，暂存试卷id，version表单
      deletePaperSubjectListData: [
        {
          paperId: "",
          version: 1
        }
      ],
      //打算删除，暂存题目id，version表单
      deleteSubjectListData: [
        {
          subjectId: "",
          version: 1
        }
      ],
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
      // 试卷规则
      subjectRules: {
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
      // 修改试题rules
      updateSubjectRules: {
        subjectCategory: [
          { required: true, message: "请选择题目类别", trigger: "change" }
        ],
        questionType: [
          { required: true, message: "请选择题目题型", trigger: "change" }
        ],
        difficult: [
          { required: true, message: "请选择题目难度", trigger: "change" }
        ],
        subject: [
          { required: true, message: "请输入题目", trigger: "blur" },
          {
            min: 1,
            max: 256,
            message: "长度在 1 到 256 个字符",
            trigger: "blur"
          }
        ]
      }
    };
  },
  created() {
    axios
      .post("/education/bes/v1/boss-bes-paper-center/paper/findList", {
          paperName: "",
          pageNum: 1,
          pageSize: 6,
          combExamMan: "",
          templateTag: ""
      })
      .then(resp => {
        this.listLoading = false
        this.tableData = resp.data.body.list;
        this.total = resp.data.body.total;
      });
      this.queryParam();
  },
  inject: ["reload"],
  methods: {
    async queryParam(){
      const { resources } = await this.$store.dispatch('user/getInfo')
      if (resources.indexOf('1000221') === -1) {
        this.isFindShow = false
      }
      if (resources.indexOf('100241') === -1) {
        this.isDeleteShow = false
      }
      if (resources.indexOf('1000222') === -1) {
        this.isPreviewShow = false
      }
      if (resources.indexOf('100242') === -1) {
        this.isDeleteListShow = false
      }
      if (resources.indexOf('100213') === -1) {
        this.isPaperDetailsShow = false
      }
      if (resources.indexOf('100243') === -1) {
        this.isUpdatePaperShow = false
      }
    },
    // 分页
    page(currentPage) {
      axios
        .post("/education/bes/v1/boss-bes-paper-center/paper/findList", {
            paperName: "",
            pageNum: currentPage,
            pageSize: 6,
            combExamMan: "",
            combExamTime: "",
            difficulty: "",
            paperType: "",
            templateTag: ""
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
    // 上方预览按钮
    previewList(){
      const checkBox = this.$refs.multipleTable.selection;
      if (this.$refs.multipleTable.selection.length > 1) {
        this.$message("单次只能预览一份试卷！");
      }else if(this.$refs.multipleTable.selection.length ==0){
        this.$message("请选择试卷！");
      }else{
        this.preview(checkBox[0])
      }
    },
    // 上方详情按钮
    paperDetailsList(){
      const checkBox = this.$refs.multipleTable.selection;
      if (this.$refs.multipleTable.selection.length > 1) {
        this.$message("单次只能编辑一份试卷！");
      }else if(this.$refs.multipleTable.selection.length ==0){
        this.$message("请选择试卷！");
      }else{
        this.paperDetails(checkBox[0])
      }
    },
    // 表格中详情按钮
    paperDetails(row) {
      //加载试卷信息
      axios
        .post("/education/bes/v1/boss-bes-paper-center/paper/getPaper/", {
            id: row.id
        })
        .then(resp => {
          this.paperId = resp.data.body.id;
          this.subjectform = resp.data.body;
          this.subjectform.paperType = String(resp.data.body.paperType);
          this.subjectform.difficulty = String(resp.data.body.difficulty);
        });
      //加载试卷中包括的试题
      axios.post("/education/bes/v1/boss-bes-paper-center/paperSubject/showSubjectWithAnswer/", {
            paperId: row.id
        })
        .then(resp => {
          this.subjectData = resp.data.body;
          this.deleteSubjectListData = [];
          for (var i = 0; i < this.subjectData.length; i++) {
            this.deleteSubjectListData[i] = {
              subjectId: this.subjectData[i].id,
              version: this.subjectData[i].version
            };
          }
          this.deletePaperSubjectListData = [];
          for (var j = 0; j < this.subjectData.length; j++) {
            this.deletePaperSubjectListData[j] = {
              paperId: this.subjectData[j].paperId,
              version: this.subjectData[j].version
            };
          }
        });
      //打开弹窗
      this.details = true;
    },
    // 重置按钮
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    // 查询功能
    findPapers(formName) {
      axios.post("/education/bes/v1/boss-bes-paper-center/paper/findList", {
            paperName: this.ruleForm.paperName,
            pageNum: 1,
            pageSize: 6,
            combExamMan: this.ruleForm.combExamMan,
            startTime: this.ruleForm.datetime[0],
            endTime: this.ruleForm.datetime[1],
            difficulty: this.ruleForm.difficultyType,
            paperType: this.ruleForm.paperType,
            templateTag: ""
        })
        .then(resp => {
          this.tableData = resp.data.body.list;
          this.total = resp.data.body.total;
        });
    },
    // 表格显示试卷类型
    showPaperType(row) {
      if (row.paperType === 1) {
        return "算法卷";
      } else if (row.paperType === 2) {
        return "基础卷";
      }
    },
    // 表格显示试卷难度
    showPaperDifficult(row) {
      if (row.difficulty === 0) {
        return "简单";
      } else if (row.difficulty === 1) {
        return "中等";
      } else if (row.difficulty === 2) {
        return "困难";
      }
    },
    // 深拷贝
    cloneObject(source) {
      return JSON.parse(JSON.stringify(source));
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
    // 表格显示题目题型
    showSubjectType(row) {
      if (row.questionType === 1 || row.questionType === "1") {
        return "单选题";
      } else if (row.questionType === 2 || row.questionType === "2") {
        return "多选题";
      } else if (row.questionType === 3 || row.questionType === "3") {
        return "填空题";
      } else if (row.questionType === 4 || row.questionType === "4") {
        return "编程题";
      } else if (row.questionType === 5 || row.questionType === "5") {
        return "简答题";
      } else if (row.questionType === 6 || row.questionType === "6") {
        return "应用题";
      } else {
        return "其他";
      }
    },
    //单行删除
    deletePaper(row) {
      this.$confirm("确定删除试卷" + row.paperName + "吗？", "消息", {
        confirmButtonText: "确定",
        cancelButtonText: '取消',
        type: 'warning'
        }).then(() => {
          axios.post("/education/bes/v1/boss-bes-paper-center/paper/deletePaper/", {
              id: row.id , version:row.version,status:row.status
            }).then(resp => {
              if(resp.data.body =="数据正在被使用"){
                this.$message.error("删除失败，"+resp.data.body+"("+resp.data.head.code+")");
              }else{
                axios.post("/education/bes/v1/boss-bes-paper-center/paperSubject/deleteSubjectList/",
                  this.deletePaperSubjectListData
                  ).then(resp => {
                    });
                this.$message({
                  message: '删除成功！',
                  type: 'success'
                });
                this.reload();
              }

            });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除！'
          });
        });
    },
    //批量删除
    deleteList() {
      const checkBox = this.$refs.multipleTable.selection;
      if (this.$refs.multipleTable.selection.length > 0) {
        this.$confirm("确定删除试卷吗？", "消息", {
          confirmButtonText: "确定",
           cancelButtonText: '取消',
          type: 'warning'
          }).then(() => {
              axios
              .post("/education/bes/v1/boss-bes-paper-center/paper/deletePapers/", checkBox)
              .then(resp => {
                if(resp.data.body =="数据正在被使用"){
                  this.$message.error("删除失败，有选中"+resp.data.body+"("+resp.data.head.code+")");
                }else{
                  this.$message({
                    message: '批量删除成功！',
                    type: 'success'
                  });
                  this.reload();
                }
              });
        }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消删除!'
              });
        });
      }else{
        this.$message("请选择试卷！");
      }
    },
    // 前端，修改内嵌框确定按钮——保存题目
    updateSubject(updateSubjectForm, index) {
      this.$refs[updateSubjectForm].validate(valid => {
        if (valid) {
          var subjectList = {
            paperId: this.paperId,
            subject: this.updateSubjectForm.subject,
            subjectCategory: this.updateSubjectForm.subjectCategory,
            questionType: this.updateSubjectForm.questionType,
            score: this.updateSubjectForm.score,
            difficult: this.updateSubjectForm.difficult,
            answers: this.updateSubjectForm.answers,
            version: this.updateSubjectForm.version
          };
          this.$set(this.subjectData, index, subjectList);
          this.updateSubjectTag = false;
          this.$message({
          message: '题目修改成功！',
          type: 'success'
        });
        } else {
          return false;
        }
      });
    },
    //前端操作：添加题目内嵌框确定按钮——保存题目
    insertSubject(insertSubjectForm, index){
      this.$refs[insertSubjectForm].validate(valid => {
        if (valid) {
          var subjectList = {
            paperId: this.paperId,
            subject: this.insertSubjectForm.subject,
            subjectCategory: this.insertSubjectForm.subjectCategory,
            questionType: this.insertSubjectForm.questionType,
            score: this.insertSubjectForm.score,
            difficult: this.insertSubjectForm.difficult,
            answers: this.insertSubjectForm.answers,
            version: this.insertSubjectForm.version
          };
          this.subjectData.push(subjectList);
          this.insertSubjectTag = false;
          this.$message({
          message: '题目增加成功！',
          type: 'success'
        });
        } else {
          return false;
        }
      });
    },
    //前端操作：删除题目
    deleteSubjectAndAnswer(index, rows) {
      rows.splice(index, 1);
    },
    // (前端实现）编辑按钮功能，会触发内层弹框打开
    updateSubjectAndAnswer(row, index) {
      this.updateSubjectForm = this.subjectData[index];
      this.updateSubjectForm.questionType = String(this.subjectData[index].questionType);
      this.updateSubjectForm.difficult = String(this.subjectData[index].difficult);
      this.updateSubjectTag = true;
    },
    // 前端操作：添加题目按钮
    addSubject() {
      this.insertSubjectForm.index = null;
      this.insertSubjectForm.score = 1;
      this.insertSubjectForm.subjectCategory = "";
      this.insertSubjectForm.questionType = "";
      this.insertSubjectForm.difficult = "";
      this.insertSubjectForm.subject = "";
      this.insertSubjectForm.answers = [];
      this.$nextTick(() => {
        this.$refs.insertSubjectForm.clearValidate();
      });
      this.insertSubjectTag = true;
    },
    // 前端操作：添加答案
    addAnswer(form) {
      form.answers.push({
        answer: "",
        key: Date.now(),
        companyId: null,
        createdBy: null,
        organizationId: null,
        pictureUrl: null,
        rightAnswer: false,
        subjectId: null,
        updatedBy: null,
        version: 1
      });
    },
    // 前端操作：修改试卷框删除答案
    removeDomain(item) {
      var index = this.updateSubjectForm.answers.indexOf(item);
      if (index !== -1) {
        this.updateSubjectForm.answers.splice(index, 1);
      }
    },
    // 前端操作：添加试卷框删除答案
    removeDomain1(item) {
      var index = this.insertSubjectForm.answers.indexOf(item);
      if (index !== -1) {
        this.insertSubjectForm.answers.splice(index, 1);
      }
    },
    // 对话框（总）确定按钮，唯一与后端交互
    updatePaper(subjectform) {
      this.$refs[subjectform].validate(valid => {
        if (valid) {
          //修改试卷信息
          axios.post("/education/bes/v1/boss-bes-paper-center/paper/updatePaper/", {
                id: this.subjectform.id,
                paperName: this.subjectform.paperName,
                difficulty: this.subjectform.difficulty,
                paperType: this.subjectform.paperType,
                discribe: this.subjectform.discribe,
                version:this.subjectform.version
                ,status:this.subjectform.status
            })
            .then(resp => {
              if(resp.data.body =="数据正在被使用"){
                this.$message.error("修改失败，"+resp.data.body+"("+resp.data.head.code+")");
              }else{
                this.details = false;
                this.listLoading= true;
            if(this.deletePaperSubjectListData.length ==0){
               //原试卷中无试题，直接批量新增试卷包含的试题与答案
                  axios.post(
                      "/education/bes/v1/boss-bes-paper-center/paperSubject/insertSubjectList/",
                        this.subjectData
                    ).then(resp => {
                      this.listLoading= false;
                       this.$message({
                        message: '修改试卷成功！',
                        type: 'success'
                      });
                      this.reload();
                    });
            }else{
              //原试卷中有试题，先批量删除试卷包含的试题与答案
            axios.post("/education/bes/v1/boss-bes-paper-center/paperSubject/deleteSubjectList/",
             this.deletePaperSubjectListData
            ).then(resp => {
              // 试题没有答案
                if(this.deleteSubjectListData.length==0){
                    //批量新增试卷包含的试题与答案
                  axios.post(
                      "/education/bes/v1/boss-bes-paper-center/paperSubject/insertSubjectList/",
                        this.subjectData
                    ).then(resp => {
                      this.listLoading= false;
                       this.$message({
                        message: '修改试卷成功！',
                        type: 'success'
                      });
                      this.reload();
                    });
                }else{
                  // 试题中包含答案，批量删除答案
                axios.post(
                  "/education/bes/v1/boss-bes-paper-center/PaperSubjectAnswer/deleteAnswerList/",
                    this.deleteSubjectListData).then(resp => {
                  //批量新增试卷包含的试题与答案
                  axios.post(
                      "/education/bes/v1/boss-bes-paper-center/paperSubject/insertSubjectList/",
                        this.subjectData
                    ).then(resp => {
                      this.listLoading= false;
                       this.$message({
                        message: '修改试卷成功！',
                        type: 'success'
                      });
                      this.reload();
                    });
                });
                }

            });
              }
              }
            });

        } else {
          return false;
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
.subjectform {
  margin: 0 0 0 100px;
}
.updateSubjectForm {
  margin: 0 0 0 50px;
}
.paperMessageForm {
  font-weight: 700;
  font-display: "微软雅黑";
}
</style>
