<!--
 * @description:
 * @fileName: Role.vue
 * @author: 张彦征
 * @date: 2020-07-16 17:00:38
!-->
<!--  -->
<template>
    <div>
        <el-container>
            <el-aside width="180px" style="background-color: rgb(238, 241, 246)">
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <em class="el-icon-menu" />
                        <span>角色列表</span>
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
                        placeholder="请输入资源名称"
                        style="width: 150px"
                        v-model="listQuery.name"
                    ></el-input>
                    <el-button
                        size="mini"
                        @click="searchRole()"
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
                            <el-button
                                icon="el-icon-user-solid"
                                @click="distributeUserTop()"
                                style="margin-left:0px;color:#D94600"
                                size="mini"
                                v-if="isDistributeUserShow"
                            >分配用户</el-button>
                            <el-button
                                icon="fa fa-share-alt-square"
                                @click="distributeResourceTop()"
                                style="margin-left:0px;color:#FF8000"
                                size="mini"
                                v-if="listQuery.organizationId===null||isDistributeResourceShow"
                            >分配资源</el-button>
                        </div>
                        <div style="margin-top:20px">
                            <el-table
                                :data="roleTableData"
                                :ref="roleTableData"
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
                                <el-table-column label="编号" prop="code" width="100px"></el-table-column>
                                <el-table-column label="角色名称" prop="name" width="200px"></el-table-column>
                                <el-table-column label="所属公司" width="100px">
                                    <template slot-scope="scope">
                                        <label
                                            v-for="(item,index) in scope.row.companyList"
                                            :key="index"
                                        >
                                            <p v-if="item!==null">{{item.name}}</p>
                                        </label>
                                    </template>
                                </el-table-column>
                                <el-table-column label="所属组织" prop="organizationName" width="150px"></el-table-column>
                                <el-table-column label="备注" prop="remark" width="100px"></el-table-column>
                                <el-table-column label="状态位" prop="status" width="100px">
                                    <template slot-scope="scope">
                                        <p @click="handleStatusCellClick(scope.row)">
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
                                            content="分配用户"
                                            placement="top-start"
                                        >
                                            <el-button
                                                type="info"
                                                icon="el-icon-user-solid"
                                                circle
                                                @click="distributeUser(scope.row)"
                                                size="mini"
                                                v-if="isDistributeUserShow"
                                            ></el-button>
                                        </el-tooltip>
                                        <el-tooltip
                                            class="item"
                                            effect="dark"
                                            content="分配资源"
                                            placement="top-start"
                                        >
                                            <el-button
                                                type="warning"
                                                icon="fa fa-share-alt-square"
                                                circle
                                                @click="distributeResource(scope.row)"
                                                size="mini"
                                                v-if="listQuery.organizationId===null||isDistributeResourceShow"
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
                                @pagination="getRoleWithPage"
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
                            :model="roleForm"
                            :rules="rules"
                            ref="roleForm"
                            label-width="100px"
                            style="width:100%;"
                        >
                            <el-form-item label="角色编号" prop="code">
                                <el-input v-model="roleForm.code" />
                            </el-form-item>
                            <el-form-item label="角色名称" prop="name">
                                <el-input v-model="roleForm.name" />
                            </el-form-item>
                            <el-form-item label="所属组织">
                                <template>
                                    <el-select
                                        value-key="id"
                                        v-model="roleForm.organizationId"
                                        placeholder="请选择"
                                        @change="handleOrgChange"
                                    >
                                        <el-option
                                            v-for="item in organizationOptions"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item.id"
                                        ></el-option>
                                    </el-select>
                                </template>
                            </el-form-item>
                            <el-form-item label="所属公司" prop="companyList">
                                <template>
                                    <el-select
                                        multiple
                                        value-key="id"
                                        v-model="roleForm.companyList"
                                        placeholder="请选择"
                                    >
                                        <el-option
                                            v-for="item in companyOptions"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item"
                                        ></el-option>
                                    </el-select>
                                </template>
                            </el-form-item>
                            <el-form-item label="备注" prop="remark">
                                <el-input v-model="roleForm.remark" />
                            </el-form-item>
                            <el-form-item label="状态" prop="status">
                                <el-radio-group v-model="roleForm.status">
                                    <el-radio :label="true">启用</el-radio>
                                    <el-radio :label="false">禁用</el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('roleForm')">确定</el-button>
                                <el-button
                                    @click="closeDialog()"
                                    type="danger"
                                    style="margin-left:50px"
                                >取消</el-button>
                            </el-form-item>
                        </el-form>
                    </el-dialog>

                    <el-dialog
                        title="用户分配"
                        :visible.sync="dialogUserVisible"
                        width="30%"
                        :center="true"
                        @close="closeUserDialog"
                    >
                        <el-form
                            :model="userRoleForm"
                            :rules="userRoleRules"
                            ref="userRoleForm"
                            label-width="100px"
                            style="width:100%;"
                        >
                            <el-form-item label="公司">
                                <template>
                                    <el-select
                                        @change="hanleCompanyChange"
                                        v-model="companyForRole"
                                        :disabled="listQuery.companyId!==null"
                                        placeholder="请选择所属公司"
                                    >
                                        <el-option
                                            v-for="item in companyOptions"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item.id"
                                        ></el-option>
                                    </el-select>
                                </template>
                            </el-form-item>

                            <el-form-item label="用户">
                                <div>
                                    <treeselect
                                        v-model="userRoleForm.users"
                                        valueFormat="object"
                                        :multiple="true"
                                        :options="userOptions"
                                        :searchable="false"
                                        :show-count="true"
                                        :disable-branch-nodes="true"
                                        placeholder="请选择用户"
                                        :normalizer="normalizer"
                                        noChildrenText="该部门无用户"
                                        noOptionsText="该公司下暂无部门"
                                    ></treeselect>
                                </div>
                            </el-form-item>
                            <el-form-item>
                                <el-button
                                    type="primary"
                                    @click="submitUserRoleForm('userRoleForm')"
                                >确定</el-button>
                                <el-button
                                    @click="closeUserDialog()"
                                    type="danger"
                                    style="margin-left:50px"
                                >取消</el-button>
                            </el-form-item>
                        </el-form>
                    </el-dialog>
                    <!-- 资源分配模态框 -->
                    <el-dialog
                        title="资源分配"
                        :visible.sync="dialogResourceVisible"
                        width="30%"
                        :center="true"
                        @close="closeResourceDialog"
                    >
                        <el-form
                            :model="resourceRoleForm"
                            :rules="resourceRules"
                            ref="resourceRoleForm"
                            label-width="100px"
                            style="width:100%;"
                        >
                            <el-form-item label="角色">
                                <el-input v-model="constRoleName" :disabled="true" />
                            </el-form-item>
                            <el-form-item label="资源">
                                <div>
                                    <treeselect
                                        v-model="resourceRoleForm.resources"
                                        valueFormat="object"
                                        :multiple="true"
                                        :options="resourceOptions"
                                        :searchable="false"
                                        :show-count="true"
                                        placeholder="请选择资源"
                                        :normalizer="resourceNormalizer"
                                        noChildrenText="该资源无子资源"
                                    ></treeselect>
                                </div>
                            </el-form-item>
                            <el-form-item>
                                <el-button
                                    type="primary"
                                    @click="submitResourceForm('resourceRoleForm')"
                                >确定</el-button>
                                <el-button
                                    @click="closeResourceDialog()"
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
import { getUserId, getCompanyId, getOrganizationId } from "@/utils/userInfo";
/**引入treeselect */
// import the component
import Treeselect from '@riophae/vue-treeselect'
// import the styles
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
export default {
    //import引入的组件需要注入到对象中才能使用
    components: { Pagination, Treeselect },
    inject: ['reload'],
    data() {
        //这里存放数据
        return {
            requestURL: 'role',
            baseURL: '/education/bes/v1/system-manager-center/role/',
            roleTableData: [{ id: '' }],
            totalNum: 100,
            checkBoxData: [],
            dialogTile: '',
            dialogVisible: false,
            /**分页查询信息 */
            defaultListQuery: null,
            listQuery: {
                pageNum: 1,
                pageSize: 5,
                name: '',
                companyId: getCompanyId(),
                organizationId: getOrganizationId()
            },
            treeData: [],
            defaultProps: {
                label: 'name',
                children: 'children'
            },
            /**角色信息 */
            roleForm: {
                id: null,
                code: null,
                name: null,
                remark: null,
                companyList: [],
                organizationId: null, //暂时固定
                organizationName: null,
                status: true,
                version: null,
                createdTime: null,
                createdBy: null,
                updatedTime: null,
                updatedBy: null
            },
            defaultRoleForm: null,
            rules: {
                code: [{ required: true, trigger: 'blur' }, { validator: this.validateCode, trigger: 'blur' }],
                name: [{ required: true, trigger: 'blur' }, { validator: this.validateName, trigger: 'blur' }]

            },
            companyOptions: []//公司选择框
            , organizationOptions: [] //组织选择框
            ,/**下面是分配用户要的 */
            dialogUserVisible: false,
            userRoleForm: {
                roleId: null,
                userId: null,
                users: []
            },
            defalutUserRoleForm: null,
            userRoleRules: null,
            userOptions: [],
            /**当前的公司 */
            companyForRole: null,
            /**通用角色Id */
            constRoleId: null,


            /**下面是资源的 */
            dialogResourceVisible: false,
            resourceRoleForm: {
                roleId: null,
                resourceId: null,
                resources: []
            },
            resourceRules: null,
            defalutResourceRoleForm: null,
            constRoleName: null,
            resourceOptions: [],
            /**是否是组织管理员 */
            orgAdmin: null,
            backRule: null,
            isInsertShow: true,
            isModifyShow: true,
            isDeleteShow: true,
            isMultiDeleteShow: true,
            isDistributeUserShow: true,
            isDistributeResourceShow: true
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
            //有孩子结点才展示
            this.listQuery.companyId = data.id
            this.getRoleWithPage()
        },
        /**顶部的分配用户 */
        distributeUserTop() {
            if (this.checkBoxData.length === 1) {
                this.distributeUser(this.checkBoxData[0])
            } else {
                showMessage(this, '请选中一行要分配用户的值！！！', 'error')
            }
        },
        /**顶部的分配资源 */
        distributeResourceTop() {
            if (this.checkBoxData.length === 1) {
                this.distributeResource(this.checkBoxData[0])
            } else {
                showMessage(this, '请选中一行要分配资源的值！！！', 'error')
            }
        },
        /**插入角色 */
        insert() {
            if (this.listQuery.companyId === null) {
                this.getOrgOptions(this.listQuery.organizationId)
            } else {
                this.getOrgName(this.roleForm.organizationId == null ? this.listQuery.organizationId : this.roleForm.organizationId)
            }
            this.generatorCode()
            this.buildSelectedCompany()
            this.dialogTile = "新增角色"
            this.dialogVisible = true

        },
        /**顶部的修改角色 */
        editTop() {
            if (this.checkBoxData.length === 1) {
                this.editInfo(this.checkBoxData[0])
            } else {
                showMessage(this, '请选中一行要修改的值！！！', 'error')
            }
        },
        /**批量删除按钮 */
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
                showMessage(this, '请选择要删除的角色', 'error')
            }
        },/**分页查询角色 */
        getRoleWithPage() {
            commenCRUD.queryWithPage(this.requestURL, this.listQuery).then(resp => {
                this.roleTableData = resp.data.body.list
                this.totalNum = resp.data.body.total

            })
        },
        /**修改角色 */
        editInfo(row) {
            commenCRUD.queryInfo(this.requestURL, {
                id: row.id,
                version: row.version,
                companyId: this.listQuery.companyId
            }).then(resp => {
                if (resp.data.head.code === "200") {
                    this.roleForm = resp.data.body
                    this.backRule = cloneObject(resp.data.body)
                    //如果没公司先这么处理吧
                    if (this.roleForm.companyList[0] === null) {
                        this.roleForm.companyList = []
                    }
                    this.getOrgOptions(this.listQuery.organizationId)
                    this.buildSelectedCompany()
                    this.dialogTile = "更新信息"
                    this.dialogVisible = true
                } else {
                    showMessage(this, '数据有更新请刷新！', 'error')
                }
            })
        },
        /**处理组织选择事件 */
        handleOrgChange(option) {
            //赋值为空
            this.roleForm.companyList = []
            this.buildSelectedCompany(option)
        },
        /**查询要显示的东西 */
        buildSelectedCompany(orgId) {

            if (this.listQuery.companyId === null) {
                //查询公司供选
                this.queryCompanyByOrgId(orgId)

            } else {
                this.companyOptions = cloneObject(this.roleForm.companyList)
                if (this.companyOptions.length === 0) {
                    this.queryCompanyById(this.listQuery.companyId)
                }
            }
        },
        /**新增时生成公司 */
        queryCompanyById(companyId) {
            axios.post(this.baseURL.replace('role', 'company') + 'queryCompanyById', companyId).then(resp => {
                this.companyOptions.push(resp.data.body)
            })
        },
        /**删除角色 */
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
        /**给用户分配角色 */
        distributeUser(row) {
            this.dialogUserVisible = true
            //看有没有公司
            this.companyOptions = cloneObject(row.companyList)
            this.constRoleId = row.id
            if (this.companyOptions[0] !== null && this.listQuery.companyId !== null) {
                this.companyForRole = this.listQuery.companyId
                //查询所有供选用户
                this.getUserByCompanyId(this.listQuery.companyId)
                //查询该公司下的数据
                this.getUserForDistributed(row.id, this.listQuery.companyId)
            } else {
                //如果没公司先这么处理吧
                if (this.companyOptions[0] === null) {
                    //不加会出warn很玄学，应该是this指针域我没搞懂
                    this.companyOptions = []
                    this.buildSelectedCompany()
                }
            }
        },
        /**查询对应公司下已分配角色的用户 */
        getUserForDistributed(rowId, companyId) {
            axios.post(this.baseURL.replace('role', 'userRole') + 'getUsersForRole', {
                roleId: rowId, companyId: companyId
            }).then(resp => {
                this.userRoleForm = resp.data.body
            })
        },
        /**给角色分配资源 */
        distributeResource(row) {
            this.dialogResourceVisible = true
            this.constRoleName = row.name
            this.constRoleId = row.id

            //查询资源树
            this.queryResourceTree()
            //查询当前角色的已有资源
            this.queryResourceForRole()
        },
        /**处理多选框 */
        clickCheckBox(val) {
            this.checkBoxData = val
        },
        /**处理双击事件 */
        handleRowDblclick(row, event) {
            this.editInfo(row)
        },
        /**处理单元格单击事件 */
        handleStatusCellClick(row) {
            this.roleForm = row
            this.roleForm.status = !this.roleForm.status
            this.updateInfo()
        },
        /**进行搜索 */
        searchRole() {
            this.listQuery.companyId = getCompanyId()
            this.listQuery.organizationId = getOrganizationId()
            this.getRoleWithPage()
        },
        /**关闭模态框 */
        closeDialog() {
            this.dialogVisible = false
            //重置
            this.$refs.roleForm.clearValidate();
            this.roleForm = cloneObject(this.defaultRoleForm)
            this.parentOptions = null
        },
        /**关闭用户模态框 */
        closeUserDialog() {
            this.dialogUserVisible = false
            this.companyForRole = null
            this.userOptions = []
            this.userRoleForm = cloneObject(this.defalutUserRoleForm)
        },
        /**关闭资源模态框 */
        closeResourceDialog() {
            this.dialogResourceVisible = false

            this.resourceRoleForm = cloneObject(this.defalutResourceRoleForm)
        },
        /**提交信息 */
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    if (this.roleForm.id !== null && this.roleForm.id !== '' && this.roleForm.id > 0) {
                        this.roleForm.updatedBy = getUserId()
                        this.updateInfo()
                    } else {
                        this.roleForm.createdBy = getUserId()
                        commenCRUD.insert(this.requestURL, this.roleForm).then(resp => {
                            if (resp.data.head.code === "200") {
                                showMessage(this, this.roleForm.name + '---->新增成功!', 'success')
                                this.reload()
                            } else {
                                showMessage(this, this.roleForm.name + '---->新增失败,请重试!', 'error')
                            }
                        })
                    }
                }
            })
        },
        /**提交用户角色信息 */
        submitUserRoleForm(formName) {
            axios.post(this.baseURL.replace('role', 'userRole') + 'updateUserForRole',
                {
                    companyId: this.companyForRole,
                    roleId: this.constRoleId,
                    users: this.userRoleForm.users
                }).then(resp => {
                    if (resp.data.head.code === "200") {
                        showMessage(this, '用户分配成功！', 'success')
                    } else {
                        showMessage(this, '用户分配失败，请重试！', 'error')
                    }
                    this.reload()
                })
        },
        /**提交资源角色信息 */
        submitResourceForm(formName) {
            this.updateResourceForRole()
        },
        /**更新信息 */
        updateInfo() {
            commenCRUD.updateInfo(this.requestURL, this.roleForm).then(resp => {
                if (resp.data.head.code === "200") {
                    showMessage(this, this.roleForm.name + '---->更新成功!', 'success')
                } else {
                    showMessage(this, this.roleForm.name + '---->更新失败,请重试!', 'error')
                }
                this.reload()
            })
        },
        /**拿到组织选择框 */
        getOrgOptions(orgId) {
            axios.post(this.baseURL.replace('role', 'org') + 'queryAll', orgId).then(resp => {
                this.organizationOptions = resp.data.body
            })
        },
        /**拿到组织的名字 */
        getOrgName(orgId) {
            axios.get(this.baseURL.replace('role', 'org') + 'getOrgName',
                { params: { id: orgId } }).then(resp => {
                    // this.roleForm.organizationName = resp.data.body
                    this.organizationOptions = [{ id: orgId, name: resp.data.body }]
                })
        },
        /**自动生成工号 */
        generatorCode() {
            axios.post(this.baseURL + 'generatorCode').then(resp => {
                this.roleForm.code = resp.data.body
            })
        },
        /**生成供选的公司 */
        queryCompanyByOrgId(orgId) {
            axios.post(this.baseURL.replace('role', 'company') + 'queryCompanyByOrgId', { companyId: this.listQuery.companyId, organizationId: orgId }).then(resp => {
                this.companyOptions = resp.data.body
            })
        },
        /**查询供选的用户 */
        getUserByCompanyId(companyId) {
            axios.post(this.baseURL.replace('role', 'user') + 'queryUserRoleTree', companyId).then(resp => {
                this.userOptions = resp.data.body
            })
        },
        /**规范treeSelect的数据 */
        normalizer(node) {
            //去掉children=[]的children属性
            if (node.departmentId && (!node.children || node.children === null || node.children.length === 0)) {
                delete node.children;
            }
            return {
                id: node.id,
                label: node.name,
                children: node.children
            }
        },
        /**处理公司改变事件 */
        hanleCompanyChange(option) {
            this.getUserByCompanyId(option)
            this.getUserForDistributed(this.constRoleId, option)

        },
        /**下面是资源的相关处理 */
        /**规范treeSelect的数据 */
        resourceNormalizer(node) {
            //去掉children=[]的children属性
            if (node.leaf) {
                delete node.children;
            }
            return {
                id: node.id,
                label: node.name,
                children: node.children
            }
        },
        /**查询资源树节点 */
        queryResourceTree() {
            commenCRUD.queryTree('resource').then(resp => {
                this.resourceOptions = resp.data.body
            })
        },
        /**查询当前角色的资源 */
        queryResourceForRole() {
            axios.get(this.baseURL.replace('role', 'resourceRole') + 'queryResourceForRole',
                {
                    params: {
                        roleId: this.constRoleId
                    }
                }).then(resp => {
                    this.resourceRoleForm = resp.data.body
                })
        },
        /**更新资源信息 */
        updateResourceForRole() {
            axios.post(this.baseURL.replace('role', 'resourceRole') + 'updateResourceForRole', this.resourceRoleForm).then(resp => {

                if (resp.data.head.code = "200") {
                    showMessage(this, '资源更新成功', 'success')
                } else {
                    showMessage(this, '资源更新失败，请重试！！', 'error')
                }
                this.reload()
            })
        },
        queryTree() {
            axios.post(this.baseURL + 'queryCompanyForTree', { companyId: this.listQuery.companyId, organizationId: this.listQuery.organizationId }).then(resp => {
                this.treeData = resp.data.body
            })
        },
        /**查询资源 */
        async queryParam() {
            const { resources } = await this.$store.dispatch('user/getInfo')
            if (resources.indexOf('100084') === -1) {
                this.isModifyShow = false
            }
            if (resources.indexOf('100085') === -1) {
                this.isInsertShow = false
            }
            if (resources.indexOf('100086') === -1) {
                this.isDeleteShow = false
            }
            if (resources.indexOf('100087') === -1) {
                this.isMultiDeleteShow = false
            }
            if (resources.indexOf('100089') === -1) {
                this.isDistributeUserShow = false
            }
            if (resources.indexOf('1000815') === -1) {
                this.isDistributeResourceShow = false
            }
        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.queryParam()
        this.defaultListQuery = cloneObject(this.listQuery)
        this.getRoleWithPage()
        this.queryTree()
        //克隆数据
        this.defaultRoleForm = cloneObject(this.roleForm)
        this.defalutUserRoleForm = cloneObject(this.userRoleForm)
        this.defalutResourceRoleForm = cloneObject(this.resourceRoleForm)

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
