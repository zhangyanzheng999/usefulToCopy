<!--
 * @description:
 * @fileName: SystemParam.vue
 * @author: 张彦征
 * @date: 2020-07-16 17:00:45
!-->
<template>
    <div>
        <el-container>
            <el-aside width="180px" style="background-color: rgb(238, 241, 246)">
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <em class="el-icon-menu" />
                        <span>参数列表</span>
                    </div>
                    <el-tree
                        :data="treeData"
                        node-key="id"
                        :props="defaultProps"
                        :accordion="true"
                        :indent="12"
                        @node-click="handleNodeClick"
                    ></el-tree>
                </el-card>
            </el-aside>

            <el-main>
                <div>
                    <el-input
                        size="mini"
                        placeholder="请输入参数名称"
                        style="width: 150px"
                        v-model="listQuery.name"
                    ></el-input>
                    <el-button
                        size="mini"
                        @click="searchSystemParam()"
                        icon="el-icon-search"
                        style="margin-left:10px;color:#0000FF"
                    >搜索</el-button>
                </div>
                <div style="margin-top:20px">
                    <el-card class="box-card">
                        <div>
                            <el-button
                                size="mini"
                                @click="insert()"
                                icon="el-icon-circle-plus"
                                style="margin-left:0px;color:#006400"
                                v-if="isInsertShow"
                            >添加</el-button>
                            <el-button
                                size="mini"
                                @click="editTop()"
                                icon="el-icon-edit-outline"
                                style="margin-left:0px;color:#0000FF"
                                v-if="isModifyShow"
                            >修改</el-button>
                            <el-button
                                size="mini"
                                @click="multiDelete()"
                                icon="el-icon-delete"
                                style="margin-left:0px;color:#DC143C"
                                v-if="isMultiDeleteShow"
                            >删除</el-button>
                            <template v-if="isImportShow">
                                <upload-excel-component
                                    :on-success="handleSuccess"
                                    :before-upload="beforeUpload"
                                />
                            </template>
                            <el-button
                                size="mini"
                                @click="handleExport()"
                                icon="el-icon-download"
                                style="margin-left:0px;color:#9400D3"
                            >导出</el-button>
                            <el-button
                                size="mini"
                                @click="handleExportAll()"
                                icon="el-icon-download"
                                style="margin-left:0px;color:#9400D3"
                                v-if="isExportAllShow"
                            >导出全部</el-button>
                            <el-button
                                size="mini"
                                @click="handleExportFormat()"
                                icon="el-icon-download"
                                style="margin-left:0px;color:#9400D3"
                            >导出模板</el-button>
                        </div>
                        <div style="margin-top:20px">
                            <el-table
                                :data="systemParamTableData"
                                :ref="systemParamTableData"
                                style="width: 100%;font-size:12px"
                                :header-cell-style="{'text-align':'center'}"
                                :cell-style="{'text-align':'center'}"
                                :row-style="{height:'20px'}"
                                @selection-change="clickCheckBox"
                                @row-dblclick="handleRowDblclick"
                                row-key="id"
                            >
                                <el-table-column
                                    type="selection"
                                    :reserve-selection="true"
                                    width="50px"
                                ></el-table-column>
                                <el-table-column label="参数类别" prop="paramType" width="150px"></el-table-column>
                                <el-table-column label="参数名" prop="name" width="150px"></el-table-column>
                                <el-table-column label="参数值" prop="value" width="150px"></el-table-column>
                                <el-table-column label="更新时间" prop="updatedTime" width="200px"></el-table-column>
                                <el-table-column label="状态" prop="status" width="100px">
                                    <template slot-scope="scope">
                                        <p @click="handleCellClick(scope.row)">
                                            <el-tag
                                                v-if="scope.row.status"
                                                type="success"
                                                effect="dark"
                                                size="mini"
                                            >启用</el-tag>
                                            <el-tag
                                                v-else
                                                type="danger"
                                                effect="dark"
                                                size="mini"
                                            >禁用</el-tag>
                                        </p>
                                    </template>
                                </el-table-column>
                                <el-table-column label="操作" width="200px">
                                    <template slot-scope="scope">
                                        <el-tooltip
                                            class="item"
                                            effect="dark"
                                            content="修改"
                                            placement="top-start"
                                        >
                                            <el-button
                                                type="primary"
                                                icon="el-icon-edit"
                                                circle
                                                @click="editInfo(scope.row)"
                                                size="mini"
                                                v-if="isModifyShow"
                                            ></el-button>
                                        </el-tooltip>
                                        <el-tooltip
                                            class="item"
                                            effect="dark"
                                            content="删除"
                                            placement="top-start"
                                        >
                                            <el-button
                                                type="danger"
                                                icon="el-icon-delete"
                                                circle
                                                @click="deleteInfo(scope.row)"
                                                size="mini"
                                                v-if="isDeleteShow"
                                            ></el-button>
                                        </el-tooltip>
                                        <el-tooltip
                                            class="item"
                                            effect="dark"
                                            content="查看"
                                            placement="top-start"
                                        >
                                            <el-button
                                                type="success"
                                                icon="el-icon-view"
                                                circle
                                                @click="viewInfo(scope.row)"
                                                size="mini"
                                            ></el-button>
                                        </el-tooltip>
                                    </template>
                                </el-table-column>
                            </el-table>
                            <pagination
                                v-show="totalNum>0"
                                :total="totalNum"
                                :page.sync="listQuery.pageNum"
                                :limit.sync="listQuery.pageSize"
                                @pagination="getSystemParamWithPage"
                            ></pagination>
                        </div>
                    </el-card>

                    <div>
                        <!-- 模态框 -->
                        <el-dialog
                            :title="dialogTile"
                            :visible.sync="dialogVisible"
                            width="30%"
                            :center="true"
                            @close="closeDialog"
                        >
                            <el-form
                                :model="systemParamForm"
                                :rules="rules"
                                ref="systemParamForm"
                                label-width="100px"
                                style="width:100%;"
                            >
                                <el-form-item label="参数" prop="name">
                                    <el-input v-model="systemParamForm.name" />
                                </el-form-item>
                                <el-form-item label="参数值" prop="value">
                                    <el-input v-model="systemParamForm.value" />
                                </el-form-item>
                                <el-form-item label="参数类别" prop="paramType">
                                    <template>
                                        <el-select
                                            v-model="systemParamForm.paramType"
                                            placeholder="请选择"
                                        >
                                            <el-option
                                                v-for="item in paramTypeOptions"
                                                :key="item.name"
                                                :value="item.name"
                                            ></el-option>
                                        </el-select>
                                    </template>
                                </el-form-item>
                                <el-form-item label="状态" prop="status">
                                    <el-radio-group v-model="systemParamForm.status">
                                        <el-radio :label="true">启用</el-radio>
                                        <el-radio :label="false">禁用</el-radio>
                                    </el-radio-group>
                                </el-form-item>
                                <el-form-item>
                                    <el-button
                                        type="primary"
                                        @click="submitForm('systemParamForm')"
                                    >确定</el-button>
                                    <el-button
                                        @click="closeDialog()"
                                        type="danger"
                                        style="margin-left:50px"
                                    >取消</el-button>
                                </el-form-item>
                            </el-form>
                        </el-dialog>
                    </div>
                </div>
            </el-main>
        </el-container>
    </div>
