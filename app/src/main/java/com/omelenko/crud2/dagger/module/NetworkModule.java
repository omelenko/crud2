package com.omelenko.crud2.dagger.module;

import com.omelenko.crud2.dagger.network.NetworkUtils;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    NetworkUtils provideNetworkUtils() {
        return new NetworkUtils();
    }

}
