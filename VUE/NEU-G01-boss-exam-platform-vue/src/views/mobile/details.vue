<template>
    <div class="main">
      <div class="welcome">{{'欢迎你' + content.peopleId}}</div>
      <el-card class="main-warpper">
        <div>{{'考试id' + content.examPublishRecordId}}</div>
        <div>{{'开始时间' + content.startTime}}</div>
        <div>{{'结束时间' + content.endTime}}</div>
        <div>{{'考试时长' + content.limitTime}}</div>
      </el-card>
      <el-button @click.native="commitStart">开始考试</el-button>
    </div>
</template>

<script>
  //想要名称的话可以加一下通过id换详情的接口 或者从二维码传（不推荐 要改的太多） 现在是ms还是分钟不记得了 看一下吧
    export default {
        name: "details",
        data() {
          return {
            content: {}
          }
        },
        methods: {
          commitStart() {
            this.$router.push({
              name: 'problem',
              params: {
                startTime: this.$route.params.startTime,
                endTime: this.$route.params.endTime,
                limitTime: this.$route.params.limitTime,
                peopleId: this.$route.params.peopleId,
                examPublishRecordId: this.$route.params.examPublishRecordId
              }
            })
          }
        },
        mounted() {
          this.content = this.$route.params;
        }
    }
</script>

<style scoped>

</style>