</template>

<script>
import { showMessage, cloneObject } from '../../utils/method'
import Pagination from '../../components/SystemManage/Pagination'
import * as commenCRUD from '../../api/commonCRUD'

import UploadExcelComponent from '@/components/UploadExcel/index.vue'
export default {
    //import引入的组件需要注入到对象中才能使用
    components: { Pagination, UploadExcelComponent },
    inject: ['reload'],
    data() {
        //这里存放数据
        return {
            requestURL: 'systemParam',
            baseURL: '/education/bes/v1/system-manager-center/systemParam/',
            systemParamTableData: [{ id: '' }],
            totalNum: 100,
            checkBoxData: [],
            dialogTile: '',
            dialogVisible: false,
            listQuery: {
                pageNum: 1,
                pageSize: 5,
                name: '',
                paramType: null
            },
            /**存放参数信息 */
            systemParamForm: {
                id: null,
                paramType: null,
                name: null,
                value: null,
                version: null,
                status: true,
                createdTime: null,
                createdBy: null,
                updatedTime: null,
                updatedBy: null
            },
            rules: {
                name: [{ required: true, trigger: 'blur' }, { validator: this.validateName, trigger: 'blur' }],
                value: [{ required: true, trigger: 'blur' }],
            },
            defaultSystemParamForm: null,
            treeData: [],
            defaultProps: {
                label: 'name',
                children: 'children'
            },
            backRule: null,
            filterVal: ['name', 'value', 'paramType', 'status'] //表头字段名
            , paramTypeOptions: [],
            allValues: []//保存所有导出值
            ,
            isInsertShow: true,
            isModifyShow: true,
            isDeleteShow: true,
            isMultiDeleteShow: true,
            isImportShow: true,
            isExportAllShow: true
        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        /** 查看name是否使用过 */
        validateName(rule, value, callback) {
            if (value == '' || value == undefined || value == null) {
                callback();
            } else {
                if (this.backRule && this.backRule.name && this.backRule.name === value) {
                    callback();
                } else {
                    commenCRUD.validateName(this.requestURL, value).then(resp => {
                        if (!resp.data.body) {
                            callback('该name已经使用,请重新输入');
                        }
                        callback();
                    })
                }
            }
        },
        /**插入参数 */
        insert() {
            this.dialogTile = "新增参数"
            this.dialogVisible = true
            //拿到参数类型
            this.getParamType()
        },
        /**顶部的修改按钮 */
        editTop() {
            if (this.checkBoxData.length === 1) {
                this.editInfo(this.checkBoxData[0])
            } else {
                showMessage(this, '请选中一行要修改的值！！！', 'error')
            }
        },
        /**批量删除 */
        multiDelete() {
            if (this.checkBoxData.length > 0) {
                if (confirm('确认删除') === true) {
                    commenCRUD.multiDelete(this.requestURL, this.checkBoxData).then(resp => {
                        if (resp.data.head.code === '200') {
                            showMessage(this, '批量删除成功!', 'success')
                            this.reload()
                        } else {
                            showMessage(this, resp.data.body, 'error')
                        }
                    })
                }
            } else {
                showMessage(this, '请选择要删除的参数', 'error')
            }
        },
        /**处理多选框 */
        clickCheckBox(val) {
            this.checkBoxData = val
        },
        /**处理双击事件 */
        handleRowDblclick(row, event) {
            this.editInfo(row)
        },
        /**编辑信息 */
        editInfo(row) {
            commenCRUD.queryInfo(this.requestURL, {
                id: row.id,
                version: row.version
            }).then(resp => {
                if (resp.data.head.code === "200") {
                    this.systemParamForm = resp.data.body
                    this.backRule = cloneObject(resp.data.body)
                    this.getParamType()
                    this.dialogTile = "更新信息"
                    this.dialogVisible = true
                } else {
                    showMessage(this, '数据有更新请刷新！', 'error')
                }
            })
        },
        /**删除信息 */
        deleteInfo(row) {
            if (confirm('确认删除') === true) {
                commenCRUD.deleteInfo(this.requestURL, {
                    id: row.id,
                    version: row.version
                }).then(resp => {
                    if (resp.data.head.code === '200') {
                        showMessage(this, row.name + '----->删除成功!', 'success')
                        this.reload()
                    } else {
                        showMessage(this, row.name + '----->' + resp.data.body, 'error')
                    }
                })
            }
        },
        /**查询信息 */
        viewInfo(row) {
            this.$alert(row, '信息')
        },
        /**分页查询  先普通分页展示数据*/
        getSystemParamWithPage() {
            commenCRUD.queryWithPage(this.requestURL, this.listQuery).then(resp => {
                this.systemParamTableData = resp.data.body.list
                this.totalNum = resp.data.body.total
            })
        },
        /**关闭模态框 */
        closeDialog() {
            this.dialogVisible = false
            //重置
            this.$refs.systemParamForm.clearValidate();
            this.systemParamForm = cloneObject(this.defaultSystemParamForm)
        },
        /**提交信息 */
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    if (this.systemParamForm.id !== null && this.systemParamForm.id !== '' && this.systemParamForm.id > 0) {
                        this.systemParamForm.updatedBy = getUserId()
                        this.updateInfo()
                    } else {
                        this.systemParamForm.createdBy = getUserId()
                        commenCRUD.insert(this.requestURL, this.systemParamForm).then(resp => {
                            if (resp.data.head.code === "200") {
                                showMessage(this, this.systemParamForm.name + '---->新增成功!', 'success')
                                this.reload()
                            } else {
                                showMessage(this, this.systemParamForm.name + '---->新增失败,请重试!', 'error')
                            }
                        })
                    }
                }
            })
        },
        /**更新信息 */
        updateInfo() {
            commenCRUD.updateInfo(this.requestURL, this.systemParamForm).then(resp => {
                if (resp.data.head.code === "200") {
                    showMessage(this, this.systemParamForm.name + '---->更新成功!', 'success')
                } else {
                    showMessage(this, this.systemParamForm.name + '---->更新失败,请重试!', 'error')
                }
                this.reload()
            })
        },
        /**单元格被单击 */
        handleCellClick(row) {
            this.systemParamForm = row
            this.systemParamForm.status = !this.systemParamForm.status
            this.updateInfo()
        },
        /**树节点点击事件 */
        handleNodeClick(data) {
            if (data.children) {
                this.listQuery.paramType = data.name
                this.getSystemParamWithPage()
            }
        },
        /**查询树节点 */
        queryTree() {
            commenCRUD.queryTree(this.requestURL).then(resp => {
                this.treeData = resp.data.body
            })
        },
        /**按照名字查询 */
        searchSystemParam() {
            this.listQuery.paramType = null
            this.getSystemParamWithPage()
        },
        /**处理导入 */
        /*
         *@description:为了判断大小
         *@author: 张彦征
         *@date: 2020-07-13 16:16:55
        */
        beforeUpload(file) {
            const isLt1M = file.size / 1024 / 1024 < 1
            if (isLt1M) {
                return true
            }
            showMessage(this, '文件最大为1MB', 'warning')
            return false
        },
        handleSuccess({ results, header }) {
            //添加id
            results = results.map(function (item, index, arr) {
                return { id: null, ...item }
            })
            axios.post(this.baseURL + 'multiInsert', results).then(resp => {
                if (resp.data.head.code === "200") {
                    showMessage(this, '导入数据成功！！', 'success')
                    this.reload()
                } else {
                    showMessage(this, '导入失败请检查数据格式是否正确', 'error')
                }
            })
        },
        /**处理导出 */
        handleExport() {
            if (this.checkBoxData.length === 0) {
                showMessage(this, '请选择要导出的数据！！！', 'error')
            } else {
                import('../../vendor/Export2Excel').then(excel => {
                    const list = this.checkBoxData;
                    const data = this.formatJson(this.filterVal, list);
                    excel.export_json_to_excel({
                        header: this.filterVal,
                        data: data,
                        filename: '参数信息表'
                    });
                })
            }
        },
        /**导出全部 */
        handleExportAll() {
            axios.get(this.baseURL + 'getAllSystemParam').then(resp => {
                this.allValues = resp.data.body
                import('../../vendor/Export2Excel').then(excel => {
                    const data = this.formatJson(this.filterVal, this.allValues);
                    excel.export_json_to_excel({
                        header: this.filterVal,
                        data: data,
                        filename: '参数信息表'
                    });
                })
            })
        },
        /**导出模板 */
        handleExportFormat() {
            import('../../vendor/Export2Excel').then(excel => {
                const list = [{ name: '参数名', value: '参数值', paramType: '参数类型', status: 'TRUE/FALSE' }];
                const data = this.formatJson(this.filterVal, list);
                excel.export_json_to_excel({
                    header: this.filterVal,
                    data: data,
                    filename: '参数信息模板'
                });
            })
        },
        formatJson(filterVal, jsonData) {
            return jsonData.map(v => filterVal.map(j => v[j]))
        },
        /**拿到所有的系统参数类型 */
        getParamType() {
            axios.get(this.baseURL.replace('systemParam', 'dictionary') + 'getParamType').then(resp => {
                this.paramTypeOptions = resp.data.body

            })
        },
        /**查询资源 */
        async queryParam() {
            const {resources} = await this.$store.dispatch('user/getInfo')
            if (resources.indexOf('100116') === -1) {
                this.isModifyShow = false
            }
            if (resources.indexOf('100115') === -1) {
                this.isInsertShow = false
            }
            if (resources.indexOf('100113') === -1) {
                this.isDeleteShow = false
            }
            if (resources.indexOf('100111') === -1) {
                this.isMultiDeleteShow = false
            }
            if (resources.indexOf('100119') === -1) {
                this.isImportShow = false
            }
            if (resources.indexOf('100118') === -1) {
                this.isExportAllShow = false
            }
        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        //查询树
        this.queryTree()
        //查询分页数据
        this.getSystemParamWithPage()

        //拷贝
        this.defaultSystemParamForm = cloneObject(this.systemParamForm)

        this.queryParam()
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
.el-header {
    background-color: #b3c0d1;
    color: #333;
    line-height: 60px;
}

.el-aside {
    color: #333;
    height: 100vh;
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
.clearfix:before,
.clearfix:after {
    display: table;
    content: "";
}
.clearfix:after {
    clear: both;
}
.box-card {
    width: 100%;
}
//去掉边框
.el-button {
    border: none;
}
</style>
