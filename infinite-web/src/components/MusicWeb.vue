<template>
  <div>

    <el-divider content-position="left">音乐电台</el-divider>


    



    <el-divider content-position="left">排行榜</el-divider>

    <el-row>
      <div v-for="modelItem in MusicRankingsModels">
        <el-col :sm="8">

          <el-card class="box-card" style="margin: 10px">

            <div slot="header">
              <span>{{modelItem.name}}</span>
            </div>

            <div v-for="contentItem in modelItem.content">
              <el-row >

                <el-col :span="8">
                  <el-image
                    style="width: 100px;height:100px"
                    fit="cover"
                    :preview-src-list="contentItem.pic_big"
                    :src="contentItem.pic_small" lazy></el-image>
                </el-col>

                <el-col :span="16">
                  <div>{{  contentItem.title }}</div>
                  <div>{{  contentItem.album_title }}</div>
                  <div>{{  contentItem.author }}</div>
                </el-col>

              </el-row>
            </div>
          </el-card>

        </el-col>
      </div>
    </el-row>


  </div>
</template>

<script>
  export default {
    name: "MusicWeb",
    created() {
      this.musicRinks();
    },
    data() {
      return {
        isoyuModel: {
          code: 0,
          message: '',
          data: null
        },
        MusicRankingsModels: [],
        MusicRankingsModel: {
          pic_s210: "",
          bg_pic: "",
          color: "",
          pic_s444: "",
          count: "",
          type: "",
          content: [],
          bg_color: "",
          web_url: "",
          name: "",
          comment: "",
          pic_s192: "",
          pic_s260: ""
        },
        MusicRankingsContentModel: {
          all_rate: "",
          song_id: "",
          rank_change: "",
          biaoshi: "",
          author: "",
          album_id: "",
          pic_small: "",
          title: "",
          pic_big: "",
          album_title: ""
        }
      }
    },
    methods: {
      musicRinks() {
        this.axios.get("/apiopen/music/rankings")
          .then((result) => {
            this.isoyuModel = result.data;
            if (this.isoyuModel.code === 0) {
              this.MusicRankingsModels = this.isoyuModel.data;
            }
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
