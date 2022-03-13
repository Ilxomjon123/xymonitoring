package com.example.hack.models

import java.io.Serializable

class Helper:Serializable {
    var img:String
    var title:String
    var description:String

    constructor(img: String, title: String, description: String) {
        this.img = img
        this.title = title
        this.description = description
    }
}