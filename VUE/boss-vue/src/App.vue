<template>
    <div>
        <router-view v-if="isRouterAlive"></router-view>
    </div>
</template>

<style>
.el-header {
    background-color: #b3c0d1;
    color: #333;
    line-height: 60px;
}

.el-aside {
    color: #333;
}
</style>

<script>
export default {
    data() {

        return {
            isRouterAlive: true
        }
    },
    provide() {
        return {
            reload: this.reload
        }
    },
    methods: {
        //刷新方法
        reload() {
            this.isRouterAlive = false
            this.$nextTick(function () {
                this.isRouterAlive = true
            })
        }
    }
}
</script>