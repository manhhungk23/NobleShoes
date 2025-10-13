import PhieuGiamGia from "@/components/giamGia/phieuGiamGia.vue";
import TableData from "@/components/table/tableData.vue";
import TrangChu from "@/components/trangChu.vue";
import { createRouter, createWebHistory } from "vue-router";

const listRouter = [
    {
        path: '/trang-chu',
        name: 'TrangChu',
        component: TrangChu,
    },
    {
        path: '/san-pham',
        name: 'SanPham',
        component: TableData,
    },
    {
        path: '/phieu-giam-gia',
        name: 'PhieuGiamGia',
        component: PhieuGiamGia,
        
    }
]

const router = createRouter ({
    history: createWebHistory(),
    routes: listRouter, // truyền vào 1 list danh sách router 
})

export default router