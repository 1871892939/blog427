import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

const article = ref(
    'kajl'
)

export const useArticleStore = defineStore('article', () => {
    const article = ref(null)

    const fetchArticle = async (id) => {
        const response = await axios.get(`http://localhost:8081/getArticle?id=${id}`)
        article.value = response.data;
        console.log("article",article.value)
        console.log("response", response.data);
        
    }
    return { article, fetchArticle }
})