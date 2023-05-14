<template>
  <div id="container"></div>
</template>

<script>
import AMapLoader from '@amap/amap-jsapi-loader'
import { mapActions, mapState } from 'vuex'
window._AMapSecurityConfig = {
  securityJsCode: '0fd3c64b9c7aa608aa135be2ea649a74'
}
export default {
  data() {
    return {
      map: null,

    }
  },
  computed: {

  },
  methods: {
    initMap() {
      AMapLoader.load({
        key: "a04931e54da22b517670cfc8c9b746f4",             // 申请好的Web端开发者Key，首次调用 load 时必填
        version: "2.0",      // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
        plugins: ['AMap.ToolBar', 'AMap.Scale', 'AMap.HawkEye', 'AMap.MapType', 'AMap.Geolocation'],       // 需要使用的的插件列表，如比例尺'AMap.Scale'等
      }).then((AMap) => {


        this.map = new AMap.Map("container", {  //设置地图容器id
          viewMode: "3D",    //是否为3D地图模式
          zoom: 18,           //初始化地图级别
          // center: [116.405467, 39.907761], //初始化地图中心点位置
        });

        this.map.addControl(new AMap.Scale())
        this.map.addControl(new AMap.ToolBar())
        this.map.addControl(new AMap.HawkEye())
        this.map.addControl(new AMap.MapType())
        this.map.addControl(new AMap.Geolocation())

      }).catch(e => {
        console.log(e);
      })
    }


  },
  mounted() {
    // this.destroyMap()
    // DOM初始化完成进行地图初始化
    this.initMap()

  }


}
</script>

<style scoped>
#container {
  padding: 0px;
  margin: 0px;
  width: 100%;
  height: 100%;
}
</style>
