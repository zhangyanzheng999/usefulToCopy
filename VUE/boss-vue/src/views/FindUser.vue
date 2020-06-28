<template>
    <div>
        <el-table :data="tableData" border style="width: 30%">
            <el-table-column fixed prop="id" label="编号" width="50"></el-table-column>
            <el-table-column fixed prop="name" label="姓名" width="120"></el-table-column>
            <el-table-column fixed prop="code" label="用户名" width="100"></el-table-column>
            <el-table-column fixed="right" label="操作" width="100">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteUser(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
            background
            layout="prev, pager, next"
            :page-size="5"
            :total="total"
            @current-change="page"
        ></el-pagination>
    </div>
</template>

<script>
export default {
    inject: ['reload'], //注入
    methods: {
        edit(row) {
            this.$router.push({
                path: '/UpdateUser',
                query: {
                    id: row.id
                }
            })
        },
        deleteUser(row) {
            axios
                .delete('http://localhost:8181/user/deleteById/' + row.id)
                .then(() => {
                    this.$alert(row.name + '---->删除成功', '消息', {
                        confirmButtonText: '确定',
                        callback: () => {
                            this.reload()
                        }
                    })
                })
        },
        page(currentpage) {
            axios
                .get('http://localhost:8181/user/findAll/' + currentpage + '/5')
                .then(resp => {
                    this.tableData = resp.data.content
                    this.total = resp.data.totalElements
                })
        }
    },
    created() {
        axios.get('http://localhost:8181/user/findAll/1/5').then(resp => {
            this.tableData = resp.data.content
            this.total = resp.data.totalElements
        })
    },
    data() {
        return {
            total: null,
            tableData: null
        }
    }
}
</script>