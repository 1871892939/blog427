import { createRouter, createWebHistory } from 'vue-router'

const routes = [
    {
        path: '/',
        name: 'home',
        component: () => import('../views/Home.vue'),
        // redirect: '/article',
        // children: [
        //     {
        //         path: 'article',
        //         name: 'article',
        //         component: () => import('../views/Article.vue')
        //     }
        // ]

    },
    {
        path: '/article',
        name: 'article',
        component: () => import('../views/Article.vue')
    }

]

const router = createRouter({
    history: createWebHistory(),
    routes
})
export default router;
