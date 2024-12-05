package com.anonymous.phonewireguardvpn.wireguard

import android.util.Log
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.wireguard.config.Config
import java.io.BufferedReader
import java.io.StringReader

class WireGuardModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "WireGuardModule"
    }

    @ReactMethod
    fun connectToVPN(configData: String, promise: Promise) {
        try {
            // Создаём BufferedReader из строки
            val reader = BufferedReader(StringReader(configData))
            val config = Config.parse(reader)

            // TODO: Здесь нужно вызвать API WireGuard для подключения
            Log.d("WireGuardModule", "Подключение к VPN с конфигурацией: $config")
            promise.resolve("VPN подключен")
        } catch (e: Exception) {
            Log.e("WireGuardModule", "Ошибка подключения к VPN", e)
            promise.reject("Ошибка подключения к VPN", e)
        }
    }

    @ReactMethod
    fun disconnectFromVPN(promise: Promise) {
        try {
            // TODO: Реализация отключения VPN
            Log.d("WireGuardModule", "VPN отключен")
            promise.resolve("VPN отключен")
        } catch (e: Exception) {
            Log.e("WireGuardModule", "Ошибка отключения VPN", e)
            promise.reject("Ошибка отключения VPN", e)
        }
    }
}
