import VueRouter from 'vue-router';
import BaseLayout from '~/layout/base/Index'

const accessCertification = async (to, from, next) => {
    next()
}

function pages() {
    return [
        {
            name: "대시보드",
            path: "dashboard",
            beforeEnter: accessCertification
        }
    ];
}

const router = new VueRouter({
    mode: "history",
    routes: [
        {
            name: "home",
            path: "/",
            beforeEnter: accessCertification,
            components: BaseLayout,
            children: pages()
        }
    ]
});

export default router