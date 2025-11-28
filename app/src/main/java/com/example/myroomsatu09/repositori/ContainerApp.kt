package com.example.myroomsatu09.repositori

import android.app.Application
import android.content.Context
import com.example.myroomsatu09.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(private val context: Context):
        ContainerApp{
            override val repositoriSiswa: RepositoriSiswa by lazy {
                OffLineRepositoriSiswa(
                    DatabaseSiswa.getDatabase(context).siswaDao())
            }
        }

class AplikasiSiswa: Application() {
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainnya untuk
     */

    lateinit var container : ContainerApp

    override fun onCreate(){
        super.onCreate()
        container = ContainerDataApp(this)
    }
}