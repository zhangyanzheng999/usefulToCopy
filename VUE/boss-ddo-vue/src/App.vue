<template>
    <div>
        <router-view v-if="isRouterAlive"></router-view>
    </div>
</template>

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
        //刷新
        reload() {
            this.isRouterAlive = false
            this.$nextTick(function () {
                this.isRouterAlive = true
            })
        }
    }
}
</script>

<style>

</style>
