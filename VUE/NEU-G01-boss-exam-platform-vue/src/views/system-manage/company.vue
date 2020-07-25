<!--
 * @description:
 * @fileName: Company.vue
 * @author: 张彦征
 * @date: 2020-07-16 16:59:46
!-->
<!--  -->
<template>
    <div>
        <el-container>
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <em class="el-icon-menu" />
                        <span>公司列表</span>
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
                    <div>
                        <el-input
                            size="mini"
                            placeholder="请输入公司名称"
                            style="width: 150px"
                            v-model="listQuery.name"
                        ></el-input>
                        <el-button
                            size="mini"
                            @click="searchCompany()"
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
                                    :data="companyTableData"
                                    ref="companyTableData"
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
                                    <el-table-column label="公司编号" prop="code" width="80px"></el-table-column>
                                    <el-table-column label="公司名称" prop="name" width="100px"></el-table-column>
                                    <el-table-column
                                        label="公司助记码"
                                        prop="mnemonicCode"
                                        width="100px"
                                    ></el-table-column>
                                    <el-table-column label="公司法人" prop="master" width="80px"></el-table-column>
                                    <el-table-column
                                        label="所属机构"
                                        prop="organizationName"
                                        width="100px"
                                    ></el-table-column>
                                    <el-table-column label="公司电话" prop="telephone" width="80px"></el-table-column>
                                    <el-table-column label="公司地址" prop="address" width="100px"></el-table-column>
                                    <el-table-column label="公司邮箱" prop="email" width="80px"></el-table-column>
                                    <el-table-column label="公司税号" prop="tax" width="80px"></el-table-column>
                                    <el-table-column label="公司传真" prop="fax" width="80px"></el-table-column>
                                    <el-table-column label="公司网址" prop="website" width="100px"></el-table-column>
                                    <el-table-column label="公司状态" prop="status" width="80px">
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
                                    <el-table-column label="操作" width="130px">
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
                                                    v-if="isModifyShow"
                                                    size="mini"
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
                                                    v-if="isDeleteShow"
                                                    size="mini"
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
                                    @pagination="getCompanyWithPage"
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
                                :model="companyForm"
                                :rules="rules"
                                ref="companyForm"
                                label-width="100px"
                                style="width:100%;"
                            >
                                <el-form-item label="公司编号" prop="code">
                                    <el-input v-model="companyForm.code" />
                                </el-form-item>
                                <el-form-item label="公司名称" prop="name">
                                    <el-input v-model="companyForm.name" />
                                </el-form-item>
                                <el-form-item label="公司助记码" prop="mnemonicCode">
                                    <el-input v-model="companyForm.mnemonicCode"></el-input>
                                </el-form-item>
                                <el-form-item label="公司法人" prop="master">
                                    <el-input v-model="companyForm.master" />
                                </el-form-item>
                                <el-form-item label="所属机构" prop="organizationId">
                                    <template>
                                        <el-select
                                            @change="handleSelectChange"
                                            v-model="companyForm.organizationId"
                                            placeholder="请选择"
                                        >
                                            <el-option
                                                v-for="item in orgOptions"
                                                :key="item.id"
                                                :label="item.name"
                                                :value="item.id"
                                            ></el-option>
                                        </el-select>
                                    </template>
                                </el-form-item>

                                <el-form-item label="公司电话" prop="telephone">
                                    <el-input v-model="companyForm.telephone" />
                                </el-form-item>
                                <el-form-item label="公司地址" prop="address">
                                    <el-input v-model="companyForm.address" />
                                </el-form-item>
                                <el-form-item label="公司邮箱" prop="email">
                                    <el-input v-model="companyForm.email" />
                                </el-form-item>
                                <el-form-item label="公司税号" prop="tax">
                                    <el-input v-model="companyForm.tax" />
                                </el-form-item>
                                <el-form-item label="公司传真" prop="fax">
                                    <el-input v-model="companyForm.fax" />
                                </el-form-item>
                                <el-form-item label="公司网址" prop="website">
                                    <el-input v-model="companyForm.website" />
                                </el-form-item>
                                <el-form-item label="状态" prop="status">
                                    <el-radio-group v-model="companyForm.status">
                                        <el-radio :label="true">启用</el-radio>
                                        <el-radio :label="false">禁用</el-radio>
                                    </el-radio-group>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="submitForm('companyForm')">确定</el-button>
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
import * as validate from '../../utils/myRoleValidate'

