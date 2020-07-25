<template>
  <div class="app-container">

    <div>
      <div class="group">

        <div class="group line">
          <div class="group-item">
            <label for="exam-num">考试场次</label>
            <el-input v-model="form.examId" id="exam-num" class="input-item"></el-input>
          </div>
          <div class="group-item">
            <label for="status">批阅状态</label>
            <el-select v-model="form.status" placeholder="请选择" id="select-list">
              <el-option label="已批阅" value="1"></el-option>
              <el-option label="未批阅" value="2"></el-option>
              <el-option label="阅卷过期" value="3"></el-option>
            </el-select>
          </div>
          <div></div>
          <div class="group-item">
            <label for="exam-from-data">交卷时间（from）</label>
            <el-date-picker
              v-model="form.commitStartTime"
              type="datetime"
              placeholder="选择日期时间"
              id="exam-from-data"
              class="input-item"
            >
            </el-date-picker>
          </div>
          <div class="group-item">
            <label for="exam-to-data">交卷时间（to）</label>
            <el-date-picker
              v-model="form.commitEndTime"
              type="datetime"
              placeholder="选择日期时间"
              id="exam-to-data"
              class="input-item"
            >
            </el-date-picker>
          </div>
       <div></div>
       <div class="group line">
        <el-button v-if="isQuery" type="primary" size="small" @click.native="queryArray(curPage)"> 查询</el-button>
      </div>
        </div>
      </div>

      <el-card class="list-view">
        <el-table
          :data="tableData"
          border
          style="width: 100%">
          <el-table-column
            fixed
            type="selection"
            width="55">
          </el-table-column>

          <el-table-column
            prop="paperName"
            label="试卷"
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
            prop="publishTime"
            label="发布时间"
            width="150">
          </el-table-column>

          <el-table-column
            prop="examUserMobile"
            label="答卷人手机号"
            width="150">
          </el-table-column>

          <el-table-column
            prop="examUserName"
            label="答卷人姓名"
            width="150">
          </el-table-column>

          <el-table-column
            prop="commitTime"
            label="交卷时间"
            width="120">
          </el-table-column>
          <el-table-column
            prop="markLimitTime"
            label="阅卷终止时间"
            width="120">
          </el-table-column>
                    <el-table-column
            prop="objectiveGrade"
            label="客观题得分"
            width="120"
          >
          </el-table-column>
          <el-table-column
            prop="subjectiveGrade"
            label="主观题得分"
            width="120"
          >
          </el-table-column>
          <el-table-column
            prop="systemEvaluate"
            label="系统评价"
            width="120">
          </el-table-column>
          <el-table-column
            prop="status"
            label="状态"
            width="120">
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

        <div v-for="(item, index) in paperData" class="list">
        <div class="header">{{(index+1)+". " + " (" + item.subjectTotalGrade + "分)"+item.paperSubjectInfo}}</div>
        <div>
          <label>考生答案:  </label>
          <div class="myAnswer" v-if="subProjectId !== 5">
            {{item.myAnswer}}
            </div>
          <img :src="item.myAnswer" alt="" v-if="subProjectId === 5">
          <label>标准答案:  </label>
          <div class="standarAnswer" v-if="subProjectId !== 5">
            {{item.standarAnswer}}

          </div>
          <img :src="item.standardName" alt="" v-if="subProjectId === 5">

          <label>得分:  </label>
          <div class="score">
          <el-input v-model="score" id="answer-score" class="input-item"></el-input>
          </div>

          <label>评价:  </label>
          <div div class="evaluate">
          <el-input v-model="evaluate" id="answer-evaluate"  class="input-item"></el-input>
          </div>
          <el-input v-model="id" class="input-item" v-show="false" >{{item.id}}</el-input>

          <el-button v-if="isSave" type="primary" icon="el-icon-search" size="small" class="line-opt" @click="save">保存</el-button>
        </div>
      </div>

    </el-dialog>
    </div>

    <el-button v-if="isPre" type="primary" @click.native="handlePre">前一页</el-button>
    <el-button v-if="isPage" v-for="i in pageNum" :key="i" @click="fetchAllData(i)" :class="{ active: curPage === i }">{{i}}</el-button>
    <el-button v-if="isNext" type="primary" @click.native="handleNext">后一页</el-button>
  </div>
</template>

