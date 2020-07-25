<template>
  <div class="app-container">

    <div>
      <div class="group">

        <div class="group-line">

          <div class="group-item">
            <label for="exam-id">考试场次</label>
            <el-input id="exam-id" class="input-item" v-model="form.examNo"></el-input>
          </div>


          <div class="group-item">

            <label for="exam-name">考试名（from）</label>
            <el-input id="exam-name" class="input-item" v-model="form.title"></el-input>
          </div>
        </div>
        <div class="group-line">
          <div class="group-item">
            <label for="publish-input">发布人</label>
            <el-input id="publish-input" class="input-item"  v-model="form.publisher"></el-input>
          </div>
          <div class="group-item">
            <label for="exam-from-data">考试开始时间（from）</label>
            <el-date-picker
              v-model="form.examStartTime"
              type="datetime"
              placeholder="选择日期时间"
              id="exam-from-data-2"
              class="input-item"
            >
            </el-date-picker>
          </div>
          <div class="group-item">

            <label for="exam-to-data">考试结束时间（to）</label>
            <el-date-picker
              v-model="form.examEndTime"
              type="datetime"
              placeholder="选择日期时间"
              id="exam-to-data-2"
              class="input-item"
            >
            </el-date-picker>
          </div>

         <div class="group line">
        <el-button v-if="isQuery" type="primary" size="small" @click.native="fetchByForm(curPage)"> 查询</el-button>

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
            prop="title"
            label="考试标题"
            sortable
            :sort-orders="['ascending', 'descending']"
            width="150">
          </el-table-column>
          <el-table-column
            prop="examNo"
            label="场次号"
            sortable
            :sort-orders="['ascending', 'descending']"
            width="120">
          </el-table-column>
          <el-table-column
            prop="endTime"
            label="考试截止时间"
            width="150">
          </el-table-column>

          <el-table-column
            prop="planPepoleNum"
            label="计划考试人数"
            width="150">
          </el-table-column>

          <el-table-column
            prop="actualNum"
            label="实际考试人数"
            width="150">
          </el-table-column>

          <el-table-column
            fixed="right"
            label="操作"
            width="180">
            <template slot-scope="scope">
              <el-button v-if="isDetail" type="primary" icon="el-icon-search" size="small" class="line-opt" @click="fetchListDetail(scope.$index)"></el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-card>
       <el-dialog title="查看明细" :visible.sync="updateDialogFormVisible">
      <el-card class="list-view">
                <div class="opt-borad">
          <el-button v-if="isExport" type="primary" size="small" @click="handleDownload">导出当前页</el-button>

        </div>
        <el-table
          :data="reportData"
          border
          style="width: 100%">
          <el-table-column
            prop="name"
            label="姓名"
            width="60">
          </el-table-column>

          <el-table-column
            prop="sex"
            label="性别"
            width="60">
          </el-table-column>
          <el-table-column
            prop="title"
            label="标题"
            width="100">
          </el-table-column>
          <el-table-column
            prop="objectiveGrade"
            label="客观题"
            width="60">
          </el-table-column>
          <el-table-column
            prop="subjectiveGrade"
            label="主观题"
            width="60">
          </el-table-column>
          <el-table-column
            prop="total"
            label="总分"
            width="60">
          </el-table-column>
          <el-table-column
            prop="ranking"
            label="排名"
            width="60">
          </el-table-column>
          <el-table-column
            prop="time"
            label="耗时"
            width="60">
          </el-table-column>
          <el-table-column
            prop="abilityTag"
            label="能力标签"
            width="100">
          </el-table-column>

        </el-table>
      </el-card>
    </el-dialog>
      <div class="opt-group">
      <el-button v-if="isPre" type="primary" @click.native="handlePre">前一页</el-button>
      <el-button v-if="isPage" v-for="i in pageNum" :key="i" @click="fetchAllList(i)" :class="{ active: curPage === i }">{{i}}</el-button>
      <el-button v-if="isNext" type="primary" @click.native="handleNext">后一页</el-button>
    </div>
    </div>
  </div>
</template>

