package com.example.viewmodellivedatademoenrichi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

// Auteur: Lemghili Mohammed Amine
// ViewModel charge de conserver et modifier la valeur du compteur.
public class CounterViewModel extends ViewModel {

    private static final String COUNT_KEY = "count";

    private final SavedStateHandle savedStateHandle;
    private final MutableLiveData<Integer> countLiveData;

    public CounterViewModel(SavedStateHandle handle) {
        savedStateHandle = handle;
        // Lemghili Mohammed Amine: SavedStateHandle restaure la valeur apres un kill processus.
        countLiveData = savedStateHandle.getLiveData(COUNT_KEY, 0);
    }

    public void increment() {
        Integer current = countLiveData.getValue();
        if (current != null) {
            countLiveData.setValue(current + 1);
        }
    }

    public void decrement() {
        Integer current = countLiveData.getValue();
        if (current != null) {
            countLiveData.setValue(current - 1);
        }
    }

    public void reset() {
        countLiveData.setValue(0);
    }

    public void incrementFromBackground() {
        new Thread(() -> {
            Integer current = countLiveData.getValue();
            if (current != null) {
                // Lemghili Mohammed Amine: postValue est adapte aux mises a jour depuis un thread secondaire.
                countLiveData.postValue(current + 1);
            }
        }).start();
    }

    public LiveData<Integer> getCount() {
        return countLiveData;
    }
}
