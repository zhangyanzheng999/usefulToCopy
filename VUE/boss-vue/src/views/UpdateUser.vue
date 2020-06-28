/* eslint-disable no-undef */
<!--  -->
<template>
    <div>
        <el-form
            :model="ruleForm"
            :rules="rules"
            ref="ruleForm"
            label-width="100px"
            class="demo-ruleForm"
            style="width:40%"
        >
            <el-form-item label="编号" prop="id">
                <el-input v-model="ruleForm.id" readonly></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="用户名" prop="code">
                <el-input v-model="ruleForm.code"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
export default {
    data() {
        return {
            ruleForm: {
                id: '',
                name: '',
                code: ''
            },
            rules: {
                name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
                code: [{ required: true, message: '请输入用户名', trigger: 'blur' }]
            }
        }
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    axios
                        .put('http://localhost:8181/user/update', this.ruleForm)
                        .then(resp => {
                            if (resp.data == 'success') {
                                this.$alert(this.ruleForm.name + '---->修改成功', '消息', {
                                    confirmButtonText: '确定',
                                    callback: () => {
                                        this.$router.push('/FindUser')
                                    }
                                })
                            }
                        })
                } else {
                    return false
                }
            })
        },
        resetForm(formName) {
            this.$refs[formName].resetFields()
        }
    },
    created() {
        axios
            .get('http://localhost:8181/user/findById/' + this.$route.query.id)
            .then(resp => {
                this.ruleForm = resp.data
            })
    }
}
</script>
