<template>
  <div class="exam-page">
    <question :problem="questionList[curProNo]" :old-res="paperRes[curProNo]" ref="curProblem"
              @res-change="changeRes"></question>
    <div class="opt">
      <el-button class="next" v-if="curProNo < (questionList.length - 1)" @click="curProNo ++"> 下一题</el-button>
      <el-button class="pre" v-if="curProNo > 0" @click="curProNo --"> 上一题</el-button>
    </div>
    <el-button class="submit" v-if="curProNo === questionList.length - 1" @click="submitPaper"> 提交</el-button>
  </div>
</template>

<script>
  import utils from "@/views/mobile/utils";
  import question from "@/views/mobile/component/question";

  export default {
    name: "exam",
    components: {
      question
    },
    data() {
      return {
        questionList: [],
        curProNo: 0,
        paperRes: {},
        startTime: "",
        endTime: "",
        limitTime: "",
        peopleId: "",
        examPublishRecordId: ""
      }
    },
    watch: {
      curProNo: function (val, oldVal) {
        console.log(oldVal);
        this.$refs.curProblem.res = this.paperRes[val];
      },
    },
    created() {
      //这个调用是有顺序的
      this.initParams();
      this.initTimerWatcher();
      this.initProblems();
    },
    methods: {
      //  1.考试开始时间明确则在考试开始之后十五分钟内可以进入考试，
      //  1.1结束时间明确则到时间还未提交试卷则将强制提交，
      //  1.2结束时间不明确则将从开始考试的时刻顺延考试时长作为考试结束时间。
      //  2.无考试开始时间则随时可以开始考试，考试结束时间为开始考试时间顺延考试时长的时间
      //  所以说其实这几个需求 首先开始时间，结束时间，考试时长是在this.$route.params里拿到的 我觉得可以换成偏移量 当前时间对于开始时间的偏移量 ms 当前时间对于结束时间的偏移量 ms
      initParams() {
        [ this.startTime, this.endTime, this.limitTime, this.peopleId, this.examPublishRecordId ] = [ (new Date(this.$route.params.startTime)), (new Date(this.$route.params.endTime)), this.$route.params.limitTime, this.$route.params.peopleId, this.$route.params.examPublishRecordId ];
      },
      initTimerWatcher() {
        let curTime = new Date();
        let startDiff, endDiff;
        if (this.startTime !== '') {
          //这部分是要求15分钟之内
          [startDiff, endDiff] = [curTime.getTime() - this.startTime.getTime(), this.endTime.getTime() - curTime.getTime()];
          startDiff > 900000 ? this.$router.push('/mobileLogin') : null;
        } else {
          this.startTime = curTime;
        }
        //每过10000ms检查一下是不是该交卷了
        setInterval(function () {
          curTime = new Date();
          this.endTime !== '' ? [startDiff, endDiff] = [curTime.getTime() - this.startTime.getTime(), this.endTime.getTime() - curTime.getTime()] : startDiff = curTime.getTime() - this.startTime.getTime();
          if (startDiff > this.limitTime.getTime()) {
            alert("到时间了 系统自动交卷");
            this.submitPaper();
            this.$router.push('/mobileLogin');
          }
          if (endDiff !== '' && endDiff < 0) {
            alert("到时间 系统自动交卷");
            this.submitPaper();
            this.$router.push('/mobileLogin');
          }
        }, 10000);
      },
      initProblems() {
        //TODO: 这个参数因为将来肯定是二维码跳转过来的 examPublishRecordId那就从this.$route.params获取就可以 现在先写死 当然其实那个peopleId现在看起来说是将来登录带上 就挺离谱的 究竟是扫码来的对应的id 还是注册登录之后的id 要问清楚
        //peopleId: this.$route.params.peopleId,
         //examPublishRecordId: this.$route.params.examPublishRecrdId
        utils.request('/exam/phone/paper', {
          peopleId: 1,
          examPublishRecordId: 1
        }, 'post', this).then((res) => {

          this.questionList = res.data.body;
          console.log("题目");
          console.log(this.questionList);
        })
      },
      changeRes(val) {
        this.paperRes[this.curProNo] = val;
      },
      submitPaper() {
        // 肉眼可见 要转换body
        let pushData = [];
        Object.keys(this.questionList).forEach((val) => {
          pushData.push({
            myAnswer: this.paperRes.val,
            id: this.questionList[val].answerRecordId
          })
        });
        utils.request('exam/phone/save', pushData, 'post', this).then((res) => {
          console.log(res);
        });
        alert("提交成功");
        this.$router.push('/mobileLogin');
      },
    }
  }
</script>

<style scoped>

</style>
