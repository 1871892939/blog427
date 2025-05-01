<template>
  <div class="home-container">
      <!-- <el-menu :default-active="activeIndex" class="el-top-menu" mode="horizontal" @select="handleSelect">
        <el-menu-item index="1">Processing Center</el-menu-item>
      </el-menu> -->
      <el-card class="article-card" :model="form"> 
        <template #header>
          <h1 class="article-title">{{ form.title }}</h1>
          <span class="article-date">{{ form.date }}</span>
        </template>
        <div class="article-content">{{ article }}</div>
        <el-button @click="showContent">showContent</el-button>
      </el-card>
  </div>
  <div>
    <router-view></router-view>
  </div>
</template>

<script setup>
import { useArticleStore } from '@/stores/article'
import {onMounted, ref} from 'vue'
const articleStore = useArticleStore()
const article = ref(null)
import {useRouter} from 'vue-router'

console.log("home article", article.value);

const router = useRouter()
const form = ref({
  title: 'hello',
  date: '2025-04-30'
})
const showContent = () => {
  
  router.push(`/article`)
  // alert('showContent');
}

onMounted(async () => {
  await articleStore.fetchArticle(1)
  article.value = articleStore.article
})
</script>
<style scoped>
.el-top-menu {
  margin: 0 auto; /* 水平居中 */
}
.article-card {
  width: 500px;
  margin: 0 auto;
}
</style>