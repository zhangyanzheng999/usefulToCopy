<!--
 * @description:
 * @fileName: Organization.vue
 * @author: 张彦征
 * @date: 2020-07-16 17:00:14
!-->
<template>
    <div>
        <el-container>
            <el-main>
                <div>
                    <el-input
                        size="mini"
                        placeholder="请输入组织名称"
                        style="width: 150px"
                        v-model="listQuery.name"
                    ></el-input>
                    <el-button
                        size="mini"
                        @click="getOrgsWithPage()"
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
                        </div>
                        <div style="margin-top:20px">
                            <el-table
                                :data="orgTableData"
                                style="width: 100%;font-size:12px"
                                ref="orgTableData"
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
                                <el-table-column prop="code" label="机构编号" width="100px"></el-table-column>
                                <el-table-column prop="name" label="机构名称" width="200px"></el-table-column>
                                <el-table-column prop="master" label="机构负责人" width="100px"></el-table-column>
                                <el-table-column prop="tel" label="机构电话" width="200px"></el-table-column>
                                <el-table-column prop="address" label="机构地址" width="230px"></el-table-column>
                                <el-table-column prop="status" label="机构状态" width="100px">
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
                                <el-table-column fixed="right" label="操作" width="200px">
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
                            <!-- 分页 -->
                            <pagination
                                v-show="totalNum>0"
                                :total="totalNum"
                                :page.sync="listQuery.pageNum"
                                :limit.sync="listQuery.pageSize"
                                @pagination="getOrgsWithPage"
                            ></pagination>
                        </div>
                    </el-card>
                </div>
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
                            :model="orgForm"
                            :rules="rules"
                            ref="orgForm"
                            label-width="100px"
                            style="width:100%;"
                        >
                            <el-form-item label="机构编号" prop="code">
                                <el-input v-model="orgForm.code" />
                            </el-form-item>
                            <el-form-item label="机构名称" prop="name">
                                <el-input v-model="orgForm.name" />
                            </el-form-item>
                            <el-form-item label="机构负责人" prop="master">
                                <el-input v-model="orgForm.master" />
                            </el-form-item>
                            <el-form-item label="机构电话" prop="tel">
                                <el-input v-model="orgForm.tel" />
                            </el-form-item>
                            <el-form-item label="机构地址" prop="address">
                                <el-input v-model="orgForm.address" />
                            </el-form-item>
                            <el-form-item label="状态" prop="status">
                                <el-radio-group v-model="orgForm.status">
                                    <el-radio :label="true">启用</el-radio>
                                    <el-radio :label="false">禁用</el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('orgForm')">确定</el-button>
                                <el-button
                                    @click="closeDialog()"
                                    type="danger"
                                    style="margin-left:50px"
                                >取消</el-button>
                            </el-form-item>
                        </el-form>
                    </el-dialog>
                </div>
            </el-main>
        </el-container>
    </div>
</template>

