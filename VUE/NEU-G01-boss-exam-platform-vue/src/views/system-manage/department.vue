<!--
 * @description:
 * @fileName: Department.vue
 * @author: 张彦征
 * @date: 2020-07-16 16:59:56
!-->
<!--  -->
<template>
    <div>
        <el-container>
            <el-aside width="210px" style="background-color: rgb(238, 241, 246)">
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <em class="el-icon-menu" />
                        <span>部门列表</span>
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
                        placeholder="请输入部门名称"
                        style="width: 150px"
                        v-model="listQuery.name"
                    ></el-input>
                    <el-button
                        size="mini"
                        @click="searchDepartment()"
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
                                :data="departmentTableData"
                                :ref="departmentTableData"
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
                                <el-table-column label="部门编号" prop="code" width="100px"></el-table-column>
                                <el-table-column label="部门助记码" prop="mnemonicCode" width="100px"></el-table-column>
                                <el-table-column label="部门名称" prop="name" width="100px"></el-table-column>
                                <el-table-column label="部门负责人" prop="master" width="100px"></el-table-column>
                                <el-table-column label="部门级别" prop="level" width="100px"></el-table-column>
                                <el-table-column label="上级部门" prop="parentName" width="100px"></el-table-column>
                                <el-table-column label="部门描述" prop="descript" width="100px"></el-table-column>
                                <el-table-column label="所属公司" prop="companyName" width="100px"></el-table-column>
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
                                @pagination="getDepartmentWithPage"
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
                                :model="departmentForm"
                                :rules="rules"
                                ref="departmentForm"
                                label-width="100px"
                                style="width:100%;"
                            >
                                <el-form-item label="部门编号" prop="code">
                                    <el-input v-model="departmentForm.code" />
                                </el-form-item>
                                <el-form-item label="部门名称" prop="name">
                                    <el-input v-model="departmentForm.name" />
                                </el-form-item>
                                <el-form-item label="部门助记码" prop="mnemonicCode">
                                    <el-input v-model="departmentForm.mnemonicCode"></el-input>
                                </el-form-item>
                                <el-form-item label="部门主管" prop="master">
                                    <el-input v-model="departmentForm.master" />
                                </el-form-item>
                                <el-form-item label="部门描述" prop="descript">
                                    <el-input v-model="departmentForm.descript" />
                                </el-form-item>
                                <el-form-item label="所属公司" prop="companyId">
                                    <template>
                                        <el-select
                                            @change="handleCompanySelectChange"
                                            v-model="departmentForm.companyId"
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
                                <el-form-item label="部门级别" prop="level">
                                    <template>
                                        <el-select
                                            @change="handleLevelSelectChange"
                                            v-model="departmentForm.level"
                                            placeholder="请选择"
                                        >
                                            <el-option
                                                v-for="item in levelOptions"
                                                :key="item.value"
                                                :value="item.value"
                                            ></el-option>
                                        </el-select>
                                    </template>
                                </el-form-item>
                                <el-form-item label="上级部门" prop="parentId">
                                    <template>
                                        <el-select
                                            @change="handleParentSelectChange"
                                            v-model="departmentForm.parentId"
                                            placeholder="请选择"
                                        >
                                            <el-option
                                                v-for="item in parentOptions"
                                                :key="item.id"
                                                :label="item.name"
                                                :value="item.id"
                                            ></el-option>
                                        </el-select>
                                    </template>
                                </el-form-item>
                                <el-form-item label="状态" prop="status">
                                    <el-radio-group v-model="departmentForm.status">
                                        <el-radio :label="true">启用</el-radio>
                                        <el-radio :label="false">禁用</el-radio>
                                    </el-radio-group>
                                </el-form-item>
                                <el-form-item>
                                    <el-button
                                        type="primary"
                                        @click="submitForm('departmentForm')"
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
import { getUserId, getCompanyId, getOrganizationId } from "@/utils/userInfo";
export default {
    //import引入的组件需要注入到对象中才能使用
    components: { Pagination },
    inject: ['reload'],
    data() {
        //这里存放数据
        return {
            requestURL: 'department',
            baseURL: '/education/bes/v1/system-manager-center/department/',
            departmentTableData: [{ id: '' }],
            totalNum: 100,
            checkBoxData: [],
            dialogTile: '',
            dialogVisible: false,
            defaultListQuery: null,
            listQuery: {
                pageNum: 1,
                pageSize: 5,
                name: '',
                companyId: getCompanyId(),
                organizationId: getOrganizationId(),
                parentId: null
            },
            /**存放公司信息 */
            departmentForm: {
                id: Number.MIN_SAFE_INTEGER,
                code: null,
                name: null,
                mnemonicCode: null,
                master: null,
                level: null,
                parentId: null,
                parentName: null,
                companyId: undefined,
                descript: null,
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
                name: [{ required: true, trigger: 'blur' }, { validator: this.validateName, trigger: 'blur' }],
                companyId: [{ required: true, trigger: 'change' }],
                level: [{ required: true, trigger: 'change' }]
            },
            /**下面是公司，上级部门，级别三个选择框 */
            companyOptions: null,
            levelOptions: [
                { value: '一级部门' },
                { value: '二级部门' }
            ],
            parentOptions: null,
            defaultDepartmentForm: null,
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
        /**插入部门 */
        insert() {
            this.dialogTile = "新增部门"
            this.dialogVisible = true
            //查询所有机构供选
            this.queryAllComapny()
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
                    this.departmentForm = resp.data.body
                    this.backRule = cloneObject(resp.data.body)
                    //查询所有公司供选
                    this.queryAllComapny()
                    //先查询这个公司的所有部门
                    this.queryAllDepartment(this.departmentForm.companyId)
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
                        showMessage(this, row.name + '----->'+resp.data.body, 'error')
                    }
                })
            }
        },
        /**查询信息 */
        viewInfo(row) {
            this.$alert(row, '信息')
        },
        /**分页查询  先普通分页展示数据*/
        getDepartmentWithPage() {
            commenCRUD.queryWithPage(this.requestURL, this.listQuery).then(resp => {
                this.departmentTableData = resp.data.body.list
                this.totalNum = resp.data.body.total
            })
        },
        /**关闭模态框 */
        closeDialog() {
            this.dialogVisible = false
            //重置
            this.$refs.departmentForm.clearValidate();
            this.departmentForm = cloneObject(this.defaultDepartmentForm)
        },
        /**提交信息 */
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    if (this.departmentForm.id !== null && this.departmentForm.id !== '' && this.departmentForm.id > 0) {
                        this.departmentForm.updatedBy = getUserId()
                        this.updateInfo()
                    } else {
                        this.defaultDepartmentForm.createdBy = getUserId()
                        commenCRUD.insert(this.requestURL, this.departmentForm).then(resp => {
                            if (resp.data.head.code === "200") {
                                showMessage(this, this.departmentForm.name + '---->新增成功!', 'success')
                                this.reload()
                            } else {
                                showMessage(this, this.departmentForm.name + '---->新增失败,请重试!', 'error')
                            }
                        })
                    }
                }
            })
        },
        /**更新信息 */
        updateInfo() {
            commenCRUD.updateInfo(this.requestURL, this.departmentForm).then(resp => {
                if (resp.data.head.code === "200") {
                    showMessage(this, this.departmentForm.name + '---->更新成功!', 'success')
                } else {
                    showMessage(this, this.departmentForm.name + '---->更新失败,请重试!', 'error')
                }
                this.reload()
            })
        },
        /**重置 */
        resetForm(formName) {
            this.$refs[formName].resetFields()
        },
        /**查询全部的公司  如果有组织Id那么就查某一个组织*/
        queryAllComapny() {
            axios.post(this.baseURL.replace('department', 'company') + 'queryCompanyByOrgId', { organizationId: this.listQuery.organizationId, companyId: this.listQuery.companyId }).then(resp => {
                this.companyOptions = resp.data.body
            })


        },
        /**查询所有的部门用来展示 */
        queryAllDepartment(companyId) {
            axios.get(this.baseURL + '/queryDepartmentByCompanyIdWithOutSelf' ,
            {params:{
              companyId:companyId,
              departmentId: this.departmentForm.id
            }}).then(resp => {
                //添加一个没有上级部门的选项
                this.parentOptions = [{ id: null, name: '无' }, ...resp.data.body]
            })
        },
        /**公司选择框处理函数 */
        handleCompanySelectChange(option) {
            this.departmentForm.companyId = option
            //清空默认绑定
            this.departmentForm.parentName = ''
            this.departmentForm.parentId = null
            this.queryAllDepartment(option)
        },
        /**部门级别选择框 */
        handleLevelSelectChange(option) {
            this.departmentForm.level = option

        },
        /**上级部门选择框 */
        handleParentSelectChange(option) {
            this.departmentForm.parentId = option

        },
        /**单元格被单击 */
        handleCellClick(row) {
            this.departmentForm = row
            this.departmentForm.status = !this.departmentForm.status
            this.updateInfo()
        },
        /**树节点点击事件 */
        handleNodeClick(data) {
            this.listQuery = cloneObject(this.defaultListQuery)
            if (data.organizationId === null && data.companyId === null) {
                this.listQuery.organizationId = data.id
            } else if (data.companyId === null) {
                this.listQuery.companyId = data.id
            } else {
                this.listQuery.parentId = data.id
            }
            this.getDepartmentWithPage()
        },
        /**查询树节点 */
        queryTree() {
            commenCRUD.postQueryTree(this.requestURL, { organizationId: this.listQuery.organizationId, companyId: this.listQuery.companyId }).then(resp => {
                this.treeData = resp.data.body
            })
        },
        /**按照名字查询 */
        searchDepartment() {
            this.listQuery = cloneObject(this.defaultListQuery)
            this.getDepartmentWithPage()
        },
        /**查询资源 */
        async queryParam() {
            const {resources} = await this.$store.dispatch('user/getInfo')
            if (resources.indexOf('100064') === -1) {
                this.isModifyShow = false
            }
            if (resources.indexOf('100065') === -1) {
                this.isInsertShow = false
            }
            if (resources.indexOf('100066') === -1) {
                this.isDeleteShow = false
            }
            if (resources.indexOf('100067') === -1) {
                this.isMultiDeleteShow = false
            }
        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        //查询树
        this.queryTree()
        //创建时调用
        this.getDepartmentWithPage()
        //深拷贝一份原始数据
        this.defaultDepartmentForm = cloneObject(this.departmentForm)
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
