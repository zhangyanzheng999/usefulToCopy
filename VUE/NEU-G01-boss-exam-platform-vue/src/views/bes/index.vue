<template>
  <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <el-form-item label="用户id"  >
      <el-input v-model="ruleForm.userId" ></el-input>
    </el-form-item>
    <el-form-item label="公司id"  >
      <el-input v-model="ruleForm.companyId" ></el-input>
    </el-form-item>
    <el-form-item label="组织id"  >
      <el-input v-model="ruleForm.organizationId" ></el-input>
    </el-form-item>
    <el-form-item label="token"  >
      <el-input v-model="ruleForm.token" ></el-input>
    </el-form-item>
    <el-form-item>
      <el-popover
        placement="top-start"
        title="tips"
        width="200"
        trigger="hover"
        content="如果你能看到这个按钮，说明你已经获得了系统管理的所有权限。">
        <el-button type="primary" slot="reference" v-if = 'isSystemShow'>系统管理</el-button>
      </el-popover>
    </el-form-item>
    <el-form-item>
      <el-popover
        placement="top-start"
        title="tips"
        width="200"
        trigger="hover"
        content="如果你能看到这个按钮，说明你已经获得了考试管理的所有权限。">
        <el-button type="primary" slot="reference" v-if = 'isExamShow'>考试管理</el-button>
      </el-popover>
    </el-form-item>
    <el-form-item>
      <el-popover
        placement="top-start"
        title="tips"
        width="200"
        trigger="hover"
        content="如果你能看到这个按钮，说明你已经获得了试卷管理的所有权限。">
        <el-button type="primary" slot="reference" v-if = 'isPaperShow'>试卷管理</el-button>
      </el-popover>
    </el-form-item>
    <el-form-item>
      <el-popover
        placement="top-start"
        title="tips"
        width="200"
        trigger="hover"
        content="如果你能看到这个按钮，说明你已经获得了基础数据管理的所有权限。">
        <el-button type="primary" slot="reference" v-if = 'isBaseDataShow'>基础数据管理</el-button>
      </el-popover>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')" v-if = 'isSystemShow'>提交</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  import {getUserId, getCompanyId, getOrganizationId} from "@/utils/userInfo";

  export default {
      data() {
        return {
          isSystemShow: true,
          isPaperShow: true,
          isExamShow: true,
          isBaseDataShow: true,
          isNeedShow: true,
          ruleForm: {
            userId: getUserId(),
            companyId: getCompanyId(),
            organizationId: getOrganizationId(),
            token: '',
            role: [],
            resources: []
          },
          rules: {
          }
        }
      },
      created() {
        this.queryParam()
      },
      methods: {
        submitForm(formName) {
        },
        resetForm(formName) {
          this.$refs[formName].resetFields();
        },
        async queryParam() {
          const { resources } = await this.$store.dispatch('user/getInfo')
          const userId = getUserId()
          const companyId = getCompanyId();
          const organizationId = getOrganizationId()
          if (resources.indexOf('10003') === -1) {
            this.isSystemShow = false
          }
          if (resources.indexOf('10014') === -1) {
            this.isExamShow = false
          }
          if (resources.indexOf('10020') === -1) {
            this.isPaperShow = false
          }
          if (resources.indexOf('10026') === -1) {
            this.isBaseDataShow = false
          }
        }
      }
    }

</script>

<style scoped>

</style>
