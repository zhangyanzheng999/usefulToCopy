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
            <el-form-item label="姓名" prop="name">
                <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="用户名" prop="code">
                <el-input v-model="ruleForm.code"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">立即添加</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
    <script>
export default {
    inject: ['reload'], //注入
    data() {
        return {
            ruleForm: {
                name: '',
                code: ''
            },
            rules: {
                name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
                code: [{ required: true, message: '请输入用户名', trigger: 'change' }]
            }
        }
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    axios
                        .post('http://localhost:8181/user/save', this.ruleForm)
                        .then(resp => {
                            if (resp.data == 'success') {
                                this.$alert(this.ruleForm.name + '---->添加成功', '消息', {
                                    confirmButtonText: '确定',
                                    callback: () => {
                                        this.$router.push('/FindUser')
                                        this.reload()
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
    }
}
</script>


