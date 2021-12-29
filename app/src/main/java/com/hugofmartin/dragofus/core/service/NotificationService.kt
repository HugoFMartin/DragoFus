package com.hugofmartin.dragofus.core.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.hugofmartin.dragofus.R

class NotificationService(private val appContext: Context, private val workerParameters: WorkerParameters): CoroutineWorker(appContext, workerParameters) {

    private fun buildNotification() {
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val name = "DragodindeNotification"
        val descriptionText = "DragodindeNotificationDescription"
        val channel = NotificationChannel(channelId,name,importance).apply{
            description = descriptionText
        }

        val notificationManager = this.applicationContext.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }


    private fun sendNotification(){
        val notificationBuilder = NotificationCompat.Builder(appContext, channelId)
            .setContentText(text)
            .setContentTitle(title)
            .setSmallIcon(R.drawable.dragodindes_rousse)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(appContext)){
            notify(notificationId,notificationBuilder.build())
        }
    }

    override suspend fun doWork(): Result {
        buildNotification()
        sendNotification()
        return Result.success()
    }

    companion object {
        private const val channelId = "dragodinde_channel"
        private const val notificationId = 101
        private const val text = "Une de vos dragodinde à accouchée!"
        private const val title = "DragoFus"

        const val workName = "dragodinde_notification_"
    }
}