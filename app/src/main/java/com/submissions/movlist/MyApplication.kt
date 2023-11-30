package com.submissions.movlist

import android.app.Application
import com.submissions.core.di.databaseModule
import com.submissions.core.di.networkModule
import com.submissions.core.di.repositoryModule
import com.submissions.movlist.di.useCaseModule
import com.submissions.movlist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}