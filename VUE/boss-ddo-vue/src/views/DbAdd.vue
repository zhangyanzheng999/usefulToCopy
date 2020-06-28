<!--  -->
<template>
    <div>
        <el-form
            :model="editForm"
            :rules="rules"
            ref="editForm"
            label-width="100px"
            class="demo-ruleForm"
            style="width:35%;"
        >
            <el-form-item label="参数值" prop="argsValue">
                <el-input v-model="editForm.argsValue"></el-input>
            </el-form-item>
            <el-form-item label="注释" prop="ddNote">
                <el-input v-model="editForm.ddNote"></el-input>
            </el-form-item>
            <el-form-item label="状态" prop="status">
                <el-radio-group v-model="editForm.status">
                    <el-radio :label="1">展示</el-radio>
                    <el-radio :label="0">不展示</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="组织ID" prop="orgId">
                <el-input v-model="editForm.orgId"></el-input>
            </el-form-item>
            <el-form-item label="创建者" prop="createdBy">
                <el-input v-model="editForm.createdBy"></el-input>
            </el-form-item>
            <el-form-item label="创建时间" prop="createdTime">
                <el-date-picker
                    v-model="editForm.createdTime"
                    type="datetime"
                    placeholder="选择日期时间"
                    align="right"
                    value-format="yyyy-MM-dd HH:mm:ss"
                    :picker-options="pickerOptions"
                ></el-date-picker>
            </el-form-item>
            <el-form-item label="版本" prop="version">
                <el-input v-model="editForm.version"></el-input>
            </el-form-item>
            <el-form-item label="字典类型ID" prop="ddTypeId">
                <el-input v-model="editForm.ddTypeId"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('editForm')">立即添加</el-button>
                <el-button @click="resetForm('editForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
    inject: ['reload'], //注入
    data() {
        return {
            editForm: {
                ddId: null,
                argsValue: null,
                ddNote: null,
                status: 1,
                orgId: null,
                createdBy: null,
                createdTime: null,
                updatedBy: null,
                updatedTime: null,
                version: null,
                ddTypeId: null,
                ddType: {
                    ddTypeId: null,
                    ddTypeName: null,
                    ddTypeNote: null
                }
            },
            rules: {
                argsValue: [{ required: true }],
                ddNote: [{ required: true }],
                orgId: [{ required: true }],
                createdBy: [{ required: true }],
                createdTime: [{ required: true }],
                version: [{ required: true }],
                ddTypeId: [{ required: true }]
            },
            pickerOptions: {
                shortcuts: [{
                    text: '今天',
                    onClick(picker) {
                        picker.$emit('pick', new Date());
                    }
                }, {
                    text: '昨天',
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24);
                        picker.$emit('pick', date);
                    }
                }, {
                    text: '一周前',
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                        picker.$emit('pick', date);
                    }
                }]
            }
        }
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        resetForm(formName) {
            this.$refs[formName].resetFields()
        },
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    axios.post('http://localhost:9000/dd/insert?&token='+localStorage.getItem('Authorization'), this.editForm).then(resp => {
                        if (resp.data == 'insert success') {
                            this.$alert(this.editForm.argsValue + '---->添加成功', '消息', {
                                confirmButtonText: '确定',
                                callback: () => {
                                    this.$router.push('/show')
                                    this.reload()
                                }
                            })
                        }
                    })
                } else {
                    return false
                }
            })
        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {

    },
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() {

    },
    beforeCreate() { }, //生命周期 - 创建之前
    beforeMount() { }, //生命周期 - 挂载之前
    beforeUpdate() { }, //生命周期 - 更新之前
    updated() { }, //生命周期 - 更新之后
    beforeDestroy() { }, //生命周期 - 销毁之前
    destroyed() { }, //生命周期 - 销毁完成
    activated() { }, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style lang='scss' scoped>
.el-form {
    margin: 0 auto;
}

</style>