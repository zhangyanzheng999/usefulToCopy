<template>
  <div class="app-container">

    <div>
      <div class="group">

        <div class="group line">
          <div class="group-item">

            <label for="exam-name">考试标题</label>
            <el-input id="exam-name" class="input-item" v-model="form.title"></el-input>
          </div>
          <div class="group-item">

            <label for="launch-people">考试发布人</label>
            <el-input id="launch-people" class="input-item" v-model="form.publisher"></el-input>
          </div>
          <div class="group-item">

            <label for="exam-num">考试场次</label>
            <el-input id="exam-num" class="input-item" v-model="form.examNo"></el-input>
          </div>
          <div class="group-item">
            <label for="exam-from-data">考试时间（from）</label>
            <el-date-picker
              v-model="form.startTime"
              type="datetime"
              placeholder="选择日期时间"
              id="exam-from-data"
              class="input-item"
            >
            </el-date-picker>
          </div>
          <div class="group-item">

            <label for="exam-to-data">考试时间（to）</label>
            <el-date-picker
              v-model="form.endTime"
              type="datetime"
              placeholder="选择日期时间"
              id="exam-to-data"
              class="input-item"
            >
            </el-date-picker>
          </div>
      </div>

      </div>
        <div class="group line">
          <el-button v-if="isQuery" type="primary" size="small" @click.native="fetchListByForm">查询</el-button>
        </div>
      </div>

      <el-card class="list-view">
        <el-table
          :data="tableData"
          border
          style="width: 100%">

          <el-table-column
            prop="title"
            label="考试标题"
            sortable
            :sort-orders="['ascending', 'descending']"
            width="150">
          </el-table-column>

          <el-table-column
            prop="examId"
            label="场次号"
            sortable
            :sort-orders="['ascending', 'descending']"
            width="120">
          </el-table-column>
          <el-table-column
            prop="examEndTime"
            label="考试截止时间"
            width="150">
          </el-table-column>
          <el-table-column
            prop="mobile"
            label="答卷人手机号"
            width="150">
          </el-table-column>
          <el-table-column
            prop="name"
            label="答卷人姓名"
            sortable
            :sort-orders="['ascending', 'descending']"
            width="150">
          </el-table-column>
          <el-table-column
            prop="actualStartTime"
            label="开始考试时间"
            width="150">
          </el-table-column>
          <el-table-column
            prop="actualEndTime"
            label="结束考试时间"
            width="150">
          </el-table-column>
          <el-table-column
            prop="objectiveSubjectGrade"
            label="客观题得分"
            width="150"
          >
          </el-table-column>
          <el-table-column
            fixed="right"
            label="查看明细"
            width="180">
            <template slot-scope="scope">
              <el-button v-if="isDetail" type="primary" icon="el-icon-search" size="small" class="line-opt" @click="fetchListDetail(scope.$index)"></el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-card>
      <el-dialog title="查看明细" :visible.sync="updateDialogFormVisible">
        <el-table
          :data="paperData"
          border
          style="width: 100%">
          <el-table-column
            prop="paperSubjectInfo"
            label="题目"
            min-width="150"
            width="150">
          </el-table-column>

          <el-table-column
            prop="subjectTotalGrade"
            label="总分"
            min-width="50"
            width="50">
          </el-table-column>
          <el-table-column
            prop="standardAnswer"
            label="标准答案"
            min-width="120"
            width="120">
          </el-table-column>
          <el-table-column
            prop="myAnswer"
            label="我的答案"
            min-width="120"
            width="120">
          </el-table-column>
          <el-table-column
            prop="score"
            label="得分"
            width="50">
          </el-table-column>
          <el-table-column
            prop="evaluate"
            label="评价"
            width="120">
          </el-table-column>

        </el-table>
     </el-dialog>
      <el-button v-if="isPre" type="primary" @click.native="handlePre">前一页</el-button>
      <el-button v-if="isPage" v-for="i in pageNum" :key="i" @click="fetchAllList(i)" :class="{ active: curPage === i }">{{i}}</el-button>
      <el-button v-if="isNext" type="primary" @click.native="handleNext">后一页</el-button>
    </div>
</template>

