package com.practice.mynewfunc.basecontent

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication : Application() {

    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())


    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
//    val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
//    val repository by lazy { WordRepository(database.wordDao()) }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
           /* val name: CharSequence = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(Constants.CHANNEL_NOTIFY_ID, name, importance)
            //channel.apply { description = descriptionText }
            channel.description = descriptionText


            val channel2 =
                NotificationChannel(Constants.CHANNEL_NOTIFY_ID_2, "Channel2_name", importance)
            channel2.apply { description = "descriptionText" }
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
            notificationManager.createNotificationChannel(channel2)*/
        }
    }
}