<script>
import {getUserId, getCompanyId, getOrganizationId} from "@/utils/userInfo";

  export default {
    data() {
      return {
        isPage: true,
        isPre: true,
        isNext: true,
        isDetail: true,
        isQuery: true,
        isSave: true,
        score: "",
        evaluate: "",
        id: "",
        updateDialogFormVisible: false,
        paperForm: {
          subject: "",
          max: "",
          standardAnswer: "",
          myAnswer: "",
          evaluate: "",
          score: ""
        },
        form: {
          examId:"",
          commitStartTime:"",
          commitEndTime:"",
          status:""
        },
        subProjectId: "",
        userId: getUserId,
        tableData: [],
        curPage: 1,
        hasprePage: false,
        hasnextPage: false,
        pageNum: 0,
        paperData: []
      }
    },
    created() {
      this.queryParam();
      this.fetchAllData(this.curPage);
    },
    methods: {
      async queryParam(){
      const { resources } = await this.$store.dispatch('user/getInfo')
        if (resources.indexOf('100815') === -1) {
          // 分页 每个按钮都触发查询
          this.isPage = false;
          this.isNext = false;
          this.isPre = false;
        }
        if (resources.indexOf('100816') === -1) {
          this.isDetail = false
        }
        if (resources.indexOf('100814') === -1) {
          this.isQuery = false
        }
        if (resources.indexOf('100817') === -1) {
          this.isSave = false
        }
      },
      save() {
        this.updateDialogFormVisible = false;
        var data = [{"score": this.score,"evaluate": this.evaluate,"id":this.id}];

        var config = {
          method: 'put',
          url: `/education/bes/v1/boss-bes-exam-center/evaluate/save`,
          headers: { 
            'Content-Type': 'application/json'
          },
          data : data
        };
        this.score = "";
        this.evaluate = "";
        this.id = "";
        axios(config)
        .then(function (response) {
          console.log(JSON.stringify(response.data));
        })
        .catch(function (error) {
          console.log(error);

        });

      },
      queryQ() {
        var data = {"subjectTypeId": this.subjectTypeId, "userId": 1};
        var config = {
          method: 'get',
          url: `/education/bes/v1/boss-bes-exam-center/evaluate/queryBySpecificType`,
          headers: {
            'Content-Type': 'application/json'
          },
          data: data
        };

        axios(config)
          .then(function (response) {
            console.log(JSON.stringify(response.data));
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      async fetchAllData(page) {
      //此处body的值为当前用户id，也就是阅卷官id，需要从store获得
        var data = {"pageNo":page,"id":1};

        var config = {
          method: 'post',
          url: '/education/bes/v1/boss-bes-exam-center/evaluate/queryAll',
          headers: {
            'Content-Type': 'application/json'
          },
          data : data
        };

         let dataList = await axios(config)
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
        //需要本场考试记录ID
        var examRecordId = this.tableData[index].examRecordId;
        console.log("examRecordId: "+examRecordId);
        var data = examRecordId;
        var config = {
          method: 'post',
          url: '/education/bes/v1/boss-bes-exam-center/evaluate/queryDetail',
          headers: {
            'Content-Type': 'application/json'
          },
          data : data
        };
      this.updateDialogFormVisible = true;
      axios(config)
          .then(res => {
            console.log(res.data.body);
            this.paperData = res.data.body;
          })

      },
      async queryArray(page) {
        this.model = "qq";
        var data = {
          "pageNo":page,
        "examId":this.form.examId,
        "commitStartTime":fthis.form.commitStartTime,
        "commitEndTime":this.form.commitEndTime,
        "status":this.form.status,
        "userId":1};

        var config = {
          method: 'post',
          url: `/education/bes/v1/boss-bes-exam-center/evaluate/query`,
          headers: {
            'Content-Type': 'application/json'
          },
          data : data
        };
        let dataList = await axios(config)
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
      handlePre() {
        this.curPage--;
        this.fetchAllData(this.curPage);
      },
      handleNext() {
        console.log('next');
        this.curPage++;
        this.fetchAllData(this.curPage);
      },
    },
    name: 'qs-comment'
  }
</script>

<style>

  #select-list {
    margin-left: 10px;
  }

  .group-line {
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
  }

  .line-opt {
    display: inline-block;
  }

  .opt-borad {
    margin-bottom: 10px;
  }

  .list-view {
    margin-top: 20px;
  }

</style>
