package ufm.universalfinancemanager.util;

/**
 * Created by smh7 on 12/11/17.
 */

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Executor that runs a task on a new background thread.
 */
public class DiskIOThreadExecutor implements Executor {

    private final Executor mDiskIO;

    public DiskIOThreadExecutor() {
        mDiskIO = Executors.newSingleThreadExecutor();
    }

    @Override
    public void execute(@NonNull Runnable command) {
        EspressoIdlingResource.increment();
        mDiskIO.execute(command);
        // decrement the idling resources once executing the command has been finished
        EspressoIdlingResource.decrement();
    }
}