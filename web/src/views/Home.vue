<template>
    <div style="height: 100%">
        <el-container class="layout-container-demo" style="height: 100%">
            <el-aside :width="daohang + 'px'" style="  height: 100%">
                <el-scrollbar style="height: 100%">

                    <el-menu :default-openeds="['1', '3']" style="height: 100%" :collapse-transition="false"
                        :collapse="!seen">

                        <div style="height:60px ; line-height: 60px; text-align: center;">
                            <img src="../assets/logo.png"
                                style="width: 25px; position: relative; top: 5px; right: 5px; left: 0px;">
                            <b v-show="seen">旅游地图系统</b>
                        </div>

                        <el-sub-menu index="1">
                            <template #title>
                                <el-icon>
                                    <Location />
                                </el-icon>
                                <span>湖北省</span>

                            </template>

                            <el-menu-item-group>
                                <template #title>地级市</template>
                                <el-menu-item index="1-1" style="padding-left: 60px;"
                                    @click="selectByName('宜昌市')">宜昌市</el-menu-item>
                                <el-menu-item index="1-2" style="padding-left: 60px;"
                                    @click="selectByName('黄石市')">黄石市</el-menu-item>
                                <el-menu-item index="1-3" style="padding-left: 60px;"
                                    @click="selectByName('十堰市')">十堰市</el-menu-item>
                                <el-menu-item index="1-4" style="padding-left: 60px;"
                                    @click="selectByName('荆州市')">荆州市</el-menu-item>
                                <el-menu-item index="1-5" style="padding-left: 60px;"
                                    @click="selectByName('襄阳市')">襄阳市</el-menu-item>
                                <el-menu-item index="1-6" style="padding-left: 60px;"
                                    @click="selectByName('鄂州市')">鄂州市</el-menu-item>
                                <el-menu-item index="1-7" style="padding-left: 60px;"
                                    @click="selectByName('荆门市')">荆门市</el-menu-item>
                                <el-menu-item index="1-8" style="padding-left: 60px;"
                                    @click="selectByName('孝感市')">孝感市</el-menu-item>
                                <el-menu-item index="1-9" style="padding-left: 60px;"
                                    @click="selectByName('黄冈市')">黄冈市</el-menu-item>
                                <el-menu-item index="1-10" style="padding-left: 60px;"
                                    @click="selectByName('咸宁市')">咸宁市</el-menu-item>
                                <el-menu-item index="1-11" style="padding-left: 60px;"
                                    @click="selectByName('随州市')">随州市</el-menu-item>
                                <el-menu-item index="1-12" style="padding-left: 60px;"
                                    @click="selectByName('武汉市')">武汉市</el-menu-item>
                            </el-menu-item-group>

                            <el-menu-item-group>
                                <template #title>自治州</template>
                                <el-menu-item index="1-13" style="padding-left: 60px;">恩施土家族苗族自治州</el-menu-item>
                            </el-menu-item-group>

                        </el-sub-menu>
                    </el-menu>
                </el-scrollbar>
            </el-aside>

            <el-container>
                <el-header style="font-size: 12px;line-height:80px ; display: flex; height: 40px;">
                    <div class="toolbar">
                        <i><el-icon style="font-size: 26px;">
                                <Fold v-if="seen" @click="shousuo" />
                                <Expand v-if="!seen" @click="zhankai" />
                            </el-icon></i>
                    </div>
                </el-header>

                <el-main>
                    <div>
                        <el-tabs v-model="activeName" @tab-click="handleClick">
                            <el-tab-pane label="地区美食" name="first">

                                <el-table :data="tableData" style="width: 100%">
                                    <el-table-column prop="id" label="编号" width="180"></el-table-column>
                                    <el-table-column prop="placename" label="地点名称" width="180"></el-table-column>
                                    <el-table-column prop="foodname" label="食物名称"></el-table-column>
                                    <el-table-column label="食物图片">
                                        <template #default="scope">
                                            <el-image style="width: 140px; height: 100px"
                                                :src="baseUrl + scope.row.photo"></el-image>
                                        </template>
                                    </el-table-column>
                                </el-table>


                                <div style="padding-top: 30px;">
                                    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                                        :current-page="pageNum" :page-sizes="[5, 10, 15, 20]" :page-size="pageSize"
                                        layout="total, sizes, prev, pager, next, jumper" :total="total">
                                    </el-pagination>
                                </div>



                            </el-tab-pane>



                            <el-tab-pane label="游玩场景" name="second">游玩场景
                                <div id="index_container">
                                    <div id="search_wrap">
                                        <search></search>
                                    </div>
                                    <div id="map_wrap">
                                        <map-container></map-container>
                                    </div>
                                </div>
                            </el-tab-pane>





                            <!-- <el-tab-pane label="城市背景" name="third">
                  城市背景
                  <div id="xqmap_wrap">
         
                  </div>
  
                </el-tab-pane> -->
                            <!-- <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane> -->
                        </el-tabs>

                    </div>

                </el-main>


            </el-container>
        </el-container>
    </div>
