<template>
  <div class="home-container">
    <el-button class="publish-article" type="primary" circle @click="publishDialog?.open()">
      <el-icon :size="24">
        <Plus />
      </el-icon>
    </el-button>
    <PublishDialog ref="publishDialog"></PublishDialog>

    <el-card class="article-card" v-for="article in articles" :key="article.id">
      <template #header>
        <div class="card-header">
          <h1 class="article-title">{{ article?.title }}</h1>
          <span class="article-date">{{ article?.date }}</span>
        </div>
      </template>
      <div class="article-content">{{ article?.content }}</div>
      <div class="card-footer">
        <el-button class="action-button" @click="showContent(article)">showContent</el-button>
        <el-button class="action-button" @click="deleteArticle(article.id)">删除</el-button>
      </div>
    </el-card>

    <vue-particles id="particles-js"></vue-particles>
  </div>
</template>

<script setup>
import { useArticleStore } from '@/stores/article'
import { nextTick, onMounted, ref } from 'vue'
import { storeToRefs } from 'pinia'
import PublishDialog from '@/components/PublishDialog.vue'
import { useRouter } from 'vue-router'
import { Plus } from '@element-plus/icons-vue'
// import 'particles.js'
// import {Engine} from 'tsparticles-engine'
import { tsParticles } from 'tsparticles-engine'
import {loadFull} from 'tsparticles'

const articleStore = useArticleStore()
const isVisibl = ref(false);
const publishDialog = ref(null)
const { articles, article, currentArticle } = storeToRefs(articleStore)
const router = useRouter()

const showContent = (article) => {
  currentArticle.value = article;
  router.push(`/article`)
}

const deleteArticle = (id) => {
  articleStore.deleteArticle(id)
}

const engine = tsParticles

const initParticle = async() => {
  await loadFull(engine)
  await engine.load(window.tsParticles.load("particles-js", {
    particles: {
      number: {
        value: 100,
      },
      color: { value: "#ffffff" },
      links: {
        enable: true,
        color: "#ffffff",
        distance: 150,
      },
      move: { enable: true }
    }
  }))
}

onMounted(async () => {
  // const engine = new Engine()
  // await loadFull(engine)
  // engine.
  await articleStore.fetchArticles()
  await nextTick()
  await initParticle()
})
</script>
<style scoped>
#particles-js {
  width: 100%;
  height: 100%;
  /* position: fixed; */
  z-index: -1;
  background: #0d47a1;
}

.home-container {
  display: flex;
  /* align-items: center; */
  flex-direction: column;
  align-items: center;
  gap: 24px;
  padding: 24px;
  /* max-width: 1200px; */
  margin: 0 auto;
  z-index: 1;
  position: relative; 
}

.article-card {
  width: 100%;
  max-width: 800px;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.88);
  /* transition: all 0.3s ease; */
  border: none;
}

.article-card:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.50);
}

.article-content {
  /* margin: 16px 0; */
  padding: 16px 0;
  font-size: 1rem;
  line-height: 1.6;
  color: #111;
  /* min-height: 100px; */

  display: -webkit-box;
  -webkit-line-clamp: 3;
  -webkit-box-orient: vertical;
  overflow: hidden;
  /* text-overflow: ellipsis; */
  /* max-height: calc(1.6rem); */
  position: relative;
  transition: all 0.3s ease;
}

.article-content::after {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  height: 1.6rem;
  background: linear-gradient(to right, rgba(255, 255, 255, 0), white 50%);
}

/* .article-content.expanded {
  -webkit-line-clamp: initial;
  max-height: none;
} */

.card-footer {
  /* display: flex; */
  /* justify-content: center; */
  /* align-content: center; */
  text-align: end;
}

.action-button {
  /* font-weight: 500; */
  letter-spacing: 0.5px;
  /* align: center; */
  /* color: brown; */
}
</style>