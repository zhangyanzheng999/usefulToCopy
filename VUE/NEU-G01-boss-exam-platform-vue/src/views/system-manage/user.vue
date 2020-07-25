<!--
 * @description:
 * @fileName: User.vue
 * @author: 张彦征
 * @date: 2020-07-16 17:00:55
!-->
<template>
    <div>
        <el-container>
            <el-aside width="180px" style="background-color: rgb(238, 241, 246)">
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <em class="el-icon-menu" />
                        <span>用户列表</span>
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
                        placeholder="请输入用户名称"
                        style="width: 150px"
                        v-model="listQuery.name"
                    ></el-input>
                    <el-input
                        size="mini"
                        placeholder="请输入工号"
                        style="width: 150px;margin-left:20px"
                        v-model="listQuery.code"
                    ></el-input>
                    <el-input
                        size="mini"
                        placeholder="请输入手机号码"
                        style="width: 150px;margin-left:20px"
                        v-model="listQuery.tel"
                    ></el-input>
                    <el-button
                        size="mini"
                        @click="searchUser()"
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
                                icon="el-icon-user"
                                style="margin-left:0px;color:#613030"
                                @click="distributeRoleTop()"
                                size="mini"
                                v-if="isModifyShow"
                            >分配角色</el-button>
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
                                :data="userTableData"
                                :ref="userTableData"
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
                                <el-table-column label="姓名" prop="name" width="100px"></el-table-column>
                                <el-table-column label="用户工号" prop="code" width="100px"></el-table-column>
                                <el-table-column label="公司" prop="companyName" width="100px"></el-table-column>
                                <el-table-column label="部门" prop="departmentName" width="100px"></el-table-column>
                                <el-table-column label="职位" prop="positionName" width="100px"></el-table-column>
                                <el-table-column label="角色" prop="roles" width="100px">
                                    <template slot-scope="scope">
                                        <label v-for="(item,index) in scope.row.roles" :key="index">
                                            <p v-if="item!==null">{{item.name}}</p>
                                        </label>
                                    </template>
                                </el-table-column>
                                <el-table-column label="性别" width="100px">
                                    <template slot-scope="scope">
                                        <p>
                                            <label v-if="scope.row.sex===0" size="mini">男</label>
                                            <label v-else size="mini">女</label>
                                        </p>
                                    </template>
                                </el-table-column>
                                <el-table-column label="生日" prop="birthday" width="150px"></el-table-column>
                                <el-table-column label="电话" prop="tel" width="100px"></el-table-column>
                                <el-table-column label="邮箱" prop="email" width="100px"></el-table-column>
                                <el-table-column label="其他" prop="other" width="50px"></el-table-column>
                                <el-table-column label="备注" prop="remark" width="50px"></el-table-column>
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
                                <el-table-column label="操作" width="160px">
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
                                        <el-tooltip
                                            class="item"
                                            effect="dark"
                                            content="分配角色"
                                            placement="top-start"
                                        >
                                            <el-button
                                                type="warning"
                                                icon="el-icon-user"
                                                circle
                                                @click="distributeRole(scope.row)"
                                                size="mini"
                                                v-if="isModifyShow"
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
                                @pagination="getUserWithPage"
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
                                :model="userForm"
                                :rules="rules"
                                ref="userForm"
                                label-width="100px"
                                style="width:100%;"
                            >
                                <el-form-item label="工号" prop="code">
                                    <el-input v-model="userForm.code" />
                                </el-form-item>
                                <el-form-item label="姓名" prop="name">
                                    <el-input v-model="userForm.name" />
                                </el-form-item>
                                <el-form-item label="密码" prop="password">
                                    <el-input v-model="userForm.password" show-password />
                                </el-form-item>

                                <el-form-item label="性别" prop="sex">
                                    <el-radio-group v-model="userForm.sex">
                                        <el-radio :label="1">男</el-radio>
                                        <el-radio :label="0">女</el-radio>
                                    </el-radio-group>
                                </el-form-item>
                                <el-form-item label="生日">
                                    <el-date-picker
                                        v-model="userForm.birthday"
                                        type="date"
                                        placeholder="选择日期"
                                        format="yyyy 年 MM 月 dd 日"
                                        value-format="yyyy-MM-dd"
                                    ></el-date-picker>
                                </el-form-item>
                                <el-form-item label="电话" prop="tel">
                                    <el-input v-model="userForm.tel" />
                                </el-form-item>
                                <el-form-item label="邮箱" prop="email">
                                    <el-input v-model="userForm.email" />
                                </el-form-item>
                                <el-form-item label="公司" prop="companyId">
                                    <template>
                                        <el-select
                                            @change="handleCompanySelectChange"
                                            v-model="userForm.companyId"
                                            placeholder="请选择"
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
                                <el-form-item
                                    label="部门"
                                    prop="departmentId"
                                    :required="userForm.companyId===null?false:true"
                                >
                                    <template>
                                        <el-select
                                            v-model="userForm.departmentId"
                                            placeholder="请选择"
                                        >
                                            <el-option
                                                v-for="item in departmentOptions"
                                                :key="item.id"
                                                :label="item.name"
                                                :value="item.id"
                                            ></el-option>
                                        </el-select>
                                    </template>
                                </el-form-item>
                                <el-form-item
                                    label="职位"
                                    prop="positionId"
                                    :required="userForm.companyId===null?false:true"
                                >
                                    <template>
                                        <el-select v-model="userForm.positionId" placeholder="请选择">
                                            <el-option
                                                v-for="item in positionOptions"
                                                :key="item.id"
                                                :label="item.name"
                                                :value="item.id"
                                            ></el-option>
                                        </el-select>
                                    </template>
                                </el-form-item>
                                <el-form-item label="角色" prop="roles">
                                    <template>
                                        <el-select
                                            multiple
                                            value-key="id"
                                            v-model="userForm.roles"
                                            placeholder="请选择"
                                        >
                                            <el-option
                                                v-for="item in roleOptions"
                                                :key="item.id"
                                                :label="item.name"
                                                :value="item"
                                            ></el-option>
                                        </el-select>
                                    </template>
                                </el-form-item>
                                <el-form-item label="其他" prop="other">
                                    <el-input v-model="userForm.other" />
                                </el-form-item>
                                <el-form-item label="备注" prop="remark">
                                    <el-input v-model="userForm.remark" />
                                </el-form-item>
                                <el-form-item label="状态" prop="status">
                                    <el-radio-group v-model="userForm.status">
                                        <el-radio :label="true">启用</el-radio>
                                        <el-radio :label="false">禁用</el-radio>
                                    </el-radio-group>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="submitForm('userForm')">确定</el-button>
                                    <el-button
                                        @click="closeDialog()"
                                        type="danger"
                                        style="margin-left:50px"
                                    >取消</el-button>
                                </el-form-item>
                            </el-form>
                        </el-dialog>
                        <el-dialog
                            title="分配角色信息"
                            :visible.sync="RoleDialogVisible"
                            width="30%"
                            :center="true"
                            @close="closeRoleDialog"
                        >
                            <el-form
                                :model="userForm"
                                :rules="rules"
                                ref="userForm"
                                label-width="100px"
                                style="width:100%;"
                            >
                                <el-form-item label="角色" prop="roles">
                                    <template>
                                        <el-select
                                            multiple
                                            value-key="id"
                                            v-model="userForm.roles"
                                            placeholder="请选择"
                                        >
                                            <el-option
                                                v-for="item in roleOptions"
                                                :key="item.id"
                                                :label="item.name"
                                                :value="item"
                                            ></el-option>
                                        </el-select>
                                    </template>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="submitForm('userForm')">确定</el-button>
                                    <el-button
                                        @click="closeRoleDialog()"
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
/**引入treeselect */
// import the component
import Treeselect from '@riophae/vue-treeselect'
// import the styles
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
import UploadExcelComponent from '@/components/UploadExcel/index.vue'
export default {
    //import引入的组件需要注入到对象中才能使用
    components: { Pagination, UploadExcelComponent },
    inject: ['reload'],
    data() {
        //这里存放数据
        return {
            requestURL: 'user',
            baseURL: '/education/bes/v1/system-manager-center/user/',
            userTableData: [{ id: '' }],
            totalNum: 100,
            checkBoxData: [],
            dialogTile: '',
            dialogVisible: false,
            RoleDialogVisible: false,
            defaultListQuery: null,
            listQuery: {
                pageNum: 1,
                pageSize: 5,
                name: null,
                tel: null,
                code: null,
                roles: [],
                organizationId: getOrganizationId(), //组织Id，先默认一下
                companyId: getCompanyId(),//公司Id，也默认
                departmentId: null
            },
            /**存放参数信息 */
            userForm: {
                id: null,
                code: null,
                name: null,
                password: 123456,
                profilePicture: null,
                sex: 1,
                birthday: null,
                tel: null,
                email: null,
                other: null,
                remark: null,
                roles: [],
                departmentId: null,
                departmentName: null,
                positionId: null,
                positionName: null,
                companyId: null,
                companyName: null,
                version: null,
                status: true,
                createdTime: null,
                createdBy: null,
                updatedTime: null,
                updatedBy: null
            },
            rules: {
                code: [{ required: true, trigger: 'blur' }, { validator: this.validateCode, trigger: 'blur' }],
                name: [{ required: true, trigger: 'blur' }],
                tel: [{ validator: validate.validatePhoneTwo, trigger: 'blur' }],
                email: [{ validator: validate.validateEMail, trigger: 'blur' }],
            },
            defaultUserForm: null,
            treeData: [],
            defaultProps: {
                label: 'name',
                children: 'children'
            },
            companyOptions: [],
            departmentOptions: [],
            positionOptions: [],
            roleOptions: [],
            backRule: null,
            filterVal: ['name', 'sex', 'birthday', 'tel', 'other', 'remark', 'status'],
            allValues: [],
            isInsertShow: true,
            isModifyShow: true,
            isDeleteShow: true,
            isMultiDeleteShow: true,
            isExportAllShow: true

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
        /**插入用户 */
        insert() {
            this.dialogTile = "新增用户"
            this.dialogVisible = true
            //查询公司
            this.queryCompanyByOrgId()
            //工号
            this.generatorCode()
        },
        /**顶部的修改按钮 */
        editTop() {
            if (this.checkBoxData.length === 1) {
                this.editInfo(this.checkBoxData[0])
            } else {
                showMessage(this, '请选中一行要修改的值！！！', 'error')
            }
        },
        /**顶部的分配资源 */
        distributeRoleTop() {
            if (this.checkBoxData.length === 1) {
                this.distributeRole(this.checkBoxData[0])
            } else {
                showMessage(this, '请选中一个要分配角色的用户！！！', 'error')
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
                showMessage(this, '请选择要删除的部门', 'error')
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
                    //查询公司
                    this.queryCompanyByOrgId()
                    this.userForm = resp.data.body
                    this.backRule = cloneObject(resp.data.body)
                    //下面是查找一些下拉框的值
                    this.queryPositionByCompanyId(this.userForm.companyId)
                    this.queryDepartmentByCompanyId(this.userForm.companyId)
                    this.queryRoleByByCompanyId(this.userForm.companyId)

                    this.dialogTile = "更新信息"
                    this.dialogVisible = true
                } else {
                    showMessage(this, '数据有更新请刷新！', 'error')
                }
            })
        },
        distributeRole(row) {
            commenCRUD.queryInfo(this.requestURL, {
                id: row.id,
                version: row.version
            }).then(resp => {
                if (resp.data.head.code === "200") {
                    //查询公司
                    this.queryCompanyByOrgId()
                    this.userForm = resp.data.body
                    //下面是查找角色的值
                    this.queryRoleByByCompanyId(this.userForm.companyId)

                    this.RoleDialogVisible = true
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
        getUserWithPage() {
            commenCRUD.queryWithPage(this.requestURL, this.listQuery).then(resp => {
                this.userTableData = resp.data.body.list
                this.totalNum = resp.data.body.total

            })
        },
        /**关闭模态框 */
        closeDialog() {
            this.dialogVisible = false
            //重置
            this.$refs.userForm.clearValidate();
            this.userForm = cloneObject(this.defaultUserForm)
        },
        /**关闭分配的模态框 */
        closeRoleDialog() {
            this.RoleDialogVisible = false

            this.userForm = cloneObject(this.defaultUserForm)
        },
        /**提交信息 */
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    if (this.userForm.id !== null && this.userForm.id !== '' && this.userForm.id > 0) {
                        this.userForm.updatedBy = getUserId()
                        this.updateInfo()
                    } else {
                        this.userForm.createdBy = getUserId()
                        commenCRUD.insert(this.requestURL, this.userForm).then(resp => {
                            if (resp.data.head.code === "200") {
                                showMessage(this, this.userForm.name + '---->新增成功!', 'success')
                                this.reload()
                            } else {
                                showMessage(this, this.userForm.name + '---->新增失败,请重试!', 'error')
                            }
                        })
                    }
                }
            })
        },
        /**更新信息 */
        updateInfo() {
            commenCRUD.updateInfo(this.requestURL, this.userForm).then(resp => {
                if (resp.data.head.code === "200") {
                    showMessage(this, this.userForm.name + '---->更新成功!', 'success')
                } else {
                    showMessage(this, this.userForm.name + '---->更新失败,请重试!', 'error')
                }
                this.reload()
            })
        },
        /**单元格被单击 */
        handleCellClick(row) {
            this.userForm = row
            this.userForm.status = !this.userForm.status
            this.updateInfo()
        },
        /**树节点点击事件 */
        handleNodeClick(data) {
            this.listQuery = cloneObject(this.defaultListQuery)
            if (data.companyId === null) {
                if (data.organizationId === null) {
                    this.listQuery.organizationId = data.id
                } else {
                    this.listQuery.companyId = data.id
                }
            } else {
                this.listQuery.departmentId = data.id
            }
            this.getUserWithPage()
        },
        /**按照名字查询 */
        searchUser() {
            this.listQuery.companyId = null
            this.listQuery.departmentId = null
            this.getUserWithPage()
        },
        /**处理公司的选择事件 */
        handleCompanySelectChange(option) {
            this.userForm.departmentId = null
            this.userForm.positionId = null
            //要去拿到对应的部门和职位
            this.queryPositionByCompanyId(option)
            this.queryDepartmentByCompanyId(option)
            this.queryRoleByByCompanyId(option)
            //清空已有的
            this.userForm.roles = []

        },
        /**查找公司下面的职位 */
        queryPositionByCompanyId(companyId) {
            axios.get(this.baseURL.replace('user', 'position') + 'queryPositionByCompanyId',
                {
                    params: {
                        companyId: companyId
                    }
                }).then(resp => {
                    this.positionOptions = resp.data.body
                })
        },
        /**查找公司下面的职位 */
        queryDepartmentByCompanyId(companyId) {
            axios.get(this.baseURL.replace('user', 'department') + 'queryDepartmentByCompanyId',
                {
                    params: {
                        companyId: companyId
                    }
                }).then(resp => {
                    this.departmentOptions = resp.data.body
                })
        },
        /**查找角色 */
        queryRoleByByCompanyId(companyId) {
            if (companyId !== null) {
                axios.get(this.baseURL.replace('user', 'role') + 'queryRoleByByCompanyId', {
                    params: {
                        companyId: companyId
                    }
                }).then(resp => {
                    this.roleOptions = resp.data.body
                })
            } else {

            }
        },
        /**生成供选的公司 */
        queryCompanyByOrgId() {
            axios.post(this.baseURL.replace('user', 'company') + 'queryCompanyByOrgId', { companyId: this.listQuery.companyId, organizationId: this.listQuery.organizationId }).then(resp => {
                this.companyOptions = resp.data.body
            })
        },
        /**自动生成工号 */
        generatorCode() {
            axios.get(this.baseURL + 'generatorCode').then(resp => {
                this.userForm.code = resp.data.body
            })
        },
        /**查询树 */
        queryTree() {
            axios.post(this.baseURL.replace('user', 'department') + 'queryTree', { companyId: this.listQuery.companyId, organizationId: this.listQuery.organizationId }).then(resp => {
                this.treeData = resp.data.body
            })
        },
        /**处理导入 */
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
                        filename: '用户信息表'
                    });
                })
            }
        },
        /**导出全部 */
        handleExportAll() {
            axios.post(this.baseURL + 'getAllUser', { companyId: this.listQuery.companyId, organizationId: this.listQuery.organizationId }).then(resp => {
                this.allValues = resp.data.body
                import('../../vendor/Export2Excel').then(excel => {
                    const data = this.formatJson(this.filterVal, this.allValues);
                    excel.export_json_to_excel({
                        header: this.filterVal,
                        data: data,
                        filename: '用户信息表'
                    });
                })
            })
        },
        /**导出模板 */
        handleExportFormat() {
            import('../../vendor/Export2Excel').then(excel => {
                const list = [{ name: '姓名', sex: '1(男)/0(女)', birthday: '生日', tel: '手机号码(11位)', other: '其他', remark: '备注', status: 'TRUE/FALSE' }];
                const data = this.formatJson(this.filterVal, list);
                excel.export_json_to_excel({
                    header: this.filterVal,
                    data: data,
                    filename: '用户信息模板'
                });
            })
        },
        formatJson(filterVal, jsonData) {
            return jsonData.map(v => filterVal.map(j => v[j]))
        },
        /**查询资源 */
        async queryParam() {
            const {resources} = await this.$store.dispatch('user/getInfo')

            if (resources.indexOf('100106') === -1) {
                this.isModifyShow = false
            }
            if (resources.indexOf('100105') === -1) {
                this.isInsertShow = false
            }
            if (resources.indexOf('100103') === -1) {
                this.isDeleteShow = false
            }
            if (resources.indexOf('100101') === -1) {
                this.isMultiDeleteShow = false
            }
            if (resources.indexOf('1001012') === -1) {
                this.isExportAllShow = false
            }

        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.getUserWithPage()
        //查询节点树
        this.queryTree()
        this.defaultUserForm = cloneObject(this.userForm)
        this.defaultListQuery = cloneObject(this.listQuery)

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
