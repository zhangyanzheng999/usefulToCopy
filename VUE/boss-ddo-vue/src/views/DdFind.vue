<!--  -->
<template>
    <div>
        <el-table
            :data="tableData"
            border
            style="width: 100%"
            :header-cell-style="{'text-align':'center'}"
            :cell-style="{'text-align':'center'}"
        >
            <el-table-column fixed prop="argsValue" label="参数值" width="100"></el-table-column>
            <el-table-column fixed prop="ddNote" label="注释" width="100"></el-table-column>
            <el-table-column fixed prop="status" label="状态" width="60"></el-table-column>
            <el-table-column fixed prop="orgId" label="组织ID" width="70"></el-table-column>
            <el-table-column fixed prop="createdBy" label="创建者" width="100"></el-table-column>
            <el-table-column fixed prop="createdTime" label="创建时间" width="160"></el-table-column>
            <el-table-column fixed prop="updatedBy" label="更新者" width="100"></el-table-column>
            <el-table-column fixed prop="updatedTime" label="更新时间" width="160"></el-table-column>
            <el-table-column fixed prop="version" label="版本" width="80"></el-table-column>
            <el-table-column fixed prop="ddType.ddTypeName" label="类型名称" width="100"></el-table-column>
            <el-table-column fixed prop="ddType.ddTypeNote" label="类型注释" width="100"></el-table-column>
            <el-table-column fixed label="操作" width="150">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="primary" size="mini">修改</el-button>
                    <el-button @click="deleteById(scope.row)" type="danger" size="mini">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
            background
            layout="prev, pager, next"
            :page-size="5"
            :total="total"
            @current-change="page"
        ></el-pagination>
        <!-- 模态框 -->
        <el-dialog
            title="修改数据字典"
            :visible.sync="dialogVisible"
            width="30%"
            :center="true"
            @close="closeDialog"
        >
            <el-form
                :model="editForm"
                :rules="rules"
                ref="editForm"
                label-width="100px"
                class="demo-ruleForm"
                style="width:100%;"
            >
                <el-form-item label="编号" prop="ddId">
                    <el-input v-model="editForm.ddId" readonly></el-input>
                </el-form-item>
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
                <el-form-item label="更新者" prop="updatedBy">
                    <el-input v-model="editForm.updatedBy"></el-input>
                </el-form-item>
                <el-form-item label="更新时间" prop="updatedTime">
                    <el-date-picker
                        v-model="editForm.updatedTime"
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
                    <el-button type="primary" @click="submitForm('editForm')">立即修改</el-button>
                    <el-button @click="resetForm('editForm')">重置</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
    inject: ['reload'], //注入
    data() {
        //这里存放数据
        return {
            dialogVisible: false,
            addLoading: false,
            total: null,
            tableData: null,
            editForm: {
                ddId: null,
                argsValue: null,
                ddNote: null,
                status: null,
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
                updatedBy: [{ required: true }],
                updatedTime: [{ required: true }],
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
        page(currentpage) {
            axios.get('http://localhost:9000/dd/get?pageNum=' + currentpage + '&pageSize=5').
                then(resp => {
                    this.tableData = resp.data.list
                    this.total = resp.data.total
                })
        },
        edit(row) {
            console.log('打印一下Token:' + localStorage.getItem('Authorization'))
            this.dialogVisible = true
            this.editForm = row
        },
        //删除
        deleteById(row) {
            axios.delete('http://localhost:9000/dd/delete/' + row.ddId ).then((resp) => {
                if (resp.status == 200) {
                    this.$alert(row.argsValue + '---->删除成功', '消息', {
                        confirmButtonText: '确定',
                        callback: () => {
                            this.reload()
                        }
                    })
                } else {
                    this.$alert(row.argsValue + '---->删除失败,请重试', '消息', {
                        confirmButtonText: '确定',
                        callback: () => {
                            this.reload()
                        }
                    })
                }

            })
        },
        //重置
        resetForm(formName) {
            this.$refs[formName].resetFields()
        },
        //关闭模态框
        closeDialog() {
            this.dialogVisible = false
            this.$refs.editForm.resetFields()
        },
        //提交修改
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    axios
                        .put('http://localhost:9000/dd/update', this.editForm)
                        .then(resp => {
                            if (resp.data == 'update success') {
                                this.$alert(this.editForm.ddId + '---->修改成功', '消息', {
                                    confirmButtonText: '确定',
                                    callback: () => {
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
        
        axios.get('http://localhost:9000/dd/get').then(resp => {

            this.tableData = resp.data.list
            this.total = resp.data.total
        })
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
.el-pagination {
    text-align: center;
}
.el-table {
    text-align: center;
    margin: 0 auto;
}
/* 设置模态框格式 */
.el-dialog {
    display: flex;
    flex-direction: column;
    margin: 0 !important;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    /*height:600px;*/
    max-height: calc(100% - 30px);
    max-width: calc(100% - 30px);
}
.el-dialog .el-dialog__body {
    flex: 1;
    overflow: auto;
}
</style>