import { getUserId, getCompanyId, getOrganizationId } from "@/utils/userInfo";
export default {
    //import引入的组件需要注入到对象中才能使用
    inject: ['reload'],
    components: {
        Pagination
    },
    data() {
        //这里存放数据
        return {
            requestURL: 'company',
            baseURL: '/education/bes/v1/system-manager-center/company/',
            companyLikeName: '',
            companyTableData: [
                { id: '' }
            ],
            totalNum: 100,
            checkBoxData: [],
            dialogTile: '',
            dialogVisible: false,
            /**分页查询信息 */
            listQuery: {
                pageNum: 1,
                pageSize: 5,
                name: '',
                organizationId: getOrganizationId()
            },
            /**存放公司信息 */
            companyForm: {
                id: null,
                code: null,
                name: null,
                mnemonicCode: null,
                master: null,
                tax: null,
                fax: null,
                telephone: null,
                address: null,
                email: null,
                website: null,
                organizationId: undefined,
                organizationName: null,
                version: null,
                status: true,
                createdTime: null,
                createdBy: null,
                updatedTime: null,
                updatedBy: null
            },
            rules: {
                code: [{ required: true, trigger: 'blur' }, { validator: this.validateCode, trigger: 'blur' }],
                name: [{ required: true, trigger: 'blur' }, { validator: this.validateName, trigger: 'blur' }],
                organizationId: [{ required: true, trigger: 'change' }],
                telephone: [{ validator: validate.validatePhoneTwo, trigger: 'blur' }],
                email: [{ validator: validate.validateEMail, trigger: 'blur' }],

            },
            orgOptions: null,
            defaultCompanyForm: null,
            treeData: [],
            defaultProps: {
                label: 'name',
                children: 'children'
            },
            backRule: null,
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
                if (this.backRule && this.backRule.code && this.backRule.code === value) {
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
        /**树节点点击 */
        handleNodeClick(data) {
            //组织的话查询全部公司
            if (data.organizationId == null) {
                this.listQuery.organizationId = data.id
                this.getCompanyWithPage()
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
        /**单元格被单击 */
        handleCellClick(row) {
            this.companyForm = row
            //状态位取反
            this.companyForm.status = !this.companyForm.status
            this.updateInfo()
        },
        /**分页查询 */
        getCompanyWithPage() {
            commenCRUD.queryWithPage(this.requestURL, this.listQuery).then(resp => {
                this.companyTableData = resp.data.body.list
                this.totalNum = resp.data.body.total
            })
        },
        /**搜索按钮 */
        searchCompany() {
            this.listQuery.organizationId = getOrganizationId()
            this.getCompanyWithPage()
        },
        /**编辑信息 */
        editInfo(row) {
            commenCRUD.queryInfo(this.requestURL, {
                id: row.id,
                version: row.version
            }).then(resp => {
                if (resp.data.head.code === "200") {
                    this.companyForm = resp.data.body
                    this.backRule = cloneObject(resp.data.body)
                    //查询所有机构供选
                    this.queryAllOrg()
                    this.dialogTile = "更新信息"
                    this.dialogVisible = true
                } else {
                    showMessage(this, '数据有更新请刷新！', 'error')
                }

            })
        },
        /**顶部的编辑 */
        editTop() {
            if (this.checkBoxData.length === 1) {
                this.editInfo(this.checkBoxData[0])
            } else {
                showMessage(this, '请选中一行要修改的值！！！', 'error')
            }
        },
        /**添加 */
        insert() {
            this.dialogTile = "新增公司"
            this.dialogVisible = true
            //查询所有机构供选
            this.queryAllOrg()
        },
        /**删除一行信息 */
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
        /**查看一行信息 */
        viewInfo(row) {
            this.$alert(row, '信息')
        },
        /**关闭模态框 */
        closeDialog() {
            this.dialogVisible = false
            //重置
            this.$refs.companyForm.clearValidate();
            this.companyForm = cloneObject(this.defaultCompanyForm)
        },
        /**提交信息 */
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    if (this.companyForm.id !== null && this.companyForm.id !== '') {
                        this.companyForm.updatedBy = getUserId()
                        this.updateInfo()
                    } else {
                        this.companyForm.createdBy = getUserId()
                        commenCRUD.insert(this.requestURL, this.companyForm).then(resp => {
                            if (resp.data.head.code === "200") {
                                showMessage(this, this.companyForm.name + '---->新增成功!', 'success')
                                this.reload()
                            } else {
                                showMessage(this, this.companyForm.name + '---->新增失败,请重试!', 'error')
                            }
                        })
                    }
                }
            })
        },
        /**更新操作 */
        updateInfo() {
            commenCRUD.updateInfo(this.requestURL, this.companyForm).then(resp => {
                if (resp.data.head.code === "200") {
                    showMessage(this, this.companyForm.name + '---->更新成功!', 'success')
                } else {
                    showMessage(this, this.companyForm.name + '---->更新失败,请重试!', 'error')
                }
                this.reload()
            })
        },
        /**重置 */
        resetForm(formName) {
            this.$refs[formName].resetFields()
        },
        /**查询全部的组织机构*/
        queryAllOrg() {
            commenCRUD.postQueryAll('org', this.listQuery.organizationId).then(resp => {
                this.orgOptions = resp.data.body
            })
        },
        /**处理选择框内容改变
         * 传入的是机构id
         */
        handleSelectChange(option) {
            this.companyForm.organizationId = option
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
                showMessage(this, '请选择要删除的公司', 'error')
            }
        },
        /**查询树节点 */
        queryTree() {
            commenCRUD.postQueryTree(this.requestURL, { organizationId: this.listQuery.organizationId, companyId: null }).then(resp => {
                this.treeData = resp.data.body
            })
        },
        /**查询资源 */
        async queryParam() {
            const {resources} = await this.$store.dispatch('user/getInfo')
            if (resources.indexOf('100053') === -1) {
                this.isModifyShow = false
            }
            if (resources.indexOf('100055') === -1) {
                this.isInsertShow = false
            }
            if (resources.indexOf('100056') === -1) {
                this.isDeleteShow = false
            }
            if (resources.indexOf('100057') === -1) {
                this.isMultiDeleteShow = false
            }
        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {

        //查询树
        this.queryTree()
        //查询公司
        this.getCompanyWithPage()
        //深拷贝一份原始数据
        this.defaultCompanyForm = cloneObject(this.companyForm)
        // 资源判断
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
