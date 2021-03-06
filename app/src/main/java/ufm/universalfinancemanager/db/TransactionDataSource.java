package ufm.universalfinancemanager.db;

import android.support.annotation.NonNull;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import ufm.universalfinancemanager.db.entity.Transaction;

/**
 * Created by smh7 on 12/11/17.
 */

public interface TransactionDataSource {
    interface LoadTransactionsCallback {
        void onTransactionsLoaded(List<Transaction> transactions);
        void onDataNotAvailable();
    }

    interface GetTransactionCallback {
        void onTransactionLoaded(Transaction transaction);
        void onDataNotAvailable();
    }

    void getTransactions(@NonNull LoadTransactionsCallback callback);

    void getTransaction(@NonNull String transactionId, @NonNull GetTransactionCallback callback);

    void saveTransaction(@NonNull Transaction transaction);

    void refreshTransactions();

    void deleteAllTransactions();

    void deleteTransaction(String transactionId);
}
