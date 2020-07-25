<template>
<div>
  <el-card class="middle">
    <div slot="header" class="clearfix">
      组卷配置项名称
      <el-input placeholder="请输入组卷配置项名称"
                  size="small"
                  clearable
                  @clear="initCombExamConfigs"
                  style="width: 150px;margin-right: 10px" v-model="query.name"></el-input>
      <el-button v-if="isSearchShow" icon="el-icon-search" type="primary" @click="initCombExamConfigs"  size="small">
        搜索
      </el-button>
      <el-button type="primary" v-if="isAddShow" icon="el-icon-circle-plus-outline" size="small" plain @click="add">新增</el-button>
      <el-button type="danger" v-if="isDeletesShow" icon="el-icon-remove-outline" size="small" plain @click="deleteCombs">删除</el-button>
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
        label="配置项"
        width="130">
      </el-table-column>
      <el-table-column
        prop="totalDifficultName"
        label="难度"
        width="170">
      </el-table-column>
      <el-table-column
        prop="updatedTime"
        label="更新时间"
        width="190">
      </el-table-column>
      <el-table-column
        prop="status"
        label="状态"
        width="150"
      >
        <template slot-scope="scope">
          <el-tag v-if="scope.row.status=='1'">已启用</el-tag>
          <el-tag v-if="scope.row.status=='0'">未启用</el-tag>
        </template>
      </el-table-column>
      <!--<el-table-column
        prop="companyName"
        label="公司名称"
        width="170"
      >
      </el-table-column>-->
      <el-table-column
        prop="remark"
        label="备注信息"
        width="260"
      >
      </el-table-column>

      <el-table-column
        label="操作"
        show-overflow-tooltip>
        <template slot-scope="scope">
          <el-button v-if="isUpdateShow" @click="updateCombExamConfig(scope.row)" style="padding: 3px" size="medium" type="info" plain>修改</el-button>
          <el-button v-if="isDeletesShow" @click="deleteComb(scope.row)" style="padding: 3px" size="medium" type="danger" plain>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @current-change="initSubjects"
      :current-page.sync="query.pageNum"
      :page-size="query.pageSize"
      layout="total, prev, pager, next, jumper"
      :total="totalNum">
    </el-pagination>
  </el-card>
  <el-dialog
    :title="title"
    :visible.sync="dialogVisible"
    width="68%">
    <div>
      <el-form :model="CombExamConfig" ref="CombExamConfigForm" label-width="90px" :inline="true" :rules="rules">
        <el-form-item label="配置项" prop="name">
          <el-input size="medium" style="width: 280px"  v-model="CombExamConfig.name" type="textarea" :rows="2" clearable
                    placeholder="请输入配置项名称"></el-input>
        </el-form-item>
        <el-form-item label="总难度" style="width: 500px" prop="totalDifficultId">
          <el-select v-model="CombExamConfig.totalDifficultId" placeholder="请选择总难度">
            <el-option
              v-for="item in totaldifficultoptions"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否启用" style="width: 370px ">
          <el-radio v-model="CombExamConfig.status" label="1" border>是</el-radio>
          <el-radio v-model="CombExamConfig.status" label="0" border>否</el-radio>
        </el-form-item>
        <el-form-item label="备注信息">
          <el-input
            style="width: 400px"
            type="textarea"
            :rows="3"
            placeholder="请输入备注信息"
            v-model="CombExamConfig.remark">
          </el-input>
        </el-form-item>
        <el-divider></el-divider>
        <el-form-item style="margin-left:128px;width:1500px">
          <el-tag type="success" style="margin-right:83px">题目类别</el-tag>
          <el-tag type="info" style="margin-right:83px">题目类型</el-tag>
          <el-tag type="warning" style="margin-right:81px">题目数量</el-tag>
          <el-tag type="danger" style="margin-right:83px">题目难度</el-tag>
          <el-tag>题目分值</el-tag>
        </el-form-item>
        <el-form-item
          v-for="(domain, index) in CombExamConfig.combExamConfigItemDTOList"
          :label="'配置明细' + index"
          :key="domain.key"
          :prop="'combExamConfigItemDTOList.' + index + '.answer'">
          <el-select v-model="domain.categoryId" placeholder="请选择题目类别" style="width: 150px;margin-right: 2px">
            <el-option
              v-for="item in subjectcategoryoptions"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
          <el-select v-model="domain.subjectTypeId" placeholder="请选择题目类型"  style="width: 150px;margin-right: 2px">
            <el-option
              v-for="item in subjecttypeoptions"
              :key="item.id"
              :label="item.subjectName"
              :value="item.id">
            </el-option>
          </el-select>
          <el-input size="medium" style="width: 150px;margin-right: 2px" prefix-icon="el-icon-edit" v-model="domain.num"
                    placeholder="请输入题目数量"  ></el-input>
          <el-select v-model="domain.difficult" placeholder="请选择题目难度" style="width: 150px;margin-right: 2px">
            <el-option
              v-for="item in difficultoptions"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
          <el-input size="medium" style="width: 150px;margin-right: 2px" prefix-icon="el-icon-edit" v-model="domain.score"
                    placeholder="请输入题目分值"  ></el-input>
          <el-button @click.prevent="removeDomain(domain)" type="danger" plain style="margin-left:10px">删除</el-button>
        </el-form-item>
        <el-form-item>
          <el-button @click="addDomain" type="primary" plain>新增配置项明细</el-button>
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
    addCombExamConfig,
    batchDeleteCombExamConfig, getSubjectTypeList,
    initCombExamConfig, queryCategoryList,
    updateCombExamConfig
  } from "../../api/basedata";*/
  import * as basedata from '../../api/basedata'
    export default {
      name: "CombExamConfig",
      data() {
        return {
          isSearchShow: true,
          isAddShow: true,
          isDeletesShow: true,
          isUpdateShow: true,
          rules: {
            name: [{required: true, message: '请输入配置项名称', trigger: 'blur'}],
            totalDifficultId: [
              {required: true, message: '请选择总难度', trigger: 'change'}
            ]
          },
          multipleSelection: [],
          query:{
            name:"",
            pageNum:1,
            pageSize:10,
          },
          tableData:[],
          totalNum:0,
          dialogVisible: false,
          totaldifficultoptions:[{
            id: '0',
            name: '简单'
          }, {
            id: '1',
            name: '中等'
          },{
            id: '2',
            name: '困难'
          }],
          subjecttypeoptions:[],
          subjectcategoryoptions:[],
          difficultoptions:[{
            id: '0',
            name: '简单'
          }, {
            id: '1',
            name: '中等'
          },{
            id: '2',
            name: '困难'
          }],


          CombExamConfig:{
            id:null,
            name:"",
            totalDifficultId:"",
            status:"1",
            remark:"",

            combExamConfigItemDTOList:[],

          }
        }
      },
      mounted() {
        //this.initSubjectTypeLists();
        this.initCombExamConfigs();
        this.queryCategoryList();
        this.initSubjectTypeLists();
      },
      created() {
        this.queryParam()
      },
      methods: {
        async queryParam(){
          const { resources } = await this.$store.dispatch('user/getInfo')
          if (resources.indexOf('1000619') === -1) {
            this.isAddShow = false
          }
          if (resources.indexOf('1000620') === -1) {
            this.isDeletesShow = false
          }
          if (resources.indexOf('100021') === -1) {
            this.isSearchShow = false
          }
          if (resources.indexOf('1000622') === -1) {
            this.isUpdateShow = false
          }
        },
        queryCategoryList(){
          basedata.queryCategoryList(
             {}
          ).then(resp => {
            this.subjectcategoryoptions=resp.data.body;
          })
        },
        initSubjectTypeLists(){
          basedata.getSubjectTypeList(
            {}
          ).then(resp => {
            this.subjecttypeoptions = resp.data.body;
          })
        },
        handleSelectionChange(val) {
          this.multipleSelection = val;
          //this.multipleSelection=this.multipleSelection.map(item=>{id:item.id,version:item.version})
        },
        deleteCombs(){
          if(this.multipleSelection.length<1){
            this.$message({
              type: 'info',
              message: '未选中数据'
            });
          }else {
            this.$confirm('此操作将永久删除【' + this.multipleSelection.length + '】条数据, 是否继续?', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
              basedata.batchDeleteCombExamConfig(
                 this.multipleSelection
              ).then(resp => {
                if (resp) {
                  this.initCombExamConfigs();
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
        deleteComb(data){
          this.$confirm('此操作将永久删除所选中的【' +data.name+ '】数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            basedata.batchDeleteCombExamConfig(
              [
                {
                  id: data.id,
                  version: data.version
                }
              ]
            ).then(resp => {
              if (resp) {
                this.initCombExamConfigs();
              }
            })
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            });
          });
        },
        updateCombExamConfig(data){
          this.title="修改配置项";
          this.CombExamConfig=JSON.parse(JSON.stringify(data));
          this.dialogVisible=true;
        },
        cancel(){
          this.dialogVisible = false;
        },
        removeDomain(item) {
          var index = this.CombExamConfig.combExamConfigItemDTOList.indexOf(item)
          if (index !== -1) {
            this.CombExamConfig.combExamConfigItemDTOList.splice(index, 1)
          }
        },
        addDomain() {
          this.CombExamConfig.combExamConfigItemDTOList.push({
            categoryId: "",
            difficult: "",
            num: null,
            score: null,
            subjectTypeId: "",
            key: Date.now()
          });
        },
        add(){
          this.empty();
          this.title = '新增配置项';
          this.dialogVisible = true;
        },
        doAdd(){
          if(this.CombExamConfig.id==null) {
            this.$refs['CombExamConfigForm'].validate(valid => {
              if (valid) {
                basedata.addCombExamConfig(
                  this.CombExamConfig
                ).then(resp => {
                  this.initCombExamConfigs();
                  this.$notify({
                    title: "成功",
                    message: "配置项添加成功",
                    type: "success",
                    duration: 1500
                  });
                  this.dialogVisible = false;
                }).catch(() => {
                  this.$message({
                    type: "error",
                    message: "配置项添加失败",
                    duration: 1000
                  });
                });
              }
            });
          }else{
            this.$refs['CombExamConfigForm'].validate(valid => {
              if (valid) {
                basedata.updateCombExamConfig(
                  this.CombExamConfig
                )
                  .then(resp => {
                    this.initCombExamConfigs();
                    this.$notify({
                      title: "成功",
                      message: "配置项修改成功",
                      type: "success",
                      duration: 1500
                    });
                    this.dialogVisible = false;
                  })
                  .catch(() => {
                    this.$message({
                      type: "error",
                      message: "配置项修改失败",
                      duration: 1000
                    });
                  });
              }
            })
          }
        },
        initCombExamConfigs() {
          basedata.initCombExamConfig(
            this.query
          ).then(resp => {
            this.tableData = resp.data.body.list;
            this.totalNum = resp.data.body.total;
          })
        },
        empty() {
          this.CombExamConfig = {
            id:null,
            name:"",
            totalDifficultId:"",
            status:"1",
            remark:"",

            combExamConfigItemDTOList:[{
              categoryId: "",
              difficult: "",
              num: null,
              score: null,
              subjectTypeId: "",
              key: Date.now()
            }],
          }
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

  .middle{
    margin-left: 30px;
    margin-top: 30px;
    margin-right: 30px;
  }
</style>