<script>
import {getUserId, getCompanyId, getOrganizationId} from "@/utils/userInfo";
  import FilenameOption from './components/FilenameOption'
  import AutoWidthOption from './components/AutoWidthOption'
  import BookTypeOption from './components/BookTypeOption'
  import axios from "axios";

  export default {
    name: 'exam-publish',
    components: {FilenameOption, AutoWidthOption, BookTypeOption},
    data() {
      return {
        isDetail: true,
        isQuery: true,
        isPage: true,
        isPre: true,
        isNext: true,
        updateDialogFormVisible: false,
        list: null,
        listLoading: true,
        downloadLoading: false,
        autoWidth: true,
        bookType: 'xlsx',
        tableData: [],
        paperData: [],
        form: {
          title: "",
          publisher: "",
          startTime: "",
          endTime: "",
          examNo: ""
        },
        paperForm: {
          subject: "",
          max: "",
          standardAnswer: "",
          myAnswer: "",
          evaluate: "",
          score: ""
        },
        addForm: {},
        formLabelWidth: '120px',
        curPage: 0,
        hasprePage: false,
        hasnextPage: false,
        pageNum: 0
      }
    },
    created() {
      this.queryParam();
      this.fetchAllList(0);
    },
    methods: {
      async queryParam(){
        const { resources } = await this.$store.dispatch('user/getInfo')
        if (resources.indexOf('100808') === -1) {
          this.isPage = false;
          this.isPre = false;
          this.isNext = false;
        }
        if (resources.indexOf('100806') === -1) {
          this.isDetail = false
        }
        if (resources.indexOf('100807') === -1) {
          this.isQuery = false
        }
      },
      async fetchAllList(page) {
        var data = {"pageNo":page};
        var config = {
          method: 'post',
          url: `/education/bes/v1/boss-bes-exam-center/exam/queryAll`,
          headers: {
            'Content-Type': 'application/json',
          },
          data: data
        };
        let dataList = await this.axios(config)
          .then(function (response) {
            return (response.data.body);
          })
          .catch(function (error) {
            console.log(error);
          });
            this.hasprePage = !dataList.isFirstPage;
            this.hasnextPage = !dataList.isLastPage;
            this.tableData =dataList.list;
            this.pageNum = dataList.navigatePages;
      },
      fetchListDetail(index) {
        var examRecordId = this.tableData[index].examRecordId;
        console.log("examRecordId: "+examRecordId);
        var data = {"examRecordId":examRecordId};

        var config = {
          method: 'post',
          url: `/education/bes/v1/boss-bes-exam-center/exam/detail`,
          headers: {
            'Content-Type': 'application/json'
          },
          data : data
        };
      this.updateDialogFormVisible = true;
        this.axios(config)
          .then(res => {
            this.paperData = res.data.body;
          })
        
      },
      async fetchListByForm() {
        this.model = "qq";
        var data = {
        "publisher":this.form.publisher,
        "examId":this.form.examNo,
        "examStartTime":this.form.examStartTime,
        "examEndTime":this.form.examEndTime,
        "title":this.form.title};

        var config = {
          method: 'post',
          url: '/education/bes/v1/boss-bes-exam-center/exam/query',
          headers: {
            'Content-Type': 'application/json'
          },
          data : data
        };

        let dataList = await this.axios(config)
          .then(function (response) {
            return (response.data.body);
          })
          .catch(function (error) {
            console.log(error);
          });
        console.log("datalist");
        console.log(dataList);

          this.tableData = dataList.list;
      },
      created() {
        this.fetchListDetail();
      },
      handlePre() {
        this.curPage--;
        this.fetchAllData(this.curPage);
      },
      handleNext() {
        this.curPage++;
        this.fetchAllData(this.curPage);
      },
      handleUpdate() {
        if (this.curVal) {
          this.updateDialogFormVisible = true;
        } else {
          alert("请选择一个元素");
        }
      },
    }
  }
</script>

<style>
  .radio-label {
    font-size: 14px;
    color: #606266;
    line-height: 40px;
    padding: 0 12px 0 30px;
  }

  .group {
    display: flex;
    justify-content: space-between;
  }

  .input-item {
    padding-left: 6px;
    width: 180px;
    height: 36px;
  }

  .line {
    margin: 20px 0;
  }

  .main-list {
    margin-top: 10px;
  }

  .line-opt {
    display: inline-block;
  }

  .opt-borad {
    margin-bottom: 10px;
  }

</style>
