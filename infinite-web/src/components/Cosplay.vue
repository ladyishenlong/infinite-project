<template>

  <div>

    <el-row :gutter="20">

      <div v-for=" modelItem in cosplayModels">
        <el-col :md="6">
          <el-card class="box-card">

            <div>
              <el-image 
                        :src="modelItem.cover" :fit="cover" lazy></el-image>
            </div>


            <!--            <div>{{modelItem.setid}}</div>-->
            <div>咸鱼不行</div>
          </el-card>
        </el-col>
      </div>

    </el-row>

    <ElButton class="primary" @click="cosplay">请求测试</ElButton>
  </div>

</template>

<script>
  export default {
    name: "Cosplay",
    data() {
      return {
        page: 10,
        isoyuModel: {
          code: 0,
          message: '',
          data: null
        },
        cosplayModels: [],
        cosplayModel: {
          postid: '',
          desc: '',
          pvnum: '',
          createdate: '',
          scover: '',
          setname: '',
          cover: '',
          pics: [],
          clientcover1: '',
          replynum: '',
          topicname: '',
          setid: '',
          seturl: '',
          datetime: '',
          clientcover: '',
          imgsum: '',
          tcover: ''
        }
      }
    },
    methods: {
      cosplay() {
        this.axios.get('/isoyu/cosplay/' + this.page)
          .then((result) => {
            this.isoyuModel = result.data;
            if (this.isoyuModel.code === 0) {
              //for循环加入数组
              this.isoyuModel.data.forEach(model => {
                this.cosplayModel = model;
                this.cosplayModels.push(this.cosplayModel);
              })
            } else console.log(this.isoyuModel.message)
          })
          .catch((error) => {
            console.log(error)
          })
      }
    }
  }
</script>

<style scoped>

</style>
