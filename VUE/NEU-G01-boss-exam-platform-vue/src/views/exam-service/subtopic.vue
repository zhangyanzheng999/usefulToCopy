<template>
  <div class="app-container">

    <div>
      <div class="group-item">
        <label for="select-list">题目类型</label>
        <el-select v-model="subProjectId" placeholder="请选择" id="select-list">
          <el-option label="编程题" value="4"></el-option>
          <el-option label="应用题" value="6"></el-option>
          <el-option label="简答题" value="5"></el-option>
          <el-option label="其他" value="1"></el-option>
        </el-select>
      </div>
      <div class="group-item">
        <el-button v-if="isQuery" type="primary" @click="fetchAllData()">查询</el-button>
      </div>

      
        <div v-for="(item, index) in tableDatalist" class="list">
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
      
    </div>
  </div>
</template>

<script>
  import {getUserId, getCompanyId, getOrganizationId} from "@/utils/userInfo";

  export default {
    data() {
      return {
        isSave: true,
        isQuery: true,
        score: "",
        evaluate: "",
        id: "",
        subProjectId: 0,
        userId: getUserId,
        tableDatalist: []
      }
    },
    created() {
      this.queryParam()
    },
    methods: {
       async queryParam(){
        const { resources } = await this.$store.dispatch('user/getInfo')

        if (resources.indexOf('100817') === -1) {
          this.isSave = false
        }
        if (resources.indexOf('100818') === -1) {
          this.isQuery = false
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
      async fetchAllData() {
        var data = {
          subjectTypeId: this.subProjectId,
          userId: this.userId
        }
        var config = {
          method: 'post',
          url: '/education/bes/v1/boss-bes-exam-center/evaluate/queryBySpecificType',
          headers: {
            'Content-Type': 'application/json'
          },
          data: data
        };

        let list = await axios(config)
          .then(function (response) {
            return response.data.body;
          })
          .catch(function (error) {
            console.log(error);
          });
        this.tableDatalist = list;
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
