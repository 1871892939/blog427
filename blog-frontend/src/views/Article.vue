<template>
  <div class="article-container">
    <div class="article">
      <div class="article-header">
        <h1 class="article-title">{{ currentArticle?.title }}</h1>
        <div class="article-meta">
          <span class="article-date"> {{ new Date().toLocaleDateString() }} </span>
        </div>
      </div>

      <div class="article-content">
        <p class="article-text"> {{ currentArticle?.content }} </p>
      </div>
      <el-button type="primary" @click="isVisible = true">编辑</el-button>
    </div>

    <el-dialog v-model="isVisible" title="编辑文章" width="30%">
      <el-form :model="currentArticle" label-width="120px">
        <el-form-item label="标题">
          <el-input v-model="currentArticle.title" />
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" v-model="currentArticle.content" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="editArticle">完成编辑</el-button>
          <el-button @click="isVisible = false">取消</el-button>
        </el-form-item>
      </el-form>

    </el-dialog>
  </div>
</template>

<script setup>
import { computed, onMounted, ref } from 'vue'
import { useArticleStore } from '@/stores/article';
import { storeToRefs } from 'pinia'

const articleStore = useArticleStore()
const { currentArticle } = storeToRefs(articleStore)
const isVisible = ref(false)


const editArticle = async () => {
  await articleStore.editArticle(currentArticle)
  isVisible.value = false
}



</script>

<style scoped>
/* .article {
 
} */

.article {
  background-color: white;
  max-width: 800px;
  margin: 2rem auto;
  padding: 2rem;
  font-family: Arial, Helvetica, sans-serif;
  color: #333;
  border: 1px solid #eaeaea;
  border-radius: 12px;
  /* overflow: hidden; */
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.article:hover {
  /* transform: translateY(-2px); */
  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.50);
}

.article-header {
  margin-bottom: 2rem;
  border-bottom: 1px solid #eaeaea;
  padding-bottom: 1rem;
}

.article-meta {
  font-size: 0.9rem;
  color: #222;
}

.article-content {
  line-height: 1.8;
  font-size: 1.1rem;
}

.article-text {
  /* white-space: pre-line; */
  /* margin-bottom: 1.5rem; */
  text-align: justify;
  /* hyphens: auto; */
}

@media (max-width: 768px) {
  .article-container {
    padding: 1rem;
  }

  .article-title {
    font-size: 1.5rem;
  }

  .article-content {
    font-size: 1rem;
  }
}
</style>
