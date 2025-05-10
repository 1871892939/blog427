<template>
    <div class="publish-container">
        <el-dialog v-model="isVisiable" title="发布文章" width="50%">
            <div class="publish-content">
                <el-input v-model="formData.title" placeholder="请输入标题"></el-input>

                <el-date-picker v-model="formData.date" type="datetime" placeholder="请选择日期" />
                <el-input v-model="formData.content" placeholder="请输入文章内容" type="textarea" :rows="10" />
            </div>

            <div class="publish-menu">
                <el-button type="danger" @click="isVisiable = false">取消发布</el-button>
                <el-button type="success" @click="publish">发布</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script setup>
import { useArticleStore } from '@/stores/article'
import { ref } from 'vue'
import { ElMessage } from 'element-plus'

const isVisiable = ref(false)
const open = () => {
    isVisiable.value = true;
}

const cancelPublish = () => {
    isVisiable.value = false
}
const articleStore = useArticleStore()
const formData = ref({
    content: '',
    title: '',
    date: ''
})

const publish = async () => {
    try {
        await articleStore.publishArticle(formData)
        isVisiable.value = false
        ElMessage.success("发布成功")
    } catch (e) {
        ElMessage.error("发布失败", e)
    }
}

defineExpose({ open })
</script>

<style scoped>
/* .dialog{
    margin: 0;
    padding: 0;
}

.dialog_body{
    margin: 0;
    padding: 0;
} */
</style>