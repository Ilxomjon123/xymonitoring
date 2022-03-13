package com.example.hack.models

import java.io.Serializable

class DataItem : Serializable {

    var img: String
    var title: String
    var description: String
    var temperature:Int = 0
    var humidity:Int = 0
    var co:Int = 0
    var ammiak:Int = 0

    constructor(img: String, title: String, description: String) {
        this.img = img
        this.title = title
        this.description = description

    }

    constructor(
        img: String,
        title: String,
        description: String,
        temperature: Int,
        humidity: Int,
        co: Int,
        ammiak: Int
    ) {
        this.img = img
        this.title = title
        this.description = description
        this.temperature = temperature
        this.humidity = humidity
        this.co = co
        this.ammiak = ammiak
    }

}
