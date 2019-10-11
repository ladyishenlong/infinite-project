<template>

  <div><button class="primary" @click="cosplay">请求测试</button></div>

</template>

<script>
  export default {
    name: "Cosplay",
    methods: {
      cosplay(){
        this.axios.get('http://localhost:7000/isoyu/cosplay/10')
          .then((result)=>{
            console.log(JSON.stringify(result))
          })
          .catch((error)=>{
            console.log(error)
          })

      }
    }
  }
</script>

<style scoped>

</style>
