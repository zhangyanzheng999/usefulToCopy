<!--
 * @description:
 * @fileName: Position.vue
 * @author: 张彦征
 * @date: 2020-07-16 17:00:21
!-->
<!--  -->
<template>
    <div>
        <el-container>
            <el-aside width="180px" style="background-color: rgb(238, 241, 246)">
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <em class="el-icon-menu" />
                        <span>职位列表</span>
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
                        placeholder="请输入职位名称"
                        style="width: 150px"
                        v-model="listQuery.name"
                    ></el-input>
                    <el-select
                        v-model="listQuery.status"
                        placeholder="请选择启用状态"
                        style="margin-left:30px;width: 150px"
                        size="mini"
                    >
                        <el-option
                            v-for="item in statusOption"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value"
                        ></el-option>
                    </el-select>
                    <el-button
                        size="mini"
                        @click="searchPosition()"
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
                                :data="positionTableData"
                                :ref="positionTableData"
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
                                    width="80px"
                                ></el-table-column>
                                <el-table-column label="编号" prop="code" width="100px"></el-table-column>
                                <el-table-column label="职位名称" prop="name" width="200px"></el-table-column>
                                <el-table-column label="所属公司" prop="companyName" width="150px"></el-table-column>
                                <el-table-column label="备注" prop="remark" width="150px"></el-table-column>
                                <el-table-column label="状态位" prop="status" width="120px">
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
                                @pagination="getPositionWithPage"
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
                            :model="positionForm"
                            :rules="rules"
                            ref="positionForm"
                            label-width="100px"
                            style="width:100%;"
                        >
                            <el-form-item label="职位编号" prop="code">
                                <el-input v-model="positionForm.code" />
                            </el-form-item>
                            <el-form-item label="职位名称" prop="name">
                                <el-input v-model="positionForm.name" />
                            </el-form-item>
                            <el-form-item label="所属公司" prop="companyId">
                                <template>
                                    <el-select v-model="positionForm.companyId" placeholder="请选择">
                                        <el-option
                                            v-for="item in companyOptions"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item.id"
                                        ></el-option>
                                    </el-select>
                                </template>
                            </el-form-item>
                            <el-form-item label="职位备注" prop="remark">
                                <el-input v-model="positionForm.remark" />
                            </el-form-item>
                            <el-form-item label="状态" prop="status">
                                <el-radio-group v-model="positionForm.status">
                                    <el-radio :label="true">启用</el-radio>
                                    <el-radio :label="false">禁用</el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('positionForm')">确定</el-button>
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
import { getUserId, getCompanyId, getOrganizationId } from "@/utils/userInfo";
export default {
    //import引入的组件需要注入到对象中才能使用
    components: { Pagination },
    inject: ['reload'],
    data() {
        //这里存放数据
        return {
            requestURL: 'position',
            baseURL: '/education/bes/v1/system-manager-center/position/',
            positionTableData: [{ id: '' }],
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
                status: null,
                organizationId: getOrganizationId()
            },
            /**资源信息 */
            positionForm: {
                id: null,
                code: null,
                name: null,
                companyId: null,
                companyName: null,
                remark: null,
                status: true,
                version: null,
                createdTime: null,
                createdBy: null,
                updatedTime: null,
                updatedBy: null
            },
            defaultPositionForm: null,
            rules: {
                code: [{ required: true, trigger: 'blur' }, { validator: this.validateCode, trigger: 'blur' }],
                name: [{ required: true, trigger: 'blur' }, { validator: this.validateName, trigger: 'blur' }],
                companyId: [{ required: true, trigger: 'change' }],
            },
            treeData: [],
            defaultProps: {
                label: 'name',
                children: 'children'
            },
            statusOption: [
                { value: null, label: '全部' },
                { value: true, label: '启用' },
                { value: false, label: '禁用' }
            ],
            companyOptions: null,
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
        /**插入职位 */
        insert() {
            this.dialogTile = "新增职位"
            this.dialogVisible = true
            //查询所有公司供选
            this.queryAllComapny()
        },
        /**顶部的修改职位 */
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
                showMessage(this, '请选择要删除的职位', 'error')
            }
        },
        /**分页查询职位 */
        getPositionWithPage() {
            commenCRUD.queryWithPage(this.requestURL, this.listQuery).then(resp => {
                this.positionTableData = resp.data.body.list
                this.totalNum = resp.data.body.total
            })
        },
        /**修改资源 */
        editInfo(row) {
            commenCRUD.queryInfo(this.requestURL, {
                id: row.id,
                version: row.version
            }).then(resp => {
                if (resp.data.head.code === "200") {
                    this.positionForm = resp.data.body
                    this.backRule = cloneObject(resp.data.body)
                    //查找公司
                    this.queryAllComapny()
                    this.dialogTile = "更新信息"
                    this.dialogVisible = true
                } else {
                    showMessage(this, '数据有更新请刷新！', 'error')
                }
            })
        },
        /**删除职位 */
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
        /**查看资源 */
        viewInfo(row) {
            this.$alert(row, '信息')
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
            this.positionForm = row
            this.positionForm.status = !this.positionForm.status
            this.updateInfo()
        },
        /**搜索职位 */
        searchPosition() {
            this.listQuery.companyId=getCompanyId()
            this.listQuery.organizationId=getOrganizationId()
            this.getPositionWithPage()
        },
        /**关闭模态框 */
        closeDialog() {
            this.dialogVisible = false
            //重置
            this.$refs.positionForm.clearValidate();
            this.positionForm = cloneObject(this.defaultPositionForm)
        },
        /**提交信息 */
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    if (this.positionForm.id !== null && this.positionForm.id !== '' && this.positionForm.id > 0) {
                        this.positionForm.updatedBy = getUserId()
                        this.updateInfo()
                    } else {
                        this.positionForm.createdBy = getUserId()
                        commenCRUD.insert(this.requestURL, this.positionForm).then(resp => {
                            if (resp.data.head.code === "200") {
                                showMessage(this, this.positionForm.name + '---->新增成功!', 'success')
                                this.reload()
                            } else {
                                showMessage(this, this.positionForm.name + '---->新增失败,请重试!', 'error')
                            }
                        })
                    }
                }
            })
        },
        /**更新信息 */
        updateInfo() {
            commenCRUD.updateInfo(this.requestURL, this.positionForm).then(resp => {
                if (resp.data.head.code === "200") {
                    showMessage(this, this.positionForm.name + '---->更新成功!', 'success')
                } else {
                    showMessage(this, this.positionForm.name + '---->更新失败,请重试!', 'error')
                }
                this.reload()
            })
        },
        /**查询树节点 */
        queryTree() {
            commenCRUD.postQueryTree('company', { organizationId: this.listQuery.organizationId, companyId: this.listQuery.companyId }).then(resp => {
                this.treeData = resp.data.body
            })
        },
        /**树节点点击 */
        handleNodeClick(data) {
            //有孩子结点才展示
            this.listQuery = cloneObject(this.defaultListQuery)
            if (data.organizationId !== null) {
                this.listQuery.companyId = data.id

            } else {
                this.listQuery.organizationId = data.id
            }
            this.getPositionWithPage()
        },
        /**查询全部的公司  如果有组织Id那么就查某一个组织*/
        queryAllComapny() {
            axios.post(this.baseURL.replace('position', 'company') + 'queryCompanyByOrgId', { organizationId: this.listQuery.organizationId, companyId: this.listQuery.companyId }).then(resp => {
                this.companyOptions = resp.data.body
            })
        },
        /**查询资源 */
        async queryParam() {
            const {resources} = await this.$store.dispatch('user/getInfo')
            if (resources.indexOf('100098') === -1) {
                this.isModifyShow = false
            }
            if (resources.indexOf('100095') === -1) {
                this.isInsertShow = false
            }
            if (resources.indexOf('100094') === -1) {
                this.isDeleteShow = false
            }
            if (resources.indexOf('100091') === -1) {
                this.isMultiDeleteShow = false
            }
        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.getPositionWithPage()
        this.queryTree()
        this.defaultPositionForm = cloneObject(this.positionForm)
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
//去掉边框
.el-button {
    border: none;
}
</style>