<script>
import { showMessage, cloneObject } from '../../utils/method'
import Pagination from '../../components/SystemManage/Pagination'
import * as commenCRUD from '../../api/commonCRUD'
import * as validate from '../../utils/myRoleValidate'
import { getUserId, getCompanyId, getOrganizationId } from "@/utils/userInfo";
export default {
    //import引入的组件需要注入到对象中才能使用
    components: { Pagination },
    inject: ['reload'],
    data() {
        //这里存放数据
        return {
            //基础url
            requestURL: 'org',
            baseURL: '/education/bes/v1/system-manager-center/org/',
            orgTableData: [{ id: '' }],
            checkBoxData: [],
            listQuery: {
                pageSize: 5,
                pageNum: 1,
                name: ''
            },
            totalNum: 100,
            dialogVisible: false,
            dialogTile: null,
            orgForm: {
                id: null,
                name: null,
                code: null,
                master: null,
                status: true,
                tel: null,
                address: null,
                version: null,
                createdBy: null,
                createdTime: null,
                updatedBy: null,
                updatedTime: null
            },
            rules: {
                code: [{ required: true, trigger: 'blur' }, { validator: this.validateCode, trigger: 'blur' }],
                name: [{ required: true, trigger: 'blur' }, { validator: this.validateName, trigger: 'blur' }],
                tel: [{ validator: validate.validatePhoneTwo, trigger: 'blur' }],

            },
            defaultOrgForm: null,
            backRule: [],
            isInsertShow: true,
            isModifyShow: true,
            isDeleteShow: true,
            isMultiDeleteShow: true
        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        /** 查看code是否使用过 */
        validateCode(rule, value, callback) {
            if (value == '' || value == undefined || value == null) {
                callback();
            } else {
                if (this.backRule&&this.backRule.code && this.backRule.code === value) {
                    callback();
                } else {
                    commenCRUD.validateCode(this.requestURL, value).then(resp => {
                        if (!resp.data.body) {
                            callback('该code已经使用,请重新输入');
                        }
                        callback();
                    })
                }

            }
        },
        /** 查看name是否使用过 */
        validateName(rule, value, callback) {
            if (value == '' || value == undefined || value == null) {
                callback();
            } else {
                if (this.backRule&&this.backRule.name && this.backRule.name === value) {
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
        /**
         * 用来判断多选框
         */
        clickCheckBox(val) {
            this.checkBoxData = val
        },
        /** 顶部的修改方法*/
        editTop() {
            if (this.checkBoxData.length === 1) {
                this.editInfo(this.checkBoxData[0])
            } else {
                showMessage(this, '请选中一行要修改的值！！！', 'error')
            }
        },
        /**处理双击事件 */
        handleRowDblclick(row, event) {
            this.editInfo(row)
        },
        /**
         * 关闭模态框
         */
        closeDialog() {
            this.dialogVisible = false
            //重置
            this.$refs.orgForm.clearValidate();
            this.orgForm = cloneObject(this.defaultOrgForm)
        },
        /**
         * 用来修改记录
         */
        editInfo(row) {
            //先查询
            commenCRUD.queryInfo(this.requestURL, {
                id: row.id,
                version: row.version
            }).then(resp => {
                //如果只有不是异常才做展示
                if (resp.data.head.code === "200") {
                    this.orgForm = resp.data.body
                    this.backRule = cloneObject(resp.data.body)
                    this.dialogTile = "更新信息"
                    this.dialogVisible = true
                } else {
                    showMessage(this, "数据有更改请刷新", 'error')
                }
            })
        },

        /**用来新增 */
        insert() {
            this.dialogTile = "新增组织机构"
            this.dialogVisible = true
        },
        /**用来批量删除 */
        multiDelete() {
            if (this.checkBoxData.length > 0) {
                if (confirm('确认删除') === true) {
                    commenCRUD.multiDelete(this.requestURL, this.checkBoxData).then(resp => {
                        if (resp.data.head.code === '200') {
                            showMessage(this, '批量删除成功!', 'success')
                            this.reload()
                        } else {
                            showMessage(this, '批量删除失败，请重试!', 'error')
                        }
                    })
                }
            } else {
                showMessage(this, '请选择要删除的机构', 'error')
            }
        },
        /**用来删除 */
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
                        showMessage(this, row.name + '----->'+resp.data.body, 'error')
                    }
                })
            }
        },
        /**查看一行信息 */
        viewInfo(row) {
            this.$alert(row, '信息')
        },
        /**分页查询函数也用来模糊搜索 */
        getOrgsWithPage() {
            commenCRUD.queryWithPage(this.requestURL, this.listQuery).then(resp => {
                this.orgTableData = resp.data.body.list
                this.totalNum = resp.data.body.total
            })
        },
        //重置
        resetForm(formName) {
            this.$refs[formName].resetFields()
        },
        /**提交修改或者新增 */
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    //这里修改
                    if (this.orgForm.id !== null && this.orgForm.id !== '') {
                        this.orgForm.updatedBy = getUserId()
                        this.updateInfo()
                    } else {
                        //这里新增
                        this.orgForm.createdBy = getUserId()
                        commenCRUD.insert(this.requestURL, this.orgForm).then(resp => {
                            if (resp.data.head.code === '200') {
                                this.dialogVisible = false
                                showMessage(this, this.orgForm.name + '----->添加成功!', 'success')
                                this.reload()
                            } else {
                                showMessage(this, this.orgForm.name + '----->添加失败,请重试!', 'error')
                            }
                        })
                    }
                } else {
                    return false
                }
            })
        },
        /**处理状态栏的单击事件 */
        handleCellClick(row) {
            this.orgForm = row
            this.orgForm.status = !this.orgForm.status
            this.updateInfo()
        },
        /**将更新抽取出来 */
        updateInfo() {
            commenCRUD.updateInfo(this.requestURL, this.orgForm).then(resp => {
                if (resp.data.head.code === '200') {
                    this.dialogVisible = false
                    showMessage(this, this.orgForm.name + '----->更新成功!', 'success')
                    //取消全选
                    // this.$refs.orgTableData.clearSelection()
                } else {
                    showMessage(this, this.orgForm.name + '----->更新失败,请重试!', 'error')
                }
                this.reload()
            })
        },
        /**查询资源 */
        async queryParam() {
            const {resources} = await this.$store.dispatch('user/getInfo')
            if (resources.indexOf('100047') === -1) {
                this.isModifyShow = false
            }
            if (resources.indexOf('100044') === -1) {
                this.isInsertShow = false
            }
            if (resources.indexOf('100045') === -1) {
                this.isDeleteShow = false
            }
            if (resources.indexOf('100046') === -1) {
                this.isMultiDeleteShow = false
            }
        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        //调用方法
        this.getOrgsWithPage()

        //拷贝
        this.defaultOrgForm = cloneObject(this.orgForm)

        this.queryParam()
    },
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() {

    },
    beforeCreate() {

    }, //生命周期 - 创建之前
    beforeMount() { }, //生命周期 - 挂载之前
    beforeUpdate() { }, //生命周期 - 更新之前
    updated() { }, //生命周期 - 更新之后
    beforeDestroy() { }, //生命周期 - 销毁之前
    destroyed() { }, //生命周期 - 销毁完成
    activated() { }, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style lang='scss' scoped>
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
//去掉边框
.el-button {
    border: none;
}
</style>
