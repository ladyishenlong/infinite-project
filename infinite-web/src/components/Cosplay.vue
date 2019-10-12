<template>

  <div>

    <el-row :gutter="20">

      <div v-for=" modelItem in cosplayModels">

        <el-col :md="6">
          <el-card class="box-card">

            <el-image
              style="width: 200px;height:200px"
              fit="cover"
              :preview-src-list="modelItem.pics"
              :src="modelItem.cover" lazy></el-image>

            <div>{{modelItem.setname}}</div>

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
