import './assets/main.css'
import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router/index'
import {createPinia} from 'pinia'
// import {useArticleStore} from '@/stores'
// import VueParticles from 'vue3-particles'

const app = createApp(App);
const pinia = createPinia();
app.config.devtools = false
// app.use(VueParticles)
app.use(pinia)
app.use(router);
app.use(ElementPlus)
app.mount('#app')