package com.omelenko.crud2.dagger.module;

import com.omelenko.crud2.dagger.storage.DatabaseHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {

    @Provides
    DatabaseHelper provideDatabaseHelper() {
        return new DatabaseHelper();
    }

}
