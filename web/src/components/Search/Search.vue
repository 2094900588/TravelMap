<template>
    <div id="search_container">
        <input type="text" placeholder="输入你想要输入的值" v-model="inputObject.userInput" :id="inputObject.inputId">
        <button id="search_Btn" @click="send">搜索</button>
    </div>
</template>

<script>
import { mapActions } from 'vuex';

export default{
    data(){
        return{
            inputObject:{
                userInput:'',
                inputId:'searchInput'
            }
            
        }
    },
    methods:{
        ...mapActions(['setuserInputac']),
        //点击按钮把用户输入的内容userInput传到vuex里面的userInput中
        send(){
            this.setuserInputac(this.inputObject)
        }
    },
    created(){
        this.send()
    }

}
</script>

<style>
#search_container{
    height: 100%;
    width: 100%;
}
input{
    height: 30px;
    width: 70%;
}
#search_Btn{
    height: 35px;
    width: 60px;
}
</style>