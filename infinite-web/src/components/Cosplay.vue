<template>

  <div><button class="primary" @click="cosplay">请求测试</button></div>

</template>

<script>
  export default {
    name: "Cosplay",
    data(){
      isoyuModel:{
        
      }
    },
    methods: {
      cosplay(){
        this.axios.get('/isoyu/cosplay/10')
          .then((result)=>{
            console.log(JSON.stringify(result.data))
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
