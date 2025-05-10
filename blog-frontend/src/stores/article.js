import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

const article = ref(
    'kajl'
)


export const useArticleStore = defineStore('article', () => {
    const article = ref(null)
    const articles = ref([])
    const currentArticle = ref(null)

    const fetchArticle = async (id) => {
        const response = await axios.get(`http://localhost:9801/getArticle/${id}`)
        article.value = response.data;
        console.log("article",article.value)
        console.log("response", response.data);
    }

    const fetchArticles = async () => {
        const response = await axios.get(`http://localhost:9801/getArticle`)
        articles.value = response.data;
        console.log("articles",articles.value)
        console.log("response", response.data);
    }

    const publishArticle = async (formData) => {
        try {const response = await axios.post(`http://localhost:9801/getArticle`, formData.value)
        fetchArticles()
        console.log("发布的response", response.data.code)
        } catch (e) {
            console.log("请求发送失败", e)
        }
    }

    const editArticle = async (formData) => {
        // if (formData.)
        console.log("formdata的id",formData.value.id);
        try {
            const response = await axios.put(`http://localhost:9801/getArticle/`, formData.value);
            fetchArticles()
            return response.data;
        } catch (e) {
            console.log("请求发送失败", e)
        }
    }

    const deleteArticle = async (id) => {
        try {
            const response = await axios.delete(`http://localhost:9801/getArticle/${id}`)
            fetchArticles()
            return response.data;
        } catch (e) {
            console.log("请求发送失败", e)
        }
    }


    return { article, articles, currentArticle, fetchArticle, fetchArticles, publishArticle, editArticle, deleteArticle }
})