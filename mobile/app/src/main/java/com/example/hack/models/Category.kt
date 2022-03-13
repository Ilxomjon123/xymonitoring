package com.example.hack.models

import java.io.Serializable

class Category : Serializable {
    var category_name: String
    var list: List<DataItem>

    constructor(category_name: String, list: List<DataItem>) {
        this.category_name = category_name
        this.list = list
    }
}