import axios from 'axios';

const api = axios.create({
    baseURL: '/api', // usa o proxy configurado no vite.config.js
});

export default api;