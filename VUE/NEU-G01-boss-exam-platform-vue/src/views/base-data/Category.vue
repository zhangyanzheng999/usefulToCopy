<template>
<div>
  <el-card class="box-card">
    <div slot="header" class="clearfix">
      <span>题目类别</span>
    </div>
    <!--<el-tree :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>-->
    <!--<tree title="题目类别管理" icon="user" :setTree="tree"
          @getInfo="queryCategorysByMenu"
          @addCategory="rightClickAdd"
          @delCategory="rightClickDel"></tree>-->
    <el-tree
      :data="data"
      node-key="id"
      :props="defaultProps"
      :accordion="true"
      :indent="12"
      @node-click="handleNodeClick"
    ></el-tree>


  </el-card>
  <el-card class="righttable">
    <div slot="header" class="clearfix">
      <el-input placeholder="请输入题目类别名称进行搜索，可以直接回车搜索" prefix-icon="el-icon-search"
                size="small"
                clearable
                @clear="initCategories"
                style="width: 350px;margin-right: 10px" v-model="query.name"
                @keydown.enter.native="initCategories" ></el-input>
      <el-button icon="el-icon-search" v-if=isSearchShow type="primary" @click="initCategories"  size="small">
        搜索
      </el-button>
      <el-button type="primary" icon="el-icon-circle-plus-outline" v-if="isAddShow" size="small" plain @click="addCategory">新增</el-button>
      <el-button type="danger" icon="el-icon-remove-outline" v-if="isDeletesShow" size="small" plain @click="deleteCategories">删除</el-button>
    </div>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        prop="name"
        label="题目类别"
        width="160">
      </el-table-column>
      <el-table-column
        prop="updatedTime"
        label="更新时间"
        width="190">
      </el-table-column>
      <el-table-column
        prop="status"
        label="状态"
        width="140"
        >
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status==1">已启用</el-tag>
          <el-tag v-if="scope.row.status==0">未启用</el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="remark"
        label="备注信息"
        width="210"
        >
      </el-table-column>
      <el-table-column
        label="操作"
        show-overflow-tooltip>
        <template slot-scope="scope">
          <el-button @click="updateCategory(scope.row)" v-if="isUpdateShow" style="padding: 3px" size="medium" type="info" plain>修改</el-button>
          <el-button @click="deleteCategory(scope.row)" v-if="isDeletesShow" style="padding: 3px" size="medium" type="danger" plain>删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @current-change="initCategories"
      :current-page.sync="query.pageNum"
      :page-size="query.pageSize"
      layout="total, prev, pager, next, jumper"
      :total="totalNum">
    </el-pagination>
  </el-card>
  <el-dialog
    :title="title"
    :visible.sync="dialogVisible"
    width="40%">
    <div>
      <el-form :model="category" :rules="rules" ref="categoryForm" label-width="80px">
          <el-form-item label="父类别">
            <el-select v-model="category.parentId" placeholder="请选择父类别">
              <el-option
                v-for="item in options"
                :key="item.id"
                :label="item.name"
                :value="item.id">
              </el-option>
            </el-select>
            <!--<el-input size="medium" style="width: 150px" prefix-icon="el-icon-edit" v-model="category.parentId"
                      placeholder="请输入父类别"></el-input>-->
          </el-form-item>
            <el-form-item label="题目类别" prop="name">
              <el-input size="medium" style="width: 150px" prefix-icon="el-icon-edit" v-model="category.name"
                        placeholder="请输入题目类别"></el-input>
            </el-form-item>
          <el-form-item label="是否启用">
            <el-radio v-model="category.status" label="1" border>是</el-radio>
            <el-radio v-model="category.status" label="0" border>否</el-radio>
            <!--<el-switch
              v-model="category.status"
              active-value=1
              inactive-value=0
              active-color="#13ce66"
              inactive-color="#ff4949">
            </el-switch>-->
          </el-form-item>
          <el-form-item label="备注信息">
            <el-input
              style="width: 80%"
              v-model="category.remark"
              type="textarea"
              :rows="2"
              placeholder="请输入备注"
            >
            </el-input>
          </el-form-item>
      </el-form>
    </div>
    <span slot="footer" class="dialog-footer">
      <el-button @click="cancel">取 消</el-button>
      <el-button type="primary" @click="doAdd">确 定</el-button>
    </span>
  </el-dialog>
</div>
</template>

<script>
  /*import {
    addCategory,
    batchDeleteCategory,
    initCategories, queryCategoryList,
    queryListWithId,
    queryTree,
    updateCategory
  } from "../../api/basedata";*/
  import * as basedata from '../../api/basedata'
