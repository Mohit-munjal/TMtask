package com.dev.mohitmunjal

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

object Util {

    fun <T> convertStringToObj(strObj: String?, classOfT: Class<T>?): T {
        //convert string json to object
        return Gson().fromJson(strObj, classOfT as Type?)
    }


    fun convertObjToString(clsObj: Any?): String? {
        //convert object  to string json
        return Gson().toJson(clsObj, object : TypeToken<Any?>() {}.type)
    }
}