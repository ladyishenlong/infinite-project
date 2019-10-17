<template>
  <div id="app">


    <el-menu :default-active="activeIndex" mode="horizontal" @select="handleSelect">
      <el-menu-item index="home">首页</el-menu-item>
      <el-menu-item index="news">新闻</el-menu-item>
      <el-menu-item index="cosplay">图片</el-menu-item>
      <el-menu-item index="setting">设置</el-menu-item>
    </el-menu>


    <!--  路由页面内容  -->
    <router-view/>

  </div>
</template>

<script>
  export default {
    name: 'App',
    data() {
      return {
        activeIndex: "home"
      }
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key,keyPath);
        switch (key) {
          case "home":
            this.$router.replace("/");
            break;
          case "cosplay":
            this.$router.replace("/cosplayWeb");
            break;
        }
      }
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
</style>
