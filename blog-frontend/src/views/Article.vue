<template>
  <div class="article-details">
    <article>
        {{ article }}
    </article>
  </div>
</template>

<script setup>
import {computed, onMounted, ref} from 'vue'
import { useArticleStore } from '@/stores/article';

const articleStore = useArticleStore()
const article = ref()

articleStore.fetchArticle(1)
article.value = computed(() => articleStore.article)
// article.value = ref(articleStore.article)

// onMounted(() => {
//   articleStore.fetchArticle()
// })


</script>

<style>

</style>