<script>
  import {parseTime} from '@/utils'
  import {format} from "@/utils/dateTool";
  import FilenameOption from './components/FilenameOption'
  import AutoWidthOption from './components/AutoWidthOption'
  import BookTypeOption from './components/BookTypeOption'
  const axios = require("axios");

  export default {
    name: 'exam-res',
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
        reportData: [],
        form: {
          examId: "",
          title: "",
          examStartTime: "",
          examEndTime: "",
          publisher:  ""
        },
        curPage: 1,
        hasprePage: false,
        hasnextPage: false,
        pageNum: 0
      }
    },
    created() {
      this.queryParam();
      this.fetchAllList(this.curPage);
    },
    methods: {
      async queryParam(){
        const { resources } = await this.$store.dispatch('user/getInfo')
        if (resources.indexOf('100820') === -1) {
          this.isPage = false;
          this.isPre = false;
          this.isNext = false;
        }
        if (resources.indexOf('100821') === -1) {
          this.isDetail = false
        }
        if (resources.indexOf('100819') === -1) {
          this.isQuery = false
        }
      },
      async fetchAllList(page) {
        var data = {"pageNo":page};
        var config = {
          method: 'post',
          url: `/education/bes/v1/boss-bes-exam-center/report/queryAll`,
          headers: {
            'Content-Type': 'application/json'
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
        console.log("datalist");
        console.log(dataList);
        this.hasprePage = !dataList.isFirstPage;
        this.hasnextPage = !dataList.isLastPage;
        this.pageNum = dataList.navigatePages;
        this.tableData = dataList.list;
      },
      async fetchListDetail(index) {
        var id = this.tableData[index].id;
        console.log(id);
        var data = {"examPublishRecordId": id};
        var config = {
          method: 'post',
          url: `/education/bes/v1/boss-bes-exam-center/report/detail`,
          headers: {
            'Content-Type': 'application/json'
          },
          data : data
        };
        this.updateDialogFormVisible = true;
        this.axios(config)
          .then(res => {
            console.log(res.data.body);
            this.reportData = res.data.body;
          })
        
      },
      async fetchByForm(page) {
        this.model = "qq";
        var axios = require('axios');
        var data ={
        "pageNo:":page,
        "examId":this.form.examId,
        "examStartTime":this.form.examStartTime,
        "examEndTime":this.form.examEndTime,
        "title":this.form.title,
        "publisher":this.form.publisher};

        var config = {
          method: 'post',
          url: '/education/bes/v1/boss-bes-exam-center/report/record',
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
        this.hasprePage = !dataList.isFirstPage;
        this.hasnextPage = !dataList.isLastPage;
        this.pageNum = dataList.navigatePages;
        this.tableData = dataList.list;
      },
       handlePre() {
        this.curPage--;
        this.fetchAllList(this.curPage);
      },
      handleNext() {
        console.log('next');
        this.curPage++;
        this.fetchAllList(this.curPage);
      },
      changeSelect(val) {
        console.log(val);
      },
      handleDownload() {
        this.downloadLoading = true
        import('@/vendor/Export2Excel').then(excel => {
          //这个表头要根据下的部分更改
          const tHeader = ['Name', 'Sex', 'Title', 'ObjectiveGrade', 'SubjectiveGrade', 'Total', 'Ranking', 'Time', 'AbilityTag']
          const filterVal = ['name', 'sex', 'title', 'objectiveGrade', 'subjectiveGrade', 'total', 'ranking', 'time', 'abilityTag']
          const list = this.reportData
          const data = this.formatJson(filterVal, list)
          excel.export_json_to_excel({
            header: tHeader,
            data,
            filename: this.filename,
            autoWidth: this.autoWidth,
            bookType: this.bookType
          })
          this.downloadLoading = false
        })
      },
      formatJson(filterVal, jsonData) {
        return jsonData.map(v => filterVal.map(j => {
          if (j === 'timestamp') {
            return parseTime(v[j])
          } else {
            return v[j]
          }
        }))
      }
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

  .input-item {
    padding-left: 6px;
    width: 180px;
    height: 36px;
  }

  .line {
    margin: 20px 0;
  }
  .group-line {
    margin-top: 10px;
    display: flex;
    justify-content: space-between;
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

  .list-view {
    margin-top: 20px;
  }

</style>