export default {
  name: 'Category',
  data() {
    return {
      isUpdateShow: true,
      isDeletesShow: true,
      isSearchShow: true,
      isAddShow: true,
      data:[],
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      tableData: [],
      multipleSelection: [],

      title:"",
      dialogVisible: false,
      rules: {
        name: [{required: true, message: '请输入题目类别名称', trigger: 'blur'}],
      },
      category: {
        id:null,
        parentId:null,
        name: "",
        status:"1",
        remark:"",
        createdBy:null,
        orgId:null,
        updatedBy:null,
        version:null,
      },
      options: [],
      query:{
        name:"",
        pageNum:1,
        pageSize:10,
      },
      totalNum:0,

    }
  },
  created() {
    this.queryParam()
  },
  mounted() {
    this.initCategories();
    this.queryTree();
    this.queryCategoryList()
  },
  methods: {
    async queryParam(){
      const { resources } = await this.$store.dispatch('user/getInfo')
      if (resources.indexOf('1000601') === -1) {
        this.isAddShow = false
      }
      if (resources.indexOf('1000602') === -1) {
        this.isDeletesShow = false
      }
      if (resources.indexOf('1000603') === -1) {
        this.isSearchShow = false
      }
      if (resources.indexOf('1000607') === -1) {
        this.isUpdateShow = false
      }
    },
    queryCategoryList(){
      basedata.queryCategoryList( {}
      ).then(resp => {
        this.options=resp.data.body;
      })
    },
    queryTree() {
      basedata.queryTree({}
      ).then(resp => {
        this.data=resp.data.body;
      })
    },
    initCategories(){
      basedata.initCategories(
          this.query
      ).then(resp => {
          this.tableData=resp.data.body.list;
          this.totalNum=resp.data.body.total;
        })
    },
    handleNodeClick(data) {
      basedata.queryListWithId( {
          id:data.id
        }
      ).then(resp => {
        this.tableData=resp.data.body;
        //this.totalNum=resp.body.total;
        this.totalNum=this.tableData.length;
      })
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      //this.multipleSelection=this.multipleSelection.map(item=>{id:item.id,version:item.version})
    },
    search(){

    },
    addCategory(){
      this.empty();
      this.title = '新增题目类别';
      this.dialogVisible = true;
    },
    updateCategory(data){
      //console.log(data);
      this.title="修改题目类别";
      //this.category=data;
      this.category=JSON.parse(JSON.stringify(data));
      this.dialogVisible=true;
    },
    empty() {
      this.category = {
        id:null,
        parentId:null,
        name: "",
        status:"1",
        remark:"",
        createdBy:null,
        orgId:null,
        updatedBy:null,
        version:null,
      }
    },
    /*doUpdate(){
      this.$refs['categoryForm'].validate(valid => {
        if (valid) {
        basedata.updateCategory(
          this.category
          )
            .then(resp => {
              this.$notify({
                title: "成功",
                message: "题目类别修改成功",
                type: "success",
                duration: 1500
              });
              //this.loadCategories();
              this.dialogVisible = false;
            })
            .catch(() => {
              this.$message({
                type: "error",
                message: "题目类别修改失败",
                duration: 1000
              });
            });
        }
      })
    },*/
    doAdd(){
      if(this.category.id==null) {
        this.$refs['categoryForm'].validate(valid => {
          if (valid) {
            basedata.addCategory(
                this.category
            ).then(resp => {
              this.initCategories();
              this.queryTree();
              this.queryCategoryList();
              this.$notify({
                title: "成功",
                message: "题目类别添加成功",
                type: "success",
                duration: 1500
              });
              //this.loadCategories();
              this.dialogVisible = false;
            }).catch(() => {
              this.$message({
                type: "error",
                message: "题目类别添加失败",
                duration: 1000
              });
            });
          }
        });
      }else{
        this.$refs['categoryForm'].validate(valid => {
          if (valid) {
            basedata.updateCategory(
              this.category
            )
              .then(resp => {
                this.initCategories();
                this.queryTree();
                this.queryCategoryList();
                this.$notify({
                  title: "成功",
                  message: "题目类别修改成功",
                  type: "success",
                  duration: 1500
                });
                //this.loadCategories();
                this.dialogVisible = false;
              })
              .catch(() => {
                this.$message({
                  type: "error",
                  message: "题目类别修改失败",
                  duration: 1000
                });
              });
          }
        })
      }
    },
    deleteCategories(){
      if(this.multipleSelection.length<1){
        this.$message({
          type: 'info',
          message: '未选中数据'
        });
      }else{
        this.$confirm('此操作将永久删除【' + this.multipleSelection.length + '】条数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          basedata.batchDeleteCategory(
            this.multipleSelection
          ).then(resp => {
            if (resp) {
              this.initCategories();
              this.queryTree();
              this.queryCategoryList();
              //this.initEmps();
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      }
    },
    deleteCategory(data){
      this.$confirm('此操作将永久删除所选中的【' + data.name + '】条数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        basedata.batchDeleteCategory(
          [
            {
              id: data.id,
              version: data.version
            }
          ]
        ).then(resp => {
          if (resp) {
            this.initCategories();
            this.queryTree();
            this.queryCategoryList();
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },
    cancel(){
      //initCategories();
      this.dialogVisible = false;
    }
  }
}
</script>

<style scoped>
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    margin-top: 30px;
    margin-left: 30px;
    width: 21%;
    float: left;
  }

  .righttable{
    float: right;
    width: 72%;
    margin-top: 30px;
    margin-right: 30px;
  }
</style>
