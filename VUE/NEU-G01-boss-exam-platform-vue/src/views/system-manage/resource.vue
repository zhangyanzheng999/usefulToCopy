<!--
 * @description:
 * @fileName: Resource.vue
 * @author: 张彦征
 * @date: 2020-07-16 17:00:31
!-->
<!--  -->
<template>
    <div>
        <el-container>
            <el-aside width="240px" style="background-color: rgb(238, 241, 246)">
                <el-card class="box-card">
                    <div slot="header" class="clearfix">
                        <em class="el-icon-menu" />
                        <span>资源列表</span>
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
                        @click="searchResource()"
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
                                :data="resourceTableData"
                                :ref="resourceTableData"
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
                                <el-table-column label="资源名称" prop="name" width="100px"></el-table-column>
                                <el-table-column label="顺序号" prop="orderIndex" width="100px"></el-table-column>
                                <el-table-column label="URL" prop="url" width="100px"></el-table-column>
                                <el-table-column label="父亲节点" prop="parentName" width="100px"></el-table-column>
                                <el-table-column label="打开图标" prop="openImg" width="100px">
                                    <template slot-scope="scope">
                                        <i :class="scope.row.openImg" />
                                    </template>
                                </el-table-column>
                                <el-table-column label="关闭图标" prop="closeImg" width="100px">
                                    <template slot-scope="scope">
                                        <i :class="scope.row.closeImg" />
                                    </template>
                                </el-table-column>
                                <el-table-column label="备注" prop="remark" width="100px"></el-table-column>
                                <el-table-column label="资源类型" prop="resourceType" width="100px">
                                    <template slot-scope="scope">
                                        <label v-if="scope.row.resourceType==1">菜单</label>
                                        <label v-else-if="scope.row.resourceType==2">按钮</label>
                                        <label v-else>其他</label>
                                    </template>
                                </el-table-column>
                                <el-table-column label="叶子结点" prop="leaf" width="100px">
                                    <template slot-scope="scope">
                                        <p @click="handleLeafCellClick(scope.row)">
                                            <el-tag
                                                v-if="scope.row.leaf"
                                                type="success"
                                                effect="dark"
                                                size="mini"
                                            >是</el-tag>
                                            <el-tag v-else type="info" effect="dark" size="mini">否</el-tag>
                                        </p>
                                    </template>
                                </el-table-column>
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
                                @pagination="getResourceWithPage"
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
                            :model="resourceForm"
                            :rules="rules"
                            ref="resourceForm"
                            label-width="100px"
                            style="width:100%;"
                        >
                            <el-form-item label="资源编号" prop="code">
                                <el-input v-model="resourceForm.code" />
                            </el-form-item>
                            <el-form-item label="资源名称" prop="name">
                                <el-input v-model="resourceForm.name" />
                            </el-form-item>
                            <el-form-item label="顺序号" prop="orderIndex">
                                <el-input v-model="resourceForm.orderIndex" />
                            </el-form-item>
                            <el-form-item label="URL" prop="url">
                                <el-input v-model="resourceForm.url" />
                            </el-form-item>
                            <el-form-item label="打开图标" prop="openImg">
                                <icon-picker v-model="resourceForm.openImg"></icon-picker>
                            </el-form-item>
                            <el-form-item label="关闭图标" prop="closeImg">
                                <icon-picker v-model="resourceForm.closeImg"></icon-picker>
                            </el-form-item>
                            <el-form-item label="资源类型" prop="resourceType">
                                <template>
                                    <el-select
                                        @change="handleTypeSelectChange"
                                        v-model="resourceForm.resourceType"
                                        placeholder="请选择"
                                    >
                                        <el-option
                                            v-for="item in typeOptions"
                                            :key="item.id"
                                            :label="item.name"
                                            :value="item.id"
                                        ></el-option>
                                    </el-select>
                                </template>
                            </el-form-item>
                            <el-form-item label="资源备注" prop="remark">
                                <el-input v-model="resourceForm.remark" />
                            </el-form-item>
                            <el-form-item label="叶子结点" prop="leaf">
                                <el-radio-group v-model="resourceForm.leaf">
                                    <el-radio :label="true">是</el-radio>
                                    <el-radio :label="false">否</el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item label="父资源" prop="parentId">
                                <div>
                                    <treeselect
                                        v-model="resourceForm.parentId"
                                        :multiple="false"
                                        :options="parentOptions"
                                        :searchable="false"
                                        :show-count="true"
                                        placeholder="请选择父级资源"
                                        :normalizer="normalizer"
                                        @select="handleSelectParent"
                                    ></treeselect>
                                </div>
                            </el-form-item>

                            <el-form-item label="状态" prop="status">
                                <el-radio-group v-model="resourceForm.status">
                                    <el-radio :label="true">启用</el-radio>
                                    <el-radio :label="false">禁用</el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="submitForm('resourceForm')">确定</el-button>
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
            requestURL: 'resource',
            baseURL: '/education/bes/v1/system-manager-center/resource/',
            resourceTableData: [{ id: '' }],
            totalNum: 100,
            checkBoxData: [],
            dialogTile: '',
            dialogVisible: false,
            /**分页查询信息 */
            listQuery: {
                pageNum: 1,
                pageSize: 5,
                name: '',
                parentId: null
            },
            /**资源信息 */
            resourceForm: {
                id: null,
                code: null,
                name: null,
                orderIndex: null,
                url: null,
                parentId: null,
                parentName: null,
                closeImg: null,
                openImg: null,
                resourceType: 1,
                leaf: true,
                remark: null,
                status: true,
                version: null,
                createdTime: null,
                createdBy: null,
                updatedTime: null,
                updatedBy: null
            },
            defaultResourceForm: null,
            rules: {
                code: [{ required: true, trigger: 'blur' }, { validator: this.validateCode, trigger: 'blur' }],
                name: [{ required: true, trigger: 'blur' }, { validator: this.validateName, trigger: 'blur' }],
                resourceType: [{ required: true, trigger: 'change' }],
                openImg: [{ required: true, trigger: 'change' }],
                closeImg: [{ required: true, trigger: 'change' }]
            },
            typeOptions: [
                {
                    id: 1,
                    name: '菜单'
                },
                {
                    id: 2,
                    name: '按钮'
                }
            ],
            treeData: [],
            defaultProps: {
                label: 'name',
                children: 'children'
            },
            parentOptions: null,
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
        /**插入资源 */
        insert() {
            this.dialogTile = "新增资源"
            this.dialogVisible = true
            //查询所有资源供选
            this.queryTree()
        },
        /**顶部的修改资源 */
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
                showMessage(this, '请选择要删除的资源', 'error')
            }
        },
        /**分页查询资源 */
        getResourceWithPage() {
            commenCRUD.queryWithPage(this.requestURL, this.listQuery).then(resp => {
                this.resourceTableData = resp.data.body.list
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
                    //查询父资源
                    this.queryTree()
                    this.backRule = cloneObject(resp.data.body)
                    this.resourceForm = resp.data.body
                    this.dialogTile = "更新信息"
                    this.dialogVisible = true
                } else {
                    showMessage(this, '数据有更新请刷新！', 'error')
                }
            })
        },
        /**删除资源 */
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
            this.resourceForm = row
            this.resourceForm.status = !this.resourceForm.status
            this.updateInfo()
        },
        handleLeafCellClick(row) {
            this.resourceForm = row
            this.resourceForm.leaf = !this.resourceForm.leaf
            this.updateInfo()
        },
        /**搜索资源 */
        searchResource() {
            this.listQuery.parentId = null
            this.getResourceWithPage()
        },
        /**关闭模态框 */
        closeDialog() {
            this.dialogVisible = false
            //重置
            this.$refs.resourceForm.clearValidate();
            this.resourceForm = cloneObject(this.defaultResourceForm)
            this.parentOptions = null
        },
        /**提交信息 */
        submitForm(formName) {
            this.$refs[formName].validate(valid => {
                if (valid) {
                    if (this.resourceForm.id !== null && this.resourceForm.id !== '' && this.resourceForm.id > 0) {
                        this.resourceForm.updatedBy = getUserId()
                        this.updateInfo()
                    } else {
                        this.resourceForm.createdBy = getUserId()
                        commenCRUD.insert(this.requestURL, this.resourceForm).then(resp => {
                            if (resp.data.head.code === "200") {
                                showMessage(this, this.resourceForm.name + '---->新增成功!', 'success')
                                this.reload()
                            } else {
                                showMessage(this, this.resourceForm.name + '---->新增失败,请重试!', 'error')
                            }
                        })
                    }
                }
            })
        },
        /**更新信息 */
        updateInfo() {
            commenCRUD.updateInfo(this.requestURL, this.resourceForm).then(resp => {
                if (resp.data.head.code === "200") {
                    showMessage(this, this.resourceForm.name + '---->更新成功!', 'success')
                } else {
                    showMessage(this, this.resourceForm.name + '---->更新失败,请重试!', 'error')
                }
                this.reload()
            })
        },
        /**处理类型选择框改变 */
        handleTypeSelectChange(option) {
            this.resourceForm.resourceType = option
        },
        /**查询树节点 */
        queryTree() {
            commenCRUD.queryTree(this.requestURL).then(resp => {
                this.treeData = resp.data.body
                //先克隆
                this.parentOptions = cloneObject(this.treeData)
            })
        },
        /**树节点点击 */
        handleNodeClick(data) {
            //有孩子结点才展示
            if (data.children.length > 0 || data.parentId === null || data.leaf === false) {
                this.listQuery.parentId = data.id
                this.getResourceWithPage()
            }
        },
        /**规范treeSelect的数据 */
        normalizer(node) {
            //去掉children=[]的children属性
            if (node.children && !node.children.length) {
                delete node.children;
            }
            return {
                id: node.id,
                label: node.name,
                children: node.children
            }
        },
        /**处理选择父节点事件 */
        handleSelectParent(node, instanceId) {
            this.resourceForm.parentId = node.id
        },
        /**查询资源 */
        async queryParam() {
            const {resources} = await this.$store.dispatch('user/getInfo')
            if (resources.indexOf('100071') === -1) {
                this.isModifyShow = false
            }
            if (resources.indexOf('100072') === -1) {
                this.isInsertShow = false
            }
            if (resources.indexOf('100075') === -1) {
                this.isDeleteShow = false
            }
            if (resources.indexOf('100077') === -1) {
                this.isMultiDeleteShow = false
            }
        }
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        //查询树
        this.queryTree()
        //查询分页
        this.getResourceWithPage()

        this.defaultResourceForm = cloneObject(this.resourceForm)
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