</template>

  
<script>
import HelloWorld from '@/components/HelloWorld.vue'
import axios from "axios"
import { mapActions, mapState } from 'vuex'
import { mapGetters, mapMutations } from 'vuex';
import MapContainer from '@/components/MapContainer/MapContainer.vue'
// import XqMapContainer from '@/components/MapContainer/XqMapContainer.vue'
import Search from "@/components/Search/Search.vue"

export default {
    name: 'HomeView',
    components: {
        HelloWorld,
        MapContainer,
        Search,
        // XqMapContainer
    },
    data() {

        return {
            tableData: [],
            activeName: 'second',
            seen: true,
            daohang: 250,
            reData: [],
            placenameindex: '',
            test: 1,
            savetableData: [],
            photo: [],
            total: 0,
            pageNum: 1,
            pageSize: 5

        }
    },
    // created(){
    //   fetch(this.baseUrl+"selectPageByName?pageNum="+this.pageNum+"&pageSize="+this.pageSize+"&placename="+this.cur).then(res=>res.json()).then(res=>{
    //     console.log(res);
    //     this.total = res.total
    //   })
    //   // fetch("http://localhost:9090/selectPageByName?pageNum=1&pageSize=5&placename="+this.cur).then(res=>res.json()).then(res=>{
    //   //   console.log(res);
    //   //   this.total = res.total
    //   // })
    // },

    computed: {
        ...mapState(['cur'])
    },
    methods: {
        ...mapActions(['setcur', 'setplacenameac']),
        handleSizeChange(pageSize) {
            console.log(pageSize);
            this.pageSize = pageSize;
            this.handleClick()
        },
        handleCurrentChange(pageNum) {
            console.log(pageNum);
            this.pageNum = pageNum;
            this.handleClick()
        },
        selectByName(param) {
            this.setcur(param)
            this.setplacenameac(param)

            // $.ajax({
            //     url: this.baseUrl + "selectPageByName?pageNum=" + this.pageNum + "&pageSize=" + this.pageSize + "&placename=" + param,
            //     success: (res) => {
            //         this.tableData = res.date
            //         this.total = res.total
            //         console.log(res);
            //     }
            // })
        },
        shousuo() {
            this.seen = !this.seen
            this.daohang = 68
        },
        zhankai() {
            this.seen = !this.seen
            this.daohang = 250
        },
        handleClick(tab, event) {
            console.log(tab, event);
            $.ajax({
                url: this.baseUrl + "selectPageByName?pageNum=" + this.pageNum + "&pageSize=" + this.pageSize + "&placename=" + this.cur,
                success: (res) => {
                    this.tableData = res.date
                    this.total = res.total
                    console.log(res);
                }
            })

        }

    }
}
</script>

<style>
html,
body {
    padding: 0px;
    margin: 0px;
}

#container {
    width: 1000px;
    height: 600px;
}

#index_container {
    height: 650px;
    width: 1000px;
    position: relative;
}

#map_wrap {
    height: 90%;
    width: 100%;
}

#xqmap_wrap {
    height: 800px;
    width: 100%;
}

#search_wrap {
    height: 60px;
    width: 400px;
}
</style>
