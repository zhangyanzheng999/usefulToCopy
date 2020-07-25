
<!--
 * @description: 抽取分页组件
 * @fileName: Pagination.vue
 * @author: 张彦征
 * @date: 2020-07-12 17:18:03
!-->
<template>
  <div>
    <!-- 分页 -->
    <el-pagination
      :current-page.sync="currentPage"
      :page-size.sync="pageSize"
      :layout="layout"
      :page-sizes="pageSizes"
      :total="total"
      v-bind="$attrs"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>
</template>

<script>

export default {
  name: 'Pagination',
  props: {
    limit: {
      type: Number,
      default: 5
    },
    total: {
      type: Number,
      default: 100
    },
    page: {
      type: Number,
      default: 1
    },
    pageSizes: {
      type: Array,
      default() {
        return [1, 5, 10, 20, 50]
      }
    },
    layout: {
      type: String,
      default: 'total, sizes, prev, pager, next, jumper'
    }
  },
  data() {
    return {

    }
  },
  // 监听属性 类似于data概念
  computed: {
    currentPage: {
      get() {
        return this.page
      },
      set(val) {
        this.$emit('update:page', val)
      }
    },
    pageSize: {
      get() {
        return this.limit
      },
      set(val) {
        this.$emit('update:limit', val)
      }
    }
  },
  // 生命周期 - 创建完成（可以访问当前this实例）
  created() {

  },
  // 方法集合
  methods: {
    /** 用来修改每页大小 */
    handleSizeChange(val) {
      this.$emit('pagination', { limit: val })
    },
    /** 用来翻页 */
    handleCurrentChange(val) {
      this.$emit('pagination', { page: val })
    }
  }

}
</script>
