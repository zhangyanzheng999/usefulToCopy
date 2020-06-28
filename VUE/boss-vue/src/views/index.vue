<!-- 主界面，避免App.vue套娃 -->
<template>
    <div>
        <el-container style="height: 500px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu router :default-openeds="['0']">
                    <el-submenu
                        v-for="(item,index) in $router.options.routes"
                        :key="item.path"
                        :index="index+''"
                    >
                        <template slot="title">
                            <em class="el-icon-message"></em>
                            {{item.name}}
                        </template>
                        <template v-for="(child) in item.children">
                            <el-menu-item
                                :key="child.path"
                                :index="child.path"
                                v-if="!child.hide"
                                :class="$route.path==child.path?'is-active':''"
                            >
                                <template slot="title">
                                    <em class="el-icon-message"></em>
                                    {{child.name}}
                                </template>
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {}
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {},
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {},
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() {},
    beforeCreate() {}, //生命周期 - 创建之前
    beforeMount() {}, //生命周期 - 挂载之前
    beforeUpdate() {}, //生命周期 - 更新之前
    updated() {
        //console.log(this.$route)
    }, //生命周期 - 更新之后
    beforeDestroy() {}, //生命周期 - 销毁之前
    destroyed() {}, //生命周期 - 销毁完成
    activated() {} //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style lang='scss' scoped>
//@import url(); 引入公共css类
</style>