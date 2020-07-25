<template>
    <div class="app-container">
        <div>
            <div class="group">
                <div class="group-item">
                    <label for="publish-input">发布人</label>
                    <el-input id="publish-input" class="input-item" v-model="form.publisher"></el-input>
                </div>
                <div class="group-item">
                    <label for="publish-from-data">发布时间（from）</label>
                    <el-date-picker
                        v-model="form.publishStartTime"
                        type="datetime"
                        placeholder="选择日期时间"
                        id="publish-from-data"
                        class="input-item"
                    ></el-date-picker>
                </div>
                <div class="group-item">
                    <label for="publish-to-data">发布时间（to）</label>
                    <el-date-picker
                        v-model="form.publishEndTime"
                        type="datetime"
                        placeholder="选择日期时间"
                        id="publish-to-data"
                        class="input-item"
                    ></el-date-picker>
                </div>
            </div>
            <div class="group line">
                <div class="group-item">
                    <label for="exam-name">考试标题</label>
                    <el-input id="exam-name" class="input-item" v-model="form.title"></el-input>
                </div>
                <div class="group-item">
                    <label for="exam-from-data">考试时间（from）</label>
                    <el-date-picker
                        v-model="form.examStartTime"
                        type="datetime"
                        placeholder="选择日期时间"
                        id="exam-from-data"
                        class="input-item"
                    ></el-date-picker>
                </div>

                <div class="group-item">
                    <label for="exam-to-data">考试时间（to）</label>
                    <el-date-picker
                        v-model="form.examEndTime"
                        type="datetime"
                        placeholder="选择日期时间"
                        id="exam-to-data"
                        class="input-item"
                    ></el-date-picker>
                </div>
            </div>
            <div class="group line">
                <el-button
                    type="primary"
                    size="small"
                    v-if="isQuery"
                    @click.native="queryArray(1)"
                >查询</el-button>
            </div>
        </div>

        <el-card class="list-view">
            <div class="opt-borad">
                <el-button
                    type="primary"
                    icon="el-icon-circle-plus"
                    v-if="isAdd"
                    @click="addDialogFormVisible=true;getSelectors()"
                >增加</el-button>
            </div>
            <el-table :data="tableData" border style="width: 100%" @select="selectChange">
                <el-table-column fixed type="selection" width="55"></el-table-column>

                <el-table-column
                    prop="title"
                    label="考试标题"
                    sortable
                    :sort-orders="['ascending', 'descending']"
                    width="150"
                ></el-table-column>

                <el-table-column
                    prop="examNo"
                    label="场次号"
                    sortable
                    :sort-orders="['ascending', 'descending']"
                    width="120"
                ></el-table-column>
                <el-table-column prop="planPepoleNum" label="计划考试人数" width="120"></el-table-column>
                <el-table-column prop="endTime" label="考试截止时间" width="150"></el-table-column>

                <el-table-column prop="limitTime" label="考试时长" width="150"></el-table-column>

                <el-table-column prop="publishName" label="发布人" width="120"></el-table-column>
                <el-table-column prop="examiner" label="阅卷人" width="120"></el-table-column>
                <el-table-column prop="createdTime" label="发布时间" width="150"></el-table-column>

                <el-table-column prop="status" label="状态" width="120"></el-table-column>

                <el-table-column fixed="right" label="操作" width="180">
                    <template slot-scope="scope">
                        <el-button
                            type="primary"
                            v-if="isQrcode"
                            icon="el-icon-s-grid"
                            size="small"
                            class="line-opt"
                            @click.native="handleQRcode(scope.$index, scope.row)"
                        ></el-button>
                        <el-button
                            type="primary"
                            v-if="isEdit"
                            icon="el-icon-edit"
                            size="small"
                            class="line-opt"
                            @click="handleUpdateOne(scope.$index,scope.row);getSelectors()"
                        ></el-button>
                        <el-button
                            type="danger"
                            v-if="isDelete"
                            icon="el-icon-delete"
                            size="small"
                            class="line-opt"
                            @click.native="handleDelete(scope.$index, scope.row)"
                        ></el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>

        <el-dialog title="发布考试" :visible.sync="addDialogFormVisible">
            <el-form :model="addForm" :rules="rules">
                <el-form-item label="考试标题" :label-width="formLabelWidth" prop="title">
                    <el-input v-model="addForm.title" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="计划考试人数" :label-width="formLabelWidth" prop="planPepoleNum">
                    <el-input v-model="addForm.planPepoleNum" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="考试开始时间" :label-width="formLabelWidth" prop="StartTime">
                    <el-date-picker
                        v-model="addForm.StartTime"
                        type="datetime"
                        placeholder="选择日期时间"
                    ></el-date-picker>
                </el-form-item>
                <el-form-item label="考试截止时间" :label-width="formLabelWidth" prop="EndTime">
                    <el-date-picker v-model="addForm.EndTime" type="datetime" placeholder="选择日期时间"></el-date-picker>
                </el-form-item>
                <el-form-item label="考试时长" :label-width="formLabelWidth" prop="limitTime">
                    <el-input v-model="addForm.limitTime"></el-input>
                </el-form-item>
                <el-form-item label="考试说明" :label-width="formLabelWidth" prop="descript">
                    <el-input v-model="addForm.descript"></el-input>
                </el-form-item>
                <el-form-item label="阅卷方式" :label-width="formLabelWidth" prop="method">
                    <el-select v-model="addForm.method" placeholder="请选择">
                        <el-option label="平均分配" value="1"></el-option>
                        <el-option label="随机分配" value="2"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="选择阅卷官" :label-width="formLabelWidth" prop="examiner">
                    <el-select v-model="updateForm.examiner" placeholder="请选择">
                        <el-option
                            v-for="item in examiners"
                            :key="item.id"
                            :label="item.name"
                            :value="item.id"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="选择试卷" :label-width="formLabelWidth" prop="paperId">
                    <el-select v-model="updateForm.paperId" placeholder="请选择">
                        <el-option
                            v-for="item in papers"
                            :key="item.id"
                            :label="item.name"
                            :value="item.id"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="阅卷截止时间" :label-width="formLabelWidth" prop="markingStopTime">
                    <el-date-picker
                        v-model="addForm.markingStopTime"
                        type="datetime"
                        placeholder="选择日期时间"
                    ></el-date-picker>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addDialogFormVisible = false">取 消</el-button>
                <el-button
                    v-if="isAddSave"
                    type="primary"
                    @click="addItem();addDialogFormVisible=false"
                >保 存</el-button>
            </div>
        </el-dialog>

        <el-dialog title="扫码考试" :visible.sync="qrCodeDialogVisible">
            <QRcodeComponent :value="qrUrl" :size="300" level="H"></QRcodeComponent>
        </el-dialog>
        <el-dialog title="编辑考试" :visible.sync="updateDialogFormVisible">
            <el-form :model="updateForm" :rules="rules">
                <el-form-item label="考试标题" :label-width="formLabelWidth" prop="title">
                    <el-input v-model="updateForm.title" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="计划考试人数" :label-width="formLabelWidth" prop="planPepoleNum">
                    <el-input v-model="updateForm.planPepoleNum" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="考试开始时间" :label-width="formLabelWidth" prop="StartTime">
                    <el-date-picker
                        v-model="updateForm.StartTime"
                        type="datetime"
                        placeholder="选择日期时间"
                    ></el-date-picker>
                </el-form-item>
                <el-form-item label="考试截止时间" :label-width="formLabelWidth" prop="EndTime">
                    <el-date-picker
                        v-model="updateForm.EndTime"
                        type="datetime"
                        placeholder="选择日期时间"
                    ></el-date-picker>
                </el-form-item>
                <el-form-item label="考试时长" :label-width="formLabelWidth" prop="limitTime">
                    <el-input v-model="updateForm.limitTime"></el-input>
                </el-form-item>
                <el-form-item label="考试说明" :label-width="formLabelWidth" prop="descript">
                    <el-input v-model="updateForm.descript"></el-input>
                </el-form-item>
                <el-form-item label="阅卷方式" :label-width="formLabelWidth" prop="method">
                    <el-select v-model="addForm.method" placeholder="请选择">
                        <el-option label="平均分配" value="1"></el-option>
                        <el-option label="随机分配" value="2"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="选择阅卷官" :label-width="formLabelWidth" prop="examiner">
                    <el-select v-model="updateForm.examiner" placeholder="请选择">
                        <el-option
                            v-for="item in examiners"
                            :key="item.id"
                            :label="item.name"
                            :value="item.id"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="选择试卷" :label-width="formLabelWidth" prop="paperId">
                    <el-select v-model="updateForm.paperId" placeholder="请选择">
                        <el-option
                            v-for="item in papers"
                            :key="item.id"
                            :label="item.name"
                            :value="item.id"
                        ></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="阅卷截止时间" :label-width="formLabelWidth" prop="markingStopTime">
                    <el-date-picker
                        v-model="updateForm.markingStopTime"
                        type="datetime"
                        placeholder="选择日期时间"
                    ></el-date-picker>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="updateDialogFormVisible = false">取 消</el-button>
                <el-button
                    v-if="isEditSave"
                    type="primary"
                    @click="updateItem();updateDialogFormVisible=false"
                >保 存</el-button>
            </div>
        </el-dialog>
        <div class="opt-group">
            <el-button v-if="isPre" type="primary" @click.native="handlePre">前一页</el-button>
            <el-button
                v-for="i in pageNum"
                v-if="isPage"
                :key="i"
                @click="fetchAllData(i)"
                :class="{ active: curPage === i }"
            >{{i}}</el-button>
            <el-button v-if="isNext" type="primary" @click.native="handleNext">后一页</el-button>
        </div>
    </div>
