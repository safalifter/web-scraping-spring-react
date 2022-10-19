import axios from "axios";

export default class ProductService {
    getProducts(page, size, sortPrice) {
        return axios.get(sortPrice ?
            `/product?page=${page}&size=${size}&sort=${sortPrice}` :
            `/product?page=${page}&size=${size}`);
    }

    getProductsByModelNumber(modelNumber) {
        return axios.get("/product?modelNumber=" + modelNumber);
    }

    getProductsByName(name) {
        return axios.get("/product/" + name);
    }
}