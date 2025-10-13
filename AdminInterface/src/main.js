// import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import router from './router'
import '@fortawesome/fontawesome-free/css/all.css'

// createApp(App).mount('#app')
const app = createApp(App)

app.use(router)
app.mount('#app')