</template>

<script>
import { format } from "@/utils/dateTool";
import { getUserId, getCompanyId, getOrganizationId } from "@/utils/userInfo";
import { parseTime } from '@/utils'
import FilenameOption from './components/FilenameOption'
import AutoWidthOption from './components/AutoWidthOption'
import BookTypeOption from './components/BookTypeOption'
import QRcodeComponent from 'qrcode.vue';

export default {
    name: 'exam-publish',
    components: { FilenameOption, AutoWidthOption, BookTypeOption, QRcodeComponent },
    data() {
        return {
            isPage: true,
            isPre: true,
            isNext: true,
            isEditSave: true,
            isAddSave: true,
            isQrcode: true,
            isEdit: true,
            isDelete: true,
            isAdd: true,
            isQuery: true,
            userId: getUserId,
            examiners: [],
            papers: [],
            list: null,
            listLoading: true,
            downloadLoading: false,
            autoWidth: true,
            bookType: 'xlsx',
            addDialogFormVisible: false,
            paperDialogFromVisible: false,
            qsDialogFromVisible: false,
            updateDialogFormVisible: false,
            qrCodeDialogVisible: false,
            model: "",
            form: {
                publisher: "",
                publishStartTime: "",
                publishEndTime: "",
                examStartTime: "",
                examEndTime: "",
                title: ""
            },
            qrUrl: "",
            addForm: {
                descript: "",
                method: "",
                StartTime: "",
                EndTime: "",
                title: "",
                planPepoleNum: "",
                limitTime: "",
                examiner: 1,
                markingStopTime: "",
                paperId: 1,
                status: 1,
                examPublishRecordId: ""
            },
            updateForm: {
                descript: "",
                method: "",
                StartTime: "",
                EndTime: "",
                title: "",
                planPepoleNum: "",
                limitTime: "",
                examiner: 1,
                markingStopTime: "",
                paperId: "",
                status: 1,
                examPublishRecordId: ""
            },
            rules: {
                title: [
                    { required: true, message: '请输入考试标题', trigger: 'blur' },
                    { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                descript: [
                    { required: true, message: '请输入考试说明', trigger: 'blur' }
                ],
                StartTime: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                EndTime: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                markingStopTime: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                planPepoleNum: [
                    { required: true, message: '请填写计划考试人数', trigger: 'blur' }
                ],
                examiner: [
                    { required: true, message: '请选择阅卷官', trigger: 'blur' }
                ],
                paperId: [
                    { required: true, message: '请选择试卷', trigger: 'blur' }
                ],
                limitTime: [
                    { required: true, message: '请填写考试时长', trigger: 'blur' }
                ],
                method: [
                    { required: true, message: '请选择阅卷方式', trigger: 'blur' }
                ]
            },
            curVal: null,
            formLabelWidth: '120px',
            tableData: [],
            options: {
                a: 'a',
                b: 'b'
            },
            curPage: 1,
            hasprePage: false,
            hasnextPage: false,
            pageNum: 0
        }
    },
    computed: {},
    created() {
        this.queryParam();
        this.fetchAllData(0);
    },
    methods: {
        async queryParam() {
            const { resources } = await this.$store.dispatch('user/getInfo')
            if (resources.indexOf('100802') === -1) {
                this.isPage = false;
                this.isPre = false;
                this.isNext = false;
            }
            if (resources.indexOf('100805') === -1) {
                this.isEditSave = false
            }
            if (resources.indexOf('100801') === -1) {
                this.isAddSave = false
            }
            if (resources.indexOf('100823') === -1 && resources.indexOf('100822') === -1) {
                this.isEdit = false
            }
            if (resources.indexOf('100807') === -1) {
                this.isQrcode = false
            }
            if (resources.indexOf('100804') === -1) {
                this.isDelete = false
            }
            if (resources.indexOf('100822') === -1 && resources.indexOf('100823') === -1) {
                this.isAdd = false
            }
            if (resources.indexOf('100803') === -1) {
                this.isQuery = false
            }
        },
        handleQRcode(index, info) {
            var id = this.tableData[index].id;
            this.qrCodeDialogVisible = true;
            //TODO: 改成 发布的url 现在这个肯定不行
            this.qrUrl = encodeURI(`http://112.124.27.214/#/mobileLogin?examPublishRecordId=${id}&startTime=${info.startTime}&endTime=${info.endTime}&limitTime=${info.limitTime}`);

        },
        handleUpdateOne(index, row) {
            this.updateForm.publisher = row.publisher;
            this.updateForm.title = row.title
            this.updateForm.planPepoleNum = row.planPepoleNum
            this.updateForm.StartTime = row.createdTime
            this.updateForm.EndTime = row.endTime
            this.updateForm.limitTime = row.limitTime
            this.updateForm.markingStopTime = this.tableData[index].markingStopTime

            this.updateForm.descript = this.tableData[index].descript
            // this.updateForm.examiner = row.examiner;
            this.updateForm.examPublishRecordId = this.tableData[index].id;
            this.updateDialogFormVisible = true;
        },
        async getSelectors() {

            var config = {
                method: 'post',
                url: '/education/bes/v1/boss-bes-exam-center/publish/examiner',
                headers: {}
            };
            let list1 = await axios(config)
                .then(function (response) {
                    return (response.data);
                })
                .catch(function (error) {
                    console.log(error);
                });
            this.examiners = list1;

            var config1 = {
                method: 'post',
                url: '/education/bes/v1/boss-bes-exam-center/publish/paper',
                headers: {}
            };

            let list2 = await axios(config1)
                .then(function (response) {
                    return (response.data);
                })
                .catch(function (error) {
                    console.log(error);
                });
            this.papers = list2;

        },
        async fetchAllData(page) {
            this.model = "";
            var data = { "pageNo": page };
            var config = {
                method: 'post',
                url: `/education/bes/v1/boss-bes-exam-center/publish/queryAll`,
                headers: {
                    'Content-Type': 'application/json',
                },
                data: data
            };

            let dataList = await axios(config)
                .then(function (response) {
                    return (response.data.body);
                })
                .catch(function (error) {
                    console.log(error);
                });
            this.hasprePage = !dataList.isFirstPage;
            this.hasnextPage = !dataList.isLastPage;
            this.tableData = dataList.list;
            this.pageNum = dataList.navigatePages;
        },
        addItem() {
            var data = {
                "publisher": this.userId,
                "descript": this.addForm.descript,
                "method": this.addForm.method,
                "startTime": format(this.addForm.StartTime, 'yyyy-MM-dd HH:mm:ss'),
                "endTime": format(this.addForm.EndTime, 'yyyy-MM-dd HH:mm:ss'),
                "title": this.addForm.title,
                "planPepoleNum": this.addForm.planPepoleNum,
                "limitTime": this.addForm.limitTime,
                "examiner": this.addForm.examiner,
                "markingStopTime": format(this.addForm.markingStopTime, 'yyyy-MM-dd HH:mm:ss'),
                "paperId": this.addForm.paperId,
                "status": this.addForm.status,
                "examPublishRecordId": this.addForm.examPublishRecordId
            };

            var config = {
                method: 'post',
                url: '/education/bes/v1/boss-bes-exam-center/publish/save',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data
            };
            const _this = this;
            axios(config)
                .then(function (response) {
                    if (response.data.body == false) {
                        alert("发布失败");
                    } else {
                        alert("发布成功");
                        _this.fetchAllData(1);
                    }
                    console.log(response.data);
                })
                .catch(function (error) {
                    console.log(error);
                });

        },
        async queryArray(page) {
            this.model = "qq";
            var data = {
                "publisher": this.form.publisher,
                "publishStartTime": this.form.publishStartTime,
                "publishEndTime": this.form.publishEndTime,
                "examStartTime": this.form.examStartTime,
                "examEndTime": this.form.examEndTime,
                "title": this.form.title
            };

            var config = {
                method: 'post',
                url: `/education/bes/v1/boss-bes-exam-center/publish/query`,
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data
            };

            let dataList = await axios(config)
                .then(function (response) {
                    return (response.data.body);
                })
                .catch(function (error) {
                    console.log(error);
                });
            console.log("datalist");
            console.log(dataList);
            this.hasprePage = !dataList.isFirstPage;
            this.hasnextPage = !dataList.isLastPage;
            this.tableData = dataList.list;
            this.pageNum = dataList.navigatePages;
        },
        updateItem() {
            var data = {
                "title": this.updateForm.title,
                "planPepoleNum": this.updateForm.planPepoleNum,
                "startTime": this.updateForm.StartTime,
                "endTime": this.updateForm.EndTime,
                "limitTime": this.updateForm.limitTime,
                "descript": this.updateForm.descript,
                "method": this.updateForm.method,
                "examiner": this.updateForm.examiner,
                "markingStopTime": this.updateForm.markingStopTim,
                "paperId": this.updateForm.paperId,
                "status": this.updateForm.status,
                "examPublishRecordId": this.updateForm.examPublishRecordId,
                "publisher": this.userId,

            };

            var config = {
                method: 'put',
                url: '/education/bes/v1/boss-bes-exam-center/publish/update',
                headers: {
                    'Content-Type': 'application/json'
                },
                data: data
            };
            var _this = this;
            axios(config)
                .then(function (response) {
                    if (response.data.body == false) {
                        alert("更新失败");
                    } else {
                        alert("更新成功");
                        _this.fetchAllData(1);
                    }
                    console.log(response);

                })
                .catch(function (error) {
                    console.log(error);
                });

        },//函数用来修改信息 同上
        selectChange(val) {
            this.curVal = val;
            val[0] ? this.curVal = val[0] : null;
        },
        handlePre() {
            this.curPage--;
            this.model === 'qq' ? this.queryArray(this.curPage) : this.fetchAllData(this.curPage);
        },
        handleNext() {
            console.log('next');
            this.curPage++;
            this.model === 'qq' ? this.queryArray(this.curPage) : this.fetchAllData(this.curPage);
        },
        handleDelete(index, info) {
            var _this = this;
            this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                axios.delete('/education/bes/v1/boss-bes-exam-center/publish/delete',
                    {
                        data: {
                            "id": this.tableData[index].id
                        }
                    }
                ).then(function (response) {
                    console.log("删除了没？")
                    console.log(response)
                    if (response.data.body == false) {
                        _this.$message({
                            type: 'success',
                            message: '使用中，删除失败!'
                        });
                    } else {
                        _this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                    }

                }).catch(function (error) {
                    console.log(error)
                });
                this.fetchAllData(1);
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });

        }

    }
}
</script>

<style>
.radio-label {
    font-size: 14px;
    color: #606266;
    line-height: 40px;
    padding: 0 12px 0 30px;
}

.group {
    display: flex;
    justify-content: space-between;
}

.input-item {
    padding-left: 6px;
    width: 180px;
    height: 36px;
}

.line {
    margin: 20px 0;
}

.main-list {
    margin-top: 10px;
}

.line-opt {
    display: inline-block;
}

.opt-borad {
    margin-bottom: 10px;
}

.active {
    background: #0a76a4;
}
</style>
